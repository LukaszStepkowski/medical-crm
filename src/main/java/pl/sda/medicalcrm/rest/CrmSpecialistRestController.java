package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.CrmSpecialist;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.service.CrmSpecialistService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/crmspecialists")
@CrossOrigin(origins = "http://localhost:4200")
public class CrmSpecialistRestController {

    @Autowired
    private CrmSpecialistService crmSpecialistService;

    @PostMapping
    public @ResponseBody
    Long registerNewCrmSpecialist(@RequestBody @Valid CrmSpecialist crmSpecialist) {
        return crmSpecialistService.registerNewCrmSpecialist(crmSpecialist);
    }

    @PutMapping(path = "/{userId}")
    public @ResponseBody Long changeCrmSpecialistData(@PathVariable Long userId,
                                                        @RequestBody @Valid CrmSpecialist crmSpecialist) {
        return crmSpecialistService.changeCrmSpecialistData(userId, crmSpecialist);
    }

    @GetMapping
    public @ResponseBody
    List<User> getAllCrmSpecialistsList(){
        return crmSpecialistService.getAllCrmSpecialistsList();
    }
}