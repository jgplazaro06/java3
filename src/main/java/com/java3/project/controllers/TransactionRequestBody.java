package com.java3.project.controllers;

import java.sql.Timestamp;

/**
 * Created by John Lazaro on 13/06/2017.
 */
public class TransactionRequestBody {
    int productId;
    boolean stocking;
    //0 = incoming
    //1 = outgoing
    Timestamp transactionDate;
    int userId;
    int quantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isStocking() {
        return stocking;
    }

    public void setStocking(boolean stocking) {
        this.stocking = stocking;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
