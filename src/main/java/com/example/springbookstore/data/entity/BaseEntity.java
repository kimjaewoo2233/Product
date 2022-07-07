package com.example.springbookstore.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.asm.Advice;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate        //데이터 생성 날짜를 자동으루 주입한다.
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate   //데이터 수정 날짜를 자동으로 주입한다.
    private LocalDateTime updatedAt;
}
