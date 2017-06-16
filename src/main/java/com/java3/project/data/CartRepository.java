package com.java3.project.data;

import com.java3.project.domain.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by John Lazaro on 17/06/2017.
 */
public interface CartRepository extends CrudRepository<Cart, Integer> {
   Cart getByUserIdAndStatus(int userId, int status);
   //0 = in cart; 1 = pending; 2 = employee approved; 3 = employee denied
   List<Cart> getAllByStatus(int status);
   List<Cart> getAllByBranchIdAndStatus(int branchId, int status);

}
