package com.java3.project.domain;

import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * Created by John Lazaro on 17/06/2017.
 */

@Entity
public class Cart {
    private int cartId;
    private int userId;
    private int status;
    private Timestamp referenceDate;
    private int branchId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != cart.cartId) return false;
        if (userId != cart.userId) return false;
        if (status != cart.status) return false;
        if (branchId != cart.branchId) return false;
        return referenceDate != null ? referenceDate.equals(cart.referenceDate) : cart.referenceDate == null;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + userId;
        result = 31 * result + status;
        result = 31 * result + (referenceDate != null ? referenceDate.hashCode() : 0);
        result = 31 * result + branchId;
        return result;
    }

    public int getCartId() {

        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Timestamp referenceDate) {
        this.referenceDate = referenceDate;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
