package com.pj.ecomproject.controller;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pj.ecomproject.modal.Product;
import com.pj.ecomproject.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService service;
	

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getALLProducts()
	{
		
		return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);	
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> get(@PathVariable int id) {
	    try {
	        Product product = service.getProductById(id);
	        return new ResponseEntity<Product>(product, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product,@RequestPart MultipartFile imageFile)
	{
		try {
			Product product1=service.addProduct(product,imageFile);
			return new ResponseEntity<>(product1,HttpStatus.OK);
			
		}
		catch(Exception e){
			return new ResponseEntity<>(e.getStackTrace(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@GetMapping("/product/{id}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
	  Product product=	service.getProductById(id);
	  byte[] imageFile =product.getImageData();
	  return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<?> updatePtoduct(@RequestPart Product product,@RequestPart MultipartFile imageFile, @PathVariable int id)  {
	         Product product1=null;
			try {
				product1 = service.updateProduct(id,product,imageFile);
			} catch (IOException e) {
				 return new ResponseEntity<>("failed to update",HttpStatus.BAD_REQUEST);

			}
	         if(product1 != null)
	        	 return new ResponseEntity<>("updated",HttpStatus.OK);
	         else 
	        	 return new ResponseEntity<>("failed to update",HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable Integer id) {
	    service.deleteProductById(id);
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
		List<Product> products=service.searchProducts(keyword);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
}
