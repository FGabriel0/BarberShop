/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ClienteDAO;
import DAO.Conexao;
import Model.Cliente;
import Views.CadastroCliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Biel
 */
public class ClienteCadastroController {
    
    private CadastroCliente view;

    public ClienteCadastroController(CadastroCliente view) {
        this.view = view;
    }
    
    public void salvarCliente(){
        
            String nome = view.getTextNome().getText();
            String email = view.getTextEmail().getName();
            String senha = view.getTextSenha().getText();
            String confirmeSenha = view.getTextConfirmSenha().getText();

            
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
    
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    
}
