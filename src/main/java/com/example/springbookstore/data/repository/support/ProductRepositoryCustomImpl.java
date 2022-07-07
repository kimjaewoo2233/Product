package com.example.springbookstore.data.repository.support;

import com.example.springbookstore.data.entity.Product;
import com.example.springbookstore.data.entity.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryCustomImpl
        extends QuerydslRepositorySupport
        implements ProductRepositoryCustom{
    public ProductRepositoryCustomImpl(){
        super(Product.class);
    }
    @Override
    public List<Product> findByName(String name){
        QProduct qProduct = QProduct.product;

        List<Product> products = from(qProduct)
                .where(qProduct.name.eq(name))
                .fetch();

        return products;
    }

}
