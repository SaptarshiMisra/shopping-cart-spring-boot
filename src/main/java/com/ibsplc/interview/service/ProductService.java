package com.ibsplc.interview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibsplc.interview.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private Repository repository;
	
	@Autowired
	private InventoryService inventory;
	
	public Product addNewProduct(Product product) {
		repository.addProduct(product);
		inventory.updateInventory(product.getId(), 1);
		return product;
	}
	
	public boolean purchaseProduct(Product product, int quantity) {
		if(inventory.getProductCountRemaining(product) >= quantity) {
			//purchase
			inventory.updateInventory(product.getId(), -quantity);
			return true;
		}
		return false;
	}
	
	public List<Product> getAllProducts(){
		return repository.getAllProducts();
	}
	

}
