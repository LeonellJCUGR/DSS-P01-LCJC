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
        // Elimina solo una unidad (la primera coincidencia), no todas las del mismo producto
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getId().equals(productId)) {
                cartItems.remove(i);
                return;
            }
        }
    }
}