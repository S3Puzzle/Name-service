package com.cas.name.controllers;

import com.cas.name.entities.UserLogin;
import com.cas.name.entities.Form;
import com.cas.name.services.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/name")
public class UserLoginController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserLoginService userLoginService;

    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody UserLogin addNewUserLogin (@RequestBody Form n) {
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail(n.getEmail());
        userLogin.setName(n.getName());
        userLoginService.addUserLogin(userLogin);
        return userLogin;
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping(path="/get")
    public @ResponseBody String getName(@RequestParam String email) {
        return userLoginService.getNameByEmail(email);
    }
}
