package pacientes;

import entidades.Paciente;
import clinica.daos.PacienteDao;
import java.awt.Window;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CadastroPaciente extends javax.swing.JFrame {

    public CadastroPaciente() {
        initComponents();
        // Adiciona o listener para o botão Salvar
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        
        // Adiciona DocumentFilter para TextCpf (apenas números, 11 dígitos)
        ((AbstractDocument) TextCpf.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (string.length() <= 11 && string.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (string.length() <= 11 && string.matches("\\d*")) {
                    super.insertString(fb, offset, text, attrs);
                }
            }
        });
        
            // Adiciona DocumentFilter para TextTelefone (apenas números, até 11 dígitos)
        ((AbstractDocument) TextTelefone.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (string.length() <= 11 && string.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
            String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
            if (string.length() <= 11 && string.matches("\\d*")) {
                super.insertString(fb, offset, text, attrs);
            }
        }
    });
        
        // Adiciona DocumentFilter para TextId (apenas números)
        ((AbstractDocument) TextId.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (string.length() <= 5 && string.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (string.length() <= 5 && string.matches("\\d*")) {
                    super.insertString(fb, offset, text, attrs);
                }
            }
        });
        
        // Adiciona DocumentFilter para TextDataNascimento (apenas números e barras)
        ((AbstractDocument) TextDataNascimento.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (string.matches("[0-9/]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (string.matches("[0-9/]*")) {
                    super.insertString(fb, offset, text, attrs);
                }
            }
        });
    }

private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
    String nome = TextNome.getText().trim();
    String cpf = TextCpf.getText().trim();
    String telefone = TextTelefone.getText().trim();
    String endereco = TextEndereco.getText().trim();
    String dataNascimentoStr = TextDataNascimento.getText().trim();
    String idText = TextId.getText().trim();

    // Validação do ID
    if (idText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "O campo ID é obrigatório!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int id;
    try {
        id = Integer.parseInt(idText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "O campo ID deve ser um número válido!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validação do Nome
    if (nome.isEmpty() || !nome.matches("[a-zA-ZáéíóúâêîôûãõçÁÉÍÓÚÂÊÎÔÛÃÕÇ ]+")) {
        JOptionPane.showMessageDialog(this, "O campo Nome é obrigatório e deve conter apenas letras.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validação do CPF
    if (!cpf.matches("\\d{11}")) {
        JOptionPane.showMessageDialog(this, "CPF inválido. Deve conter exatamente 11 dígitos numéricos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validação do Telefone
    if (!telefone.isEmpty() && !telefone.matches("\\d{10,11}")) {
        JOptionPane.showMessageDialog(this, "O campo Telefone deve conter 10 ou 11 dígitos (se preenchido).", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validação da data de nascimento
    Date dataNascimento = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false); // Não permite datas inválidas como 30/02/2023
    try {
        dataNascimento = sdf.parse(dataNascimentoStr);
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Formato de data de nascimento inválido. Use dd/MM/yyyy.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Paciente paciente = new Paciente();
    paciente.setId(id);
    paciente.setNome(nome);
    paciente.setCpf(cpf);
    paciente.setTelefone(telefone);
    paciente.setEndereco(endereco);
    paciente.setDataNascimento(dataNascimento);

    PacienteDao dao = new PacienteDao();
    try {
        dao.inserir(paciente);
        JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        // Atualizar a listagem de pacientes
        for (Window window : Window.getWindows()) {
            if (window instanceof ListagemPaciente) {
                ((ListagemPaciente) window).carregarPacientes();
            }
        }

        // Limpar campos após o cadastro
        TextNome.setText("");
        TextCpf.setText("");
        TextTelefone.setText("");
        TextEndereco.setText("");
        TextDataNascimento.setText("");
        TextId.setText("");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar paciente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextCpf = new javax.swing.JTextField();
        TextTelefone = new javax.swing.JTextField();
        TextNome = new javax.swing.JTextField();
        TextEndereco = new javax.swing.JTextField();
        TextId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextDataNascimento = new javax.swing.JTextPane();
        btnSalvar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel1.setText("CADASTRO PACIENTE");

        jLabel2.setText("Nome:");

        jLabel7.setText("Data Nascimento:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("Endereço:");

        jLabel6.setText("Id:");

        TextTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTelefoneActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(TextDataNascimento);

        btnSalvar.setText("Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(TextId))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(TextEndereco))))
                        .addGap(0, 212, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(TextNome))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnSalvar)
                .addGap(0, 93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTelefoneActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextCpf;
    private javax.swing.JTextPane TextDataNascimento;
    private javax.swing.JTextField TextEndereco;
    private javax.swing.JTextField TextId;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextTelefone;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}


