package pl.sda.medicalcrm.service;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.dto.CreatePatientDto;
import pl.sda.medicalcrm.dto.EmailSenderDto;
import pl.sda.medicalcrm.entity.CrmMail;
import pl.sda.medicalcrm.entity.Patient;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.UUID;


@Service
public class EmailService {
    public void sendEmail(EmailSenderDto dto) throws MailjetException, MailjetSocketTimeoutException {
        String title = "Account has been created";
        String header = "<h3>Dear" + dto.getPatientName() + "</a></h3>";
        String text = "Your new account has been created";
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient(CrmMail.APIKEY.showValue(), CrmMail.APISECRET.showValue(),
                new ClientOptions("v3.1"));

        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", CrmMail.CRMADDRESS.showValue())
                                        .put("Name", CrmMail.CRMNAME.showValue()))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", dto.getPatientEmail())
                                                .put("Name", dto.getPatientName())))
                                .put(Emailv31.Message.SUBJECT, title)
                                .put(Emailv31.Message.HTMLPART, header + text)));
        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
   }
