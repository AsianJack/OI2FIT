/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.ColaboradorDAO;
import java.io.IOException;
import java.sql.ResultSet;
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
public class LoginTest {
    public LoginTest() {
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
    public void testaLoginCerto(){
        ColaboradorDAO daocolabt = new ColaboradorDAO();
        try{
            daocolabt.conexaoTeste();
            
        }catch(IOException oe){
            
        }
        Assertions.assertNotEquals(0, daocolabt.login("adm", "adm"));
    }
    
    @Test
    public void testaLoginCerto2(){
        ColaboradorDAO daocolabt = new ColaboradorDAO();
        try{
            daocolabt.conexaoTeste();
            
        }catch(IOException oe){
            
        }
        Assertions.assertNotEquals(1, daocolabt.login("lucas", "1"));
    }
    
    @Test
    public void testaLoginErrado(){
        ColaboradorDAO daocolabt = new ColaboradorDAO();
        try{
            daocolabt.conexaoTeste();
        }catch(Exception oe){
            
        }
        
        Assertions.assertEquals(0,daocolabt.login("erro", "12345"));
    }
    
    @Test
    public void testaLoginErrado2(){
        ColaboradorDAO daocolabt = new ColaboradorDAO();
        try{
            daocolabt.conexaoTeste();
        }catch(Exception oe){
            
        }
        
        Assertions.assertEquals(0,daocolabt.login("lucasTESTE", "erro"));
    }  
   
}
