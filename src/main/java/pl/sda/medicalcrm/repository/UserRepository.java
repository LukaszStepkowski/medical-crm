package pl.sda.medicalcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.sda.medicalcrm.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {
   /* @Modifying
    @Query("update Doctor c set c.name = ?2 where c.id = ?1")
    int updateDoctorName(UUID id, String name);

   @Modifying
   @Query("update Doctor  c set c.surname = ?2 where c.id =?1 ")
   int updateDoctorSurname(UUID id, String surname);


    @Modifying
    @Query("update Doctor c set c.specialization = ?2 where c.id = ?1")
    int updateDoctorSpecialization(UUID id, String specialization);*/



    @Modifying
    @Query("update Doctor c set c.login =?2, c.password = ?3, c.npwz = ?4, c.name = ?5, c.surname =?6, c.specialization =?7 where c.id =?1")
    int updateDoctorEntity(UUID id, String login, String password, String npwz, String name, String surname, String specialization);


}



