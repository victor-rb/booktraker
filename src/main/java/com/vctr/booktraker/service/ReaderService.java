package com.vctr.booktraker.service;

import com.vctr.booktraker.dto.ReaderDTO;
import com.vctr.booktraker.entity.Reader;
import com.vctr.booktraker.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;

    public Reader createReader(ReaderDTO dto) {
        Reader reader = new Reader(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getBooks());
        readerRepository.save(reader);
        return reader;
    }

    public Optional<Reader> getById(String id) {
        return readerRepository.findById(id);
    }
    public Optional<Reader> getByEmail(String email) {
        return readerRepository.findByEmail(email);
    }
}
