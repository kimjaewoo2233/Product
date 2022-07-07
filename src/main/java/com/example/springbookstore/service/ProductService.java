package com.example.springbookstore.service;

import com.example.springbookstore.data.dto.ProductDto;
import com.example.springbookstore.data.dto.ProductResponseDto;

public interface ProductService {   //dao에서 구현한걸 클라이언트에서 사용할떄 service를 거쳐사용한다 service는 DTO를 다루고 dao는 Entity를 다루기때문
        ProductResponseDto getProduct(Long number);

        ProductResponseDto saveProduct(ProductDto dto);

        ProductResponseDto changeProductName(Long number,String name) throws Exception;

        void deleteProduct(Long number) throws Exception;

}
//DAO 에서 구현한 기능을 서비스 인터페이스에서 ㅁ호출해 결괏값을 가져오는 작업을 수행하도록 설계함
//서비스는 클라이언트가 요청한 데이터를 적절하게 가공해서 컨트롤러에게 넘기는 역할을 하낟
