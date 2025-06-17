package clinica.daos;

import entidades.Consulta;
import entidades.Paciente;
import entidades.Medico;
import entidades.Especialidade;

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
            // Instanciar DAOs para buscar objetos relacionados
            PacienteDao pacienteDao = new PacienteDao();
            MedicoDao medicoDao = new MedicoDao();
            EspecialidadeDao especialidadeDao = new EspecialidadeDao();

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setId(rs.getInt("id"));
                
                // Buscar e setar Paciente
                int pacienteId = rs.getInt("paciente_id");
                Paciente paciente = pacienteDao.buscarPorId(pacienteId);
                c.setPaciente(paciente);

                // Buscar e setar Medico
                int medicoId = rs.getInt("medico_id");
                Medico medico = medicoDao.buscarPorId(medicoId);
                c.setMedico(medico);

                // Buscar e setar Especialidade
                int especialidadeId = rs.getInt("especialidade_id");
                Especialidade especialidade = especialidadeDao.buscarPorId(especialidadeId);
                c.setEspecialidade(especialidade);

                c.setDataHora(rs.getTimestamp("data_hora"));
                c.setRetorno(rs.getBoolean("retorno"));
                c.setTipo(rs.getString("tipo"));
                lista.add(c);
            }
        }
        return lista;
    }

    public void atualizar(Consulta c) throws SQLException {
        String sql = "UPDATE consulta SET paciente_id = ?, medico_id = ?, especialidade_id = ?, data_hora = ?, retorno = ?, tipo = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, c.getPaciente().getId());
            stmt.setInt(2, c.getMedico().getId());
            stmt.setInt(3, c.getEspecialidade().getId());
            stmt.setTimestamp(4, new java.sql.Timestamp(c.getDataHora().getTime()));
            stmt.setBoolean(5, c.isRetorno());
            stmt.setString(6, c.getTipo());
            stmt.setInt(7, c.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM consulta WHERE id = ?";
        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}


