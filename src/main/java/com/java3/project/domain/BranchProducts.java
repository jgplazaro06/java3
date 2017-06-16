package com.java3.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@IdClass(BranchProductsID.class)
//@Table(name = "branchproducts", schema = "monoproject")
public class BranchProducts implements Serializable {

    private int branchId;
    private int productId;
    private Integer quantity;

    @Id
    @Column(name = "BranchID")
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }


    private Set<Branch> branches;


//    @ManyToMany
//    @JoinColumn(name = "branchID")
//    public Set<Branch> getBranches() {
//        return branches;
//    }
//
//    public void setBranches(Set<Branch> branches) {
//        this.branches = branches;
//    }

    @Id
    @Column(name = "ProductID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchProducts that = (BranchProducts) o;

        if (branchId != that.branchId) return false;
        if (productId != that.productId) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = branchId;
        result = 31 * result + productId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
