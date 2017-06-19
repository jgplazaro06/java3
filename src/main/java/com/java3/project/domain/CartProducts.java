package com.java3.project.domain;

import javax.persistence.*;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@Entity
@IdClass(CartProductsID.class)
public class CartProducts {
    private int cartId;
    private int productId;
    private int quantity;
    private int referenceId;
    private int branchId;
    private int approved;


    @Id
    @Column(name = "CartID")
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

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
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Id
    @Column(name = "ReferenceID")
    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    @Id
    @Column(name = "BranchID")
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @Id
    @Column(name = "Approved")
    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartProducts that = (CartProducts) o;

        if (cartId != that.cartId) return false;
        if (productId != that.productId) return false;
        if (quantity != that.quantity) return false;
        if (referenceId != that.referenceId) return false;
        if (branchId != that.branchId) return false;
        return approved == that.approved;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + productId;
        result = 31 * result + quantity;
        result = 31 * result + referenceId;
        result = 31 * result + branchId;
        result = 31 * result + approved;
        return result;
    }
}
