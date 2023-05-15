package DAO;

import BancoDeDados.DAO;
import Model.Colaborador;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ColaboradorDAO {

    //Para utilizar o properts
    private static final String path = System.getProperty("user.dir");
    private static final File config_file = new File(path + "/src/main/java/BancoDeDados/configuracaoDAO.properties");
    private static final File config_fileTeste = new File(path + "/src/main/java/BancoDeDados/configuracaoDAOTeste.properties");
    DefaultListModel lista = new DefaultListModel();

    //Chamadas SQL para mexer no Banco de Dados
    int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
    int concorrencia = ResultSet.CONCUR_UPDATABLE;
    private final String criarColab = "Insert into Colaborador(nome_colab, login_colab, senha_colab, cpf_colab) values (?,?,?,?)";
    private final String login2 = "Select * from Colaborador where login_colab = ? and senha_colab = ?";
    private final String editar = "Update Colaborador Set nome_colab = ? , login_colab = ?, senha_colab = ?, cpf_colab = ? where id_colab = ?";
    private final String consultar = "SELECT * FROM Colaborador order by nome_colab";
    private static final String sqlexcluir = "DELETE FROM Colaborador WHERE id_colab = ?";
    private static final String sqlconsultarcolab = "SELECT * FROM Colaborador WHERE cpf_colab = ? or nome_colab = ?";
    private static final String sqlconsultar = "SELECT * FROM Colaborador order by id_colab limit 1";

    private PreparedStatement pstdados = null;
    private ResultSet rsdados = null;
    Connection conn = null;
    private int execute = 0;
    CallableStatement callableStatement = null;

    public ColaboradorDAO() {

    }

    //Criar conexão com o banco de dados
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

    public int criarColab(Colaborador colab) {
        try {
            pstdados = conn.prepareStatement(criarColab, tipo, concorrencia);
            pstdados.setString(1, colab.getNome_colab());
            pstdados.setString(2, colab.getLogin_colab());
            pstdados.setString(3, colab.getSenha_colab());
            pstdados.setString(4, colab.getCpf_colab());
            execute = pstdados.executeUpdate();//retorna um numero positivo pra cima de 0 no caso, retorna 0 se caso nenhuma linha foi mudada
            pstdados.close();
             JOptionPane.showMessageDialog(null, "Colaborador inserido com sucesso.", "Ok", JOptionPane.INFORMATION_MESSAGE);
            return execute;
        } catch (SQLException se) {
            System.out.println("Erro ao criar colaborador " + se);
        } catch (NumberFormatException nfe) {
            System.out.println("CPF precisa ser apenas numeros sem '.' e sem '-'");
        }
        return -1;
    }

    public int login(String login, String senha) {
        try {
            pstdados = conn.prepareStatement(login2, tipo, concorrencia);
            pstdados.setString(1, login);
            pstdados.setString(2, senha);
            rsdados = pstdados.executeQuery();
            if (rsdados.first()) {
                return rsdados.getInt("id_colab");
            }

        } catch (SQLException se) {
            System.out.println("Erro ao logar " + se);
        }
        return 0;
    }

    public int editar(Colaborador colab) {
        try {
            pstdados = conn.prepareStatement(editar, tipo, concorrencia);
            pstdados.setString(1, colab.getNome_colab());
            pstdados.setString(2, colab.getLogin_colab());
            pstdados.setString(3, colab.getSenha_colab());
            pstdados.setString(4, colab.getCpf_colab());
            pstdados.setInt(5, colab.getId_colab());
            execute = pstdados.executeUpdate();
            JOptionPane.showMessageDialog(null, "Colaborador editado com sucesso.", "Ok", JOptionPane.INFORMATION_MESSAGE);
            return execute;
        } catch (SQLException se) {
            System.out.println("Erro ao editar " + se);
        }
        return -1;
    }

    public boolean consultarColab() {
        try {
            pstdados = conn.prepareStatement(consultar, tipo, concorrencia);
            rsdados = pstdados.executeQuery();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao realizar consulta = " + erro);
        }
        return false;
    }

    public boolean consultar() {
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

            if (resposta == 1) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    public boolean pesquisa(String cpf) {
        try {
            pstdados = conn.prepareStatement(sqlconsultarcolab, tipo, concorrencia);
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
                    lista.addElement("ID" + getColaborador().getId_colab() + "  Nome:  " + getColaborador().getNome_colab() + "  CPF:  " + getColaborador().getCpf_colab() + "  Login:  " + getColaborador().getLogin_colab() + "  Senha:  " + getColaborador().getSenha_colab());
                } while (rsdados.next());
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lista", "erro", JOptionPane.ERROR_MESSAGE);

        }
        return lista;
    }

    public Colaborador getColaborador() {
        Colaborador colab = null;
        if (rsdados != null) {
            try {
                int id = rsdados.getInt("id_colab");
                String nome = rsdados.getString("nome_colab");
                String cpf = rsdados.getString("cpf_colab");
                String login = rsdados.getString("login_colab");
                String senha = rsdados.getString("senha_colab");
                colab = new Colaborador(id, nome, cpf, login, senha);
            } catch (SQLException erro) {
                System.out.println(erro);
            }
        }
        return colab;
    }

    public void deletarLast() {
        try {
            callableStatement = conn.prepareCall("{CALL deletarLast()}");
            callableStatement.execute();
        } catch (SQLException se) {

        }

    }

}
