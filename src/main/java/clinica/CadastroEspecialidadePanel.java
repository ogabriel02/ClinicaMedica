package clinica;

import javax.swing.JPanel;
import especialidades.CadastroEspecialidade; // tela original

public class CadastroEspecialidadePanel extends JPanel {

    private CadastroEspecialidade cadastroEspecialidade;

    public CadastroEspecialidadePanel() {
        cadastroEspecialidade = new CadastroEspecialidade();
        this.setLayout(new java.awt.BorderLayout());
        this.add(cadastroEspecialidade.getContentPane());
    }
}