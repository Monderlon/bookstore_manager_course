package com.monderbispo.bookstoremanager.repository;

import com.monderbispo.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
