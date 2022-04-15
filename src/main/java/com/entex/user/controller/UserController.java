package com.entex.user.controller;

import com.entex.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

       @GetMapping("/users")
    public String getUsersListPage(Model model){
          model.addAttribute("userDto", userService.findAll());
          return "users";
       }

}
