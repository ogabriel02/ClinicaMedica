package clinica;

import especialidades.ListagemEspecialidade;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ListaEspPanel extends JPanel {
    public ListaEspPanel() {
        setLayout(new BorderLayout());
        ListagemEspecialidade frame = new ListagemEspecialidade();
        add(frame.getContentPane(), BorderLayout.CENTER);
    }
}