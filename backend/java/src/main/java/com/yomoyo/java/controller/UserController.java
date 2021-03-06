package com.yomoyo.java.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yomoyo.java.entities.User;
import com.yomoyo.java.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
public final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    @GetMapping(path = "/all" )
    @CrossOrigin("http://localhost:8080")
    public List<User> findUsers()
    {
        return userServices.findAllUsers();
    }
    @PostMapping(path = "/new")
    @CrossOrigin("http://localhost:8080")
    public void newUser(@RequestBody User user ){
         userServices.saveUser(user);
    }
    @PutMapping(path = "/update")
    @CrossOrigin("http://localhost:8080")
    public void updateUser(@RequestBody User user){
        userServices.updateUser(user.getIduser(),user.getName(),user.getSurname(),user.getLogin(),user.getPassword());
    }
    @DeleteMapping(path = "/deletebyid")
    @CrossOrigin("http://localhost:8080")
    public void deleteUserById(@RequestParam Long iduser ){
        userServices.deleteUser(iduser);
    }
}
