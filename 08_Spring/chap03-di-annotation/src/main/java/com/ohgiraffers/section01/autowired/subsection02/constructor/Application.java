package com.ohgiraffers.section01.autowired.subsection02.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookServiceConstructor", BookService.class); // 정확하게 두 개 ! (bean 명, 메타 정보)

        /* 전체 도서 목록 조회 후 출력 확인 */
        bookService.selectAllBooks().forEach(System.out::println);

        /* 도서 번호 조회 후 출력 확인 */
        System.out.println(bookService.searchBookBySequence(1));
    }
}
