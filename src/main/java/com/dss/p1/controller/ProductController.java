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

import com.dss.p1.model.Product;
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
	
	// Muestra o lista todos los productos
    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productos";
    }
    
    // Muestra Formulario de alta (ADMIN)
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "formulario-producto";
    }
    
    // Muestra Formulario de edicion (ADMIN)
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "formulario-producto";
    }
        
    // etiqueta
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
    	return productService.getProductById(id);
    }
    
    // Anhade y modifica producto (ADMIN)
    @PostMapping
    public String saveProduct(@ModelAttribute Product producto) {
        productService.saveProduct(producto);
        return "redirect:/products";
    }
    
    // para borrar tiene que buscar, ergo GetMapping
    // borrar producto (ADMIN)
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }


}
