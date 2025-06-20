package clinica;

import javax.swing.JPanel;
import medico.CadastroMedico; // tela original

public class CadastroMedicoPanel extends JPanel {

    private final CadastroMedico cadastroMedico;

    public CadastroMedicoPanel() {
        cadastroMedico = new CadastroMedico();
        // Adiciona o conteúdo da tela original nesse JPanel
        this.setLayout(new java.awt.BorderLayout());
        this.add(cadastroMedico.getContentPane());
    }
}
