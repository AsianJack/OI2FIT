/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.AlunoDAO;
import Model.Aluno;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Ramon
 */
public class EditarAlunoTest {

    public EditarAlunoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testaEdicaoColabCerto() {     //PASSAMOS TODOS OS PARAMETROS CORRETAMENTA, OU SEJA O RESULTADO ESPERADO DO TESTE É 1, OU SEJA DEU CERTO
        AlunoDAO daoalunot = new AlunoDAO();
        int id_colab = 1;
        Aluno alunot = new Aluno();
        try {
            daoalunot.conexaoTeste();
            alunot.setNome_alu("AlunoTeste");
            alunot.setCpf_alu("4354534543");
            alunot.setSexo_alu("Masculino");
            alunot.setIdade_alu(10);
            alunot.setEmail_alu("teste@gmail.com");
            alunot.setData_matricula_alu("2022-09-21");
            alunot.setId_colab(id_colab);
            daoalunot.criarAlu(alunot, id_colab);
            daoalunot.pesquisa("4354534543");
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            daoalunot.pesquisa("4354534543");
            Aluno aluno = daoalunot.getAluno();
            Assertions.assertEquals("AlunoTeste", aluno.getNome_alu());
            Assertions.assertEquals("4354534543", aluno.getCpf_alu());
            Assertions.assertEquals("Masculino", aluno.getSexo_alu());
            Assertions.assertEquals(10, aluno.getIdade_alu());
            Assertions.assertEquals("teste@gmail.com", aluno.getEmail_alu());
            Assertions.assertEquals(timeStamp, aluno.getData_matricula_alu());

        } catch (Exception oe) {
        }
        alunot.setNome_alu("NomeEditado");
        alunot.setCpf_alu("4354534543");
        alunot.setSexo_alu("Masculino");
        alunot.setIdade_alu(10);
        alunot.setEmail_alu("teste@gmail.com");
        alunot.setData_matricula_alu("2022-09-21");
        alunot.setId_colab(id_colab);
        daoalunot.pesquisa("4354534543");
        Aluno alunoaux = daoalunot.getAluno();
        alunot.setId_alu(alunoaux.getId_alu());
        Assertions.assertEquals(1, daoalunot.editar(alunot));
        daoalunot.pesquisa("4354534543");
        Aluno aluno = daoalunot.getAluno();
        Assertions.assertEquals("NomeEditado", aluno.getNome_alu());
        Assertions.assertEquals("4354534543", aluno.getCpf_alu());
        Assertions.assertEquals("Masculino", aluno.getSexo_alu());
        Assertions.assertEquals(10, aluno.getIdade_alu());
        Assertions.assertEquals("teste@gmail.com", aluno.getEmail_alu());
        Assertions.assertEquals("2022-09-21", aluno.getData_matricula_alu());
        daoalunot.deletarLast();

    }
}
