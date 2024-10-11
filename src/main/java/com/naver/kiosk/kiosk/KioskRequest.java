package com.naver.kiosk.kiosk;

public record KioskRequest(int storeId) {
    public Kiosk toKiosk() {
        return new Kiosk(storeId);
    }
}
