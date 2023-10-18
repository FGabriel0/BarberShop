/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
/**
 *
 * @author Biel
 */
public class GerentedeImagens {
     private String urlImagem = "";

    public boolean setImagemNaJlabel(String path, JLabel jLabel) {
        BufferedImage imagem = null;
        if (new File(path).isFile()) {
            try {
                imagem = ImageIO.read(new File(path));
            } catch (IOException ex) {
                Logger.getLogger(GerentedeImagens.class.getName()).log(Level.SEVERE, null, ex);
            }
            jLabel.setIcon(new ImageIcon(imagem));
            return true;
        }
        return false;
    }

    public void gravarImagem(String path, int width, int height, String novoCaminho) {
        if (new File(path).isFile()) {
            try {
                BufferedImage image = ImageIO.read(new File(path));
                BufferedImage new_img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = new_img.createGraphics();
                g.drawImage(image, 0, 0, width - 2, height - 2, null);
                ImageIO.write(new_img, "JPG", new File(novoCaminho));
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro au salvar imagem!\nDescrição do erro: " + iOException.getMessage());
            }
        }
    }

    public String escolherImagem(JLabel jLabel) {
        JFileChooser chooser = new JFileChooser(GerenciadorIO.getProperties("ultimoPath"));
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                String caminho = f.getAbsolutePath();
                return caminho.endsWith("png") | caminho.endsWith("jpg") | caminho.endsWith("bmp") | f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Imagem";
            }
        });

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            ImageIcon icone = new ImageIcon(path);
            Image image = icone.getImage().getScaledInstance(jLabel.getWidth() - 2, jLabel.getHeight() - 2, Image.SCALE_DEFAULT);
            jLabel.setIcon(new ImageIcon(image));
            GerenciadorIO.getPropriedades("ultimoPath", chooser.getCurrentDirectory().getPath());
            return urlImagem = chooser.getSelectedFile().getAbsolutePath();
        }
        return "";
    }

    public void removerImagem(String path) {
        File f = new File(path);
        if (f.isFile()) {
            f.delete();
        }
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}
