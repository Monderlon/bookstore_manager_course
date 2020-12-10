package com.monderbispo.bookstoremanager.service;

import com.monderbispo.bookstoremanager.dto.BookDTO;
import com.monderbispo.bookstoremanager.dto.MessageResponseDTO;
import com.monderbispo.bookstoremanager.entity.Book;
import com.monderbispo.bookstoremanager.exception.BookNotFoundException;
import com.monderbispo.bookstoremanager.mapper.BookMapper;
import com.monderbispo.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId()).build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException{
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}
