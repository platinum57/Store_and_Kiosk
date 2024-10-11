package com.naver.kiosk.kiosk;

import com.naver.kiosk.store.domain.Store;

public record KioskResponse(int id, int kioskNumber, boolean isActive, Store store) {
    public static KioskResponse from(Kiosk kiosk) {
        return new KioskResponse(
                kiosk.getId(),
                kiosk.getKioskNumber(),
                kiosk.isActive(),
                kiosk.getStore(kiosk.getStoreId())
        );
    }
}
