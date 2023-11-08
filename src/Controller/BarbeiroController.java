/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AgendamentoDAO;
import DAO.Conexao;
import DAO.ServiceDAO;
import DAO.UsuarioDAO;
import Model.Agendamento;
import Model.Service;
import Model.Usuario;
import Views.CadastrarBarbeiro;
import Views.CadastroCliente;
import Views.LoginBarbeiro;
import Views.MenuBarbeiro;
import Views.TelaService;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Biel
 */
public class BarbeiroController {
    
      private  LoginBarbeiro view;
      private CadastrarBarbeiro cadastrar;
      private TelaService service;
      private MenuBarbeiro menu;
      

    public BarbeiroController(LoginBarbeiro view) {
        this.view = view;
    }
    
    public BarbeiroController(CadastrarBarbeiro cadastrar){
        this.cadastrar = cadastrar;
    }

    public BarbeiroController(TelaService service) {
        this.service = service;
    }

    public BarbeiroController(MenuBarbeiro menu) {
        this.menu = menu;
    }
    
    public void atualizarTextoBoasVindas(String nome){
        JLabel welcomeLabel  = menu.getWelcome();
        welcomeLabel.setText("Seja Bem-Vindo: "+ nome);
        
        
    }
   
    
   public void Autenticar() throws SQLException {
    // Buscar usuario da View
    String nome = view.getVarNameBarbeiro().getText();
    String senha = view.getVarPasswordBarbeiro().getText();

    Usuario usuarioAutenticar = new Usuario(nome, senha);

    // Verificar Se existir no banco de dados
    Connection conexao = new Conexao().getConnection();
    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
    boolean existe = usuarioDAO.autenticarUsuario(usuarioAutenticar);

    if (existe) {
        MenuBarbeiro menubarbeiro = new MenuBarbeiro();
        menubarbeiro.setVisible(true);
        view.setVisible(false);

        BarbeiroController barbeiroController = new BarbeiroController(menubarbeiro);
        
        // Passe o nome do usuário para o método de atualização
        barbeiroController.atualizarTextoBoasVindas(nome);
    } else {
        JOptionPane.showMessageDialog(null, "Usuario Não Encontrado no Banco");
    }
}
    
