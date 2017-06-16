package com.java3.project.domain;

import javax.persistence.Entity;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@Entity
public class CartProducts {
    private int cartId;
    private int productId;
    private int quantity;
    private int referenceId;
    private int branchId;


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
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
        return branchId == that.branchId;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + productId;
        result = 31 * result + quantity;
        result = 31 * result + referenceId;
        result = 31 * result + branchId;
        return result;
    }
}
