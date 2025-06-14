// PacienteDao.java
package clinica.daos;

import especialidade.*;
import java.sql.*;
import java.util.*;

public class PacienteDao {
    public void inserir(Paciente p) throws SQLException {
        String sql = "INSERT INTO paciente (nome, telefone, email, data_nascimento) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, p.getEmail());
            stmt.setDate(4, new java.sql.Date(p.getDataNascimento().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Paciente> listar() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Paciente p = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getDate("data_nascimento")
                );
                lista.add(p);
            }
        }
        return lista;
    }
}
