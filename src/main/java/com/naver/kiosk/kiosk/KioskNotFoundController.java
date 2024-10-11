package com.naver.kiosk.kiosk;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class KioskNotFoundController {
    @ExceptionHandler(KioskNotFoundException.class)
    public ResponseEntity<?> KioskNotFoundHandler(KioskNotFoundException e) {
        System.out.println(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}
