package com.asher_2.springboottest_2.reposity;

import com.asher_2.springboottest_2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
