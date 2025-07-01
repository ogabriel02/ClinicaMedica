package consultas;

import clinica.daos.ConsultaDao;
import clinica.daos.PacienteDao;
import clinica.daos.MedicoDao;
import clinica.daos.EspecialidadeDao;
import entidades.Consulta;
import entidades.Paciente;
import entidades.Medico;
import entidades.Especialidade;
import clinica.MenuScreen;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendarConsulta extends javax.swing.JFrame {

  private clinica.MenuScreen menuScreen;
    
    public AgendarConsulta() {
        initComponents();
        confButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        String nomePaciente = nomeText.getText().trim();
        String telefonePaciente = jTextField1.getText().trim();
        String nomeMedico = medText.getText().trim();
        String nomeEspecialidade = espText.getText().trim();
        String dataHoraStr = dthrText.getText().trim();
        boolean retorno = jCheckBox2.isSelected(); // Sim
        boolean convenio = jCheckBox3.isSelected(); // Sim

        if (nomePaciente.isEmpty() || telefonePaciente.isEmpty() || nomeMedico.isEmpty() || nomeEspecialidade.isEmpty() || dataHoraStr.isEmpty() || (!jCheckBox1.isSelected() && !jCheckBox2.isSelected()) || (!jCheckBox3.isSelected() && !jCheckBox4.isSelected())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Formatar data e hora
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date dataHora = sdf.parse(dataHoraStr);

            // Buscar ou criar Paciente
            PacienteDao pacienteDao = new PacienteDao();
            Paciente paciente = pacienteDao.buscarPorNome(nomePaciente); 
            if (paciente == null) {
                // Se o paciente não existe, cria um novo (simplificado, pode precisar de mais campos)
                paciente = new Paciente();
                paciente.setNome(nomePaciente);
                paciente.setTelefone(telefonePaciente);
                // Outros campos do paciente podem ser solicitados ou preenchidos com valores padrão
                pacienteDao.inserir(paciente);
                paciente = pacienteDao.buscarPorNome(nomePaciente); // Busca novamente para obter o ID gerado
            }

            // Buscar Medico
            MedicoDao medicoDao = new MedicoDao();
            Medico medico = medicoDao.buscarPorNome(nomeMedico); 
            if (medico == null) {
                JOptionPane.showMessageDialog(null, "Médico não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar Especialidade
            EspecialidadeDao especialidadeDao = new EspecialidadeDao();
            Especialidade especialidade = especialidadeDao.buscarPorNome(nomeEspecialidade);
            if (especialidade == null) {
                JOptionPane.showMessageDialog(null, "Especialidade não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criar e inserir Consulta
            Consulta consulta = new Consulta();
            consulta.setPaciente(paciente);
            consulta.setMedico(medico);
            consulta.setEspecialidade(especialidade);
            consulta.setDataHora(dataHora);
            consulta.setRetorno(retorno);
            consulta.setTipo(convenio ? "Convênio" : "Particular");

            ConsultaDao consultaDao = new ConsultaDao();
            consultaDao.inserir(consulta);

            JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso!");
            // Limpar campos ou fechar janela
            // dispose(); 

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data e hora inválido. Use dd/MM/yyyy HH:mm", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao agendar consulta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
});

fecButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        dispose(); // Fecha a janela atual
    }
});

desmButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        new CancelarConsulta().setVisible(true); // Abre a tela CancelarConsulta
        if (menuScreen != null) {
            menuScreen.dispose(); // Fecha a MenuScreen
        }
        dispose(); // Fecha a tela AgendarConsulta (se ainda quiser que ela feche)
    }
});

    } 
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        nomeText = new javax.swing.JTextField();
        medText = new javax.swing.JTextField();
        espText = new javax.swing.JTextField();
        dthrText = new javax.swing.JTextField();
        confButton = new javax.swing.JButton();
        fecButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        desmButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel1.setText("AGENDAR CONSULTA");

        jLabel2.setText("Nome Do Paciente");

        jLabel3.setText("Médico");

        jLabel4.setText("Especialidade");

        jLabel5.setText("Data e Hora");

        jCheckBox1.setText("Não");

        jLabel7.setText("Retorno");

        jCheckBox2.setText("Sim");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        nomeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextActionPerformed(evt);
            }
        });

        dthrText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dthrTextActionPerformed(evt);
            }
        });

        confButton.setText("Confirmar");
        confButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confButtonActionPerformed(evt);
            }
        });

        fecButton.setText("Fechar");

        jLabel6.setText("Telefone");

        jLabel8.setText("Convênio");

        jCheckBox3.setText("Sim");

        jCheckBox4.setText("Não");

        desmButton.setText("Desmarcar");
        desmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(confButton)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(medText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(espText, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dthrText, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jCheckBox2)
                                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jCheckBox1)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(fecButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(desmButton))))
                            .addComponent(jLabel7)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 101, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(medText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(espText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dthrText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jCheckBox3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confButton)
                    .addComponent(fecButton)
                    .addComponent(desmButton))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void dthrTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dthrTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dthrTextActionPerformed

    private void confButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confButtonActionPerformed

    private void desmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desmButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desmButtonActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendarConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confButton;
    private javax.swing.JToggleButton desmButton;
    private javax.swing.JTextField dthrText;
    private javax.swing.JTextField espText;
    private javax.swing.JButton fecButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField medText;
    private javax.swing.JTextField nomeText;
    // End of variables declaration//GEN-END:variables
}


