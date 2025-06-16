// ExameDao.java
/*package clinica.daos;

import especialidade.*;
import java.sql.*;
import java.util.*;

public class ExameDao {
    public void inserir(Exame e) throws SQLException {
        String sql = "INSERT INTO exame (paciente_id, tipo_exame, data_exame, resultado) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, e.getPaciente().getId());
            stmt.setString(2, e.getTipoExame());
            stmt.setDate(3, new java.sql.Date(e.getDataExame().getTime()));
            stmt.setString(4, e.getResultado());
            stmt.executeUpdate();
        }
    }
}
*/