package com.java3.project.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by John Lazaro on 13/06/2017.
 */
@MappedSuperclass
public class UserPurchaseID implements Serializable{
    int purchaseId;
    int transactionId;
    int referenceId;
    int userId;

    public UserPurchaseID() {
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
