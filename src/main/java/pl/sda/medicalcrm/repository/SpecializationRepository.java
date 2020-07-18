package pl.sda.medicalcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.sda.medicalcrm.entity.Specialization;

import java.util.List;
import java.util.UUID;


public interface SpecializationRepository extends JpaRepository<Specialization, UUID> , JpaSpecificationExecutor<Specialization> {

    @Override
    List<Specialization> findAll();
}
