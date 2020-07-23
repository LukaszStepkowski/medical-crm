package pl.sda.medicalcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import pl.sda.medicalcrm.entity.Specialization;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface SpecializationRepository extends CrudRepository <Specialization, Long> {

//    @Override
//    List<Specialization> findAll();

}
