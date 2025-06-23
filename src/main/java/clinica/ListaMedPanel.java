package clinica;

import medico.ListagemMedico;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ListaMedPanel extends JPanel {
    public ListaMedPanel() {
        setLayout(new BorderLayout());
        ListagemMedico frame = new ListagemMedico();
        add(frame.getContentPane(), BorderLayout.CENTER);
    }
}