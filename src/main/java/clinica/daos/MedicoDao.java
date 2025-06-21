package clinica.daos;

import entidades.Especialidade;
import entidades.Medico;
import java.sql.*;
import java.util.*;

public class MedicoDao {
    public void inserir(Medico medico) throws SQLException {
        String sql = "INSERT INTO medico (nome, especialidade_id, crm, uf_crm, telefone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setInt(2, medico.getEspecialidade().getId());
            stmt.setString(3, medico.getCrm());
            stmt.setString(4, medico.getUfCrm());
            stmt.setString(5, medico.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<Medico> listar() throws SQLException {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT m.*, e.nome AS nome_esp FROM medico m JOIN especialidade e ON m.especialidade_id = e.id";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Especialidade esp = new Especialidade(rs.getInt("especialidade_id"), rs.getString("nome_esp"));
                Medico medico = new Medico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("crm"),
                    rs.getString("uf_crm"), 
                    esp,
                    rs.getString("telefone")
                );
                lista.add(medico);
            }
        }
        return lista;
    }
    
    public Medico buscarPorId(int id) throws SQLException {
    String sql = "SELECT m.*, e.nome AS nome_esp FROM medico m JOIN especialidade e ON m.especialidade_id = e.id WHERE m.id = ?";
    try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                Especialidade esp = new Especialidade(rs.getInt("especialidade_id"), rs.getString("nome_esp"));
                return new Medico(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("crm"),
                    rs.getString("uf_crm"),
                    esp,
                    rs.getString("telefone")
                );
            }
        }
    }
    return null;
    }

    public void atualizar(Medico medico) throws SQLException {
        String sql = "UPDATE medico SET nome = ?, especialidade_id = ?, crm = ?, uf_crm = ?, telefone = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setInt(2, medico.getEspecialidade().getId());
            stmt.setString(3, medico.getCrm());
            stmt.setString(4, medico.getUfCrm());
            stmt.setString(5, medico.getTelefone());
            stmt.setInt(6, medico.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM medico WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Medico buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT m.*, e.nome AS nome_esp FROM medico m JOIN especialidade e ON m.especialidade_id = e.id WHERE m.nome = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Especialidade esp = new Especialidade(rs.getInt("especialidade_id"), rs.getString("nome_esp"));
                    return new Medico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("crm"),
                        rs.getString("uf_crm"),
                        esp,
                        rs.getString("telefone")
                    );
                }
            }
        }
        return null;
    }
}


