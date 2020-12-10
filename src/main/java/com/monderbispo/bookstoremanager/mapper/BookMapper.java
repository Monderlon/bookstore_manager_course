package com.monderbispo.bookstoremanager.mapper;

import com.monderbispo.bookstoremanager.dto.BookDTO;
import com.monderbispo.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
