/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Biel
 */
public class Agendamento {
    
    private Long id;
    private String nome;
    private String telefone;
    private String servico_id;
    private float price_agendamento;
    private String data;
    private String hora;
    private String observacao;

    public Agendamento(Long id, String nome, String telefone, String servico_id, float price_agendamento, String data, String hora) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.servico_id = servico_id;
        this.price_agendamento = price_agendamento;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Agendamento(String nome, String telefone, String servico_id, String data, String hora,String observacao) {
        this.nome = nome;
        this.telefone = telefone;
        this.servico_id = servico_id;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServico_id() {
        return servico_id;
    }

    public void setServico_id(String servico_id) {
        this.servico_id = servico_id;
    }

    public float getPrice_agendamento() {
        return price_agendamento;
    }

    public void setPrice_agendamento(float price_agendamento) {
        this.price_agendamento = price_agendamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
    
}
