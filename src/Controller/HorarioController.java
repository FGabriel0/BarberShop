/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.Conexao;
import DAO.ServiceDAO;
import Model.Service;
import Views.ControleHorario;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author Biel
 */
public class HorarioController {
    
    private ControleHorario controller;

    public HorarioController(ControleHorario controller) {
        this.controller = controller;
    }
    
        public void AdicionandoHorasTermino() throws SQLException{
       Connection conexao = new Conexao().getConnection();
       ServiceDAO serviceDAO = new ServiceDAO(conexao);

        ArrayList<Service> listar = serviceDAO.Buscar();
        
        
       ArrayList<String> horas = new ArrayList<>();
       LocalTime currentTime = LocalTime.of(8, 0);
       
       while(currentTime.isBefore(LocalTime.of(20, 30))){
           horas.add(currentTime.format(DateTimeFormatter.ofPattern("HH:mm")));
          
           currentTime = currentTime.plusMinutes(30);
       }  
       JComboBox<String> dataComboBox = controller.getHoradeInicio();
       dataComboBox.removeAllItems();
       for(String hora : horas){
           dataComboBox.addItem(hora);
       }
       
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
       JComboBox<String> dataComboBox = controller.getHoradeInicio();
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
                controller.getDiaController().addItem(dateFormat.format(date));
            }            
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                
        }
         
   }

    
}
