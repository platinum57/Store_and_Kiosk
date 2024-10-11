package com.naver.kiosk.store;

// controller: 유저와 개발자의 소통의 장
// service: 개발자의 생각창고
// repository: 개발자와 data의 소통의 장

import org.springframework.stereotype.Service;
import java.util.List;

@Service // @Component와 같은 기능을 하는듯??? (Class에 의존성 주입(Bean으로 써먹기 위함))
public class StoreServiceImpl implements StoreService {
    public List<StoreResponse> getAllStores() {
        List<StoreResponse> list = StoreUtils.stores
                .stream()
                .map(StoreResponse::from)
                .toList();
        return list;
    }

    public Store getStoreById(int id) {
        return StoreUtils.stores
                .stream()
                .filter(el -> (el.getId() == id && !el.isDeleted()))
                .findFirst()
                .orElseThrow(()->new StoreNotFoundException(id));
    }

    public Store addStore(StoreRequest request) {
        Store store = request.toStore();
        StoreUtils.stores.add(store);
        return store;
    }

    public void deleteStore(int id) {
        Store target = getStoreById(id);
        target.delete();
        StoreUtils.stores.remove(target);
    }

    public Store updateStore(int id, StoreRequest request){
        return getStoreById(id).update(request);
    }
}
