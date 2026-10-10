package com.dss.p1.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
    private List<Product> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public void removeProduct(Long productId) {
        cartItems.removeIf(product -> product.getId().equals(productId));
    }
}