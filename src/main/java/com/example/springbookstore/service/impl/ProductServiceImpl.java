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

        ProductResponseDto dto = new ProductResponseDto();
        dto.setNumber(product.getNumber());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());


        return dto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto dto) {
        return null;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        return null;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {

    }

//    @Override
//    public ProductResponseDto saveProduct(ProductDto dto) {
//        Product product = Product.builder()
//                .name(dto.getName())
//                .price(dto.getPrice())
//                .stock(dto.getStock())
//                .createdAt(LocalDateTime.now())
//                .updatedAt(LocalDateTime.now())
//                .build();
//
//        Product saveProduct = dao.insertProduct(product);
//        //저장한 데이터가 무엇인지 알아야하기에 리턴값이 있다.
//        ProductResponseDto responseDto = ProductResponseDto.builder()
//                .number(saveProduct.getNumber())
//                .name(saveProduct.getName())
//                .price(saveProduct.getPrice())
//                .stock(saveProduct.getStock())
//                .build();
//        return null;
//    }
//
//    @Override
//    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
//        Product changedProduct = dao.updateProductName(number,name);
//
//
//        ProductResponseDto dto = ProductResponseDto.builder()
//                .number(changedProduct.getNumber())
//                .name(changedProduct.getName())
//                .price(changedProduct.getPrice())
//                .stock(changedProduct.getStock())
//                .build();
//
//        return dto;
//    }
//
//    @Override
//    public void deleteProduct(Long number) throws Exception {
//            //repository에서 delete는 반환타입이 없다 그래서 여기도 없다
//    }
}
