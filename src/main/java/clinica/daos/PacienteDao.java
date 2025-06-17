package clinica.daos;

import entidades.Paciente;
import java.sql.*;
import java.util.*;

public class PacienteDao {
    public void inserir(Paciente p) throws SQLException {
        String sql = "INSERT INTO paciente (nome, cpf, telefone, endereco, data_nascimento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getTelefone());
            stmt.setString(4, p.getEndereco());
            stmt.setDate(5, new java.sql.Date(p.getDataNascimento().getTime()));
            stmt.executeUpdate();
        }
    }
    
    public Paciente buscarPorId(int id) throws SQLException {
    String sql = "SELECT * FROM paciente WHERE id = ?";
    try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getDate("data_nascimento")
                );
            }
        }
    }
    return null;
    }

    public List<Paciente> listar() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Paciente p = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("endereco"),
                    rs.getDate("data_nascimento")
                );
                lista.add(p);
            }
        }
        return lista;
    }

    public void atualizar(Paciente p) throws SQLException {
        String sql = "UPDATE paciente SET nome = ?, cpf = ?, telefone = ?, endereco = ?, data_nascimento = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCpf());
            stmt.setString(3, p.getTelefone());
            stmt.setString(4, p.getEndereco());
            stmt.setDate(5, new java.sql.Date(p.getDataNascimento().getTime()));
            stmt.setInt(6, p.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM paciente WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}


