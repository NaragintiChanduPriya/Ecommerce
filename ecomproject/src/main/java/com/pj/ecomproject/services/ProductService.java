package com.pj.ecomproject.services;


import com.pj.ecomproject.repo.ProductRepo;

import jakarta.transaction.Transactional;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pj.ecomproject.modal.Product;

@Service
@Transactional
public class ProductService {
	@Autowired
  ProductRepo repo;
	public List<Product> getAllProducts() {
		
		return  repo.findAll() ;
	}
	
	 public Product getProductById(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void deleteProductById(Integer id) {
	        repo.deleteById(id);
	    }

		public Product addProduct(Product prod, MultipartFile imageFile) throws IOException  {
			prod.setImageName(imageFile.getOriginalFilename());
			prod.setImageType(imageFile.getContentType());
			prod.setImageData(imageFile.getBytes());
			return repo.save(prod);
		}

		public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
			product.setImageData(imageFile.getBytes());
			product.setImageName(imageFile.getOriginalFilename());
			product.setImageType(imageFile.getContentType());
			return repo.save(product);
			
			
		}

		public List<Product> searchProducts(String keyword) {
			
			return repo.searchProducts(keyword);
		}

		

	

}
