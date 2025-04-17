package com.vctr.booktraker.dto;

import com.vctr.booktraker.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDTO {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<Book> books;
}
