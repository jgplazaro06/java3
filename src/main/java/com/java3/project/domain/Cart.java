package com.java3.project.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by John Lazaro on 17/06/2017.
 */

@Entity
@IdClass(CartID.class)
public class Cart {
    private int cartId;
    private int userId;
    private int status;
    private Timestamp referenceDate;
    private BigDecimal userCash;


    @Id
    @Column(name = "CartID")
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Id
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ReferenceDate")
    public Timestamp getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Timestamp referenceDate) {
        this.referenceDate = referenceDate;
    }

    @Basic
    @Column(name = "UserCash")
    public BigDecimal getUserCash() {
        return userCash;
    }

    public void setUserCash(BigDecimal userCash) {
        this.userCash = userCash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (cartId != cart.cartId) return false;
        if (userId != cart.userId) return false;
        if (status != cart.status) return false;
        if (referenceDate != null ? !referenceDate.equals(cart.referenceDate) : cart.referenceDate != null)
            return false;
        return userCash != null ? userCash.equals(cart.userCash) : cart.userCash == null;
    }

    @Override
    public int hashCode() {
        int result = cartId;
        result = 31 * result + userId;
        result = 31 * result + status;
        result = 31 * result + (referenceDate != null ? referenceDate.hashCode() : 0);
        result = 31 * result + (userCash != null ? userCash.hashCode() : 0);
        return result;
    }
}
