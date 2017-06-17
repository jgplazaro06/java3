package com.java3.project.controllers;

import com.java3.project.data.CartProductRepository;
import com.java3.project.services.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by John Lazaro on 17/06/2017.
 */
@RestController
public class CartProductController {
    @Autowired
    CartProductService cartProductService;

    @RequestMapping(value = "cartproducts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCartProducts(){
        return new ResponseEntity<Object>(cartProductService.getAllCartProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "cartproducts/cart/{cartid}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCartProductsByCartId(@PathVariable int cartId){
        return new ResponseEntity<Object>(cartProductService.getAllCartProductsByCartId(cartId), HttpStatus.OK);
    }

    @RequestMapping(value = "cartproducts/branch/{cartId}/{branchId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCartByIdAndBranchId(@PathVariable int cartId, @PathVariable int branchId){
        return new ResponseEntity<Object>(cartProductService.getAllCartProductsByCartIdAndBranchId
                (cartId, branchId), HttpStatus.OK);
    }

    @RequestMapping(value = "/cartproducts/create", method = RequestMethod.POST)
    @ResponseBody
    public void createUser(@RequestBody CartProductRequestBody cartProductRequestBody) {

            cartProductService.createCartProduct(
                    cartProductRequestBody.getCartId(),
                    cartProductRequestBody.getProductId(),
                    cartProductRequestBody.getBranchId(),
                    cartProductRequestBody.getQuantity(),
                    cartProductRequestBody.getReferenceId()
        );
    }

    @RequestMapping(value = "/cartproducts/delete/{cartId}/{productId}", method = RequestMethod.DELETE)
    public void deleteCartProduct(@PathVariable int cartId, @PathVariable int productId){
        cartProductService.deleteCartProduct(cartId, productId);
    }

    @RequestMapping(value = "/cartproducts/update/{cartId}/{productId}/{quantity}", method = RequestMethod.PUT)
    public void updateCartProduct(@PathVariable int cartId, @PathVariable int productId, @PathVariable int quantity){
        cartProductService.updateCartProduct(cartId, productId, quantity);
    }
}
