package service;

import entity.MenuItem;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> daftarMenu = new ArrayList<>();

    public void tambahMenu(MenuItem item) {
        daftarMenu.add(item);
    }

    public void tampilkanMenu() {
        if (daftarMenu.isEmpty()) {
            System.out.println("Menu kosong.");
        } else {
            for (MenuItem item : daftarMenu) {
                item.tampilMenu();
            }
        }
    }

    public MenuItem cariMenu(String nama) {
        for (MenuItem item : daftarMenu) {
            if (item.getNama().equalsIgnoreCase(nama)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Menu tidak ditemukan.");
    }
}
