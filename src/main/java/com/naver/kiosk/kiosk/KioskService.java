package com.naver.kiosk.kiosk;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KioskService {
    public List<KioskResponse> getAllKiosks() {
        List<KioskResponse> kiosks = KioskUtils.kiosks
                .stream()
                .map(KioskResponse::from)
                .toList();
        return kiosks;
    }

    public Kiosk getKioskById(int id) {
        return KioskUtils.kiosks
                .stream()
                .filter(kiosk -> kiosk.getId() == id)
                .findFirst()
                .orElseThrow(()->new KioskNotFoundException(id));
    }

    public Kiosk addKiosk(KioskRequest request) {
        Kiosk kiosk = request.toKiosk();
        KioskUtils.kiosks.add(kiosk);
        return kiosk;
    }

    public void deleteKiosk(int id) {
        Kiosk target = getKioskById(id);
        KioskUtils.kiosks.remove(target);
    }
}