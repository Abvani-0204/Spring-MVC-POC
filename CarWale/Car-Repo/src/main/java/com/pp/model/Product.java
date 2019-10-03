package com.pp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column
private int id;

@Column
private String productName;

@Column
private String productDescription;

@Column
private int productPrice;

@Column
private String dateOfIssue;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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

public int getProductPrice() {
	return productPrice;
}

public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}

public String getDateOfIssue() {
	return dateOfIssue;
}

public void setDateOfIssue(String dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
}





}
