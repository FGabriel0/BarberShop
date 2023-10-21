package ServiceEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * Classe responsável por enviar E-mail.
 * @author Biel
 */
public class Email {
    static final String REMETENTE_NOME = "sbaber026@gmail.com";
    static final String REMETENTE_SENHA = "barbershopadmin";
    private String assunto ;
    private String mensagem;
    private String destinatario;
    
    /**
     * 
     * @param assunto  Assunto para envio do E-mail.
     * @param mensagem  Mensagem qual vai ser enviado ao destinatário.
     * @param destinatario  E-mail do destinatário.
     */
    public Email(String assunto, String mensagem, String destinatario) {
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }

    
    
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
   
    /**
     * Função para enviar o e-mail ao destinatário.
     */
    public void enviar (){
        
        System.setProperty("mail.smtp.starttls.enable", "true");

        
        HtmlEmail email = new HtmlEmail();
        email.setSSL(true);
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465); // Use a porta 465 para SSL
        email.setAuthenticator(new DefaultAuthenticator(REMETENTE_NOME, REMETENTE_SENHA));
        

       try {
           email.setFrom(REMETENTE_NOME);

           email.setDebug(true);

           email.setSubject(this.assunto);
           email.setMsg(this.mensagem);
           email.addTo(this.destinatario);//por favor trocar antes de testar!!!!

           email.send();

       } catch (EmailException e) {
           e.printStackTrace();
       }
    }

}
