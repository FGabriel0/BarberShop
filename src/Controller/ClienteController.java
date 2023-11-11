/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AgendamentoDAO;
import DAO.ClienteDAO;
import DAO.Conexao;
import Model.Agendamento;
import Model.Cliente;
import Views.Agendar;
import Views.CadastroCliente;
import Views.LoginCliente;
import Views.MenuCliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Biel
 */
public class ClienteController {
    
    private  LoginCliente login;
    private  CadastroCliente cadastrar;
    private Agendar agendar;
    private MenuCliente menu;

    
    public ClienteController(MenuCliente menu) {
        this.menu = menu;
    }
    
    public ClienteController(LoginCliente login) {
        this.login = login;
    }

    public ClienteController(CadastroCliente cadastrar) {
        this.cadastrar = cadastrar;
    }
    
    

public void Autenticar() throws SQLException {
    String email = login.getTextName().getText();
    String senha = login.getTextPassword().getText();
        
    Cliente clienteAutenticar = new Cliente(email, senha);
         
    // Verificar se o cliente existe no banco de dados
    Connection conexao = new Conexao().getConnection();
    ClienteDAO clienteDAO = new ClienteDAO(conexao);
    
      Cliente clienteAutenticado = clienteDAO.autenticarCliente(clienteAutenticar);

    if (clienteAutenticado != null) {
        // Autenticação bem-sucedida
        MenuCliente menu = new MenuCliente();
        ClienteController controller = new ClienteController(menu);
        menu.setVisible(true);
        login.setVisible(false);

        // Chame a função para atualizar a tabela de agendamentos, passando o cliente autenticado
    } else {
        JOptionPane.showMessageDialog(null, "Cliente Não Encontrado no Banco");
    }
}
    
    public void salvarCliente(){
        
            String nome = cadastrar.getTextNome().getText();
            String email = cadastrar.getTextEmail().getText();
            String senha = cadastrar.getTextSenha().getText();
           
            Cliente cliente = new Cliente(nome, email, senha);
            
        
        try {
            Connection conexao = new Conexao().getConnection();
            ClienteDAO clienteDAO = new ClienteDAO(conexao);
            clienteDAO.Salvar(cliente);
            
            JOptionPane.showMessageDialog(null, "Cliente Salvo com Sucesso");
            cadastrar.dispose();
            LoginCliente loginCliente = new LoginCliente();
            loginCliente.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void atualizarTextoBoasVindas(String nome){
        JLabel welcomeLabel  = menu.getWelcomeCliente();
        welcomeLabel.setText("Seja Bem-Vindo: "+ nome);
         
    }
     

    

}
