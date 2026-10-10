package com.dss.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dss.p1.model.Product;


public interface ProductRepo extends JpaRepository<Product,Long>{
		

}
