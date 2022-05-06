package com.springboot.ex02.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.ex02.product.service.ProductService;
import com.springboot.ex02.product.vo.Product;

@Controller
public class ProductController {

	@Autowired
	ProductService service;
	
	// 리스트
	@RequestMapping("/")
	public String viewHome(Model model) {
		
		List<Product> list = service.listAll();
		model.addAttribute("list", list);
		
		return "index"; // 타임리프 방식임 => template/index.html
	};

	// 제품 등록화면
	@RequestMapping("/new")
	public String newProductForm(Model model) {
		
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	// 제품 등록, 수정
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product, Model model) {
		
		service.save(product);
		
		return "redirect:/"; // 한건이 추가된 후 index.html로 이동
	};
	
	// 제품 수정 화면
	@RequestMapping("/edit/{id}")
	public ModelAndView editProductForm(@PathVariable(name="id") int id) {
		
		ModelAndView mav = new ModelAndView();
		Product product = service.get(id); // 해당 id로 한건 조회
		mav.setViewName("edit_product");
		mav.addObject(product);
		
		return mav;
	}
	
	// 제품 삭제
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") int id) {
		
		service.delete(id);
		return "redirect:/";
	}
}