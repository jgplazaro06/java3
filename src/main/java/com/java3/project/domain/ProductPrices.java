package com.java3.project.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
//@Table(name = "productprices", schema = "monoproject")
public class ProductPrices {
    private int referenceId;
    private int productId;
    private BigDecimal productPrice;
    private Timestamp referenceDate;
//    private Products products;

    @Id
    @Column(name = "ReferenceID")
    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

//    @ManyToOne
////    @JoinColumn(name = "ProductId")
//    public Products getProducts() {
//        return products;
//    }
//
//    public void setProducts(Products products) {
//        this.products = products;
//    }

    @Basic
    @Column(name = "ProductID")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "ProductPrice")
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "ReferenceDate")
    public Timestamp getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Timestamp referenceDate) {
        this.referenceDate = referenceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductPrices that = (ProductPrices) o;

        if (referenceId != that.referenceId) return false;
        if (productId != that.productId) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (referenceDate != null ? !referenceDate.equals(that.referenceDate) : that.referenceDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = referenceId;
        result = 31 * result + productId;
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (referenceDate != null ? referenceDate.hashCode() : 0);
        return result;
    }
}
