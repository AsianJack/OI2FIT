/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.ColaboradorDAO;
import Model.Colaborador;
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
public class EditarColaboradorTest {

    public EditarColaboradorTest() {
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
        ColaboradorDAO daocolabt = new ColaboradorDAO();

        Colaborador colabt = new Colaborador();
        try {
            daocolabt.conexaoTeste();
            colabt.setNome_colab("JonasTeste");
            colabt.setLogin_colab("loginTeste");
            colabt.setSenha_colab("senhaTeste");
            colabt.setCpf_colab("32323232");
            daocolabt.criarColab(colabt);
            daocolabt.pesquisa("32323232");
            Colaborador colaborador = daocolabt.getColaborador();
            Assertions.assertEquals("JonasTeste", colaborador.getNome_colab());
            Assertions.assertEquals("loginTeste", colaborador.getLogin_colab());
            Assertions.assertEquals("senhaTeste", colaborador.getSenha_colab());
            Assertions.assertEquals("32323232", colaborador.getCpf_colab());
        } catch (Exception oe) {
        }
        colabt.setNome_colab("Nomeditado");
        colabt.setLogin_colab("loginTeste");
        colabt.setSenha_colab("senhaTeste");
        colabt.setCpf_colab("32323232");

        daocolabt.pesquisa("32323232");

        Colaborador colabaux = daocolabt.getColaborador();

        colabt.setId_colab(colabaux.getId_colab());

        Assertions.assertEquals(-1, daocolabt.editar(colabt));
        daocolabt.pesquisa("32323232");
        Colaborador colaborador = daocolabt.getColaborador();
        Assertions.assertEquals("JonasTeste", colaborador.getNome_colab());
        Assertions.assertEquals("loginTeste", colaborador.getLogin_colab());
        Assertions.assertEquals("senhaTeste", colaborador.getSenha_colab());
        Assertions.assertEquals("32323232", colaborador.getCpf_colab());
        daocolabt.deletarLast();
    }
}
