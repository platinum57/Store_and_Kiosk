package com.naver.kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KioskApplication {

	public static void main(String[] args) {
		SpringApplication.run(KioskApplication.class, args);
	}

}

/*
	http method
	GET : body가 없음, 요청 방법: url치고 들어가기
	POST : body가 있음, 요청 방법: url만 쳐서는 못들어감, <form>태그로 들어감
*/