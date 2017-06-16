package com.java3.project.services;

import com.java3.project.data.BranchProductRepository;
import com.java3.project.data.BranchRepository;
import com.java3.project.domain.Branch;
import com.java3.project.domain.BranchProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by John Lazaro on 17/06/2017.
 */

@Service
public class BranchProductService {

    @Autowired
    BranchProductRepository branchProductRepository;

    @Autowired
    BranchRepository branchRepository;

    public List<BranchProducts> getAllBranchProducts(){
        return StreamSupport.stream(branchProductRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public List<BranchProducts> getAllByBranchId(int branchId){
        return new ArrayList<>(branchProductRepository.getAllByBranchId(branchId));
    }

    public List<Branch> getAllByProductId(int productId){
        List<Branch> branches = new ArrayList<Branch>();
        List<BranchProducts> branchProducts = new ArrayList<>(branchProductRepository.getAllByProductId(productId));
        for(BranchProducts branch: branchProducts){
            Branch temp = branchRepository.getByBranchId(branch.getBranchId());
            branches.add(temp);
        }
        return branches;
    }

    public BranchProducts getAllByBranchIdAndProductId(int branchId, int productId){
        return branchProductRepository.getByBranchIdAndProductId(branchId, productId);
    }

    public void updateBranchProductQuantity(int branchId, int productId, int quantity){
        BranchProducts branchProducts = branchProductRepository.getByBranchIdAndProductId(branchId, productId);
        branchProducts.setQuantity(branchProducts.getQuantity() + quantity);
        branchProductRepository.save(branchProducts);
    }

}
