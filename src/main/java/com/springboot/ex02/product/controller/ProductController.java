package com.springboot.ex02.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.ex02.product.service.ProductService;
import com.springboot.ex02.product.vo.Product;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		
		List<Product> list = service.listAll();
		model.addAttribute("list", list);
		
		return "index"; // 타임리프 방식임 => template/index.html
	};
	
}