package com.naver.kiosk.store.controller;

import com.naver.kiosk.store.domain.Store;
import com.naver.kiosk.store.request.StoreRequest;
import com.naver.kiosk.store.response.StoreResponse;
import com.naver.kiosk.store.service.StoreServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
    RESTful API
    : 리소스(data)를 꺼내준다.

    method: GET     (r)
            POST    (c)
            PUT     (u) -> 막상 까고보면 POST임 : body가 있다.
            DELETE  (d) -> 막상 까고보면 GET임  : body가 없다.

    url 설계
        전체 스토어를 가져온다. (/stores) (GET)<< 여러개를 가져올 거니까 복수형! (약간 국룰같은 거임)
        스토어에 추가한다. (/stores) (POST)
        스토어 중에 id=1인것을 가져온다. (/stores/1) (GET)
        스토어 안에 이름이 커피가 들어간 것들을 가져온다. (/stores?name=커피) (GET)
        1번 스토어 이름을 커피로 바꾸고싶다. (/stores/1, {name="커피", "ㅁㄴㅇㄹ", "ㅂㅈㄷㄱ"}) (PUT)
        나머지 건 두고 필요한 부분만 수정: PATCH (그냥 put으로 통일해도 됨)
        스토어 1번을 지운다. (stores/1) (DELETE)

        <정리>
        1. url은 복수형만 사용하시오.
        2. 명사만 사용하시오.
        3. 소문자로 작성하시오.
        4. 언더바사용은 지양하고 하이픈으로 쓰십시오. ex) store-create

        http 통신 과정에선 여러가지 상태가 존재한다.
        ex) 성공! 실패! 성공...했지만 아무 변화 없음
                -> status code (상태코드)
                        100 =< >200 : socket
                        200 =< >300 : http 통신 ( 성공 )
                        300 =< >400 : html을 사용할 때 (Found, Redirect)
                        400 =< >500 : 클라이언트 실수 (404 not found, 401 권한 없음 같은 것)
                        500 =< >600 : 서버       실수 (500 internal server error)
*/

@RequestMapping("/stores")
@RestController
public class StoreController {
    private final StoreServiceImpl storeServiceImpl;

    // Single-tone
    public StoreController(StoreServiceImpl storeServiceImpl) {
        this.storeServiceImpl = storeServiceImpl;
    }

    @GetMapping()
    public List<StoreResponse> getAllStores(){
        return storeServiceImpl.getAllStores();
    }

    // Path: 주소     Variable: 변수
    @GetMapping("/{id}") // <<@PathVariable에 있는 변수와 이름이 같아야함!!!!
    public Store getStoreById(@PathVariable int id){
        return storeServiceImpl.getStoreById(id);
    }

    // get은 body가 없고, post는 body가 있다.
    // 여러 데이터를 받아올 땐 body가 있는 post가 더 적합
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Store saveStore(@RequestBody StoreRequest request){
        return storeServiceImpl.addStore(request);
    }

    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable int id) {
        storeServiceImpl.deleteStore(id);
    }

    @PutMapping("/{id}")
    public Store updateStore(@PathVariable int id, @RequestBody StoreRequest request){
        return storeServiceImpl.updateStore(id, request);
    }
}
