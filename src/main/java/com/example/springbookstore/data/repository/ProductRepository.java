package com.example.springbookstore.data.repository;

import com.example.springbookstore.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByNumber(Long number);

    List<Product> findAllByName(String name);

    @Query("SELECT p FROM Product AS p WHERE p.name = :name")
    List<Product> findByName(@Param("name")String name);
    // 맨 뒤에 ?1은 파라미터를 받는 다는 것이고 1은 첫번쨰 파라미터라는 의미다
    // 하지만 이 문장은 좋지 않아 :이름 이런식으로 일치시켜 사용한다

    @Query("SELECT p.name,p.price,p.stock FROM Product AS p WHERE p.name = :name")
    List<Object[]> findByNameParam(@Param("name")String name);

    List<Product> findByName(Sort sort, String name);
    //productRepository.findByName(Sort.by(Order.asc("price")),"name");
    //productRepository.findByName(Sort.by(Order.desc("price"),Order.asc("stock")),"name");
    Product queryByNumber(Long number);

    Page<Product> findByName(String name, Pageable pageable);
    boolean existsByNumber(Long number);
    //특정 데이터가 존재하는지 확인하는 키워드이다.리턴 타입으로는 boolean 타입을 사용한다
    long countByName(String name);
    //조회 쿼리를 수행한 후 쿼리 결과로 나온 레코드의 개수를 리턴한다.
    void deleteByNumber(Long number);

    long removeByNumber(Long number);

    Product findByNumberIs(Long number);
    //Is - 값의 일치를 조건으로 사용하는 조건자 키워드이다. 생략되는 경우가 많으며 Equals와 동일한 기능을 수행
    Product findByNumberEquals(Long number);

    Product findByNumberIsNot(Long number);
    //Not 값의 불일치를 조건으로 사용하는 조건자 키워드이다. Is는 생략하고 Not 키워드만 사용할 수도 있다.
    Product findByNumberNot(Long number);

    Product findByNumberAndName(Long number,String name);
    //And
    Product findByNumberOrName(Long number,String name);

    //(Is)GreaterThan,(Is)LessThan,(Is)Between
    //숫자나 datetime 칼럼을 대상으로 한 비교 연산에 사용할 수 있는 조건자 키워드이다.
    //GreaterThan,LessThan 은 초과/미만 개념이고 경곗값을 포함하려면 Equal 키워들르 추가하면 된다,
    List<Product> findByPriceGreaterThan(Long price);

    List<Product> findByPriceLessThanEqual(Long price);

    //정렬처리하기
    //Asc : 오름차순, Desc : 내림차순
    List<Product> findByNameOrderByNumberDesc(String name);
    List<Product> findByNameOrderByNumberAsc(String name);


}
