// LoginDao.java
/*package clinica.daos;

import especialidade.Login;
import java.sql.*;

public class LoginDao {
    public Login autenticar(String usuario, String senha) throws SQLException {
        String sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Login(rs.getString("usuario"), rs.getString("senha"), rs.getBoolean("admin"));
                }
            }
        }
        return null;
    }
}
*/