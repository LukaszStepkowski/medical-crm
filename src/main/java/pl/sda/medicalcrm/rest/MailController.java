package pl.sda.medicalcrm.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.medicalcrm.service.MailService;

@RestController
public class MailController {

    private MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

//    @GetMapping("/sendemail")
    public String sendEmail() {
        mailService.sendSimpleEmail("User.username <odbiorca@maila.pl>", "Test e-mail", "Testing email functionality");

        return "E-mail sent!";
    }
}