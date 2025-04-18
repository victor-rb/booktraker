package com.vctr.booktraker.controller;

import com.vctr.booktraker.dto.ReaderDTO;
import com.vctr.booktraker.entity.Reader;
import com.vctr.booktraker.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final ReaderService readerService;

    @PostMapping("/register")
    public ResponseEntity<Reader> register(
            @Validated @RequestBody ReaderDTO dto){
        Reader reader = readerService.createReader(dto);
        return ResponseEntity.ok(reader);
    }
}
