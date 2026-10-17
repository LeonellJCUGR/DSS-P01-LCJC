package com.dss.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dss.p1.service.CartService;
import com.dss.p1.service.ProductService;


@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
    @GetMapping
    public String viewCart(Model model) {
    	// cart.html recorre ${cartItems}
    	model.addAttribute("cartItems", cartService.getCart().getCartItems());
    	return "cart";
    }
		
    // El formulario solo envía el id en la URL: el producto se busca en la BD
    @PostMapping("/add/{id}")
    public String addProductCart(@PathVariable Long id) {
    	cartService.addProduct(productService.getProductById(id));
        return "redirect:/products";
    }
    
    @PostMapping("/remove/{id}")
    public String removeCartItem(@PathVariable Long id) {
    	cartService.removeProduct(id);
        return "redirect:/cart";
    }

}
