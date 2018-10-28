package com.example.demo.Controllers;

import com.example.demo.models.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/Login")
    public String Login(){

        return "Login";
    }

    @PostMapping("/Login")
    public String LoginVerification(LoginUser loginUser){

        System.out.println("Login verification2 " + loginUser.getName() + ", " + loginUser.getPassword());
        return "LoginResult";
    }
}
