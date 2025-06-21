package consultas;

import clinica.daos.ConsultaDao;
import clinica.daos.PacienteDao;
import entidades.Consulta;
import entidades.Paciente;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;

public class CancelarConsulta extends javax.swing.JFrame {

    public CancelarConsulta() {
        initComponents();
        okButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        String nomePaciente = jTextField1.getText().trim();

        if (nomePaciente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o nome do paciente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!simBox.isSelected()) {
            JOptionPane.showMessageDialog(null, "Você deve confirmar o cancelamento.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            PacienteDao pacienteDao = new PacienteDao();
            Paciente paciente = pacienteDao.buscarPorNome(nomePaciente);

            if (paciente == null) {
                JOptionPane.showMessageDialog(null, "Paciente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ConsultaDao consultaDao = new ConsultaDao();
            List<Consulta> consultas = consultaDao.listar(); // Lista todas as consultas
            
            boolean consultaEncontrada = false;
            for (Consulta c : consultas) {
                if (c.getPaciente() != null && c.getPaciente().getId() == paciente.getId()) {
                    consultaDao.deletar(c.getId());
                    consultaEncontrada = true;
                    break; 
                }
            }

            if (consultaEncontrada) {
                JOptionPane.showMessageDialog(null, "Consulta cancelada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma consulta encontrada para este paciente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cancelar consulta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
});

volButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        new AgendarConsulta().setVisible(true);
        dispose(); // Fecha a tela de cancelamento
    }
});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        simBox = new javax.swing.JCheckBox();
        naoBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        volButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do Paciente");

        jLabel2.setText("Deseja Cancelar a Consulta?");

        simBox.setText("Sim");

        naoBox.setText("Não");

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel3.setText("DESMARCAR CONSULTA");

        okButton.setText("Ok");

        volButton.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(simBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(okButton)
                                .addGap(18, 18, 18)
                                .addComponent(volButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(naoBox)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(10, 10, 10)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(simBox)
                    .addComponent(naoBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(volButton))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CancelarConsulta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JCheckBox naoBox;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox simBox;
    private javax.swing.JButton volButton;
    // End of variables declaration//GEN-END:variables
}


