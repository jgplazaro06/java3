package com.java3.project.controllers;

import com.java3.project.data.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@RestController
public class CartProductController {
    @Autowired
    CartProductRepository cartProductRepository;


}
