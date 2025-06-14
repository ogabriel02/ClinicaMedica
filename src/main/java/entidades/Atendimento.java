// Atendimento.java
package entidades;
        
       
import java.util.Date;

public class Atendimento {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private Date dataHora;
    private String descricao;

    public Atendimento() {}
    public Atendimento(int id, Paciente paciente, Medico medico, Date dataHora, String descricao) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public Date getDataHora() { return dataHora; }
    public void setDataHora(Date dataHora) { this.dataHora = dataHora; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}

