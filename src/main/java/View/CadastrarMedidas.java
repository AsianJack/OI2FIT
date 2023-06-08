/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.AlunoDAO;
import Model.Aluno;
import Model.Medidas;
import javax.swing.JOptionPane;

/**
 *
 * @author William Tanaka
 */
public class CadastrarMedidas extends javax.swing.JFrame {

    Aluno alu = new Aluno();
    Medidas med = new Medidas();
    
    AlunoDAO daoaluno = new AlunoDAO();
    int id_colab;
    
    public CadastrarMedidas() {
        initComponents();
    }
    
    public CadastrarMedidas(AlunoDAO a, String cpf, int id_colab) {
        initComponents();
        daoaluno = a;
        if(daoaluno.pesquisa(cpf)){
            med.setId_alu(daoaluno.getAluno().getId_alu());
            alu.setId_alu(daoaluno.getAluno().getId_alu());     
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_cadastrar_medidas = new javax.swing.JLabel();
        tf_peso = new javax.swing.JTextField();
        btFechar = new javax.swing.JButton();
        bt_cadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb_peso = new javax.swing.JLabel();
        lb_altura = new javax.swing.JLabel();
        tf_altura = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lb_cadastrar_medidas.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lb_cadastrar_medidas.setForeground(new java.awt.Color(204, 51, 0));
        lb_cadastrar_medidas.setText("Cadastrar Medidas do Aluno");
        getContentPane().add(lb_cadastrar_medidas);
        lb_cadastrar_medidas.setBounds(350, 50, 330, 30);

        tf_peso.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_peso);
        tf_peso.setBounds(380, 140, 280, 30);

        btFechar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btFechar);
        btFechar.setBounds(570, 280, 90, 40);

        bt_cadastrar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_cadastrar.setText("Cadastrar");
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_cadastrar);
        bt_cadastrar.setBounds(470, 280, 90, 40);

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

        lb_peso.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_peso.setForeground(new java.awt.Color(204, 51, 0));
        lb_peso.setText("Peso:");
        getContentPane().add(lb_peso);
        lb_peso.setBounds(320, 140, 60, 30);

        lb_altura.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_altura.setForeground(new java.awt.Color(204, 51, 0));
        lb_altura.setText("Altura:");
        getContentPane().add(lb_altura);
        lb_altura.setBounds(320, 200, 60, 30);

        tf_altura.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        getContentPane().add(tf_altura);
        tf_altura.setBounds(380, 200, 280, 30);

        setSize(new java.awt.Dimension(725, 399));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        MedidasAluno md = new MedidasAluno(daoaluno, daoaluno.getAluno().getCpf_alu(), id_colab);
        md.setVisible(true);
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        if (verificacampos()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Ok", JOptionPane.ERROR_MESSAGE);

        } else {
            med.setPeso(Float.parseFloat(tf_peso.getText()));
            med.setAltura(Float.parseFloat(tf_altura.getText()));
            med.setImc(med.get_peso()/(med.get_altura()*med.get_altura()));
            med.setId_alu(daoaluno.getAluno().getId_alu());
            daoaluno.criarMedida(med);
            //daoaluno.Editar(alu);
        }
    }//GEN-LAST:event_bt_cadastrarActionPerformed

     private boolean verificacampos() {
        return (tf_peso.getText().equals("") || tf_altura.getText().equals(""));
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
            java.util.logging.Logger.getLogger(CadastrarMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastrarMedidas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_altura;
    private javax.swing.JLabel lb_cadastrar_medidas;
    private javax.swing.JLabel lb_peso;
    private javax.swing.JTextField tf_altura;
    private javax.swing.JTextField tf_peso;
    // End of variables declaration//GEN-END:variables
}
