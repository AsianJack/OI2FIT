/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BancoDeDados.DAO;
import Model.Aluno;
import Model.Medidas;
import Model.Treino;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.Calendar;

/**
 *
 * @author lucas
 */
public class AlunoDAO {

    //Para utilizar o properts
    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/main/java/BancoDeDados/configuracaoDAO.properties");
    private static final File config_fileTeste = new File(path + "/src/main/java/BancoDeDados/configuracaoDAOTeste.properties");
    DefaultListModel lista = new DefaultListModel();

    //Chamadas SQL para mexer no Banco de Dados
    int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
    int concorrencia = ResultSet.CONCUR_UPDATABLE;
    private final String criarAlu = "Insert into Aluno(nome_alu, cpf_alu, sexo_alu, idade_alu, email_alu, data_matricula_alu) values (?,?,?,?,?,?)";
    private final String editar = "Update Aluno Set nome_alu = ? , cpf_alu = ? ,sexo_alu = ?, idade_alu = ?, email_alu = ?, data_matricula_alu = ? where id_alu = ?";
    private final String consultar = "SELECT * FROM Aluno order by nome_alu";
    private static final String sqlexcluir = "DELETE FROM Aluno WHERE id_alu = ?";
    private static final String sqlconsultaralu = "SELECT * FROM Aluno WHERE cpf_alu = ? or nome_alu = ?";
    private static final String sqlconsultar = "SELECT * FROM Aluno order by id_alu";

    private static final String cadMedida = "Insert into Medidas(peso_kg, altura_m, imc, id_alu) values (?,?,?,?)";
    private static final String excMedida = "Delete from Medidas where id_medida = ?";
    private static final String consMedida = "Select * from Medidas where id_alu = ?";

    private static final String cadTreino = "Insert into Treino(atividade, id_alu) values (?,?)";
    private static final String excTreino = "Delete from Treino where id_treino = ?";
    private static final String consTreino = "Select * from Treino where id_alu = ?";
    
    private PreparedStatement pstdados = null;
    private ResultSet rsdados = null;
    private ResultSet rsdados2 = null;
    private ResultSet rsdados3 = null;
    Connection conn = null;
    private int execute = 0;
    CallableStatement callableStatement = null;

    public AlunoDAO() {

    }

