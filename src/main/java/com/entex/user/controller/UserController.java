package com.entex.user.controller;

import com.entex.user.dto.UserDto;
import com.entex.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> allUsers = userService.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}/edit", method = RequestMethod.PATCH)
    public String userEdit(@PathVariable Long id, @RequestBody UserDto userDto)  {
        userService.update(id, userDto);
        return "User updated successfully";
        }

    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Long id) {
            userService.deleteById(id);
            return "User removed from database";
    }


}
