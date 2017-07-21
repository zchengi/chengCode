package com.cheng.cartitem.povo;

import java.math.BigDecimal;

import com.cheng.domain.Book;
import com.cheng.domain.CartItem;
import com.cheng.domain.User;

public class CartItempovo extends Book {
    private CartItem cartItem;
    private User user;
    private double subTotal;

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotal() {
        this.subTotal = new BigDecimal(cartItem.getQuantity()).multiply(
                super.getCurrprice()).doubleValue();
        return subTotal;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