    public void salvarBarbeiro(){
        
            String Nome = cadastrar.getTextNome().getText();
            String Email = cadastrar.getTextEmail().getText();
            String Senha = cadastrar.getTextSenha().getText();
            String Cpf = cadastrar.getTextCpf().getText();
            String Data_nasc = cadastrar.getTextNascimento().getText();

            
           Usuario usuario = new Usuario(Nome, Email, Cpf, Data_nasc, Senha);
            
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.Salvar(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario Salvo com Sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public void atualizarTableService() throws SQLException{
          //Buscar Elementos no Banco
             Connection conexao = new Conexao().getConnection();
             ServiceDAO serviceDAO = new ServiceDAO(conexao);
             ArrayList<Service> Buscar = serviceDAO.Buscar();
             
          //Enviar para View
            DefaultTableModel tableModel = (DefaultTableModel) service.getTableServices().getModel();
            tableModel.setNumRows(0);
            
            for (Service services : Buscar) {
                tableModel.addRow(new Object[]{
                    services.getId(),
                    services.getNome(),
                    services.getPrice()
                });

}
              
      }
      
    public void VincularCampodaTabelaService() throws SQLException{
          Connection conexao = new Conexao().getConnection();
          ServiceDAO serviceDAO = new ServiceDAO(conexao);
          ArrayList<Service> Buscar = serviceDAO.Buscar();
          
          Service services = Buscar.get(service.getTableServices().getSelectedRow());
          ImageIcon imagem = new ImageIcon(services.getImagem());
          service.getFotodoService().setIcon(new ImageIcon(imagem.getImage().getScaledInstance(service.getFotodoService().getWidth()
                  , service.getFotodoService().getHeight(), Image.SCALE_DEFAULT)));
      } 
      
    public void atualizarTabelaAgendamento() throws SQLException{
           //Buscar Elementos no Banco
             Connection conexao = new Conexao().getConnection();
             AgendamentoDAO agendamentoDAO = new AgendamentoDAO(conexao);
             ArrayList<Agendamento> Buscar = agendamentoDAO.Buscar();
             
          //Enviar para View
            DefaultTableModel tableModel = (DefaultTableModel) menu.getTableAgendamentos() .getModel();
            tableModel.setNumRows(0);
            
           //Pecorrer o TableMode
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

for (Agendamento agendamentos : Buscar) {
    try {
        Date dataAgendamento = dateFormat.parse(agendamentos.getData());
        Date dataAtual = new Date(); // Obter a data atual

        // Verificar se a data do agendamento é maior ou igual à data de hoje
        if (dataAgendamento.equals(dataAtual) || dataAgendamento.after(dataAtual)) {
            tableModel.addRow(
                new Object[]{
                    agendamentos.getId(),
                    agendamentos.getNome(),
                    agendamentos.getTelefone(),
                    agendamentos.getServico_id(),
                    agendamentos.getData(),
                    agendamentos.getHora(),
                    agendamentos.getPrice_agendamento(),
                    agendamentos.getObservacao()
                }
            );
        }
    } catch (ParseException e) {
        e.printStackTrace();
    }
}
    }
      
    public void filtrarAgendamentosHoje() throws SQLException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String hoje = dateFormat.format(new Date());

    Connection conexao = new Conexao().getConnection();
    AgendamentoDAO agendamentoDAO = new AgendamentoDAO(conexao);
    ArrayList<Agendamento> agendamentos = agendamentoDAO.Buscar();
    
    ArrayList<Agendamento> agendamentosHoje = new ArrayList<>();

    for (Agendamento agendamento : agendamentos) {
        String dataAgendamento = agendamento.getData(); // Suponhamos que o método de Agendamento que retorna a data seja "getData()"
        if (dataAgendamento.equals(hoje)) {
            agendamentosHoje.add(agendamento);
        }
    }
        atualizarTabela(agendamentosHoje);

       }
       
    public void atualizarTabela(ArrayList<Agendamento> agendamentos) {
    DefaultTableModel model = (DefaultTableModel) menu.getTableAgendamentos().getModel();
    
    // Limpa o modelo atual da tabela
    model.setRowCount(0);

    // Adiciona os novos agendamentos à tabela
    for (Agendamento agendamento : agendamentos) {
        String[] rowData = {
            agendamento.getNome(),
            agendamento.getTelefone(),
            agendamento.getServico_id(),
            agendamento.getData(),
            agendamento.getHora(),
            agendamento.getPrice_agendamento(),
            agendamento.getObservacao()
        };
        model.addRow(rowData);
    }
}
    
    public void filtrarTodos() throws SQLException{
        atualizarTabelaAgendamento();
    }
    
    public boolean dataAnterior(String data1, String data2) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    try {
        Date date1 = dateFormat.parse(data1);
        Date date2 = dateFormat.parse(data2);

        return date1.before(date2);
    } catch (ParseException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public void atualizarHistoricodaTabela() throws SQLException{
             Connection conexao = new Conexao().getConnection();
             AgendamentoDAO agendamentoDAO = new AgendamentoDAO(conexao);
             ArrayList<Agendamento> Buscar = agendamentoDAO.Buscar();
             
          //Enviar para View
            DefaultTableModel tableModel = (DefaultTableModel) menu.getTableAgendamentos() .getModel();
            tableModel.setNumRows(0);
            
           //Pecorrer o TableMode
           for (Agendamento agendamentos : Buscar) {
              tableModel.addRow(
                      new Object[]{
                          agendamentos.getId(),
                          agendamentos.getNome(),
                          agendamentos.getTelefone(),
                          agendamentos.getServico_id(),
                          agendamentos.getData(),
                          agendamentos.getHora(),
                          agendamentos.getPrice_agendamento(),
                          agendamentos.getObservacao()
                          
                      }
              );
        }
    }
      
    
}
