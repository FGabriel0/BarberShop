package Controller;

import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.ServiceDAO;
import Model.Cliente;
import Model.Service;
import Utils.GerentedeImagens;
import Views.AddService;
import Views.CadastroCliente;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;
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
            String imagem = views.getImagemDeService().getText();
              
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