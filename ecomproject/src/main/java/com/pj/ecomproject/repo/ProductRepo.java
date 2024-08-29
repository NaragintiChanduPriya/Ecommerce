package com.pj.ecomproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pj.ecomproject.modal.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("SELECT p from Product p WHERE "+
			"LOWER(p.name) Like LOWER(CONCAT('%', :keyword,'%')) OR "+
			"LOWER(p.description) Like LOWER(CONCAT('%', :keyword,'%')) OR "+
			"LOWER(p.brand) Like LOWER(CONCAT('%', :keyword,'%')) OR "+
			"LOWER(p.category) Like LOWER(CONCAT('%', :keyword,'%'))")
			
			
			
			
			
	List<Product> searchProducts(String keyword);
		
	
}
