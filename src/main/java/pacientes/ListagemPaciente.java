package pacientes;

import entidades.Paciente;
import clinica.daos.PacienteDao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListagemPaciente extends javax.swing.JFrame {

    private PacienteDao pacienteDao;

    public ListagemPaciente() {
        initComponents();
        pacienteDao = new PacienteDao();
        carregarPacientes();
        
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });
        BtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarActionPerformed(evt);
            }
        });
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });
    }

    private void carregarPacientes() {
        DefaultTableModel model = (DefaultTableModel) TableListagemPaciente.getModel();
        model.setRowCount(0); // Limpa a tabela antes de carregar novos dados
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            List<Paciente> pacientes = pacienteDao.listar();
            for (Paciente p : pacientes) {
                model.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getCpf(),
                    sdf.format(p.getDataNascimento()),
                    p.getTelefone(),
                    p.getEndereco()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar pacientes: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = TableListagemPaciente.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) TableListagemPaciente.getModel();
            // Torna as células editáveis
            // A coluna 0 (Id) deve permanecer não editável, as outras podem ser editadas
            for (int i = 1; i < model.getColumnCount(); i++) { // Começa do índice 1 para pular o ID
                TableListagemPaciente.getColumnModel().getColumn(i).setCellEditor(TableListagemPaciente.getDefaultEditor(model.getColumnClass(i)));
            }
            JOptionPane.showMessageDialog(this, "Agora você pode editar as células da linha selecionada (exceto o ID). Clique em Salvar após a edição.", "Modo de Edição", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void BtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = TableListagemPaciente.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) TableListagemPaciente.getModel();
            try {
                int id = (int) model.getValueAt(selectedRow, 0);
                String nome = (String) model.getValueAt(selectedRow, 1);
                String cpf = (String) model.getValueAt(selectedRow, 2);
                String dataNascimentoStr = (String) model.getValueAt(selectedRow, 3);
                String telefone = (String) model.getValueAt(selectedRow, 4);
                String endereco = (String) model.getValueAt(selectedRow, 5);

                // Validação do CPF
                if (!cpf.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(this, "CPF inválido. Deve conter exatamente 11 dígitos numéricos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    carregarPacientes(); // Recarrega para desfazer edições inválidas
                    return;
                }
                
                // Validação do Telefone
                if (!telefone.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Telefone inválido. Deve conter apenas dígitos numéricos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    carregarPacientes(); // Recarrega para desfazer edições inválidas
                    return;
                }

                // Validação da data de nascimento
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false); // Não permite datas inválidas como 30/02/2023
                java.util.Date dataNascimento = null;
                try {
                    dataNascimento = sdf.parse(dataNascimentoStr);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(this, "Formato de data de nascimento inválido. Use dd/MM/yyyy.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    carregarPacientes(); // Recarrega para desfazer edições inválidas
                    return;
                }

                Paciente paciente = new Paciente(id, nome, cpf, telefone, endereco, dataNascimento);
                pacienteDao.atualizar(paciente);
                JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                carregarPacientes(); // Recarrega a tabela para mostrar os dados atualizados
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar paciente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para salvar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = TableListagemPaciente.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel model = (DefaultTableModel) TableListagemPaciente.getModel();
            int id = (int) model.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este paciente?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    pacienteDao.excluir(id);
                    JOptionPane.showMessageDialog(this, "Paciente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarPacientes(); // Recarrega a tabela
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir paciente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableListagemPaciente = new javax.swing.JTable();
        BtnEditar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        BtnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableListagemPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "CPF", "Nascimento", "Telefone", "Endereco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableListagemPaciente);

        BtnEditar.setText("Editar");

        BtnExcluir.setText("Excluir");

        BtnSalvar.setText("Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEditar)
                    .addComponent(BtnExcluir)
                    .addComponent(BtnSalvar))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(BtnEditar)
                .addGap(18, 18, 18)
                .addComponent(BtnExcluir)
                .addGap(18, 18, 18)
                .addComponent(BtnSalvar)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ListagemPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListagemPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListagemPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListagemPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListagemPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JTable TableListagemPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}


