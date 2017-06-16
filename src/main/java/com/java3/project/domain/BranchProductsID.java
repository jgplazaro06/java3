package com.java3.project.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by John Lazaro on 13/06/2017.
 */
@MappedSuperclass
public class BranchProductsID implements Serializable{

     int branchId;
     int productId;

    public BranchProductsID() {
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
