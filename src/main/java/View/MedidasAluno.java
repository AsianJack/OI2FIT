/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.AlunoDAO;
import DAO.RelatorioDAO;
import Model.Aluno;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class MedidasAluno extends javax.swing.JFrame {

    Aluno alu = new Aluno();
    AlunoDAO daoaluno = new AlunoDAO();
    RelatorioDAO rel = new RelatorioDAO();
    
    int id_colab;
    String frase = "";
    String item = "";
    
    public MedidasAluno() {
        initComponents();
    }
    
    public MedidasAluno(AlunoDAO a, String cpf, int id_colab) {
        initComponents();
        this.id_colab = id_colab;
        daoaluno = a;
        rel.criaConexao();
        if(daoaluno.pesquisa(cpf)){
            alu.setId_alu(daoaluno.getAluno().getId_alu());  
            lb_nome.setText(daoaluno.getAluno().getNome_alu());
            
            daoaluno.consultarMedidas(daoaluno.getAluno().getId_alu());
            listALL.setModel(daoaluno.listarMedidas()); 
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_fechar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listALL = new javax.swing.JList<>();
        bt_relatorios = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_lista_medidas = new javax.swing.JLabel();
        bt_cadastrar_medida = new javax.swing.JButton();
        lb_nome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        bt_fechar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_fechar.setText("Fechar");
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });
        getContentPane().add(bt_fechar);
        bt_fechar.setBounds(450, 330, 90, 40);

        bt_excluir.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_excluir.setText("Excluir medida");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });
        getContentPane().add(bt_excluir);
        bt_excluir.setBounds(150, 330, 110, 40);

        listALL.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        listALL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listALLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listALL);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 530, 230);

        bt_relatorios.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_relatorios.setText("Relatório Evolução");
        bt_relatorios.setActionCommand("Nova medida");
        bt_relatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_relatoriosActionPerformed(evt);
            }
        });
        getContentPane().add(bt_relatorios);
        bt_relatorios.setBounds(400, 50, 140, 30);

        jPanel1.setBackground(new java.awt.Color(204, 51, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Medidas do aluno");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(370, 10, 170, 24);

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Oi2Fit");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 10, 60, 24);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 560, 40);

        lb_lista_medidas.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_lista_medidas.setForeground(new java.awt.Color(204, 51, 0));
        lb_lista_medidas.setText("Lista de medidas:");
        getContentPane().add(lb_lista_medidas);
        lb_lista_medidas.setBounds(10, 50, 130, 32);

        bt_cadastrar_medida.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_cadastrar_medida.setText("Cadastrar medida");
        bt_cadastrar_medida.setActionCommand("Nova medida");
        bt_cadastrar_medida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrar_medidaActionPerformed(evt);
            }
        });
        getContentPane().add(bt_cadastrar_medida);
        bt_cadastrar_medida.setBounds(10, 330, 130, 40);

        lb_nome.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_nome.setForeground(new java.awt.Color(102, 51, 0));
        getContentPane().add(lb_nome);
        lb_nome.setBounds(130, 50, 140, 32);

        setSize(new java.awt.Dimension(574, 429));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        try{
            listALL.removeAll();
            int i = Integer.parseInt(item);
            daoaluno.deletarMedida(i);
            daoaluno.consultarMedidas(daoaluno.getAluno().getId_alu());
            listALL.setModel(daoaluno.listarMedidas());
        }catch(NumberFormatException a){
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void listALLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listALLMouseClicked
        frase = listALL.getSelectedValue();
        item = frase.substring(frase.indexOf("ID") + 2, frase.indexOf("  Peso:"));
        System.out.println("id selecionado:" + item);
    }//GEN-LAST:event_listALLMouseClicked

    private void bt_relatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_relatoriosActionPerformed
        Map parametros = new HashMap();
        parametros.put("idaluno", daoaluno.getAluno().getId_alu());
        rel.relatorioEvolucaoCorporal(true, parametros);
    }//GEN-LAST:event_bt_relatoriosActionPerformed

    private void bt_cadastrar_medidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrar_medidaActionPerformed
       CadastrarMedidas JCadastraMedida = new CadastrarMedidas(daoaluno, daoaluno.getAluno().getCpf_alu(), id_colab);
       JCadastraMedida.setVisible(true);
       dispose();
    }//GEN-LAST:event_bt_cadastrar_medidaActionPerformed

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
            java.util.logging.Logger.getLogger(MedidasAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedidasAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedidasAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedidasAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MedidasAluno().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrar_medida;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_fechar;
    private javax.swing.JButton bt_relatorios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_lista_medidas;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JList<String> listALL;
    // End of variables declaration//GEN-END:variables
}
