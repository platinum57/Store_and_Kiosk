package com.naver.kiosk.store;

public record StoreRequest(String name, String address, int openTime, int closeTime) {
    // record: 모든 field가 final이고, getter가 모두 필요하다면 record class로 전환 가능
    // record classname(...field) 생성자

    public Store toStore() {
        return new Store(name, address, openTime, closeTime);
    }
}
