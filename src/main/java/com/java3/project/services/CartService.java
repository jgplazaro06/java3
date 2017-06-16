package com.java3.project.services;

import org.springframework.stereotype.Service;

/**
 * Created by Bryan on 6/15/2017.
 */
@Service
public class CartService {

    public Object getUserCart(String userId) {
        // TODO
        // 1) Check if there is already a cart entry in the db with user_id = to `userId`
        //      and status is equal to 0.
        // 1a) If conditions in (1) was satisfied, retrieve the cart entry
        // 1b) If conditions in (1) was NOT satisfied, insert a new cart entry
        // 2) Return the cart entry

        throw new UnsupportedOperationException();
    }

    public Object getUserCartProducts(String userId) {
        // TODO
        // 1) Retrieve the user's cart by calling `getUserCart(String)`
        // 2) Retrieve the list of cart product entries using the id of the cart entry
        // 3) Return the cart product entries list

        throw new UnsupportedOperationException();
    }

    public void checkOutCart(String userId, double cash) {
        // TODO
        // 1) Retrieve the cart of the user using `getUserCart(String)`
        // 2) Retrieve and validate the cart products
        // 3) Set the status of the cart equal to `1` and set the cash equal to `cash`

        throw new UnsupportedOperationException();
    }
}
