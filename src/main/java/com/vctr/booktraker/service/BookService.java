package com.vctr.booktraker.service;

import com.vctr.booktraker.dto.BookDTO;
import com.vctr.booktraker.entity.Book;
import com.vctr.booktraker.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book createBook(BookDTO dto){
        Book book = new Book(
                UUID.randomUUID().toString(),
                dto.getTitle(),
                dto.getAuthor(),
                dto.getYear());
        bookRepository.save(book);
        return book;
    }

    public Optional<Book> getById(String id){
        return bookRepository.findById(id);
    }

}
