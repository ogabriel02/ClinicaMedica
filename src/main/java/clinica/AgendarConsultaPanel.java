package clinica;

import consultas.AgendarConsulta;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class AgendarConsultaPanel extends JPanel {
    private AgendarConsulta agendarConsulta;

    public AgendarConsultaPanel() {
        agendarConsulta = new AgendarConsulta();

        // Remove o JFrame para não abrir independente
        agendarConsulta.setVisible(false);
        agendarConsulta.dispose();

        // Pega o content pane do JFrame AgendarConsulta e coloca neste JPanel
        this.setLayout(new BorderLayout());
        this.add(agendarConsulta.getContentPane(), BorderLayout.CENTER);
    }
}