//
//import DAO.AlunoDAO;
//import DAO.RelatorioDAO;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
///**
// *
// * @author Ramon
// */
//public class RelatorioTreinoTest {
//     public RelatorioTreinoTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    @Test
//    public void testaRelatorioTreino() {     
//        AlunoDAO daoalunot = new AlunoDAO();
//        RelatorioDAO relatoriodao = new RelatorioDAO();
//        Map parametros = new HashMap();
//        
//        try{
//            daoalunot.conexaoTeste();
//            relatoriodao.criaConexao();
//            parametros.put("IdAluno", 3);
//            parametros.put("IdTreino", 2);
//        }catch(IOException oe){  
//        }
//
//        Assertions.assertEquals(true,relatoriodao.relatorioTreino(true, parametros));
//    }
//    
//    @Test
//    public void testaRelatorioTreino2() {     
//        AlunoDAO daoalunot = new AlunoDAO();
//        RelatorioDAO relatoriodao = new RelatorioDAO();
//        Map parametros = new HashMap();
//        
//        try{
//            daoalunot.conexaoTeste();
//            relatoriodao.criaConexao();
//            parametros.put("IdAluno", 4);
//            parametros.put("IdTreino", 1);
//        }catch(IOException oe){  
//        }
//
//        Assertions.assertEquals(true,relatoriodao.relatorioTreino(true, parametros));
//    }
//    
//    @Test
//    public void testaEnvioRelatorioTreino() {     //envia mas da erro no teste, esperado true mas é falso, e no email chega um doc em branco
//        AlunoDAO daoalunot = new AlunoDAO();
//        RelatorioDAO relatoriodao = new RelatorioDAO();
//        Map parametros = new HashMap();
//        
//        try{
//            daoalunot.conexaoTeste();
//            relatoriodao.criaConexao();
//            parametros.put("IdAluno", 3);
//            parametros.put("IdTreino", 2);
//        }catch(IOException oe){  
//        }
//
//        Assertions.assertEquals(true,relatoriodao.enviarEmail(parametros));
//    }
//    
//    @Test
//    public void testaEnvioRelatorioTreino2() {     //envia mas da erro no teste, esperado true mas é falso, e no email chega um doc em branco
//        AlunoDAO daoalunot = new AlunoDAO();
//        RelatorioDAO relatoriodao = new RelatorioDAO();
//        Map parametros = new HashMap();
//        
//        try{
//            daoalunot.conexaoTeste();
//            relatoriodao.criaConexao();
//            parametros.put("IdAluno", 4);
//            parametros.put("IdTreino", 1);
//        }catch(IOException oe){  
//        }
//
//        Assertions.assertEquals(true,relatoriodao.enviarEmail(parametros));
//    }
//         
//}
