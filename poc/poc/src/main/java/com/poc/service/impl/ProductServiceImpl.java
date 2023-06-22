package com.poc.service.impl;

import com.poc.binding.ProductForm;
import com.poc.entity.ProductEntity;
import com.poc.repo.ProductRepository;
import com.poc.search.SearchRequest;
import com.poc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;




@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public ProductEntity save(ProductForm form) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(form, entity);
        ProductEntity save = repo.save(entity);
        return save;
    }

    @Override
    public Page<ProductEntity> getProducts(Integer page, Integer size, String[] sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return repo.findAll(pageable);

    }


    @Override
    public Page<ProductEntity> searchCriteria(SearchRequest search, Integer page, Integer size,String[] sort) {

      /*  PageRequest pageble = PageRequest.of(page, size, Sort.by(sort));
        ProductEntity entity = new ProductEntity();
        if (null != search.getName() && !"".equals(search.getName())) {
            entity.setName(search.getName());
        }
        if (null != search.getBrand() && !"".equals(search.getBrand())) {
            entity.setBrand(search.getBrand());
        }
        if (null != search.getStore() && !"".equals(search.getStore())) {
            entity.setStore(search.getStore());
        }
        Page<ProductEntity> all = repo.findAll(Example.of(entity), pageble);
        return all;
*//*
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> query = criteriaBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = query.from(ProductEntity.class);
      */
        Specification<ProductEntity> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (null != search.getName() && !"".equals(search.getName())) {
                predicates.add(criteriaBuilder.equal(root.get("name"), search.getName()));
            }
            if (null != search.getBrand() && !"".equals(search.getBrand())) {
                predicates.add(criteriaBuilder.like(root.get("brand"), "%" + search.getBrand() + "%"));
            }
            if (null != search.getStore() && !"".equals(search.getStore())) {
                predicates.add(criteriaBuilder.like(root.get("store"), "%" + search.getStore() + "%"));
            }
             return    criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

        };

        PageRequest of = PageRequest.of(page, size, Sort.by(sort));
        Page<ProductEntity> all = repo.findAll(spec, of);
        return all;
    }


}
