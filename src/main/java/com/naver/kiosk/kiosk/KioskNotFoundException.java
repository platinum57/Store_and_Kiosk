package com.naver.kiosk.kiosk;

public class KioskNotFoundException extends IllegalArgumentException {
  public KioskNotFoundException(int id) {
    super("ERROR MESSAGE: KIOSK NUMBER"+id+" IS NOT FOUND!!!");
  }
}
