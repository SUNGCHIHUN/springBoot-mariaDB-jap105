package com.springboot.ex02.product.service;

import java.util.List;

import com.springboot.ex02.product.vo.Product;

public interface ProductService {
	
	public List<Product> listAll(); // list
	
	public void save(Product product); // insert
	
	public Product get(int id);	// 1건 select
	
	public void delete(int id); // 1건 delete
}