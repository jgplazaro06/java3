package com.java3.project.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
//@Table(name = "transactions", schema = "monoproject")
public class Transactions {
    private int transactionId;
    private int productId;
    private boolean stocking;
    //0 = incoming
    //1 = outgoing
    private Timestamp transactionDate;
    private int userId;
    private int quantity;

    @Id
    @Column(name = "TransactionID")
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "ProductID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Stocking")
    public boolean isStocking() {
        return stocking;
    }

    public void setStocking(boolean stocking) {
        this.stocking = stocking;
    }

    @Basic
    @Column(name = "TransactionDate")
    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Basic
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transactions that = (Transactions) o;

        if (transactionId != that.transactionId) return false;
        if (productId != that.productId) return false;
        if (stocking != that.stocking) return false;
        if (userId != that.userId) return false;
        if (quantity != that.quantity) return false;
        if (transactionDate != null ? !transactionDate.equals(that.transactionDate) : that.transactionDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionId;
        result = 31 * result + productId;
        result = 31 * result + (stocking ? 1 : 0);
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + quantity;
        return result;
    }
}
