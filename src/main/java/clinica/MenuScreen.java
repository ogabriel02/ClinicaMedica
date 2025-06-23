package clinica;

import consultas.AgendarConsulta;
import java.awt.BorderLayout;

public class MenuScreen extends javax.swing.JFrame {
     private final AgendarConsultaPanel agendarConsultaPanel;
     private final CadastroMedicoPanel cadastroMedicoPanel;
     private final CadastroEspecialidadePanel cadastroEspecialidadePanel;
     private final CadastroPacientePanel cadastroPacientePanel;
     private final ListaMedPanel listaMedPanel = new ListaMedPanel();
     private final ListaPacPanel listaPacPanel = new ListaPacPanel();
     private final ListaEspPanel listaEspPanel = new ListaEspPanel();

    public MenuScreen() {
        initComponents();
        // Inicializa a tela de AgendarConsulta embutida
    agendarConsultaPanel = new AgendarConsultaPanel();
    cadastroMedicoPanel = new CadastroMedicoPanel();
    cadastroEspecialidadePanel = new CadastroEspecialidadePanel();
    cadastroPacientePanel = new CadastroPacientePanel();

    conPanel.removeAll();
    conPanel.setLayout(new BorderLayout());
    conPanel.add(agendarConsultaPanel, BorderLayout.CENTER);
    conPanel.revalidate();
    conPanel.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lateralPanel = new javax.swing.JPanel();
        conButton = new javax.swing.JButton();
        medButton = new javax.swing.JButton();
        pacButton = new javax.swing.JButton();
        espButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lista1 = new javax.swing.JButton();
        lista3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lista2 = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        conPanel = new javax.swing.JPanel();
        medPanel = new javax.swing.JPanel();
        pacPanel = new javax.swing.JPanel();
        espPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastros");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Listas");

        lista1.setText("Médicos");
        lista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista1ActionPerformed(evt);
            }
        });

        lista3.setText("Especialidaes");
        lista3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista3ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        lista2.setText("Pacientes");
        lista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lista2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lateralPanelLayout = new javax.swing.GroupLayout(lateralPanel);
        lateralPanel.setLayout(lateralPanelLayout);
        lateralPanelLayout.setHorizontalGroup(
            lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(lateralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(conButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(medButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pacButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(espButton)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lista1)
                    .addGroup(lateralPanelLayout.createSequentialGroup()
                        .addComponent(lista3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lista2))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        lateralPanelLayout.setVerticalGroup(
            lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lateralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(conButton)
                .addGap(29, 29, 29)
                .addComponent(medButton)
                .addGap(29, 29, 29)
                .addComponent(pacButton)
                .addGap(29, 29, 29)
                .addComponent(espButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(lista1)
                .addGap(29, 29, 29)
                .addComponent(lista2)
                .addGap(29, 29, 29)
                .addGroup(lateralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lista3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout conPanelLayout = new javax.swing.GroupLayout(conPanel);
        conPanel.setLayout(conPanelLayout);
        conPanelLayout.setHorizontalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
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
            .addGap(0, 686, Short.MAX_VALUE)
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
            .addGap(0, 686, Short.MAX_VALUE)
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
            .addGap(0, 686, Short.MAX_VALUE)
        );
        espPanelLayout.setVerticalGroup(
            espPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab4", espPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab5", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab6", jPanel2);

        jPanel3.setPreferredSize(new java.awt.Dimension(600, 500));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 488, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab7", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lateralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lateralPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
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

    private void lista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista1ActionPerformed
    jPanel1.removeAll();
    jPanel1.setLayout(new BorderLayout());
    jPanel1.add(listaMedPanel, BorderLayout.CENTER);
    jPanel1.revalidate();
    jPanel1.repaint();
    jTabbedPane.setSelectedComponent(jPanel1);
    }//GEN-LAST:event_lista1ActionPerformed

    private void lista3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista3ActionPerformed
    jPanel3.removeAll();
    jPanel3.setLayout(new BorderLayout());
    jPanel3.add(listaEspPanel, BorderLayout.CENTER);
    jPanel3.revalidate();
    jPanel3.repaint();
    jTabbedPane.setSelectedComponent(jPanel3);
    }//GEN-LAST:event_lista3ActionPerformed

    private void lista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lista2ActionPerformed
    jPanel2.removeAll();
    jPanel2.setLayout(new BorderLayout());
    jPanel2.add(listaPacPanel, BorderLayout.CENTER);
    jPanel2.revalidate();
    jPanel2.repaint();
    jTabbedPane.setSelectedComponent(jPanel2);
    }//GEN-LAST:event_lista2ActionPerformed
 
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel lateralPanel;
    private javax.swing.JButton lista1;
    private javax.swing.JButton lista2;
    private javax.swing.JButton lista3;
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
