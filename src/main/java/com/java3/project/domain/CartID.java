package com.java3.project.domain;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@MappedSuperclass
public class CartID {
    int cartId;
    int userId;
    int status;
    int branchId;

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

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
