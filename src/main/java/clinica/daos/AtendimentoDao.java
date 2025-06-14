// AtendimentoDao.java
package clinica.daos;

import especialidade.*;
import java.sql.*;
import java.util.*;

public class AtendimentoDao {
    public void inserir(Atendimento a) throws SQLException {
        String sql = "INSERT INTO atendimento (paciente_id, medico_id, data_hora, descricao) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, a.getPaciente().getId());
            stmt.setInt(2, a.getMedico().getId());
            stmt.setTimestamp(3, new java.sql.Timestamp(a.getDataHora().getTime()));
            stmt.setString(4, a.getDescricao());
            stmt.executeUpdate();
        }
    }
}
