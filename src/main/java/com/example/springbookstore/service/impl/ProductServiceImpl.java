package com.example.springbookstore.service.impl;

import com.example.springbookstore.data.dao.ProductDAO;
import com.example.springbookstore.data.dto.ProductDto;
import com.example.springbookstore.data.dto.ProductResponseDto;
import com.example.springbookstore.data.entity.Product;
import com.example.springbookstore.data.repository.ProductRepository;
import com.example.springbookstore.service.ProductService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service        //구현체는 빈으로 등록해야 사용가능
@RequiredArgsConstructor
@Data
@Slf4j
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
   // private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productRepository.findById(number).get();
        log.info("[getProduct] input number : {}",number);

        log.info("[getProduct] product number : {},name: {} ",product.getName());
        ProductResponseDto dto = new ProductResponseDto();
        dto.setNumber(product.getNumber());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());


        return dto;
    }
    @Override
    public ProductResponseDto saveProduct(ProductDto dto) {
        log.info("[saveProduct] productDTO : {}",dto.toString());

        Product product = Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Product saveProduct = productRepository.save(product);
        log.info("[saveProduct] saveProduct : {}",saveProduct);
        //저장한 데이터가 무엇인지 알아야하기에 리턴값이 있다.
        ProductResponseDto responseDto = ProductResponseDto.builder()
                .number(saveProduct.getNumber())
                .name(saveProduct.getName())
                .price(saveProduct.getPrice())
                .stock(saveProduct.getStock())
                .build();
        return responseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changeName = productRepository.save(foundProduct);

        ProductResponseDto dto = ProductResponseDto.builder()
                .number(changeName.getNumber())
                .name(changeName.getName())
                .price(changeName.getPrice())
                .stock(changeName.getStock())
                .build();

        return dto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
            //repository에서 delete는 반환타입이 없다 그래서 여기도 없다
    }
}
