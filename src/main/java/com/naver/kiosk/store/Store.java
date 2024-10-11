package com.naver.kiosk.store;

// 1. 가게
// name: 매머드 커피
// address: 서울
// opentime: 7
// closetime: 21
// id: 1

// 2. 가게
// name: 깐부치킨
// address: 서울
// opentime: 11
// closetime: 1
// id: 2

public class Store {
    private String name;
    private String address;
    private int openTime;
    private int closeTime;
    private final int id;
    private int kioskCount = 0;
    private boolean isDeleted;

    public void delete(){
        isDeleted = true;
    }

    public int kioskCountIncrease(){
        kioskCount++;
        return kioskCount;
    }

    public Store update(StoreRequest request){
        if(!request.name().isEmpty())
            name = request.name();
        if(!request.address().isEmpty())
            address = request.address();
        return this;
    }

    public Store(String name, String address, int openTime, int closeTime) {
        this.name = name;
        this.address = address;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.id = StoreUtils.storeCount++;
        this.kioskCount = 0;
        this.isDeleted = false;
    }

    public int getKioskCount(){
        return kioskCount;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getOpenTime() {
        return openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public int getId() {
        return id;
    }
}
