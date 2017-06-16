package com.java3.project.domain;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@MappedSuperclass
public class CartID {
    private int cartId;
    private int userId;

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
}
