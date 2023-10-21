/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Biel
 */
public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void Salvar(Usuario usuarios) throws SQLException{
              
        String sql = "insert into usuario(nome,senha,email,cpf,datanasc) values(? , ?, ?, ? , ?)";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, usuarios.getNome());
        prepareStatement.setString(3, usuarios.getEmail());
        prepareStatement.setString(4, usuarios.getCpf());
        prepareStatement.setString(5, usuarios.getData_Nasc());
        prepareStatement.setString(2, usuarios.getSenha());
        prepareStatement.execute();       
        connection.close();
        
       
    }

    public boolean autenticarUsuario(Usuario usuarioAutenticar) throws SQLException {
        String sql = "select * from usuario where nome = ? and senha = ?";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, usuarioAutenticar.getNome());
        prepareStatement.setString(2, usuarioAutenticar.getSenha());
        prepareStatement.execute();       
        connection.close();
        
        ResultSet resultSet = prepareStatement.getResultSet();
        
        return resultSet.next();
    }   
    
    
    public void Atualizar(Usuario usuarios) throws SQLException{
        String sql = "update usuario set nome = ?, senha = ? where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, usuarios.getNome());
        prepareStatement.setString(2, usuarios.getSenha());
        prepareStatement.setInt(3, usuarios.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    public void SalvarouAtualiza(Usuario usuarios) throws SQLException{
        if(usuarios.getId() > 0){
            Atualizar(usuarios);
        }
        else{
            Salvar(usuarios);
        }
    }
    
    public void Deleta(Usuario usuarios) throws SQLException{
        String sql = "delete from usuario where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, usuarios.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    public ArrayList<Usuario> Buscar() throws SQLException{
        String sql = "select * from usuario";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.execute();   
        
        return pesquisa(prepareStatement);  
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement prepareStatement) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        prepareStatement.execute();
        ResultSet resultSet = prepareStatement.getResultSet();
                
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String email = resultSet.getString("email");
            String cpf = resultSet.getString("cpf");
            String data_nasc = resultSet.getString("DataNasc");
            String Senha = resultSet.getString("senha");

            
            Usuario usuarioEncontrado = new Usuario(id, nome, email, cpf, data_nasc, Senha);
            usuarios.add(usuarioEncontrado);
                 
        }
        return usuarios;  
    }
    
    public Usuario BuscarPorId(Usuario usuarios) throws SQLException{
        String sql = "select from usuario where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, usuarios.getId());
        
        return pesquisa(prepareStatement).get(0);
    }
    
    
}
