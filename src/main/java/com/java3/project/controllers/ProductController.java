package com.java3.project.controllers;
import com.java3.project.data.ProductRepository;
import com.java3.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<Object>(productService.getAllProducts(), HttpStatus.OK);

    }

    @RequestMapping(value = "/products/{productID}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductsByID(@PathVariable int productID){
        return new ResponseEntity<Object>(productService.getProductsById(productID), HttpStatus.OK);
    }
}
