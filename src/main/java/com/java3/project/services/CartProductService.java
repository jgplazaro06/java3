package com.java3.project.services;

import com.java3.project.data.CartProductRepository;
import com.java3.project.data.ProductPriceRepository;
import com.java3.project.domain.CartProducts;
import com.java3.project.domain.ProductPrices;
import com.java3.project.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@Service
public class CartProductService {

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    ProductPriceRepository productPriceRepository;

    public List<CartProducts> getAllCartProducts(){
        return StreamSupport.stream(cartProductRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public List<CartProducts> getAllCartProductsByCartId(int cartId){
        return cartProductRepository.getByCartId(cartId);
    }
    public List<CartProducts> getAllCartProductsByCartIdAndBranchId(int cartId, int branchId){
        return cartProductRepository.getAllByCartIdAndBranchId(cartId, branchId);
    }

    public void createCartProduct(int cartId, int productId,int branchId, int quantity, int referenceId){
        CartProducts cartProduct = new CartProducts();
        cartProduct.setCartId(cartId);
        cartProduct.setProductId(productId);
        cartProduct.setBranchId(branchId);
        cartProduct.setQuantity(quantity);
        ProductPrices productPrice = productPriceRepository.getByProductId(productId);
        cartProduct.setReferenceId(productPrice.getReferenceId());
    }

    public void deleteCartProduct(int cartId, int productId){
        cartProductRepository.deleteByCartIdAndProductId(cartId, productId);
    }

    public void updateCartProduct(int cartId, int productId, int quantity){
        CartProducts cartProduct = new CartProducts();
        cartProduct = cartProductRepository.getByCartIdAndProductId(cartId, productId);
        cartProduct.setQuantity(quantity);
        cartProductRepository.save(cartProduct);
    }
}
