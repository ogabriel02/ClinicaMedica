// EspecialidadeDao.java
package clinica.daos;

import especialidade.Especialidade;
import java.sql.*;
import java.util.*;

public class EspecialidadeDao {
    public void inserir(Especialidade esp) throws SQLException {
        String sql = "INSERT INTO especialidade (nome) VALUES (?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, esp.getNome());
            stmt.executeUpdate();
        }
    }

    public List<Especialidade> listar() throws SQLException {
        List<Especialidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidade";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Especialidade(rs.getInt("id"), rs.getString("nome")));
            }
        }
        return lista;
    }

    public Especialidade buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM especialidade WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Especialidade(rs.getInt("id"), rs.getString("nome"));
                }
            }
        }
        return null;
    }

    public void atualizar(Especialidade esp) throws SQLException {
        String sql = "UPDATE especialidade SET nome = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, esp.getNome());
            stmt.setInt(2, esp.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM especialidade WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
