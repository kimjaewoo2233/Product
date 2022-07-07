package com.example.springbookstore.data.repository.support;

import com.example.springbookstore.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepositorySupport")     //기존에 있는 RroductRepository와 빈이름을 다르게 해준다.
public interface ProductRepository extends JpaRepository<Product,Long>,ProductRepositoryCustom {
}
