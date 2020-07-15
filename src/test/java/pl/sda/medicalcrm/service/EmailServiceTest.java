package pl.sda.medicalcrm.service;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.medicalcrm.dto.CreatePatientDto;
import pl.sda.medicalcrm.dto.EmailSenderDto;
import pl.sda.medicalcrm.entity.Patient;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Transactional
public class EmailServiceTest {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void TestCreatePatientWithSendingEmail() throws MailjetSocketTimeoutException, MailjetException {
        //given
        var createPatientDto = new CreatePatientDto("buuka@op.pl", "password", "Jan", "Kowalski", "123456789");
//        var createEmailSenderDto = new EmailSenderDto(createPatientDto.getLogin(), createPatientDto.getName());

        //when
        var id = service.createPatientWithSendingEmail(createPatientDto);
        em.flush();
        em.clear();

        //then
        var companyOptional = repository.findById(id);
        assertTrue(companyOptional.isPresent());

    }
}