package com.example.springbookstore.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Getter
@Setter
public class ChangeProductNameDto {
    private  Long number;
    private String name;
}
