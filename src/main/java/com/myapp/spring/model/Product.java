package com.myapp.spring.model;

import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="devops_products")
public class Product {

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Integer productid; 
	
	
	@Column(name = "PRODUCT_NAME", nullable = false)
	private String productName;
	
	
	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;

	@Column(name = "PRODUCT_PRICE", nullable = false)
	private Double price;
	
	@Column(name = "PRODUCT_Rating", nullable = false)
	private Double starRating;

	public Product(String productName, String productDescription, Double price, Double starRating) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.starRating = starRating;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getStarRating() {
		return starRating;
	}

	public void setStarRating(Double starRating) {
		this.starRating = starRating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, productDescription, productName, productid, starRating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		return Objects.equals(price, other.price) && Objects.equals(productDescription, other.productDescription)
				&& Objects.equals(productName, other.productName) && Objects.equals(productid, other.productid)
				&& Objects.equals(starRating, other.starRating);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productid=");
		builder.append(productid);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productDescription=");
		builder.append(productDescription);
		builder.append(", Price=");
		builder.append(price);
		builder.append(", starRating=");
		builder.append(starRating);
		builder.append("]");
		return builder.toString();
	}


	
	
	
}
