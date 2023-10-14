/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteDAO;
import DAO.Conexao;
import Model.Cliente;
import Views.LoginCliente;
import Views.MenuCliente;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Biel
 */
public class LoginClienteController {
    private LoginCliente view;

    public LoginClienteController(LoginCliente view) {
        this.view = view;
    }

    public void Autenticar() throws SQLException {
        //Buscar usuario da View
        String nome = view.getTextName().getText();
        String senha = view.getTextPassword().getText();
        
        Cliente clienteAutenticar = new Cliente(nome, senha);
        
        //Verificar Se exixtir no banco de dados
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        
       boolean existe =  clienteDAO.autenticarCliente(clienteAutenticar); 
       
       if(existe){
         MenuCliente menucliente = new MenuCliente();
         menucliente.setVisible(true);
         this.view.dispose();
       }
       else{
           JOptionPane.showMessageDialog(null, "Cliente Não Encontrado no Banco");
       }
        
    }
    
    
    
}
