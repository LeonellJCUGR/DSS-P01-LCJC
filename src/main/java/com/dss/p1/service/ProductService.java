package com.dss.p1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.p1.repository.ProductRepo;
import com.dss.p1.model.Producto;

// etiqueta para reconozca un servicio
@Service
public class ProductService {
	
	// inyeccion de dependencia solo aqui
	@Autowired
	private ProductRepo productRepo;
	
	public List<Producto> getAllProducts(){
		return productRepo.findAll();
	}
	
	public Producto getProductById(Long id) {
		return productRepo.getById(id);
		// revisar despues
	}
	
	public void saveProduct(Producto producto) {
		productRepo.save(producto);
	}
	
	public void deleteProduct(Producto producto) {
		productRepo.delete(producto);
	}

}
