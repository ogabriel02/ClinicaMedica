// Consulta.java
package entidades;

import java.util.Date;

public class Consulta {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private Especialidade especialidade;
    private Date dataHora;
    private boolean retorno;
    private String tipo; // "Convenio" ou "Particular"

    public Consulta() {}
    public Consulta(int id, Paciente paciente, Medico medico, Especialidade especialidade,
                    Date dataHora, boolean retorno, String tipo) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.especialidade = especialidade;
        this.dataHora = dataHora;
        this.retorno = retorno;
        this.tipo = tipo;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }
    public Date getDataHora() { return dataHora; }
    public void setDataHora(Date dataHora) { this.dataHora = dataHora; }
    public boolean isRetorno() { return retorno; }
    public void setRetorno(boolean retorno) { this.retorno = retorno; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
