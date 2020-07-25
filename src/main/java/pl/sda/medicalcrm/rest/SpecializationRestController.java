package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.repository.SpecializationRepository;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/specializations")
public class SpecializationRestController {

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody
    List<Specialization> listSpecializations() {
        return (List<Specialization>) specializationRepository.findAll();
    }
    
/*
    @PutMapping(path = "/{doctorId}/{specializationId}")
    public @ResponseBody Long connectSpecializationDoctor(@PathVariable Long doctorId,
                                                          @PathVariable Long specializationId,
                                                          @RequestBody @Valid Specialization specialization,
                                                          @RequestBody @Valid Doctor doctor) {
        Optional<Specialization> specializationOptional = specializationRepository.findById(specializationId);
        if (!specializationOptional.isPresent()) return 0L;

        Optional<User> doctorOptional = userRepository.findById(doctorId);
        if (!doctorOptional.isPresent()) return 0L;

        specialization.setId(specializationId);
        specialization.getDoctors().add(doctor);
        specializationRepository.save(specialization);
        return specialization.getId();
    }*/

    @PostMapping
    public @ResponseBody
    Long createSpecialization(@RequestBody @Valid Specialization specialization) {
        if (checkForSpecialization(specialization)) return 0L;
        specializationRepository.save(specialization);
        return specialization.getId();
    }

    @PutMapping(path = "/{doctorId}/{specializationId}")
    public @ResponseBody
    Long connectSpecializationDoctor(@PathVariable Long doctorId,
                                     @PathVariable Long specializationId) {
        Optional<Specialization> specializationOptional = specializationRepository.findById(specializationId);
        if (!specializationOptional.isPresent()) return 0L;
        Optional<User> doctorOptional = userRepository.findById(doctorId);
        if (!doctorOptional.isPresent()) return 0L;
        Specialization specialization = specializationOptional.get();
        User doctor = doctorOptional.get();
        specialization.setId(specializationId);
        specialization.getDoctors().add(doctor);
        specializationRepository.save(specialization);
        return specialization.getId();
    }

    @DeleteMapping(path = "/{specializationId}")
    public @ResponseBody String deleteSpecialization (@PathVariable Long specializationId) {
        specializationRepository.deleteById(specializationId);
        return "Specialization deleted";
    }

    private boolean checkForSpecialization(Specialization specialization) {
        return listSpecializations().stream()
                .anyMatch(s -> s.getTypeOfSpecialization().equals(specialization.getTypeOfSpecialization()));
    }

}




