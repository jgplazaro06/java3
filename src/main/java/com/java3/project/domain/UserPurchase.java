package com.java3.project.domain;

import javax.persistence.*;

@Entity
@IdClass(UserPurchaseID.class)
//@Table(name = "userpurchase", schema = "monoproject")
public class UserPurchase {
    private int purchaseId;
    private int transactionId;
    private int referenceId;
    private int userId;

    @Id
    @Column(name = "PurchaseID")
    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Basic
    @Column(name = "TransactionID")
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "ReferenceID")
    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    @Basic
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPurchase that = (UserPurchase) o;

        if (purchaseId != that.purchaseId) return false;
        if (transactionId != that.transactionId) return false;
        if (referenceId != that.referenceId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purchaseId;
        result = 31 * result + transactionId;
        result = 31 * result + referenceId;
        result = 31 * result + userId;
        return result;
    }
}
