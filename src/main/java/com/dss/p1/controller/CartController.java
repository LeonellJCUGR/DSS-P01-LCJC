package com.dss.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dss.p1.service.CartService;

import com.dss.p1.model.Product;


@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
    @GetMapping
    public String viewCart(Model model) {
    	model.addAttribute("cart", cartService.getCart());
    	return "cart";
    }
		
    @PostMapping("/add/{id}")
    public String addProductCart(@ModelAttribute Product carItem) {
    	cartService.addProduct(carItem);
        return "redirect:/products";
    }
    
    @PostMapping("/remove/{id}")
    public String removeCartItem(@PathVariable Long id) {
    	cartService.removeProduct(id);
        return "redirect:/cart";
    }
    
    // ...

}