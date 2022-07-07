package com.example.springbookstore.data.entity;


import com.example.springbookstore.data.entity.listener.ProductListener;
import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@ToString(callSuper = true) //부모 필드를 추가한다
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = ProductListener.class)
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable =false)
    private String name;

    @Column(nullable = false)   //notnull
    private Integer price;

    @Column(nullable = false)
    private Integer stock;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
