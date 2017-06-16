package com.java3.project.data;

import com.java3.project.domain.BranchProducts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by John Lazaro on 13/06/2017.
 */
public interface BranchProductRepository extends CrudRepository<BranchProducts, Integer> {

    List<BranchProducts> getAllByBranchId(int branchID);
    BranchProducts getByBranchIdAndProductId(int branchID, int productID);
    List<BranchProducts> getAllByProductId(int productID);

}
