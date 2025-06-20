package clinica;

import consultas.AgendarConsulta;
import clinica.CadastroMedicoPanel;
import clinica.CadastroEspecialidadePanel;
import clinica.CadastroPacientePanel;
import java.awt.BorderLayout;

public class MenuScreen extends javax.swing.JFrame {

    public MenuScreen() {
        initComponents();
        // Inicializa a tela de AgendarConsulta embutida
    agendarConsultaPanel = new AgendarConsultaPanel();
    cadastroMedicoPanel = new CadastroMedicoPanel();
    cadastroEspecialidadePanel = new CadastroEspecialidadePanel();
    cadastroPacientePanel = new CadastroPacientePanel();

    // Remove tudo que tiver em conPanel e adiciona o conteúdo da AgendarConsulta
    conPanel.removeAll();
    conPanel.setLayout(new BorderLayout());
    conPanel.add(agendarConsultaPanel, BorderLayout.CENTER);
    conPanel.revalidate();
    conPanel.repaint();

    }

    private final AgendarConsultaPanel agendarConsultaPanel;
    private final CadastroMedicoPanel cadastroMedicoPanel;
    private final CadastroEspecialidadePanel cadastroEspecialidadePanel;
    private final CadastroPacientePanel cadastroPacientePanel;

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lateralPanel = new javax.swing.JPanel();
        conButton = new javax.swing.JButton();
        medButton = new javax.swing.JButton();
        pacButton = new javax.swing.JButton();
        espButton = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        conPanel = new javax.swing.JPanel();
        medPanel = new javax.swing.JPanel();
        pacPanel = new javax.swing.JPanel();
        espPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lateralPanel.setBackground(new java.awt.Color(0, 0, 0));

        conButton.setText("Consulta");
        conButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conButtonActionPerformed(evt);
            }
        });

        medButton.setText("Médico");
        medButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medButtonActionPerformed(evt);
            }
        });

        pacButton.setText("Paciente");
        pacButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacButtonActionPerformed(evt);
            }
        });

        espButton.setText("Especialidade");
        espButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lateralPanelLayout = new javax.swing.GroupLayout(lateralPanel);
        lateralPanel.setLayout(lateralPanelLayout);
        lateralPanelLayout.setHorizontalGroup(
            lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lateralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(conButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(medButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pacButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(espButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lateralPanelLayout.setVerticalGroup(
            lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lateralPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(conButton)
                .addGap(26, 26, 26)
                .addComponent(medButton)
                .addGap(29, 29, 29)
                .addComponent(pacButton)
                .addGap(29, 29, 29)
                .addComponent(espButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout conPanelLayout = new javax.swing.GroupLayout(conPanel);
        conPanel.setLayout(conPanelLayout);
        conPanelLayout.setHorizontalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        conPanelLayout.setVerticalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab1", conPanel);

        javax.swing.GroupLayout medPanelLayout = new javax.swing.GroupLayout(medPanel);
        medPanel.setLayout(medPanelLayout);
        medPanelLayout.setHorizontalGroup(
            medPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        medPanelLayout.setVerticalGroup(
            medPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab2", medPanel);

        javax.swing.GroupLayout pacPanelLayout = new javax.swing.GroupLayout(pacPanel);
        pacPanel.setLayout(pacPanelLayout);
        pacPanelLayout.setHorizontalGroup(
            pacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        pacPanelLayout.setVerticalGroup(
            pacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab3", pacPanel);

        javax.swing.GroupLayout espPanelLayout = new javax.swing.GroupLayout(espPanel);
        espPanel.setLayout(espPanelLayout);
        espPanelLayout.setHorizontalGroup(
            espPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        espPanelLayout.setVerticalGroup(
            espPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab4", espPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lateralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lateralPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conButtonActionPerformed
 // Exibe a aba do painel de consultas (supondo que conPanel está numa aba do jTabbedPane)
    jTabbedPane.setSelectedComponent(conPanel);
    }//GEN-LAST:event_conButtonActionPerformed

    private void medButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medButtonActionPerformed
        // Remove tudo que estiver no medPanel
    medPanel.removeAll();

    // Adiciona o painel de cadastro médico no medPanel
    medPanel.setLayout(new java.awt.BorderLayout());
    medPanel.add(cadastroMedicoPanel);

    // Atualiza o medPanel para mostrar o novo conteúdo
    medPanel.revalidate();
    medPanel.repaint();

    // Opcional: Seleciona a aba correta no jTabbedPane (se quiser forçar)
    jTabbedPane.setSelectedComponent(medPanel);      
    }//GEN-LAST:event_medButtonActionPerformed

    private void espButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espButtonActionPerformed
    espPanel.removeAll();
    espPanel.setLayout(new java.awt.BorderLayout());
    espPanel.add(cadastroEspecialidadePanel);
    espPanel.revalidate();
    espPanel.repaint();

    jTabbedPane.setSelectedComponent(espPanel);
    }//GEN-LAST:event_espButtonActionPerformed

    private void pacButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacButtonActionPerformed
    pacPanel.removeAll();
    pacPanel.setLayout(new java.awt.BorderLayout());
    pacPanel.add(cadastroPacientePanel);
    pacPanel.revalidate();
    pacPanel.repaint();

    jTabbedPane.setSelectedComponent(pacPanel);        // TODO add your handling code here:
    }//GEN-LAST:event_pacButtonActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conButton;
    private javax.swing.JPanel conPanel;
    private javax.swing.JButton espButton;
    private javax.swing.JPanel espPanel;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel lateralPanel;
    private javax.swing.JButton medButton;
    private javax.swing.JPanel medPanel;
    private javax.swing.JButton pacButton;
    private javax.swing.JPanel pacPanel;
    // End of variables declaration//GEN-END:variables

    private static class conPannel {

        private static void setComponentAt(int i, AgendarConsulta agendarConsultaPanel) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void setTitleAt(int i, String agendar_Consulta) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void setSelectedIndex(int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public conPannel() {
        }
    }
}
