package com.java3.project.services;

import com.java3.project.data.UserRepository;
import com.java3.project.domain.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by John Lazaro on 16/06/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Users getUserById(int userId){
        Users user = userRepository.getByUserId(userId);
        return user;
    }

    public void updateUser(int userId, String newPass){
        Users user = userRepository.getByUserId(userId);
        if(user != null)
        {
            user.setUserPass(newPass);
        }

    }
    public void createUser(int role, String userPass, String givenName, String email, String address, String gender, String contact){
        //check if email already exist
//        List<Users> users = StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
//        boolean doesExist = false;
//        for (Users user : users) {
//            if(user.getEmail().equals(email))
//            {
//                //error message
//                doesExist = true;
//                break;
//            }
//        }

        Users user = new Users();
        user.setUserPass(userPass);
        user.setGivenName(givenName);
        user.setEmail(email);
        user.setAddress(address);
        user.setGender(gender);
        user.setContact(contact);
        user.setRole(role);
    }


    public boolean userExist(String email){
        Users user = userRepository.getByEmail(email);
        return user!=null;
    }



}
