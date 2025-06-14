// Exame.java
package entidades;

import java.util.Date;

public class Exame {
    private int id;
    private Paciente paciente;
    private String tipoExame;
    private Date dataExame;
    private String resultado;

    public Exame() {}
    public Exame(int id, Paciente paciente, String tipoExame, Date dataExame, String resultado) {
        this.id = id;
        this.paciente = paciente;
        this.tipoExame = tipoExame;
        this.dataExame = dataExame;
        this.resultado = resultado;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public String getTipoExame() { return tipoExame; }
    public void setTipoExame(String tipoExame) { this.tipoExame = tipoExame; }
    public Date getDataExame() { return dataExame; }
    public void setDataExame(Date dataExame) { this.dataExame = dataExame; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}
