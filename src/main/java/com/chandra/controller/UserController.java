package com.chandra.controller;

import com.chandra.entity.User;
import com.chandra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loadForm(Model model){
        User userObj=new User();
        model.addAttribute("user" ,userObj);
        return "USERDATA";
    }

    @PostMapping("/user")
    public String HandleSubmitButton(User user,Model model){
        System.out.println(user);
        // store the form data into store database .....
      boolean saveUser= userService.saveUser(user);
        if(saveUser){

            model.addAttribute("msg", "USer Data saved successfully ");
        }
        return "USERDATA";
    }
    @GetMapping("/users")
    public String viewUsers(Model model){
       List<User> allUsers= userService.getAllUsers();
       model.addAttribute("users",allUsers);

        return "VIEW-USERS";
    }

}
