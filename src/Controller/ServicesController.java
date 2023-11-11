package Controller;

import DAO.Conexao;
import DAO.ServiceDAO;
import Model.Service;
import Views.AddService;
import Views.AlterarService;
import Views.CadastroCliente;
import Views.TelaService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ServicesController {
    private AddService views;
    private Service currentService;
    private AlterarService edit;
    private TelaService services;

    public ServicesController(TelaService services) {
        this.services = services;
    }

    public ServicesController(AddService views) {
        this.views = views;
    }

    public ServicesController(AlterarService edit) {
        this.edit = edit;
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
            
            views.dispose();
            TelaService tela = new TelaService();
            tela.setVisible(true);
            

        } catch (SQLException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void AtualizarService(){
        String nome = edit.getVarEditNameService().getText();
        String price = edit.getVarEditPriceService().getText();
        String idStr = edit.getVarCodigo().getText();
        String imagem = edit.getTfEditCaminho().getText();
        
        Service service = new Service(imagem, nome, price);
        
        try {
            Connection conexao = new Conexao().getConnection();
            ServiceDAO serviceDAO = new ServiceDAO(conexao);
            
            int id = Integer.parseInt(idStr);

            Service existingService = serviceDAO.BuscarPorId(id);

        if (existingService != null) {
            // Se o serviço com o ID existir, atualize seus valores
            existingService.setNome(nome);
            existingService.setPrice(price);
            existingService.setImagem(imagem);

            serviceDAO.Atualizar(existingService);
            JOptionPane.showMessageDialog(null, "Service Atualizado com Sucesso");
            
            views.dispose();
            TelaService tela = new TelaService();
            tela.setVisible(true);
        } else {
            // Se o serviço com o ID não existe, exiba uma mensagem de erro
            JOptionPane.showMessageDialog(null, "ID não encontrado. Não é possível atualizar o serviço.");
        }

        conexao.close();
        } catch (Exception e) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, e);

        }
    }
    
    public void Excluir() {
    String idStr = JOptionPane.showInputDialog(null, "Digite o Código a ser excluído:");
    Service service = new Service(0);
    if (idStr != null && !idStr.isEmpty()) {
        try {
            int id = Integer.parseInt(idStr); // Converter a string para int
            Connection conexao = new Conexao().getConnection();
            ServiceDAO serviceDAO = new ServiceDAO(conexao);

            // Verificar se o serviço com o ID fornecido existe no banco de dados
            Service existingService = serviceDAO.BuscarPorId(id);

            if (existingService != null) {
                // Se o serviço com o ID existir, exclua-o
                serviceDAO.Deleta(existingService);
                JOptionPane.showMessageDialog(null, "Service excluído com sucesso.");
            } else {
                // Se o serviço com o ID não existe, exiba uma mensagem de erro
                JOptionPane.showMessageDialog(null, "Código não encontrado. Não é possível excluir o serviço.");
            }

            conexao.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código inválido. Digite um número válido.");
        } catch (Exception e) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, e);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Nenhum ID fornecido. A exclusão foi cancelada.");
    }
}
    

   

 }

