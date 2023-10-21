/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Agendamento;
import Model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

/**
 *
 * @author Biel
 */
public class AgendamentoDAO {
    
    private final Connection connection;

    public AgendamentoDAO(Connection connection) {
        this.connection = connection;
    }
    
    
    
     public void Salvar(Agendamento agendamentos) throws SQLException{
              
        String sql = "insert into agendamentos(nome,telefone,email,service_id,price_service,data,hora,observacao) values(? , ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, agendamentos.getNome());
        prepareStatement.setString(2, agendamentos.getTelefone());
        prepareStatement.setString(3, agendamentos.getEmail());
        prepareStatement.setString(4, agendamentos.getServico_id());
        prepareStatement.setString(5, agendamentos.getPrice_agendamento());
        prepareStatement.setString(6, agendamentos.getData());
        prepareStatement.setString(7, agendamentos.getHora());
        prepareStatement.setString(8, agendamentos.getObservacao());
        prepareStatement.execute();       
        connection.close();
        
       
    }

     /* public boolean autenticarCliente(Agendamento agendamentoAutenticar) throws SQLException {
     String sql = "select * from clientes where nome = ? and senha = ?";
     
     PreparedStatement prepareStatement = connection.prepareStatement(sql);
     prepareStatement.setString(1, agendamentoAutenticar.getNome());
     prepareStatement.setString(2, agendamentoAutenticar.getSenha());
     prepareStatement.execute();
     connection.close();
     
     ResultSet resultSet = prepareStatement.getResultSet();
     
     return resultSet.next();
     }   */
    
    
    public void Atualizar(Agendamento agendamentos) throws SQLException{
        String sql = "update agendamentos set nome = ?, telefone = ?,email = ?,service_id = ?, price_service = ?,data= ?,hora = ?,observacao = ?  where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, agendamentos.getNome());
        prepareStatement.setString(2, agendamentos.getTelefone());
        prepareStatement.setString(3, agendamentos.getEmail());
        prepareStatement.setString(4, agendamentos.getServico_id());
        prepareStatement.setString(5, agendamentos.getPrice_agendamento());
        prepareStatement.setString(6, agendamentos.getData());
        prepareStatement.setString(7, agendamentos.getHora());
        prepareStatement.setString(8, agendamentos.getObservacao());
        prepareStatement.setLong(9, agendamentos.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    public void SalvarouAtualiza(Agendamento agendamentos) throws SQLException{
        if(agendamentos.getId() > 0){
            Atualizar(agendamentos);
        }
        else{
            Salvar(agendamentos);
        }
    }
    
    public void Deleta(Agendamento agendamentos) throws SQLException{
        String sql = "delete from agendamentos where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setLong(1, agendamentos.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    public ArrayList<Agendamento> Buscar() throws SQLException{
        String sql = "select * from agendamentos";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.execute();   
        
        return pesquisa(prepareStatement);  
    }

    private ArrayList<Agendamento> pesquisa(PreparedStatement prepareStatement) throws SQLException {
        ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
        
        prepareStatement.execute();
        ResultSet resultSet = prepareStatement.getResultSet();
                
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String Nome = resultSet.getString("nome");
            String Telefone = resultSet.getString("telefone");
            String Email = resultSet.getString("email");
            String Service_id = resultSet.getString("service_id");
            String Price_service = resultSet.getString("price_service");
            String Data = resultSet.getString("data");
            String Hora = resultSet.getString("hora");
            String Observacao = resultSet.getString("observacao");
            
            Agendamento AgendamentoEncontrado = new Agendamento(Long.MIN_VALUE, Nome, Telefone, Service_id, Price_service, Data, Hora, Observacao);
            agendamentos.add(AgendamentoEncontrado);
                 
        }
        return agendamentos;  
    }
    
    public Agendamento BuscarPorId(Agendamento agendamentos) throws SQLException{
        String sql = "select from agendamentos where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setLong(1, agendamentos.getId());
        
        return pesquisa(prepareStatement).get(0);
    }
    
    
}
