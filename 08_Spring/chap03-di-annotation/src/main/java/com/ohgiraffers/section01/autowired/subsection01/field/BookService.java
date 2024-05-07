package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Service : @Component의 세분화 어노테이션의 한 종류로 Service 계층에서 사용한다. */
/* 필드 주입은 final을 붙여줄 수 없음 */
@Service("bookServiceField")
public class BookService {

    /* BookDAO 타입의 빈(bean) 객체를 '프로퍼티'에 자동으로 주입해준다. (BookDAO 타입이 있으면 넣어줘 !) */
    @Autowired // --- > type을 통한 의존성 주입 (*type : BookDAO)
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBooks() {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.selectOneBook(sequence);
    }


}
