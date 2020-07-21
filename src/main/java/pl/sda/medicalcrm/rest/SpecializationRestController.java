package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Doctor;
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
    public List<Specialization> listSpecializations(){
        return (List<Specialization>) specializationRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Long createSpecialization(@RequestBody @Valid Specialization specialization){
        //TODO could need to set new ArrayList before saving to repository
        specializationRepository.save(specialization);
        return specialization.getId();
    }

    @PutMapping(path = "/{doctorId}/{specializationId")
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
    }
}
