package com.example.springbookstore.data.entity.listener;

import com.example.springbookstore.data.entity.Product;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class ProductListener {
    @PreUpdate
    private void preUpdate(Object obj){
        Product product = (Product)obj;
        product.setUpdatedAt(LocalDateTime.now());
    }

    @PrePersist
    private void prePersist(Object obj){
        Product product = (Product) obj;
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
    }
}
