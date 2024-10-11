package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.Store;
import com.naver.kiosk.store.StoreNotFoundException;
import com.naver.kiosk.store.StoreUtils;


public class Kiosk {
    private final int id;
    private int kioskNumber;
    private Store store;
    private int storeId;
    private boolean active;

    public boolean kioskError(){
        return true;
    }

    public Kiosk(int storeId) {
        this.id = KioskUtils.kioskId++;
        this.active = true;
        this.storeId = storeId;
        this.store = getStore(storeId);
        this.kioskNumber = store.kioskCountIncrease();
    }

    public int getId() {
        return id;
    }

    public int getKioskNumber() {
        return kioskNumber;
    }

    public boolean isActive() {
        return active;
    }

    public int getStoreId(){
        return storeId;
    }

    public Store getStore(int id) {
        return StoreUtils.stores
                .stream()
                .filter(el -> (el.getId() == id && !el.isDeleted()))
                .findFirst()
                .orElseThrow(()->new StoreNotFoundException(id));
    }
}
