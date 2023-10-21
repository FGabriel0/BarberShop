package Controller;

import DAO.Conexao;
import DAO.ServiceDAO;
import Model.Service;
import Views.AddService;
import Views.CadastroCliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ServicesController {
    private AddService views;

    public ServicesController(AddService views) {
        this.views = views;
    }

    public void salvarServico(){
        
            String nome = views.getVarNameService().getText();
            String price = views.getVarPriceService().getText();
            String imagem = views.getTfCaminho().getText();
              
             Service service = new Service(imagem, nome, price);
             
        try {
            Connection conexao = new Conexao().getConnection();
            ServiceDAO serviceDAO = new ServiceDAO(conexao);
            serviceDAO.Salvar(service);
            
            JOptionPane.showMessageDialog(null, "Service Salvo com Sucesso");

        } catch (SQLException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}