package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* 필드에 final을 붙여줄 수 있음 */
@Service("bookServiceConstructor") //Constructor 생성자 주입
public class BookService {

    private final BookDAO bookDAO;

    /* BookDAO 타입의 빈 객체를 '생성자'에 자동으로 주입해준다. */
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }


}
