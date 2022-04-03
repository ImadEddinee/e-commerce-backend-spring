package ma.uca.ensas.ecommercebackendspring.service.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.uca.ensas.ecommercebackendspring.service.MailService;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImp implements MailService {

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void sendMail(String subject, String body, String receiver) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("email");
            messageHelper.setTo(receiver);
            messageHelper.setSubject(subject);
            messageHelper.setText(body,true);
        };
        try{
            mailSender.send(messagePreparator);
            log.info("the email is sent ...");
        }catch (MailException e){
            throw new IllegalStateException("Exception occurred when sending email to " + receiver);
        }
    }
}
