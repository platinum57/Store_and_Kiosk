package com.naver.kiosk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    react, vue, next, nuxt와 같은 front-end framework가 많이 때문에
    fe를 아예 분리하는 것이 좋다. 사유: 성능이슈, 편함

    ??? 그럼 이런 spring은 어디다 써먹나요 ???
        => data 전달
        ex) react에서 통신요청을 하면 -> spring에서 data(json)를 받아감

    mvc에서의 @Controller: view(html)를 꺼내주는 일을 함
    mvc 자체를 요즘 잘 안 쓴다. (위의 이유와 동일)

    @ResponseBody : view가 아닌 data로써 반환해줌
 */

@RestController // ResponseBody + Controller
public class TestController {
//    @RequestMapping("/java")
    @GetMapping("/java") // @RequestMapping(value = "/java", method = RequestMethod.GET)과 같음
    public String java() throws InterruptedException {
        Thread.sleep(10000);
        return "java";
    }

    // API (Application Programming Interface)
    //          -> application의 엔드포인트를 지정, 인터페이스를 구성함

    //get 메소드로 /name으로 이름 출력하기
    // 여기서 /name이 endpoint이다.
    @GetMapping("/name")
    public String name(){
        return "이현숙";
    }
}
