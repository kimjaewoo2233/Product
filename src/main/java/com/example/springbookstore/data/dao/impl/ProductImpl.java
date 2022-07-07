package com.example.springbookstore.data.dao.impl;

import com.example.springbookstore.data.dao.ProductDAO;
import com.example.springbookstore.data.entity.Product;
import com.example.springbookstore.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component      //인터페이스 구현체는 빈 등록을 해줘야한다
@RequiredArgsConstructor    //Entitiy는 dto에서 다루고 이 dto를 클라이언트에서 다룬다
public class ProductImpl implements ProductDAO {
    private final ProductRepository repository;

    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = repository.save(product);
        return saveProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product product = repository.findById(number).orElse(null);
        return product;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectProduct = repository.findById(number);

        Product updateProduct;
        if(selectProduct.isPresent()){
            Product product = selectProduct.get();

            product.setName(name);

            updateProduct = repository.save(product);
        }else{
            throw new Exception();
        }
        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
            repository.deleteById(number);
    }
}
