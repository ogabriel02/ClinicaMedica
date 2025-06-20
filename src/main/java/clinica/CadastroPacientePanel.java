package clinica;

import javax.swing.JPanel;
import pacientes.CadastroPaciente; // tela original

public class CadastroPacientePanel extends JPanel {

    private CadastroPaciente cadastroPaciente;

    public CadastroPacientePanel() {
        cadastroPaciente = new CadastroPaciente();
        this.setLayout(new java.awt.BorderLayout());
        this.add(cadastroPaciente.getContentPane());
    }
}