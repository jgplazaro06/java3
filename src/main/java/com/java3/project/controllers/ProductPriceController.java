package com.java3.project.controllers;

import com.java3.project.data.ProductPriceRepository;
import com.java3.project.domain.ProductPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by John Lazaro on 13/06/2017.
 */

@RestController
public class ProductPriceController {

    @Autowired
    ProductPriceRepository productPriceRepository;

    @RequestMapping(value = "/productprice",  method = RequestMethod.GET)
    public ResponseEntity<?> getProductPrices(){
        List<HashMap<String, Object>> pps = StreamSupport.stream(productPriceRepository.findAll().spliterator(), false).map(pp -> {
            HashMap<String, Object> hashmap = new HashMap<>();
            hashmap.put("referenceId", pp.getReferenceId());
            hashmap.put("productId", pp.getProductId());
            hashmap.put("productPrice", pp.getProductPrice());
            hashmap.put("referenceDate", SimpleDateFormat.getDateTimeInstance().format(pp.getReferenceDate()));
            return hashmap;
        }).collect(Collectors.toList());

        return new ResponseEntity<Object>(pps, HttpStatus.OK);
    }

    @RequestMapping(value = "/productprice/{productId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductPricesByProductId(@PathVariable int productId){
        return new ResponseEntity<Object>(
                productPriceRepository.getAllByProductId(productId), HttpStatus.OK
        );
    }

    @RequestMapping(value = "/productprice/latest/{productId}", method = RequestMethod.GET)
    public ProductPrices getLatestProductPrice(@PathVariable int productId){
        List<ProductPrices> productPrices = productPriceRepository.getAllByProductId(productId);
        ProductPrices productPrice;
        if(productPrices != null && !productPrices.isEmpty())
        {
            productPrice = productPrices.get(productPrices.size() - 1);
            return productPrice;
        }
        else
        {
            return null;
        }
    }

    @RequestMapping(value = "productprice/create/{productId}/{productprice}", method = RequestMethod.POST)
    public void createProductPrice(@PathVariable int productId,
                                   @PathVariable BigDecimal productPrice
                                   ){
        ProductPrices newPrice = new ProductPrices();
        newPrice.setProductId(productId);
        newPrice.setProductPrice(productPrice);
//        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp referenceDate = new Timestamp(System.currentTimeMillis());
        newPrice.setReferenceDate(referenceDate);
        productPriceRepository.save(newPrice);
    }
}
