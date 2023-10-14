/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Biel
 */
public class ClienteDAO {
    
    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void Salvar(Cliente clientes) throws SQLException{
              
        String sql = "insert into clientes(nome,email,senha) values(? , ?)";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, clientes.getNome());
        prepareStatement.setString(2, clientes.getSenha());
        prepareStatement.execute();       
        connection.close();
        
       
    }

    public boolean autenticarCliente(Cliente clienteAutenticar) throws SQLException {
        String sql = "select * from clientes where nome = ? and senha = ?";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, clienteAutenticar.getNome());
        prepareStatement.setString(2, clienteAutenticar.getSenha());
        prepareStatement.execute();       
        connection.close();
        
        ResultSet resultSet = prepareStatement.getResultSet();
        
        return resultSet.next();
    }   
    
    
    public void Atualizar(Cliente clientes) throws SQLException{
        String sql = "update clientes set nome = ?, senha = ? where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, clientes.getNome());
        prepareStatement.setString(2, clientes.getSenha());
        prepareStatement.setInt(3, clientes.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    public void SalvarouAtualiza(Cliente clientes) throws SQLException{
        if(clientes.getId() > 0){
            Atualizar(clientes);
        }
        else{
            Salvar(clientes);
        }
    }
    
    public void Deleta(Cliente clientes) throws SQLException{
        String sql = "delete from clientes where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, clientes.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    public ArrayList<Cliente> Buscar() throws SQLException{
        String sql = "select * from clientes";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.execute();   
        
        return pesquisa(prepareStatement);  
    }

    private ArrayList<Cliente> pesquisa(PreparedStatement prepareStatement) throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        prepareStatement.execute();
        ResultSet resultSet = prepareStatement.getResultSet();
                
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String Senha = resultSet.getString("senha");
            
            Cliente clienteEncontrado = new Cliente(id,nome, Senha);
            clientes.add(clienteEncontrado);
                 
        }
        return clientes;  
    }
    
    public Cliente BuscarPorId(Cliente cliente) throws SQLException{
        String sql = "select from clientes where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, cliente.getId());
        
        return pesquisa(prepareStatement).get(0);
    }
         
}