    //Cria conexão com o banco de dados
    public boolean conexao() throws IOException {
        try {
            DAO.init(config_file);
            conn = DAO.getConnection();
            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
        return false;
    }

    public boolean conexaoTeste() throws IOException {
        try {
            DAO.init(config_fileTeste);
            conn = DAO.getConnection();
            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
        }
        return false;
    }

    public int criarAlu(Aluno alu) {
        try {
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
            pstdados = conn.prepareStatement(criarAlu, tipo, concorrencia);
            pstdados.setString(1, alu.getNome_alu());
            pstdados.setString(2, alu.getCpf_alu());
            pstdados.setString(3, alu.getSexo_alu());
            pstdados.setInt(4, alu.getIdade_alu());
            pstdados.setString(5, alu.getEmail_alu());
            pstdados.setString(6, timeStamp);
            execute = pstdados.executeUpdate();//retorna um numero positivo pra cima de 0 no caso, retorna 0 se caso nenhuma linha foi mudada
            pstdados.close();
            JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso.", "Ok", JOptionPane.INFORMATION_MESSAGE);
            return execute;

        } catch (SQLException se) {
            System.out.println("Erro ao criar aluno " + se);
        } catch (NumberFormatException nfe) {
            System.out.println("Idade precisa ser apenas numeros.");
        }
        return -1;
    }

    public int editar(Aluno alu) {
        try {
            System.out.println(alu.getId_alu());
            pstdados = conn.prepareStatement(editar, tipo, concorrencia);
            pstdados.setString(1, alu.getNome_alu());
            pstdados.setString(2, alu.getCpf_alu());
            pstdados.setString(3, alu.getSexo_alu());
            pstdados.setInt(4, alu.getIdade_alu());
            pstdados.setString(5, alu.getEmail_alu());
            pstdados.setString(6, alu.getData_matricula_alu());
            pstdados.setInt(7, alu.getId_alu());
            execute = pstdados.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno editado com sucesso.", "Ok", JOptionPane.INFORMATION_MESSAGE);
            return execute;
        } catch (SQLException se) {
            System.out.println("Erro ao editar " + se);
        }
        return -1;
    }

    public int criarMedida(Medidas med) {
        try {
            pstdados = conn.prepareStatement(cadMedida, tipo, concorrencia);
            pstdados.setFloat(1, med.get_peso());
            pstdados.setFloat(2, med.get_altura());
            pstdados.setFloat(3, med.get_imc());
            pstdados.setInt(4, med.getId_alu());
            execute = pstdados.executeUpdate();//retorna um numero positivo pra cima de 0 no caso, retorna 0 se caso nenhuma linha foi mudada
            pstdados.close();
            JOptionPane.showMessageDialog(null, "Medida inserida com sucesso.", "Ok", JOptionPane.INFORMATION_MESSAGE);
            return execute;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar medida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    public boolean deletarMedida(int id) {
        try {
            pstdados = conn.prepareStatement(excMedida, tipo, concorrencia);
            pstdados.setInt(1, id);
            int resposta = pstdados.executeUpdate();
            pstdados.close();

            return resposta == 1;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }
    
        public int criarTreino(Treino tr) {
        try {
            pstdados = conn.prepareStatement(cadTreino, tipo, concorrencia);
            pstdados.setString(1, tr.getAtividade());
            pstdados.setInt(2, tr.getId_alu());
            execute = pstdados.executeUpdate();//retorna um numero positivo pra cima de 0 no caso, retorna 0 se caso nenhuma linha foi mudada
            pstdados.close();
            JOptionPane.showMessageDialog(null, "Treino inserido com sucesso.", "Ok", JOptionPane.INFORMATION_MESSAGE);
            return execute;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar treino.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(se);
        }
        return -1;
    }
        
    public boolean deletarTreino(int id) {
        try {
            pstdados = conn.prepareStatement(excTreino, tipo, concorrencia);
            pstdados.setInt(1, id);
            int resposta = pstdados.executeUpdate();
            pstdados.close();
            return true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public boolean consultarAlu() {
        try {
            pstdados = conn.prepareStatement(consultar, tipo, concorrencia);
            rsdados = pstdados.executeQuery();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao realizar consulta = " + erro);
        }
        return false;
    }

    public boolean consultarMedidas(int id) {
        try {
            pstdados = conn.prepareStatement(consMedida, tipo, concorrencia);
            pstdados.setInt(1, id);
            rsdados2 = pstdados.executeQuery();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao realizar consulta = " + erro);
        }
        return false;
    }
    
    public boolean consultarTreino(int id) {
        try {
            pstdados = conn.prepareStatement(consTreino, tipo, concorrencia);
            pstdados.setInt(1, id);
            rsdados3 = pstdados.executeQuery();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao realizar consulta = " + erro);
        }
        return false;
    }
    
    public boolean consultarTodos() {
        try {
            pstdados = conn.prepareStatement(sqlconsultar, tipo, concorrencia);
            rsdados = pstdados.executeQuery();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao realizar consulta = " + erro);
        }
        return false;
    }

    public boolean deletar(int id) {
        try {
            pstdados = conn.prepareStatement(sqlexcluir, tipo, concorrencia);
            pstdados.setInt(1, id);
            int resposta = pstdados.executeUpdate();
            pstdados.close();

            return resposta == 1;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public boolean pesquisa(String cpf) {
        try {
            pstdados = conn.prepareStatement(sqlconsultaralu, tipo, concorrencia);
            pstdados.setString(1, cpf);
            pstdados.setString(2, cpf);
            rsdados = pstdados.executeQuery();

            if (rsdados.first()) {

            }

            return true;
        } catch (SQLException sqlerro) {

        }
        return false;
    }

    public DefaultListModel listar() {
        lista.removeAllElements();
        try {
            if (!rsdados.first()) {
                return lista;
            } else {
                do {
                    lista.addElement("ID" + getAluno().getId_alu() + "  Nome:  " + getAluno().getNome_alu() + "  CPF:  " + getAluno().getCpf_alu() + "  Sexo:  " + getAluno().getSexo_alu() + "  Idade:  " + getAluno().getIdade_alu() + "  Email:  " + getAluno().getEmail_alu());
                } while (rsdados.next());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lista", "erro", JOptionPane.ERROR_MESSAGE);

        }
        return lista;
    }

    public DefaultListModel listarMedidas() {

        lista.removeAllElements();
        try {
            if (!rsdados2.first()) {
                return lista;
            } else {
                do {
                    lista.addElement("ID" + getMedida().getId_medida() + "  Peso:  " + getMedida().get_peso() + "  Altura:  " + getMedida().get_altura() + "  IMC:  " + getMedida().get_imc());
                } while (rsdados2.next());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lista", "erro", JOptionPane.ERROR_MESSAGE);

        }
        return lista;
    }

        public DefaultListModel listarTreino() {

        lista.removeAllElements();
        try {
            if (!rsdados3.first()) {
                return lista;
            } else {
                do {
                    lista.addElement("ID" + getTreino().getId_treino() +"  Id_Treino"+ getTreino().getId_treino() + "  Treino:  " + getTreino().getAtividade());
                } while (rsdados3.next());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lista", "erro", JOptionPane.ERROR_MESSAGE);

        }
        return lista;
    }
    
    public Aluno getAluno() {
        Aluno alu = null;
        if (rsdados != null) {
            try {
                int id = rsdados.getInt("id_alu");
                String nome = rsdados.getString("nome_alu");
                String cpf = rsdados.getString("cpf_alu");
                String sexo = rsdados.getString("sexo_alu");
                int idade = rsdados.getInt("idade_alu");
                String email = rsdados.getString("email_alu");
                String data_matricula = rsdados.getString("data_matricula_alu");
                alu = new Aluno(id, nome, cpf, sexo, idade, email, data_matricula);
            } catch (SQLException erro) {
                System.out.println(erro);
            }
        }
        return alu;
    }

    public Medidas getMedida() {
        Medidas med = null;
        if (rsdados2 != null) {
            try {
                int id_medida = rsdados2.getInt("id_medida");
                int id_alu = rsdados2.getInt("id_alu");
                float peso = rsdados2.getFloat("peso_kg");
                float altura = rsdados2.getFloat("altura_m");
                float imc = rsdados2.getFloat("imc");
                med = new Medidas(id_medida, peso, altura, imc, id_alu);
            } catch (SQLException erro) {
                System.out.println(erro);
            }
        }
        return med;

    }

        public Treino getTreino() {
        Treino tr = null;
        if (rsdados3 != null) {
            try {
                int id_treino = rsdados3.getInt("id_treino");
                int id_alu = rsdados3.getInt("id_alu");
                String atividade = rsdados3.getString("atividade");
                tr = new Treino(id_treino, id_alu, atividade);
            } catch (SQLException erro) {
                System.out.println(erro);
            }
        }
        return tr;

    }
    
    //Fechar conexão com banco de dados
    public boolean fechaConexao() {
        if (conn != null) {
            try {
                conn.close();
                return true;
            } catch (SQLException erro) {
                System.err.println("Erro ao fechar a conexão = " + erro);
                return false;
            }
        } else {
            return false;
        }
    }

    public void deletarLast() {
        try {
            callableStatement = conn.prepareCall("{CALL deletarLastAluno()}");
            callableStatement.execute();
        } catch (SQLException se) {

        }
    }

    public void deletarLastMedida() {
        try {
            callableStatement = conn.prepareCall("{CALL deletarLastMedida()}");
            callableStatement.execute();
        } catch (SQLException se) {

        }
    }

    public void deletarLastTreino() {
        try {
            callableStatement = conn.prepareCall("{CALL deletarLastTreino()}");
            callableStatement.execute();
        } catch (SQLException se) {

        }
    }    
}
