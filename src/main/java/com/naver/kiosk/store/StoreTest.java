package com.naver.kiosk.store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store("매머드", "서울", 7, 21);
        Store store2 = new Store("깐부", "서울", 11, 1);


        if(store.getId()!=1 && store.getName().equals("매머드")){
            System.out.println("매머드에서 오류");
        }
        if(store2.getId()!=2&&store2.getName().equals("깐부")){
            System.out.println("깐부에서 오류");
        }

        System.out.println(store.getName()+' '+store.getId());
        System.out.println(store2.getName()+' '+store2.getId());

    }
}
