package com.vctr.booktraker.service;

import com.vctr.booktraker.dto.BookDTO;
import com.vctr.booktraker.entity.Book;
import com.vctr.booktraker.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void saveBooks(List<BookDTO> books){
        for (BookDTO bookDTO : books) {
            Book book = new Book(
                    UUID.randomUUID().toString(),
                    bookDTO.getTitle(),
                    bookDTO.getAuthor(),
                    bookDTO.getYear());
            bookRepository.save(book);
        }
    }

    public Optional<Book> getById(String id){
        return bookRepository.findById(id);
    }

}
