package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Admin;
import pl.sda.medicalcrm.service.AdminService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admins")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public @ResponseBody
    Long RegisterNewAdmin(@RequestBody @Valid Admin admin) {
        return adminService.registerNewAdmin(admin);
    }

    @PutMapping(path = "/{userId}")
    public @ResponseBody Long changeAdminData(@PathVariable Long userId,
                                                @RequestBody @Valid Admin admin) {
        return adminService.changeAdminData(userId, admin);
    }
}
