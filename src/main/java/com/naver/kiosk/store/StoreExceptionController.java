package com.naver.kiosk.store;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StoreExceptionController {
    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<?> StoreNotFoundHandler(StoreNotFoundException e) {
        System.out.println(e.getMessage());
        return ResponseEntity.notFound().build();
    }
}

/*
예현...현숙언니 노트북에 왔다 감....
 */
