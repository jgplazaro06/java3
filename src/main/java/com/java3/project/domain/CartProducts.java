package com.java3.project.domain;

import javax.persistence.Entity;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@Entity
public class CartProducts {
    private int cartId;
    private int productId;
    private int transactionId;
    private int quantity;
    private int referenceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartProducts that = (CartProducts) o;

        if (cartId != that.cartId) return false;
        if (productId != that.productId) return false;
        if (transactionId != that.transactionId) return false;
        if (quantity != that.quantity) return false;
        return referenceId == that.referenceId;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + productId;
        result = 31 * result + transactionId;
        result = 31 * result + quantity;
        result = 31 * result + referenceId;
        return result;
    }

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

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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
}
