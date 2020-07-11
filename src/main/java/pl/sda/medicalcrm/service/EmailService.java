package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
    public class EmailService {

        @Autowired
        private JavaMailSender javaMailSender;

        public void MailService(JavaMailSender javaMailSender) {
            this.javaMailSender = javaMailSender;
        }

    public void sendEmail(String to, String subject, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom("Blog Example <from@email.com>");

        msg.setSubject(subject);
        msg.setText(content);

        javaMailSender.send(msg);
    }
}
