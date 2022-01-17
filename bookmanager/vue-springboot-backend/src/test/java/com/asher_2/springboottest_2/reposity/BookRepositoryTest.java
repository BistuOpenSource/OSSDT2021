package com.asher_2.springboottest_2.reposity;

import com.asher_2.springboottest_2.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void fingAll() {
        System.out.println(bookRepository.findAll());
    }

    @Test
    void save() {
        Book book = new Book();
        book.setAuthor("张三");
        book.setName("Java基础");
        bookRepository.save(book);
    }

    @Test
    void deleteById() {
        bookRepository.deleteById(48);
    }

    @Test
    public void findById() {
        System.out.println(bookRepository.findById(6).get());
        ;
    }

}