package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.service.UserDetailsServiceImpl;

@Controller
@RequestMapping(path = "/authenticate")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationRestController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    User authenticateUser (@RequestBody String login, String password){
        return (User) userDetailsService.loadUserByUsername(login);
    }
}
