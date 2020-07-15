package pl.sda.medicalcrm.mail;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.sda.medicalcrm.entity.CrmMail;

public class MyClass {
    public static void main(String[] args) throws MailjetException, MailjetSocketTimeoutException {
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient(CrmMail.APIKEY.showValue(), "ac08fc57bcda3a8fec574d7d510e4883",
                new ClientOptions("v3.1"));

        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", CrmMail.CRMADDRESS.showValue())
                                        .put("Name", CrmMail.CRMNAME.showValue()))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", "buuka@op.pl")
                                                .put("Name", "UserName")))
                                .put(Emailv31.Message.SUBJECT, "tytul")
                                .put(Emailv31.Message.HTMLPART, "<h3>Nagłowek</a></h3><br />Treść maila")));
        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());


    }
}

