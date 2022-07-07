package com.example.springbookstore;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();
    }//테스트를 시작하기 전에 호출되는 메소드를 정의한다.

    @AfterAll   //테스트를 종료하면서 호출되는 메소드를 정의한다.
    static void afterAll(){
        System.out.println("## afterAll Annotation 호출 ##");
        System.out.println();
    }
    @BeforeEach     //각 테스트 메소드가 실행되기 전에 동작하는 메서드를 정의한다
    void beforeEach(){
        System.out.println("## beforeEach Annotation 호출 ##");
        System.out.println();
    }
    @AfterEach  //각 테스트 메서드가 종료되면서 호출되는 메소드를 정의한다.
    void afterEach(){
        System.out.println("## afterEach Annotation 호출 ##");
        System.out.println();
    }

    @Test       //테스트 코드를 포함한 메소드를 정의한다.
    void test1(){
        System.out.println("## test1 시작 ##");
        System.out.println();
    }
    @Test
    @DisplayName("Test Case 2!!!")
    void test2(){
        System.out.println("## test2 시작 ##");
        System.out.println();
    }
    // Disabled Annotation 테스트를 실행하지 않게 설정하는 애노테이션
    @Test
    @Disabled
    void test3(){
        System.out.println("## test3 시작 ##");
        System.out.println();
    }

}
