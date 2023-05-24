
package View;


import DAO.ColaboradorDAO;
import Model.Colaborador;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 *
 * @author Ramon
 */
public class CadastrarColaborador extends javax.swing.JFrame {

    
    Colaborador colab = new Colaborador();
    ColaboradorDAO daocolaborador = new ColaboradorDAO();
        
       
    
    public CadastrarColaborador() {
        try{
            initComponents();
            daocolaborador.conexao();
        
        }catch(IOException b){
            JOptionPane.showMessageDialog(null, "Conexão não foi estabelecida", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        tf_login = new javax.swing.JTextField();
        lb_senha = new javax.swing.JLabel();
        tf_senha = new javax.swing.JTextField();
        lb_cpf = new javax.swing.JLabel();
        tf_cpf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb_nome1 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 51, 0));
        jLabel5.setText("Login");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        lb_nome.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lb_nome.setForeground(new java.awt.Color(204, 51, 0));
        lb_nome.setText("Cadastrar Colaborador");
        getContentPane().add(lb_nome);
        lb_nome.setBounds(60, 50, 280, 30);

        tf_nome.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_nome);
        tf_nome.setBounds(90, 110, 250, 30);

        btFechar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btFechar);
        btFechar.setBounds(250, 280, 90, 30);

        bt_cadastrar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_cadastrar.setText("Cadastrar");
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_cadastrar);
        bt_cadastrar.setBounds(150, 280, 90, 30);

        lb_login.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_login.setForeground(new java.awt.Color(204, 51, 0));
        lb_login.setText("Login:");
        getContentPane().add(lb_login);
        lb_login.setBounds(30, 189, 60, 30);

        tf_login.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_login);
        tf_login.setBounds(90, 190, 250, 30);

        lb_senha.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_senha.setForeground(new java.awt.Color(204, 51, 0));
        lb_senha.setText("Senha:");
        getContentPane().add(lb_senha);
        lb_senha.setBounds(30, 230, 60, 30);

        tf_senha.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tf_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_senhaActionPerformed(evt);
            }
        });
        getContentPane().add(tf_senha);
        tf_senha.setBounds(90, 230, 250, 30);

        lb_cpf.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_cpf.setForeground(new java.awt.Color(204, 51, 0));
        lb_cpf.setText("CPF:");
        getContentPane().add(lb_cpf);
        lb_cpf.setBounds(30, 149, 60, 30);

        tf_cpf.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_cpf);
        tf_cpf.setBounds(90, 150, 250, 30);

        jPanel1.setBackground(new java.awt.Color(204, 51, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Oi2Fit");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 140, 150, 63);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(370, 0, 290, 390);

        lb_nome1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_nome1.setForeground(new java.awt.Color(204, 51, 0));
        lb_nome1.setText("Nome:");
        getContentPane().add(lb_nome1);
        lb_nome1.setBounds(30, 110, 60, 30);

        setSize(new java.awt.Dimension(664, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        if (verificacampos()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Ok", JOptionPane.ERROR_MESSAGE);
        } else {
            colab.setNome_colab(tf_nome.getText());
            colab.setCpf_colab(tf_cpf.getText());
            colab.setLogin_colab(tf_login.getText());
            //funcao de hash vai aqui
            
            String senha = tf_senha.getText();
            String hashSenha = daocolaborador.gerarHashSenha(senha);
            System.out.println("\n" + senha);
            System.out.println("\n" + hashSenha);
            colab.setSenha_colab(hashSenha);
            
            daocolaborador.criarColab(colab);  
        }
        limpar();
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void tf_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_senhaActionPerformed
    
    private boolean verificacampos() {
        return (tf_nome.getText().equals("") || tf_cpf.getText().equals("") || tf_login.getText().equals("") || tf_senha.getText().equals(""));
    }
    
    public void limpar(){
        tf_nome.setText("");
        tf_cpf.setText("");
        tf_login.setText("");
        tf_senha.setText("");
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
            java.util.logging.Logger.getLogger(CadastrarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarColaborador().setVisible(true);
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
    private javax.swing.JTextField tf_cpf;
    private javax.swing.JTextField tf_login;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_senha;
    // End of variables declaration//GEN-END:variables
}
