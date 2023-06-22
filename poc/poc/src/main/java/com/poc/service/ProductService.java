package com.poc.service;

import java.util.List;

import com.poc.binding.ProductForm;
import com.poc.entity.ProductEntity;
import com.poc.repo.ProductRepository;
import com.poc.search.SearchRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface ProductService {
		public ProductEntity save(ProductForm form) ;

		public Page<ProductEntity> getProducts(Integer page,Integer size,String[] sort) ;

		public Page<ProductEntity> searchCriteria (SearchRequest search,Integer page,Integer size,String[] sort);
		}
	
	
	
	
	

