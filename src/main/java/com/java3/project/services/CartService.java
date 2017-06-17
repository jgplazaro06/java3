package com.java3.project.services;

import com.java3.project.data.BranchProductRepository;
import com.java3.project.data.CartProductRepository;
import com.java3.project.data.CartRepository;
import com.java3.project.domain.BranchProducts;
import com.java3.project.domain.Cart;
import com.java3.project.domain.CartProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan on 6/15/2017.
 */
@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    BranchProductRepository branchProductRepository;

    public Cart getUserCart(int userId) {
        // TODO
        // 1) Check if there is already a cart entry in the db with user_id = to `userId`
        //      and status is equal to 0.
        // 1a) If conditions in (1) was satisfied, retrieve the cart entry
        // 1b) If conditions in (1) was NOT satisfied, insert a new cart entry
        // 2) Return the cart entry
        Cart cart = cartRepository.getByUserIdAndStatus(userId, 0);
        if (cart == null) {
            createCart(userId);
            return getUserCart(userId);
        }
        return cart;
    }

    public void createCart(int userId)
    {
        Cart cart = new Cart();
        cart.setUserId(userId);
//        cart.setBranchId(branchId);
        cart.setStatus(0);
        Timestamp referenceDate = new Timestamp(System.currentTimeMillis());
        cart.setReferenceDate(referenceDate);
        cartRepository.save(cart);
    }

    public List<CartProducts> getUserCartProducts(int userId) {
        // TODO
        // 1) Retrieve the user's cart by calling `getUserCart(String)`
        // 2) Retrieve the list of cart product entries using the id of the cart entry
        // 3) Return the cart product entries list

        Cart cart = getUserCart(userId);
        return new ArrayList<>(cartProductRepository.getByCartId(cart.getCartId()));
    }

    public void checkOutCart(int userId, BigDecimal cash) {
        // TODO
        // 1) Retrieve the cart of the user using `getUserCart(String)`
        // 2) Retrieve and validate the cart products
        // 3) Set the status of the cart equal to `1` and set the cash equal to `cash`
        Cart cart = getUserCart(userId);

        List<CartProducts> cartProducts = cartProductRepository.getByCartId(cart.getCartId());
        for (CartProducts cartProduct : cartProducts) {
            boolean b = cartProduct.getQuantity() > 0;
            if (b)
                throw new UnavailableBranchProduct(cartProduct.getProductId());
            else
            {
                BranchProducts branchProducts = branchProductRepository.getByBranchIdAndProductId
                        (cartProduct.getBranchId(), cartProduct.getProductId());
                if(branchProducts.getQuantity() < cartProduct.getQuantity()){
                    throw new UnavailableBranchProduct(cartProduct.getProductId());
                }
                else
                {
                    cart.setStatus(1);
                    cart.setUserCash(cash);
                }
            }
        }

        throw new UnsupportedOperationException();
    }

    public class UnavailableBranchProduct extends RuntimeException {
        private int productId;

        public UnavailableBranchProduct(int productId) {
            this.productId = productId;
        }

        public int getProductId() {
            return productId;
        }
    }

    //approve cart
    //deny cart
}
