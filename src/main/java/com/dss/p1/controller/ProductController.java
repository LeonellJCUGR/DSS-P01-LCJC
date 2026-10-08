package com.dss.p1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dss.p1.model.Producto;
import com.dss.p1.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	// MVC (revisar arquitectura)
	// model --> repository --> service --> controller
	// ProductController --> ProductService --> ProductRepo --> BD
	
	// inyeccion de dependencia (solo dentro de la clase)
	@Autowired
	private ProductService productService;
	
	// Muestra todos los productos
    @GetMapping
    public String getAllProducts(Model model) {
        List<Producto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productos";
    }
    
    // etiqueta -revisar-
    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id) {
    	return productService.getProductById(id);
    }
    
    // Anhade y modifica producto
    @PostMapping
    public String saveProduct(@ModelAttribute Producto producto) {
        productService.saveProduct(producto);
        return "redirect:/products";
    }
    
    // para borrar tiene que buscar, ergo GetMapping
    // borra producto
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }


}
