package com.ibsplc.interview.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ibsplc.interview.model.Product;

@Service
public class InventoryService {
	
	private Map<String, Integer> inventory = new HashMap<>();
	
	public boolean updateInventory(String productId, int quantity) {
		int productCount =  inventory.get(productId);
		
		if(null == productId || productId.isEmpty()) return false;
		
		inventory.put(productId, productCount+quantity);
		
		return true;
	}
	
	public int getProductCountRemaining(Product product) {
		
		int productCount =  inventory.getOrDefault(product.getId(), 0);
		
		return productCount;
	}

}
