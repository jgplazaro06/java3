package com.java3.project.domain;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@MappedSuperclass
public class CartPorductsID {
    int cartId;
    int productId;
    int transactionId;
    int referenceId;

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

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }
}
