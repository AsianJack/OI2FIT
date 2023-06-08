/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.AlunoDAO;
import Model.Aluno;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 *
 * @author lucas
 */
public class CadastroAlunoTest {
    
    public CadastroAlunoTest() {
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
    public void testaCadastroAlunoCerto() {     //PASSAMOS TODOS OS PARAMETROS CORRETAMENTA, OU SEJA O RESULTADO ESPERADO DO TESTE É 1, OU SEJA DEU CERTO
        AlunoDAO daoalunot = new AlunoDAO();
        int id_colab = 1;
        Aluno alunot = new Aluno();
        try{
            
            daoalunot.conexaoTeste();
            alunot.setNome_alu("AlunoTeste");
            alunot.setCpf_alu("4354534543");
            alunot.setSexo_alu("Masculino");
            alunot.setIdade_alu(10);
            alunot.setEmail_alu("teste@gmail.com");
            alunot.setId_colab(id_colab);
        }catch(Exception oe){  
        }
        Assertions.assertEquals(1,daoalunot.criarAlu(alunot, id_colab));
        
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        daoalunot.pesquisa("4354534543");
        Aluno aluno = daoalunot.getAluno();
        Assertions.assertEquals("AlunoTeste" , aluno.getNome_alu());
        Assertions.assertEquals("4354534543", aluno.getCpf_alu());
        Assertions.assertEquals("Masculino", aluno.getSexo_alu());
        Assertions.assertEquals(10, aluno.getIdade_alu());
        Assertions.assertEquals("teste@gmail.com", aluno.getEmail_alu());
        Assertions.assertEquals(timeStamp, aluno.getData_matricula_alu());
        daoalunot.deletarLast();
    }
    
    @Test
    public void testaCadastroAlunoCerto2() {     //PASSAMOS TODOS OS PARAMETROS CORRETAMENTA, OU SEJA O RESULTADO ESPERADO DO TESTE É 1, OU SEJA DEU CERTO
        AlunoDAO daoalunot = new AlunoDAO();
        int id_colab = 1;
        Aluno alunot = new Aluno();
        try{
            daoalunot.conexaoTeste();
            alunot.setNome_alu("AlunoTeste2");
            alunot.setCpf_alu("4354534533");
            alunot.setSexo_alu("Feminino");
            alunot.setIdade_alu(10);
            alunot.setEmail_alu("teste2@gmail.com");
            alunot.setId_colab(id_colab);
        }catch(Exception oe){  
        }
        Assertions.assertEquals(1,daoalunot.criarAlu(alunot, id_colab));
        
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        daoalunot.pesquisa("4354534533");
        Aluno aluno = daoalunot.getAluno();
        Assertions.assertEquals("AlunoTeste2" , aluno.getNome_alu());
        Assertions.assertEquals("4354534533", aluno.getCpf_alu());
        Assertions.assertEquals("Feminino", aluno.getSexo_alu());
        Assertions.assertEquals(10, aluno.getIdade_alu());
        Assertions.assertEquals("teste2@gmail.com", aluno.getEmail_alu());
        Assertions.assertEquals(timeStamp, aluno.getData_matricula_alu());
        daoalunot.deletarLast();
    }
    
    @Test
    public void testaCadastroAlunoErrado() {    //COMO NAO PASSAMOS O CPF, E NO BD ELE N PODE SER NULL, E NO TESTE ESPERAMOS DAR -1 OU SEJA ERRO
        AlunoDAO daoalunot = new AlunoDAO();
        int id_colab = 1;
        Aluno alunot = new Aluno();
        try{
            daoalunot.conexaoTeste();
            alunot.setNome_alu("AlunoTeste");
            alunot.setSexo_alu("Masculino");
            alunot.setIdade_alu(10);
            alunot.setEmail_alu("teste@gmail.com");
            alunot.setData_matricula_alu("2022-09-21");
            alunot.setId_colab(id_colab);
            
        }catch(Exception oe){
            
        }
        Assertions.assertEquals(-1,daoalunot.criarAlu(alunot, id_colab));
        //teremos -1 pois deixamos o cpf como null e no banco de dados o cpf esta como not null
    }
    
    @Test
    public void testaCadastroAlunoErrado2() {    //COMO NAO PASSAMOS O CPF, E NO BD ELE N PODE SER NULL, E NO TESTE ESPERAMOS DAR -1 OU SEJA ERRO
        AlunoDAO daoalunot = new AlunoDAO();
        int id_colab = 1;
        Aluno alunot = new Aluno();
        try{
            daoalunot.conexaoTeste();
            alunot.setNome_alu("AlunoTeste2");
            alunot.setSexo_alu("Feminino");
            alunot.setIdade_alu(18);
            alunot.setEmail_alu("teste2@gmail.com");
            alunot.setData_matricula_alu("2022-09-21");
            alunot.setId_colab(id_colab);
            
        }catch(Exception oe){
            
        }
        Assertions.assertEquals(-1,daoalunot.criarAlu(alunot, id_colab));
        //teremos -1 pois deixamos o cpf como null e no banco de dados o cpf esta como not null
    }
}
