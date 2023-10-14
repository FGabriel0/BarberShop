/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import Model.Usuario;
import Views.LoginBarbeiro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Biel
 */
public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void Salvar(Usuario usuario) throws SQLException{
              
        String sql = "insert into usuario(nome,senha) values('"+usuario.getNome()+"','"+usuario.getSenha()+"');";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.execute();       
        connection.close();
        
       
    }
    
    
}
