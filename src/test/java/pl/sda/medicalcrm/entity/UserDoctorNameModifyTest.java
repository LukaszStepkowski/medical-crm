package pl.sda.medicalcrm.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class UserDoctorNameModifyTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void changeDoctorNameTest(){

        //given
        var doctor = new Doctor("antoni", "Domek12!","1234567", "Jan", "Zielony", "Ortopeda");
        repository.saveAndFlush(doctor);
        em.clear();

        //when
        int update = repository.updateDoctorName(doctor.getId(),"Władek");

        //then
        assertEquals(1, update);

    }


   @Test
    void changeSpecializationTest(){
       //given
       var doctor = new Doctor("antoni", "Domek12!","1234567", "Jan", "Zielony", "Ortopeda");
       repository.saveAndFlush(doctor);
       em.clear();

       //when
       int update = repository.updateDoctorSpecialization(doctor.getId(),"Ortodonta");

       //then
       assertEquals(1,update);


   }
}
