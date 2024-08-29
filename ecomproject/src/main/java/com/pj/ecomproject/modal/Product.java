package com.pj.ecomproject.modal;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;

//import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity
@Component
public class Product {
  
  private int Id;
  private String name;
  private String description;
  private String brand;
  private BigDecimal price;
  private String category;
//  @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
  private Date releaseDate;
  private boolean productAvailable;
  private int stockQuantity;
  
  private String imageName;
  private String imageType;
  @Lob
  @Column(name = "image_data", columnDefinition = "LONGBLOB")
  private byte[] imageData;
  
  

public Product() {
	
}

public Product(int id, String name, String description, String brand, BigDecimal price, String category,
		Date releaseDate, boolean productAvailable, int stockQuantity, String imageName, String imageType,
		byte[] imageData) {
	
	Id = id;
	this.name = name;
	this.description = description;
	this.brand = brand;
	this.price = price;
	this.category = category;
	this.releaseDate = releaseDate;
	this.productAvailable = productAvailable;
	this.stockQuantity = stockQuantity;
	this.imageName = imageName;
	this.imageType = imageType;
	this.imageData = imageData;
}

@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
      return Id;
  }
  
	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
    @Lob
	public byte[] getImageData() {
		return imageData;
	}
    @Lob
    
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + ", description=" + description + ", brand=" + brand + ", price="
				+ price + ", category=" + category + ", releaseDate=" + releaseDate + ", productAvailable="
				+ productAvailable + ", stockQuantity=" + stockQuantity + ", imageName=" + imageName + ", imageType="
				+ imageType + ", imageData=" + Arrays.toString(imageData) + "]";
	}



}
