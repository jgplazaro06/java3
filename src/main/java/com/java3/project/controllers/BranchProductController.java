package com.java3.project.controllers;

/**
 * Created by John Lazaro on 13/06/2017.
 */

import com.java3.project.data.BranchProductRepository;
import com.java3.project.domain.BranchProducts;
import com.java3.project.services.BranchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchProductController {

    @Autowired
    BranchProductService branchProductService;

    @RequestMapping(value = "/branchproducts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBranchProducts() {
        return new ResponseEntity<Object>
                (branchProductService.getAllBranchProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/branchproducts/{productId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBranchesWithProductId(@PathVariable int productId){
        return new ResponseEntity<Object>
                (branchProductService.getAllByProductId(productId), HttpStatus.OK);
    }

    @RequestMapping(value = "/branchproducts/{branchId}/{productId}", method = RequestMethod.GET)
    public BranchProducts getBranchProductByID(@PathVariable int branchId, @PathVariable int productId) {
        return branchProductService.getAllByBranchIdAndProductId(branchId, productId);
    }

    @RequestMapping(value = "/branchproducts/branch/{branchId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBranchProducts(@PathVariable int branchId) {
        return new ResponseEntity<Object>
                (branchProductService.getAllByBranchId(branchId), HttpStatus.OK);
    }

    @RequestMapping(value = "/branchproducts/update/{branchId}/{productId}/{quantity}", method = RequestMethod.PUT)
    public void updateBranchProductQuantity(@PathVariable int branchId,
                                            @PathVariable int productId,
                                            @PathVariable int quantity) {
        branchProductService.updateBranchProductQuantity(branchId, productId, quantity);
    }
}
