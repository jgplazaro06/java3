package com.java3.project.data;


import com.java3.project.domain.CartProducts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by John Lazaro on 17/06/2017.
 */
public interface CartProductRepository extends CrudRepository<CartProducts, Integer> {
   List<CartProducts> getByCartId(int cartId);
   void deleteByCartIdAndProductId(int cartId, int productId);
   CartProducts getByCartIdAndProductId(int cartId, int productId);
   List<CartProducts> getAllByCartIdAndBranchId(int cartId, int branchId);

}
