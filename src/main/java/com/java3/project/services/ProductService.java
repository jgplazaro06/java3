package com.java3.project.services;

import com.java3.project.data.ProductRepository;
import com.java3.project.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts(){
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Products getProductsById(int productId){
        Products product = new Products();
        product = productRepository.getByProductId(productId);
        return product;
    }

}
