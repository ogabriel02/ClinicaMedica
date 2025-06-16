// Medico.java
package entidades;

public class Medico {
    private int id;
    private String nome;
    private String crm;
    private String ufCrm;
    private Especialidade especialidade;
    private String telefone;

    public Medico(int id, String nome, String crm, String ufCrm, Especialidade especialidade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.ufCrm = ufCrm;
        this.especialidade = especialidade;
        this.telefone = telefone;
    }
    
    // Construtor para uso em MedicoDao.listar (se necessário, embora o de cima seja mais completo)
    public Medico(int id, String nome, Especialidade especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = null;
        this.ufCrm = null;
        this.telefone = null;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
    public String getUfCrm() { return ufCrm; }
    public void setUfCrm(String ufCrm) { this.ufCrm = ufCrm; }
    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}

