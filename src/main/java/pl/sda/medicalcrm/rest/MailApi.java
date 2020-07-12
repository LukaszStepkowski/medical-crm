package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.medicalcrm.entity.Mail;
import pl.sda.medicalcrm.service.EmailService;

import javax.mail.MessagingException;

@RestController
public class MailApi {

    private EmailService emailService;

    @Autowired
    public MailApi(EmailService emailService) {
        this.emailService = emailService;
    }


    Mail mail = new Mail();
        mail.setFrom("no-reply@memorynotfound.com");
        mail.setTo("info@memorynotfound.com");
        mail.setSubject("Spring Mail Integration Testing with JUnit and GreenMail Example");
        mail.setContent("We show how to write Integration Tests using Spring and GreenMail.");

        m

    @GetMapping("/sendMail")
    public String sendMail() throws MessagingException {
        emailService.sendMail(mail);
        return "wysłano";
    }
}
