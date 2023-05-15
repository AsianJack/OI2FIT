
package View;

import DAO.ColaboradorDAO;
import java.io.IOException;
import javax.swing.JOptionPane;


public class ConsultarColaborador extends javax.swing.JFrame {

   ColaboradorDAO daocolab = new ColaboradorDAO();
    
    
    String frase = "";
    String item = "";
    
    public ConsultarColaborador() {
        try{
            initComponents();
            daocolab.conexao();
            daocolab.consultarColab();
            listALL.setModel(daocolab.listar()); 
        
        }catch(IOException b){
            JOptionPane.showMessageDialog(null, "Conexão não foi estabelecida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        bt_pesquisar = new javax.swing.JButton();
        tf_busca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listALL = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 51, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Colaboradores");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(420, 10, 140, 24);

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Oi2Fit");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 10, 60, 24);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 560, 40);

        jButton1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 330, 90, 40);

        bt_editar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_editar.setText("Editar cadastro");
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_editar);
        bt_editar.setBounds(10, 330, 120, 40);

        bt_excluir.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_excluir.setText("Excluir cadastro");
        getContentPane().add(bt_excluir);
        bt_excluir.setBounds(140, 330, 120, 40);

        bt_pesquisar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_pesquisar.setText("Buscar");
        bt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_pesquisar);
        bt_pesquisar.setBounds(440, 50, 100, 30);

        tf_busca.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tf_busca.setText("Digite o CPF do colaborador...");
        getContentPane().add(tf_busca);
        tf_busca.setBounds(10, 50, 420, 30);

        listALL.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(listALL);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 530, 230);

        setSize(new java.awt.Dimension(570, 421));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        frase = listALL.getSelectedValue();
        item = frase.substring(frase.indexOf(" CPF: ") + 7, frase.indexOf("  Login: "));
        JanEditarColaborador janeditarcolaborador = new JanEditarColaborador(daocolab, item);
        janeditarcolaborador.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt_editarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarActionPerformed
        String cpf = tf_busca.getText();  
        if(tf_busca.getText().equalsIgnoreCase("")){
            daocolab.consultarColab();
            daocolab.listar();
        }else{
            daocolab.pesquisa(cpf);
            listALL.setModel(daocolab.listar());
        }
    }//GEN-LAST:event_bt_pesquisarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new ConsultarColaborador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_pesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listALL;
    private javax.swing.JTextField tf_busca;
    // End of variables declaration//GEN-END:variables
}
