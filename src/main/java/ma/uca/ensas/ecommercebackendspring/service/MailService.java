package ma.uca.ensas.ecommercebackendspring.service;

public interface MailService {

    void sendMail(String subject, String body, String receiver);
}
