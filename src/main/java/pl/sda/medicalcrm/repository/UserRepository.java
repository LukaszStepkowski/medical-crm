package pl.sda.medicalcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.sda.medicalcrm.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>, JpaSpecificationExecutor<User> {


    @Modifying
    @Query("update Doctor c set c.login =?2, c.password = ?3, c.npwz = ?4, c.name = ?5, c.surname =?6, c.specialization =?7 where c.id =?1")
    int updateDoctorEntity(UUID id, String login, String password, String npwz, String name, String surname, String specialization);




}



