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
//public class RelatorioEvolucaoCorporalTest {
//     public RelatorioEvolucaoCorporalTest() {
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
//    public void testaRelatorioEvolucaoCorporalErro() {     
//        AlunoDAO daoalunot = new AlunoDAO();
//        RelatorioDAO relatoriodao = new RelatorioDAO();
//        Map parametros = new HashMap();
//        
//        try{
//            daoalunot.conexaoTeste();
//            relatoriodao.criaConexao();
//            parametros.put("idaluno", -3);
//        }catch(IOException oe){  
//        }
//
//        Assertions.assertEquals(false,relatoriodao.relatorioEvolucaoCorporal(false, parametros));
//    }
//    
//    @Test
//    public void testaRelatorioEvolucaoCorporalErro2() {     
//        AlunoDAO daoalunot = new AlunoDAO();
//        RelatorioDAO relatoriodao = new RelatorioDAO();
//        Map parametros = new HashMap();
//        
//        try{
//            daoalunot.conexaoTeste();
//            relatoriodao.criaConexao();
//            parametros.put("idaluno", -1);
//        }catch(IOException oe){  
//        }
//
//        Assertions.assertEquals(false,relatoriodao.relatorioEvolucaoCorporal(false, parametros));
//    }
//        
//}
