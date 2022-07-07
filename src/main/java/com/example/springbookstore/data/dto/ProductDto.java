package com.example.springbookstore.data.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {   //number는 pk , 시간은 생성과 수정할떄 이미 리스너 등록함
        private String name;
        private int price;
        private int stock;
}
