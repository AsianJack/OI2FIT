package View;

import DAO.AlunoDAO;
import Model.Aluno;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ConsultarAluno extends javax.swing.JFrame {

    AlunoDAO daoaluno = new AlunoDAO();

    int id_colab;
    
    String frase = "";
    String item = "";

    public ConsultarAluno(int id_colab) {
        try {
            initComponents();
            this.id_colab = id_colab;
            System.out.println(id_colab);
            daoaluno.conexao();
            daoaluno.consultarAlu(id_colab);
            listALL.setModel(daoaluno.listar());

        } catch (IOException b) {
            JOptionPane.showMessageDialog(null, "Conexão não foi estabelecida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ConsultarAluno() {
  
            initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt_fechar = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        bt_pesquisar = new javax.swing.JButton();
        tf_busca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listALL = new javax.swing.JList<>();
        bt_editar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 51, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alunos");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(570, 10, 80, 24);

        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Oi2Fit");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 10, 60, 24);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 670, 40);

        bt_fechar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_fechar.setText("Fechar");
        bt_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fecharActionPerformed(evt);
            }
        });
        getContentPane().add(bt_fechar);
        bt_fechar.setBounds(540, 330, 90, 40);

        bt_editar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_editar.setText("Medidas");
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_medidasActionPerformed(evt);
            }
        });
        getContentPane().add(bt_editar);
        bt_editar.setBounds(280, 330, 120, 40);

        bt_excluir.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_excluir.setText("Excluir cadastro");
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });
        getContentPane().add(bt_excluir);
        bt_excluir.setBounds(150, 330, 120, 40);

        bt_pesquisar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_pesquisar.setText("Buscar");
        bt_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_pesquisar);
        bt_pesquisar.setBounds(530, 50, 100, 30);

        tf_busca.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tf_busca.setText("Digite o CPF do aluno...");
        getContentPane().add(tf_busca);
        tf_busca.setBounds(10, 50, 420, 30);

        listALL.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        listALL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listALLMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listALL);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 620, 230);

        bt_editar1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_editar1.setText("Editar cadastro");
        bt_editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editar1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt_editar1);
        bt_editar1.setBounds(10, 330, 130, 40);

        jButton1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jButton1.setText("Treino");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(410, 330, 120, 40);

        setSize(new java.awt.Dimension(667, 452));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_bt_fecharActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        try{
            listALL.removeAll();
            int i = Integer.valueOf(item);
            daoaluno.deletar(i);
            daoaluno.consultarAlu(id_colab);
            listALL.setModel(daoaluno.listar());
        }catch(NumberFormatException a){
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Error", JOptionPane.INFORMATION_MESSAGE);
        }    
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void listALLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listALLMouseClicked
        frase = listALL.getSelectedValue();
        item = frase.substring(frase.indexOf("ID") + 2, frase.indexOf("  Nome:"));
        System.out.println("id selecionado:" + item);
    }//GEN-LAST:event_listALLMouseClicked

    private void bt_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pesquisarActionPerformed
        String cpf = tf_busca.getText();
        if (tf_busca.getText().equalsIgnoreCase("")) {
            daoaluno.consultarTodos(id_colab);
            daoaluno.listar();
        }else {
            daoaluno.buscar(cpf, id_colab);            
            listALL.setModel(daoaluno.listar());
        }
    }//GEN-LAST:event_bt_pesquisarActionPerformed

    private void bt_editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editar1ActionPerformed
        try{
            frase = listALL.getSelectedValue();
            item = frase.substring(frase.indexOf(" CPF: ") + 7, frase.indexOf("  Sexo: "));
            EditarAluno janeditaraluno = new EditarAluno(daoaluno, item, id_colab);
            
            janeditaraluno.setVisible(true);
            dispose();
        }catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Error", JOptionPane.INFORMATION_MESSAGE);
        }    
    }//GEN-LAST:event_bt_editar1ActionPerformed

    private void bt_medidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_medidasActionPerformed
        try{
            frase = listALL.getSelectedValue();
            item = frase.substring(frase.indexOf(" CPF: ") + 7, frase.indexOf("  Sexo: "));
            MedidasAluno JMedidasAluno = new MedidasAluno(daoaluno, item, id_colab);
            JMedidasAluno.setVisible(true);
            dispose();
        }catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_medidasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            frase = listALL.getSelectedValue();
            item = frase.substring(frase.indexOf(" CPF: ") + 7, frase.indexOf("  Sexo: "));
            TreinoAluno JTreinoAluno = new TreinoAluno(daoaluno, item);
            JTreinoAluno.setVisible(true);
            dispose();
        }catch(NullPointerException a){
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new ConsultarAluno().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_editar1;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_fechar;
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
