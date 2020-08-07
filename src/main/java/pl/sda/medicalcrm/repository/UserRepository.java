package pl.sda.medicalcrm.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.medicalcrm.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {

}



