package com.example.springbookstore.controller;

import com.example.springbookstore.data.dto.ChangeProductNameDto;
import com.example.springbookstore.data.dto.ProductDto;
import com.example.springbookstore.data.dto.ProductResponseDto;
import com.example.springbookstore.data.entity.Product;
import com.example.springbookstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {        //서비스랑 상호작용
    private final ProductService service;

    @GetMapping("{number}")
    public ResponseEntity<ProductResponseDto> getProduct(
            @PathVariable Long number
    ){
        ProductResponseDto dto = service.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(
            @RequestBody ProductDto dto
            ){  //id값은 자동지정이기에 dto로 받지만 다시 돌려받을떄는 id가 필요하다 그래서 response객체를 따로 만듬
        ProductResponseDto responseDto = service.saveProduct(dto);

        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto dto
            ) throws Exception{
            ProductResponseDto responseDto = service.changeProductName(
                    dto.getNumber(),
                    dto.getName()
            );
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);

    }


    @DeleteMapping("{number}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long number) throws Exception{
        service.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다");

    }





}

