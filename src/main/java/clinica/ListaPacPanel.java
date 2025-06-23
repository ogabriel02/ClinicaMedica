package clinica;

import pacientes.ListagemPaciente;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ListaPacPanel extends JPanel {
    public ListaPacPanel() {
        setLayout(new BorderLayout());
        ListagemPaciente frame = new ListagemPaciente();
        add(frame.getContentPane(), BorderLayout.CENTER);
    }
}
