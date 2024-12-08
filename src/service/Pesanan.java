package service;

import entity.MenuItem;

import java.util.ArrayList;

public class Pesanan {
    private ArrayList<MenuItem> itemPesanan = new ArrayList<>();

    public void tambahPesanan(MenuItem item) {
        itemPesanan.add(item);
    }

    public void tampilkanPesanan() {
        if (itemPesanan.isEmpty()) {
            System.out.println("Pesanan kosong.");
        } else {
            System.out.println("=== Daftar Pesanan ===");
            for (MenuItem item : itemPesanan) {
                item.tampilMenu();
            }
        }
    }
}
