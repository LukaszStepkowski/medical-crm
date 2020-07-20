package pl.sda.medicalcrm.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.sda.medicalcrm.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, Integer> {


//    @Modifying
//    @Query("update Doctor c set c.login =?2, c.password = ?3, c.npwz = ?4, c.name = ?5, c.surname =?6 where c.id =?1")
//    int updateDoctorEntity(UUID id, String login, String password, String npwz, String name, String surname);
//
//
//    @Modifying
//    @Query("update Patient c set c.login =?2, c.password =?3, c.name =?4, c.surname =?5, c.pesel =?6 where  c.id =?1")
//    int updatePatientEntity(UUID id, String login, String password, String name, String surname, String pesel);
//
//    @Modifying
//    @Query("update Patient c set c.password =?2 where  c.id =?1")
//    int updatePatientPassword(UUID id, String password);
//
//    @Modifying
//    @Query("update Doctor c set c.password =?2 where  c.id =?1")
//    int updateDoctorPassword(UUID id, String password);
//
//    @Modifying
//    @Query("update CrmSpecialist c set c.password =?2 where  c.id =?1")
//    int updateCrmSpecialistPassword(UUID id, String password);
//
//
//    Optional<User> findById(UUID userId);

}



