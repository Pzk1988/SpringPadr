package com.example.demo.Controllers;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.models.LoginUser;
import com.example.demo.models.PasswordValidator;
import com.example.demo.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.DatatypeConverter;

@Controller
public class LoginController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/Login")
    public String Login(){

        return "Login";
    }

    @PostMapping("/Login")
    public String LoginVerification(LoginUser loginUser){

        if(loginUser.getName() != null && loginUser.getPassword() != null)
        {
            Users user = usersRepository.findByName(loginUser.getName());

            if(user != null)
            {
                PasswordValidator passwordValidator = new PasswordValidator();
                byte[] hash = passwordValidator.GenerateHash(loginUser.getPassword(), user.getSeed());

                if (user.getHash().equals(DatatypeConverter.printHexBinary(hash)))
                {
                    System.out.println("Logged");
                    return "LoginResult";
                }
                else
                {
                    System.out.println("invalid pass");
                    return "Login";
                }
            }
            else
            {
                System.out.println("Invalid user");
                return "Login";
            }
        }
        else
        {
            System.out.println("Invalid params");
            return "Login";
        }
    }

//    @GetMapping("/Register")
//    public String RegisterPage(){
//
//    }
}
