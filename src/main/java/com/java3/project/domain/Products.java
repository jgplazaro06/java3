package com.java3.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
//@Table(name = "products", schema = "monoproject")
public class Products implements Serializable {

    @Id
    @Column(name = "ProductID")
    private int productId;

    @Basic
    @Column(name = "ProductName")
    private String productName;

    @OneToMany
    @JoinColumn(name = "productID")
    private Set<ProductPrices> productPrices;

    public Set<BranchProducts> getBranchProducts() {
        return branchProducts;
    }

    public void setBranchProducts(Set<BranchProducts> branchProducts) {
        this.branchProducts = branchProducts;
    }

    @OneToMany
    @JoinColumn(name = "productID")
    private Set<BranchProducts> branchProducts;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<ProductPrices> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Set<ProductPrices> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products that = (Products) o;

        if (productId != that.productId) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }
}
