package com.java3.project.services;

import com.java3.project.data.ProductPriceRepository;
import com.java3.project.domain.ProductPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@Service
public class ProductPriceService {
    @Autowired
    ProductPriceRepository productPriceRepository;

    public List<ProductPrices> getAllProductPrices(){
        return StreamSupport.stream(productPriceRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

//    public List<ProductPrices> getAllByProductId(int productId){
//        return StreamSupport.stream(productPriceRepository.getAllByProductId(productId).spliterator(), false).collect(Collectors.toList());
//    }

    public ProductPrices getByProductPrice(int productId){
        ProductPrices productPrice = new ProductPrices();
        productPrice = productPriceRepository.getByProductId(productId);
        return productPrice;

    }
}
