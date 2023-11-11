/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AgendamentoDAO;
import DAO.Conexao;
import DAO.ServiceDAO;
import Model.Agendamento;
import Model.Service;
import Views.Agendar;
import Views.CadastroCliente;
import Views.ControleHorario;
import Views.MenuBarbeiro;
import Views.MenuCliente;
import Views.TelaAgendamentoBarbeiro;
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
    private  Agendar view;
    private MenuBarbeiro menu;
    private ControleHorario controller;
    private TelaAgendamentoBarbeiro AgendamentoBarbeiro;

    public AgendamentoController(MenuBarbeiro menu) {
        this.menu = menu;
    }

    public AgendamentoController(TelaAgendamentoBarbeiro AgendamentoBarbeiro) {
        this.AgendamentoBarbeiro = AgendamentoBarbeiro;
    }
    
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
            JOptionPane.showMessageDialog(null, "Agendamento Salvo com Sucesso");
            
            view.dispose();
            MenuCliente menuCliente = new MenuCliente();
            menuCliente.setVisible(true);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
   public void ExcluirAgendamento() {
    String idStr = JOptionPane.showInputDialog(null, "Digite o Código a ser excluído:");
    Agendamento agendamento = new Agendamento(0);
    if (idStr != null && !idStr.isEmpty()) {
        try {
            int id = Integer.parseInt(idStr); // Converter a string para int
            Connection conexao = new Conexao().getConnection();
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO(conexao);

            // Verificar se o serviço com o ID fornecido existe no banco de dados
            Agendamento existingService = agendamentoDAO.BuscarPorId(id);

            if (existingService != null) {
                // Se o serviço com o ID existir, exclua-o
                agendamentoDAO.Deleta(existingService);
                JOptionPane.showMessageDialog(null, "Agendamento excluído com sucesso.");
            } else {
                // Se o serviço com o ID não existe, exiba uma mensagem de erro
                JOptionPane.showMessageDialog(null, "Código não encontrado. Não é possível excluir o Agendamento.");
            }

            conexao.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido. Digite um número válido.");
        } catch (Exception e) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Nenhum ID fornecido. A exclusão foi cancelada.");
    }
  }
   
    

}
