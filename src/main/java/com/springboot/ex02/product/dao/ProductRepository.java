package com.springboot.ex02.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ex02.product.vo.Product;

// extends JpaRepository<VO Type(테이블), id Type(PK)>
public interface ProductRepository extends JpaRepository<Product, Integer> {}