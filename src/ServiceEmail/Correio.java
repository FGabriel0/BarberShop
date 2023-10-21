/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceEmail;

import Model.Agendamento;
/**
 *
 * @author Biel
 */
public class Correio {
    public void NotificarEmail(Agendamento agendamento){
           
        String emailFormat = formartEmail(agendamento);
        String destinatario = agendamento.getEmail();
        
        Email email = new Email("BarberShop", emailFormat, destinatario);
        
    }

    private String formartEmail(Agendamento agendamento) {
        String nomeCliente = agendamento.getNome();
        String Servico = agendamento.getServico_id();
        String Data = agendamento.getData();
        String Hora = agendamento.getHora();
        String price = agendamento.getPrice_agendamento();
        String Observacao = agendamento.getObservacao();
        
        return "Olá " + nomeCliente + "Vai dar um Tapa no visu... Seu agendamento para "+ 
                Servico + ",Esta marcado para o dia " + Data + "às " + Hora + "o vai sair baratinho de " + 
                price + ".\n Um Forte Abraço e aguadamos você..." ;
    }
}
