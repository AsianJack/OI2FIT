package View;

import DAO.AlunoDAO;
import View.ConsultarAluno;
import Model.Aluno;
import javax.swing.JOptionPane;

public class EditarAluno extends javax.swing.JFrame {

    Aluno alu = new Aluno();
    AlunoDAO daoaluno = new AlunoDAO();
    int id_colab;
            
    public EditarAluno() {
        initComponents();
    }

    public EditarAluno(AlunoDAO a, String cpf, int id_colab) {
        initComponents();
        this.id_colab = id_colab;
        
        daoaluno = a;
        if (daoaluno.pesquisa(cpf)) {
            alu.setId_alu(daoaluno.getAluno().getId_alu());
            tf_nomeP.setText(daoaluno.getAluno().getNome_alu());
            tf_cpf.setText(daoaluno.getAluno().getCpf_alu());
            tf_sexo.setText(daoaluno.getAluno().getSexo_alu());
            tf_idade.setText(Integer.toString(daoaluno.getAluno().getIdade_alu()));
            tf_email.setText(daoaluno.getAluno().getEmail_alu());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_nomeP = new javax.swing.JTextField();
        tf_sexo = new javax.swing.JTextField();
        tf_idade = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        bt_salvar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        tf_cpf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb_login = new javax.swing.JLabel();
        lb_senha = new javax.swing.JLabel();
        lb_sexo1 = new javax.swing.JLabel();
        lb_nome1 = new javax.swing.JLabel();
        lb_cpf1 = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        tf_nomeP.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tf_nomeP.setForeground(new java.awt.Color(204, 51, 0));
        getContentPane().add(tf_nomeP);
        tf_nomeP.setBounds(90, 80, 270, 30);

        tf_sexo.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tf_sexo.setForeground(new java.awt.Color(204, 51, 0));
        getContentPane().add(tf_sexo);
        tf_sexo.setBounds(90, 160, 270, 30);

        tf_idade.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tf_idade.setForeground(new java.awt.Color(204, 51, 0));
        getContentPane().add(tf_idade);
        tf_idade.setBounds(90, 200, 270, 30);

        tf_email.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tf_email.setForeground(new java.awt.Color(204, 51, 0));
        getContentPane().add(tf_email);
        tf_email.setBounds(90, 240, 270, 30);

        bt_salvar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        bt_salvar.setText("Gravar");
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_salvar);
        bt_salvar.setBounds(190, 290, 80, 30);

        btVoltar.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        btVoltar.setText("Fechar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btVoltar);
        btVoltar.setBounds(280, 290, 80, 30);

        tf_cpf.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tf_cpf.setForeground(new java.awt.Color(204, 51, 0));
        getContentPane().add(tf_cpf);
        tf_cpf.setBounds(90, 120, 270, 30);

        jPanel1.setBackground(new java.awt.Color(204, 51, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Oi2Fit");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 130, 150, 63);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(380, 0, 290, 390);

        lb_login.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_login.setForeground(new java.awt.Color(204, 51, 0));
        lb_login.setText("Idade:");
        getContentPane().add(lb_login);
        lb_login.setBounds(30, 200, 60, 30);

        lb_senha.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_senha.setForeground(new java.awt.Color(204, 51, 0));
        lb_senha.setText("E-mail:");
        getContentPane().add(lb_senha);
        lb_senha.setBounds(30, 240, 60, 30);

        lb_sexo1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_sexo1.setForeground(new java.awt.Color(204, 51, 0));
        lb_sexo1.setText("Sexo:");
        getContentPane().add(lb_sexo1);
        lb_sexo1.setBounds(30, 160, 60, 30);

        lb_nome1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_nome1.setForeground(new java.awt.Color(204, 51, 0));
        lb_nome1.setText("Nome:");
        getContentPane().add(lb_nome1);
        lb_nome1.setBounds(30, 80, 60, 30);

        lb_cpf1.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        lb_cpf1.setForeground(new java.awt.Color(204, 51, 0));
        lb_cpf1.setText("CPF:");
        getContentPane().add(lb_cpf1);
        lb_cpf1.setBounds(30, 120, 60, 30);

        lb_nome.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lb_nome.setForeground(new java.awt.Color(204, 51, 0));
        lb_nome.setText("Editar Aluno");
        getContentPane().add(lb_nome);
        lb_nome.setBounds(130, 30, 240, 30);

        setSize(new java.awt.Dimension(664, 398));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        if (verificacampos()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Ok", JOptionPane.ERROR_MESSAGE);

        } else {
            alu.setNome_alu(tf_nomeP.getText());
            alu.setCpf_alu(tf_cpf.getText());
            alu.setSexo_alu(tf_sexo.getText());
            alu.setIdade_alu(Integer.parseInt(tf_idade.getText()));
            alu.setEmail_alu(tf_email.getText());
            daoaluno.editar(alu);
     
        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        
        ConsultarAluno janconsultaraluno = new ConsultarAluno(id_colab);
        janconsultaraluno.setVisible(true);
        dispose();
        System.out.println(id_colab);

    }//GEN-LAST:event_btVoltarActionPerformed

    private boolean verificacampos() {
        return (tf_nomeP.getText().equals("") || tf_cpf.getText().equals("") || tf_sexo.getText().equals("") || tf_idade.getText().equals("") || tf_email.getText().equals(""));
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_cpf1;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_nome1;
    private javax.swing.JLabel lb_senha;
    private javax.swing.JLabel lb_sexo1;
    private javax.swing.JTextField tf_cpf;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_idade;
    private javax.swing.JTextField tf_nomeP;
    private javax.swing.JTextField tf_sexo;
    // End of variables declaration//GEN-END:variables
}
