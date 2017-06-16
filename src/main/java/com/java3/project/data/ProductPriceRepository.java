package com.java3.project.data;

import com.java3.project.domain.ProductPrices;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by John Lazaro on 13/06/2017.
 */
public interface ProductPriceRepository extends CrudRepository<ProductPrices, Integer> {
    List<ProductPrices> getAllByProductId(int productID);
    ProductPrices findFirstByOrderByReferenceDateDesc();

//    @Query("select p.`ProductName`, pp.`ProductPrice` from `Products` as p left join `ProductPrices` as pp on p.`ProductID` = pp.`ProductID` where p.`ProductID` = :productId")
//    List<Object[]> getProductAndProductPrice(@PathVariable int productId);
}
