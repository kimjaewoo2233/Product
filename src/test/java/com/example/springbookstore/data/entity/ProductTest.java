package com.example.springbookstore.data.entity;

import com.example.springbookstore.data.dao.ProductDAO;
import com.example.springbookstore.data.dto.ProductResponseDto;
import com.example.springbookstore.data.repository.ProductRepository;
import com.example.springbookstore.data.repository.QProductRepository;
import com.example.springbookstore.service.ProductService;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest {

        @Autowired
        private ProductRepository repository;

        @Autowired
        ProductService service;
        @Autowired
        ProductDAO dao;

        @PersistenceContext
        EntityManager entityManager;

        @Autowired
        QProductRepository qProductRepository;

        @Test
        void test(){
               repository.deleteById(2L);

        }
        @Test
        void queryDsl(){
                JPAQuery<Product> query = new JPAQuery<>(entityManager);
                QProduct qProduct = QProduct.product;

                List<Product> productList = query
                        .from(qProduct)
                        .where(qProduct.name.eq("펜"))
                        .orderBy(qProduct.price.asc())
                        .fetch();
                productList.forEach(System.out::println);
        }
        @Test
        void queryDsl2(){
                JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
                QProduct product = QProduct.product;

                List<Product> products = jpaQueryFactory
                        .selectFrom(product)
                        .where(product.name.eq("펜"))
                        .orderBy(product.price.asc())
                        .fetch();

                products.forEach(System.out::println);
                //JPAQueryFactory를 활용해 쿼리를 작성해도 같은 값이 나온다. JPAQuery를 사용했을 때와 달리
                //JPAQueryFactory에서는 select절부터 작성이 가능하다.
                //만약 전체 칼럼을 조회하지 않고 일부만 조회하고 싶다면 selectFrom()이 아닌 select따로 from따로 작성
        }
        @Test
        void queryDsl3(){
                JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
                QProduct product = QProduct.product;

                List<String> products = jpaQueryFactory
                        .select(product.name)
                        .from(product)
                        .where(product.name.eq("펜"))
                        .orderBy(product.price.asc())
                        .fetch();


                List<Tuple> tuples = jpaQueryFactory
                        .select(product.name,product.price)
                        .from(product)
                        .where(product.name.eq("펜"))
                        .orderBy(product.price.asc())
                        .fetch();
                // Select에서 두개에 값을 받고 싶을때는 Tuple타입으로 해야한다
                tuples.forEach(System.out::println);
        }
        @Test
        void queryDslPredicateExcutor(){


                Optional<Product> findOneProduct = qProductRepository.findOne(
                        QProduct.product.name.contains("펜")
                                .and(QProduct.product.price.between(100,40000)));

                System.out.println(findOneProduct.get());
        }
}