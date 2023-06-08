/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author willi
 */
public class Aluno {

    public Aluno(int id_alu, String nome_alu, String cpf_alu, String sexo_alu, int idade_alu, String email_alu, String data_matricula_alu, int id_colab) {
        this.id_alu = id_alu;
        this.cpf_alu = cpf_alu;
        this.nome_alu = nome_alu;
        this.sexo_alu = sexo_alu;
        this.idade_alu = idade_alu;
        this.email_alu = email_alu;
        this.data_matricula_alu = data_matricula_alu;
        this.id_colab = id_colab;
    }
    
    public Aluno(){
        
    }
    
    private int id_alu;
    private String nome_alu;
    private String cpf_alu;
    private String sexo_alu;
    private int idade_alu;
    private String email_alu;
    private String data_matricula_alu;
    private int id_colab;
    private int id_treino;
    
    public int getId_alu() {
        return id_alu;
    }

    public String getNome_alu() {
        return nome_alu;
    }
    
    public String getCpf_alu(){
        return cpf_alu;
    }

    public String getSexo_alu() {
        return sexo_alu;
    }

    public int getIdade_alu() {
        return idade_alu;
    }

    public String getEmail_alu() {
        return email_alu;
    }
    
    public int getId_colab(){
        return id_colab;
    }
    
    public void setId_colab(int id_colab){
        this.id_colab = id_colab;
    }
    
    public void setId_alu(int id_alu) {
        this.id_alu = id_alu;
    }

    public void setNome_alu(String nome_alu) {
        this.nome_alu = nome_alu;
    }
    
    public void setCpf_alu(String cpf_alu){
        this.cpf_alu = cpf_alu;
    }

    public void setSexo_alu(String sexo_alu) {
        this.sexo_alu = sexo_alu;
    }

    public void setIdade_alu(int idade_alu) {
        this.idade_alu = idade_alu;
    }

    public void setEmail_alu(String email_alu) {
        this.email_alu = email_alu;
    }    
    
    public String getData_matricula_alu(){
        return data_matricula_alu;
    }
    
    public void setData_matricula_alu(String data_matricula_alu){
        this.data_matricula_alu = data_matricula_alu;
    }
}
