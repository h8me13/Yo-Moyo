package com.yomoyo.java.services;

import com.yomoyo.java.entities.User;
import com.yomoyo.java.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){ return userRepository.findAll();}
    public void saveUser(User user) { userRepository.save(user); }
    public void deleteUser(Long iduser)
    {
        userRepository.deleteById(iduser);
    }
    public ResponseEntity<Object> updateUser(Long iduser, String name, String surname, String login, String password)
    {
        ResponseEntity<Object> entity = (iduser == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        User user = userRepository.findByIduser(iduser);
        entity = (user == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        if(name != null)
        {
            user.setName(name);
        }
        if (surname != null)
        {
            user.setSurname(surname);
        }
        if (login != null)
        {
            user.setLogin(login);
        }
        if(password != null)
        {
            user.setPassword(password);
        }
        userRepository.save(user);
        return entity;
    }
 }

