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
import java.util.List;

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
        prepareStatement.setInt(9, agendamentos.getId());
        prepareStatement.execute();   
        
        connection.close();
    }
    
    /*  public void SalvarouAtualiza(Agendamento agendamentos) throws SQLException{;
    if(agendamentos.getId() > 0){
    Atualizar(agendamentos);
    }
    else{
    Salvar(agendamentos);
    }
    }*/
    
    public void Deleta(Agendamento agendamentos) throws SQLException{
        String sql = "DELETE from agendamentos where id = ? ";
        
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, agendamentos.getId());
        prepareStatement.executeUpdate();   
        
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
            int Id = resultSet.getInt("id");
                        
            String Nome = resultSet.getString("nome");
            String Telefone = resultSet.getString("telefone");
            String Email = resultSet.getString("email");
            String Service_id = resultSet.getString("service_id");
            String Price_service = resultSet.getString("price_service");
            String Data = resultSet.getString("data");
            String Hora = resultSet.getString("hora");
            String Observacao = resultSet.getString("observacao");
            
            Agendamento AgendamentoEncontrado = new Agendamento(Id, Nome, Email, Telefone, Service_id, Price_service, Data, Hora, Observacao);
            agendamentos.add(AgendamentoEncontrado);
                 
        }
        return agendamentos;  
    }
    
   public Agendamento BuscarPorId(int id) throws SQLException {
    String sql = "SELECT * FROM agendamentos WHERE id = ?";
    
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, id);
    
    ArrayList<Agendamento> services = pesquisa(preparedStatement);
    
    if (!services.isEmpty()) {
        return services.get(0);
    } else {
        return null; 
    }
}
     
    public boolean existeAgendamentoNaDataHora(String data, String hora) throws SQLException {
        String sql = "SELECT COUNT(*) FROM agendamentos WHERE data = ? AND hora = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, data);
            stmt.setString(2, hora);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }
    
public Agendamento BuscarPorEmail(String email) throws SQLException {
        String sql = "select from agendamentos where email = ? ";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
    
        ArrayList<Agendamento> services = pesquisa(preparedStatement);
    
    if (!services.isEmpty()) {
        return services.get(0);
    } else {
        return null; // ou lançar uma exceção se preferir
    }
}    

    
    
    
    
}
