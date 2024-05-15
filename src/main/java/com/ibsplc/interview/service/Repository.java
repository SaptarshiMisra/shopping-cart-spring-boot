package com.ibsplc.interview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ibsplc.interview.model.Product;

@Component
public class Repository {
	
	private List<Product> products = new ArrayList<Product>();
	
	public Product addProduct (Product product) {
		products.add(product);
		return product;
	}
	public List<Product> getAllProducts(){
		return products;
	}

}
