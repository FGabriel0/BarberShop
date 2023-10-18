/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Biel
 */
public class ServiceDAO {
    
    private final Connection connection;

    public ServiceDAO(Connection connection) {
        this.connection = connection;
    }
    
     public void Salvar(Service services) throws SQLException{
              
        String sql = "insert into services(imagem,nome,price) values(? , ?, ?)";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, services.getImagem());
        prepareStatement.setString(2, services.getNome());
        prepareStatement.setString(3, services.getPrice());

        prepareStatement.execute();       
        connection.close();
         
    }
     
     
     public void Atualizar(Service services) throws SQLException{
        String sql = "update services set imagem = ? ,nome = ?, price = ? where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, services.getImagem());
        prepareStatement.setString(2, services.getNome());
        prepareStatement.setString(3, services.getPrice());
        prepareStatement.setLong(4, services.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    public void SalvarouAtualiza(Service services) throws SQLException{
        if(services.getId() > 0){
            Atualizar(services);
        }
        else{
            Salvar(services);
        }
    }
    
    public void Deleta(Service services) throws SQLException{
        String sql = "delete from services where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setLong(1, services.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    public ArrayList<Service> Buscar() throws SQLException{
        String sql = "select * from services";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.execute();   
        
        return pesquisa(prepareStatement);  
    }

    private ArrayList<Service> pesquisa(PreparedStatement prepareStatement) throws SQLException {
        ArrayList<Service> services = new ArrayList<Service>();
        
        prepareStatement.execute();
        ResultSet resultSet = prepareStatement.getResultSet();
                
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            double price = resultSet.getDouble("price");
            
            Service serviceEncontrado = new Service(Long.MIN_VALUE, nome, nome);
            services.add(serviceEncontrado);
                 
        }
        return services;  
    }
    
    public Service BuscarPorId(Service services) throws SQLException{
        String sql = "select from service where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setLong(1, services.getId());
        
        return pesquisa(prepareStatement).get(0);
    }
         
}
