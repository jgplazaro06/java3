package com.java3.project.controllers;

import com.java3.project.data.UserRepository;
import com.java3.project.domain.Users;
import com.java3.project.services.UserService;
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
    private UserService userService;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    public void createUser(@RequestBody UserRequestBody userRequestBody) {

        if (userService.userExist(userRequestBody.getEmail())) {
            System.out.println("That email already exist");

        } else {
            userService.createUser(
                    userRequestBody.getRole(),
                    userRequestBody.getUserPass(),
                    userRequestBody.getGivenName(),
                    userRequestBody.getEmail(),
                    userRequestBody.getAddress(),
                    userRequestBody.getGender(),
                    userRequestBody.getContact());
        }
    }

    @RequestMapping(value = "users/update/{userId}/{newpass}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable int userID, @PathVariable String newPass){
        userService.updateUser(userID, newPass);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){return new ResponseEntity<Object>(userService.getAllUsers(), HttpStatus.OK);}

    @RequestMapping(value = "/users/{userID}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByID(@PathVariable int userID){return new ResponseEntity<Object>
            (userService.getUserById(userID), HttpStatus.OK);}
}
