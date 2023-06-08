
package View;


import DAO.AlunoDAO;
import Model.Aluno;
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author willi
 */
public class CadastrarAluno extends javax.swing.JFrame {

    
    Aluno alu = new Aluno();
    AlunoDAO daoaluno = new AlunoDAO();
        
    int id_colab;
    
    public CadastrarAluno(int id_colab) {
        try{
            initComponents();
            this.id_colab = id_colab;
            daoaluno.conexao();
        
        }catch(IOException b){
            JOptionPane.showMessageDialog(null, "Conexão não foi estabelecida", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public CadastrarAluno() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        btFechar = new javax.swing.JButton();
        bt_cadastrar = new javax.swing.JButton();
        lb_login = new javax.swing.JLabel();
        tf_idade = new javax.swing.JTextField();
        lb_senha = new javax.swing.JLabel();
        tf_emails = new javax.swing.JTextField();
        lb_sexo = new javax.swing.JLabel();
        tf_sexo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb_nome1 = new javax.swing.JLabel();
        lb_cpf = new javax.swing.JLabel();
        tf_cpf = new javax.swing.JTextField();

        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 51, 0));
        jLabel5.setText("Login");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        lb_nome.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lb_nome.setForeground(new java.awt.Color(204, 51, 0));
        lb_nome.setText("Cadastrar Aluno");
        getContentPane().add(lb_nome);
        lb_nome.setBounds(410, 50, 240, 30);

        tf_nome.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_nome);
        tf_nome.setBounds(380, 90, 280, 30);

        btFechar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btFechar);
        btFechar.setBounds(570, 290, 90, 30);

        bt_cadastrar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_cadastrar.setText("Cadastrar");
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_cadastrar);
        bt_cadastrar.setBounds(470, 290, 90, 30);

        lb_login.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_login.setForeground(new java.awt.Color(204, 51, 0));
        lb_login.setText("Idade:");
        getContentPane().add(lb_login);
        lb_login.setBounds(320, 210, 60, 30);

        tf_idade.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_idade);
        tf_idade.setBounds(380, 210, 280, 30);

        lb_senha.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_senha.setForeground(new java.awt.Color(204, 51, 0));
        lb_senha.setText("E-mail:");
        getContentPane().add(lb_senha);
        lb_senha.setBounds(320, 250, 60, 30);

        tf_emails.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_emails);
        tf_emails.setBounds(380, 250, 280, 30);

        lb_sexo.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_sexo.setForeground(new java.awt.Color(204, 51, 0));
        lb_sexo.setText("Sexo:");
        getContentPane().add(lb_sexo);
        lb_sexo.setBounds(320, 170, 60, 30);

        tf_sexo.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_sexo);
        tf_sexo.setBounds(380, 170, 280, 30);

        jPanel1.setBackground(new java.awt.Color(204, 51, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Oi2Fit");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 140, 150, 63);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 290, 390);

        lb_nome1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_nome1.setForeground(new java.awt.Color(204, 51, 0));
        lb_nome1.setText("Nome:");
        getContentPane().add(lb_nome1);
        lb_nome1.setBounds(320, 90, 60, 30);

        lb_cpf.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_cpf.setForeground(new java.awt.Color(204, 51, 0));
        lb_cpf.setText("CPF:");
        getContentPane().add(lb_cpf);
        lb_cpf.setBounds(320, 130, 60, 30);

        tf_cpf.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_cpf);
        tf_cpf.setBounds(380, 130, 280, 30);

        setSize(new java.awt.Dimension(709, 369));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        if (verificacampos()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Ok", JOptionPane.ERROR_MESSAGE);
        } else {
            alu.setNome_alu(tf_nome.getText());
            alu.setCpf_alu(tf_cpf.getText());
            alu.setSexo_alu(tf_sexo.getText());
            alu.setIdade_alu(Integer.parseInt(tf_idade.getText()));
            alu.setEmail_alu(tf_emails.getText());

            daoaluno.criarAlu(alu, id_colab);   
        }
        limpar();
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed
    
    private boolean verificacampos() {
        return (tf_nome.getText().equals("") || tf_sexo.getText().equals("") || tf_idade.getText().equals("") || tf_emails.getText().equals(""));
    }
    
    public void limpar(){
        tf_nome.setText("");
        tf_sexo.setText("");
        tf_idade.setText("");
        tf_emails.setText("");
        tf_cpf.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarAluno().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_cpf;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_nome1;
    private javax.swing.JLabel lb_senha;
    private javax.swing.JLabel lb_sexo;
    private javax.swing.JTextField tf_cpf;
    private javax.swing.JTextField tf_emails;
    private javax.swing.JTextField tf_idade;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_sexo;
    // End of variables declaration//GEN-END:variables
}
