/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Biel
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String data_Nasc;
    private String senha;

    public Usuario(int id, String nome, String email, String cpf, String data_Nasc, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.data_Nasc = data_Nasc;
        this.senha = senha;
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String cpf, String data_Nasc, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.data_Nasc = data_Nasc;
        this.senha = senha;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_Nasc() {
        return data_Nasc;
    }

    public void setData_Nasc(String data_Nasc) {
        this.data_Nasc = data_Nasc;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
