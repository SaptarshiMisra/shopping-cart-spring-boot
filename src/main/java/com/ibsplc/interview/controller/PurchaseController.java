package com.ibsplc.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibsplc.interview.model.Product;
import com.ibsplc.interview.service.ProductService;

@RestController(value="/product")
public class PurchaseController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/all")
	public List<Product> getAll(){
		return productService.getAllProducts();
	}
	
	@PostMapping(value="/add")
	public boolean addNewProduct(Product product){
		if(null == product.getId() || product.getId().isEmpty()) return false ; 
		return productService.addNewProduct(product) != null;
	}
	
	@PostMapping(value="/purchase")
	public boolean buyProduct(Product product, int quantity) {
		return productService.purchaseProduct(product, quantity);
	}

}
