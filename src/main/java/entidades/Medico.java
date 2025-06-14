// Medico.java
package entidades;

public class Medico {
    private int id;
    private String nome;
    private Especialidade especialidade;

    public Medico() {}
    public Medico(int id, String nome, Especialidade especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }
}
