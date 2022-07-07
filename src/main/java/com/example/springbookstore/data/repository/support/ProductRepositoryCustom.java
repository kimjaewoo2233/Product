package com.example.springbookstore.data.repository.support;


import com.example.springbookstore.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByName(String name);
}
