package com.java3.project.controllers;

import com.java3.project.data.UserPurchaseRepository;
import com.java3.project.domain.UserPurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by John Lazaro on 13/06/2017.
 */

@RestController
public class UserPurchaseController {

    @Autowired
    UserPurchaseRepository userPurchaseRepository;

    @RequestMapping(value = "/userpurchases", method = RequestMethod.GET)
    public ResponseEntity<?> getUserPurchases(){
        return new ResponseEntity<Object>(userPurchaseRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/userpurchases/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserPurchaseById(@PathVariable int userID){
        return new ResponseEntity<Object>(userPurchaseRepository.getAllByUserId(userID), HttpStatus.OK);
    }

    @RequestMapping(value = "/userpurchases/create/{transactionId}/{referenceId}/{userId}", method = RequestMethod.POST)
    public void createUserPurchase(@PathVariable int transactionId, @PathVariable int referenceId, @PathVariable int userId){
        UserPurchase userPurchase = new UserPurchase();
        userPurchase.setTransactionId(transactionId);
        userPurchase.setReferenceId(referenceId);
        userPurchase.setUserId(userId);
        userPurchaseRepository.save(userPurchase);
    }
}
