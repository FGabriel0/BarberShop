/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Biel
 */
public class Service {
    private Long id;
    private String imagem;
    private String nome;
    private String price;

    public Service(Long id, String imagem, String nome, String price) {
        this.id = id;
        this.imagem = imagem;
        this.nome = nome;
        this.price = price;
    }

    public Service(String imagem, String nome, String price) {
        this.imagem = imagem;
        this.nome = nome;
        this.price = price;
    }

    public Service(Long id, String nome, String price) {
        this.id = id;
        this.nome = nome;
        this.price = price;
    }
    

    public Service(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    
    
    
}
