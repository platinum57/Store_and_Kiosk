package com.naver.kiosk.store;

public record StoreResponse
        (String name, String address, int openTime, int closeTime, int id){
    public static StoreResponse from(Store store){
        return new StoreResponse(
                store.getName(),
                store.getAddress(),
                store.getOpenTime(),
                store.getCloseTime(),
                store.getId());
    }
}
