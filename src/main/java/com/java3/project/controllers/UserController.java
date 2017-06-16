package com.java3.project.controllers;

import com.java3.project.data.UserRepository;
import com.java3.project.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by John Lazaro on 16/06/2017.
 */

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    public void createUser(@RequestBody UserRequestBody userRequestBody){
        Users user = new Users();
        user.setUserPass(userRequestBody.getUserPass());
        user.setGivenName(userRequestBody.getGivenName());
        user.setEmail(userRequestBody.getEmail());
        user.setAddress(userRequestBody.getAddress());
        user.setGender(userRequestBody.getGender());
        user.setContact(userRequestBody.getContact());
        userRepository.save(user);
    }

    @RequestMapping(value = "users/update/{userId}/{newpass}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable int userID, @PathVariable String newPass){
        Users user = userRepository.getByUserId(userID);
        user.setUserPass(newPass);
        userRepository.save(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){return new ResponseEntity<Object>(userRepository.findAll(), HttpStatus.OK);}

    @RequestMapping(value = "/users/{userID}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByID(@PathVariable int userID){return new ResponseEntity<Object>(userRepository.getByUserId(userID), HttpStatus.OK);}
}
