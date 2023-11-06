/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AgendamentoDAO;
import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.ServiceDAO;
import Model.Agendamento;
import Model.Service;
import ServiceEmail.Correio;
import Views.Agendar;
import Views.CadastroCliente;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Biel
 */
public class AgendamentoController {
    private final Agendar view;
    
    public AgendamentoController(Agendar view) {
        this.view = view;
    }
    
   public void ComboboxService() throws SQLException {
        Connection conexao = new Conexao().getConnection();
        ServiceDAO serviceDAO = new ServiceDAO(conexao);

        ArrayList<Service> listar = serviceDAO.Buscar();

        view.getComboBoxService().removeAll(); // Remove itens do ComboBox

        for (Service service : listar) {
            view.getComboBoxService().addItem(service.getNome());
        }

        view.getComboBoxService().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando um item é selecionado no ComboBox, este código será executado.
                String selectedItem = (String) view.getComboBoxService().getSelectedItem();

                if (selectedItem != null) {
                    for (Service service : listar) {
                        if (selectedItem.equals(service.getNome())) {
                            view.getVarPrice().setText(service.getPrice());
                            
                            ImageIcon imagem = new ImageIcon(service.getImagem());
                            view.getImagemCorte().setIcon(new ImageIcon(imagem.getImage().getScaledInstance(view.getImagemCorte().getWidth()
                  , view.getImagemCorte().getHeight(), Image.SCALE_DEFAULT)));
                            break; 
                        }
                    }
                } else {
                    view.getVarPrice().setText("");
           
                }
            }
        });
   }
   
   
   public void AdicionandoHoras() throws SQLException{
       Connection conexao = new Conexao().getConnection();
       ServiceDAO serviceDAO = new ServiceDAO(conexao);

        ArrayList<Service> listar = serviceDAO.Buscar();
        
        
       ArrayList<String> horas = new ArrayList<>();
       LocalTime currentTime = LocalTime.of(8, 0);
       
       while(currentTime.isBefore(LocalTime.of(20, 30))){
           horas.add(currentTime.format(DateTimeFormatter.ofPattern("HH:mm")));
          
           currentTime = currentTime.plusMinutes(30);
       }  
       JComboBox<String> dataComboBox = view.getVarHora();
       dataComboBox.removeAllItems();
       for(String hora : horas){
           dataComboBox.addItem(hora);
       }
       
   }
   
   public void AdicionandoData(){
        
       Calendar calendar = Calendar.getInstance();
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       
       
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
       
        //Data Atual
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        
        
         while (year == calendar.get(Calendar.YEAR)) {
            Date date = calendar.getTime();
            boolean horaJaAgendada = false;
            
                if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                view.getVarData().addItem(dateFormat.format(date));
            }            
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                
        }
         
   }
   
   
   
   public void salvarAgendamento(){
       String Nome = view.getVarName().getText();
       String Email = view.getVarEmail().getText();
       String Telefone = view.getVarTelefone().getText();
       String Data = (String) view.getVarData().getSelectedItem();
       String Hora = (String) view.getVarHora().getSelectedItem();
       String Servico = (String) view.getComboBoxService().getSelectedItem();
       String Price = view.getVarPrice().getText();
       String Observacao = view.getVarObeservacao().getText();
       
       
       Agendamento agendamento = new Agendamento(Nome, Email, Telefone, Servico, Price, Data, Hora, Observacao);
       
         try {
        Connection conexao = new Conexao().getConnection();
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO(conexao);

        // Verifique se já existe um agendamento para a mesma data e hora
        if (agendamentoDAO.existeAgendamentoNaDataHora(Data, Hora)) {
              view.getVarHora().removeItem(Hora);
            JOptionPane.showMessageDialog(null, "Já existe um agendamento para essa data e hora. Escolha outra data ou hora.");
        } else {
            agendamentoDAO.Salvar(agendamento);
            /* Correio correio = new Correio();;
            correio.NotificarEmail(agendamento);*/
            JOptionPane.showMessageDialog(null, "Agendamento Salvo com Sucesso");
        }
    } catch (SQLException ex) {
        Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
   
    
}
