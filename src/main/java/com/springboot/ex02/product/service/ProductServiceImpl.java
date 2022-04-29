package com.springboot.ex02.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ex02.product.dao.ProductRepository;
import com.springboot.ex02.product.vo.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository dao;
	
	// List
	@Override
	public List<Product> listAll() {
		return dao.findAll();
	}

	// insert
	@Override
	public void save(Product product) {
		dao.save(product);
	}

	// 1건 select
	@Override
	public Product get(int id) {
		return dao.findById(id).get();
	}

	// delete
	@Override
	public void delete(int id) {
		dao.deleteById(id);
	}
}