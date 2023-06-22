package com.poc.repo;

import com.poc.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer>, JpaSpecificationExecutor<ProductEntity> {

}
