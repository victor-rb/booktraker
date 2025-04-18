package com.vctr.booktraker.controller;

import com.vctr.booktraker.entity.Reader;
import com.vctr.booktraker.service.LambdaCallerService;
import com.vctr.booktraker.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    private final LambdaCallerService lambdaCallerService;

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable String id){
        return readerService.getByEmail(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
