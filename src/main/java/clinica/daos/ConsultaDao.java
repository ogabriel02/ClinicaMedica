// ConsultaDao.java
package clinica.daos;

import especialidade.*;
import java.sql.*;
import java.util.*;

public class ConsultaDao {
    public void inserir(Consulta c) throws SQLException {
        String sql = "INSERT INTO consulta (paciente_id, medico_id, especialidade_id, data_hora, retorno, tipo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getPaciente().getId());
            stmt.setInt(2, c.getMedico().getId());
            stmt.setInt(3, c.getEspecialidade().getId());
            stmt.setTimestamp(4, new java.sql.Timestamp(c.getDataHora().getTime()));
            stmt.setBoolean(5, c.isRetorno());
            stmt.setString(6, c.getTipo());
            stmt.executeUpdate();
        }
    }

    public List<Consulta> listar() throws SQLException {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                // Aqui você deve buscar os objetos relacionados usando DAOs
                // Ex: pacienteDao.buscarPorId(rs.getInt("paciente_id"))
                c.setDataHora(rs.getTimestamp("data_hora"));
                c.setRetorno(rs.getBoolean("retorno"));
                c.setTipo(rs.getString("tipo"));
                lista.add(c);
            }
        }
        return lista;
    }
}
