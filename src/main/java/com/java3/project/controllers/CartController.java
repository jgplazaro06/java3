package com.java3.project.controllers;

import com.java3.project.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by Bryan on 6/15/2017.
 */
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cart/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCart(@PathVariable("userId") int userId) {

        cartService.getUserCart(userId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/products/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCartProducts(@PathVariable int userID){
        cartService.getUserCartProducts(userID);
        return new ResponseEntity<>( null, HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/checkout/{userID}/{cash}", method = RequestMethod.PUT)
    public ResponseEntity<?> checkoutCart(@PathVariable int userId, @PathVariable BigDecimal cash){
        cartService.checkOutCart(userId, cash);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }



}
