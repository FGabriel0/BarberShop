/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteDAO;
import DAO.Conexao;
import Model.Cliente;
import Views.CadastroCliente;
import Views.LoginCliente;
import Views.MenuCliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Biel
 */
public class ClienteController {
    
    private  LoginCliente login;
    private  CadastroCliente cadastrar;

    public ClienteController(LoginCliente login) {
        this.login = login;
    }

    public ClienteController(CadastroCliente cadastrar) {
        this.cadastrar = cadastrar;
    }

    public void Autenticar() throws SQLException {
     String nome = login.getTextName().getText();
     String senha = login.getTextPassword().getText();
        
        Cliente clienteAutenticar = new Cliente(nome, senha);
        
        //Verificar Se exixtir no banco de dados
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        
       boolean existe =  clienteDAO.autenticarCliente(clienteAutenticar); 
       
       if(existe){
         MenuCliente menucliente = new MenuCliente();
         menucliente.setVisible(true);
         this.login.dispose();
       }
       else{
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

        } catch (SQLException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
