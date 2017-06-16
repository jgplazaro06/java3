package com.java3.project.data;

import com.java3.project.domain.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Products, Integer> {
    Products getByProductId(int productID);

}
