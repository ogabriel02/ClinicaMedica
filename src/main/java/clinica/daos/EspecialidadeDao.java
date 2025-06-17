package clinica.daos;

import entidades.Especialidade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDao {

    public void salvar(Especialidade especialidade) throws SQLException {
        String sql = "INSERT INTO especialidade (nome) VALUES (?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, especialidade.getNome());
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    especialidade.setId(rs.getInt(1));
                }
            }
        }
    }

    public Especialidade buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM especialidade WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Especialidade e = new Especialidade();
                    e.setId(rs.getInt("id"));
                    e.setNome(rs.getString("nome"));
                    return e;
                }
            }
        }
        return null;
    }

    public Especialidade buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM especialidade WHERE nome = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Especialidade e = new Especialidade();
                    e.setId(rs.getInt("id"));
                    e.setNome(rs.getString("nome"));
                    return e;
                }
            }
        }
        return null;
    }

    public List<Especialidade> listarTodas() throws SQLException {
        List<Especialidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidade";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Especialidade e = new Especialidade();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                lista.add(e);
            }
        }
        return lista;
    }

    public void atualizar(Especialidade especialidade) throws SQLException {
        String sql = "UPDATE especialidade SET nome = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, especialidade.getNome());
            stmt.setInt(2, especialidade.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(long id) throws SQLException {
        String sql = "DELETE FROM especialidade WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}


