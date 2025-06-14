// MedicoDao.java
package clinica.daos;

import especialidade.*;
import java.sql.*;
import java.util.*;

public class MedicoDao {
    public void inserir(Medico medico) throws SQLException {
        String sql = "INSERT INTO medico (nome, especialidade_id) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setInt(2, medico.getEspecialidade().getId());
            stmt.executeUpdate();
        }
    }

    public List<Medico> listar() throws SQLException {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT m.*, e.nome AS nome_esp FROM medico m JOIN especialidade e ON m.especialidade_id = e.id";
        try (Connection conn = Conexao.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Especialidade esp = new Especialidade(rs.getInt("especialidade_id"), rs.getString("nome_esp"));
                lista.add(new Medico(rs.getInt("id"), rs.getString("nome"), esp));
            }
        }
        return lista;
    }
}
