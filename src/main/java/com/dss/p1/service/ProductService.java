package com.dss.p1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.p1.repository.ProductRepo;
import com.dss.p1.model.Product;

// etiqueta para reconozca un servicio
@Service
public class ProductService {
	
	// inyeccion de dependencia solo aqui
	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Product getProductById(Long id) {
		return productRepo.getById(id);
	}
	
	public void saveProduct(Product producto) {
		productRepo.save(producto);
	}
	
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}

}
