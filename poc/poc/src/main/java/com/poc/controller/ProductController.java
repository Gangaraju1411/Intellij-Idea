package com.poc.controller;



import com.poc.binding.ProductForm;
import com.poc.entity.ProductEntity;
import com.poc.search.SearchRequest;
import com.poc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public ResponseEntity<ProductEntity> save(@RequestBody ProductForm form) {
		ProductEntity save = service.save(form);
		return ResponseEntity.ok(save);

	}

	@GetMapping("/get")
	public ResponseEntity<Page<ProductEntity>> get(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id,asc") String[] sort) {

		Page<ProductEntity> products = service.getProducts(page,size,sort);
		return ResponseEntity.ok(products);

	}

	@PostMapping("/search")
	public ResponseEntity<Page<ProductEntity>> search (@RequestBody SearchRequest search,
	@RequestParam(defaultValue = "0") int page,
	@RequestParam(defaultValue = "10") int size,
	@RequestParam(defaultValue = "id,asc") String[] sort)
	{
		Page<ProductEntity> productEntities = service.searchCriteria(search, page, size, sort);
		return ResponseEntity.ok(productEntities);
	}



}
