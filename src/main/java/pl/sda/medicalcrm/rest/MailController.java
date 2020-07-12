package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.medicalcrm.service.MailService;

import javax.mail.MessagingException;

@RestController
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/sendMail")
    public String sendMail() throws MessagingException {
        mailService.sendMail("medicalcrm23@gmail.com",
                "TEST",
                "<b>Test</b><br>:P", true);
        return "Wysłano";
    }
}