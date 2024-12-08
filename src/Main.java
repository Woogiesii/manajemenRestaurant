import entity.*;
import service.Menu;
import service.Pesanan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Menu menu = new Menu();
            Pesanan pesanan = new Pesanan();

            while (true) {
                System.out.println("\n=== Manajemen Restoran ===");
                System.out.println("1. Tambah Menu");
                System.out.println("2. Tampilkan Menu");
                System.out.println("3. Buat Pesanan");
                System.out.println("4. Tampilkan Pesanan");
                System.out.println("5. Keluar");
                System.out.print("Pilih: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                try {
                    switch (pilihan) {
                        case 1 -> {
                            System.out.print("Nama: ");
                            String nama = scanner.nextLine();
                            System.out.print("Harga: ");
                            double harga = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Kategori (Makanan/Minuman/Diskon): ");
                            String kategori = scanner.nextLine();

                            if (kategori.equalsIgnoreCase("Makanan")) {
                                System.out.print("Jenis Makanan: ");
                                String jenisMakanan = scanner.nextLine();
                                menu.tambahMenu(new Makanan(nama, harga, kategori, jenisMakanan));
                            } else if (kategori.equalsIgnoreCase("Minuman")) {
                                System.out.print("Jenis Minuman: ");
                                String jenisMinuman = scanner.nextLine();
                                menu.tambahMenu(new Minuman(nama, harga, kategori, jenisMinuman));
                            } else if (kategori.equalsIgnoreCase("Diskon")) {
                                System.out.print("Diskon (%): ");
                                double diskon = scanner.nextDouble();
                                menu.tambahMenu(new Diskon(nama, harga, kategori, diskon));
                            } else {
                                System.out.println("Kategori tidak valid.");
                            }
                        }
                        case 2 -> menu.tampilkanMenu();
                        case 3 -> {
                            System.out.print("Nama Menu yang Dipesan: ");
                            String namaItem = scanner.nextLine();
                            MenuItem item = menu.cariMenu(namaItem);
                            pesanan.tambahPesanan(item);
                        }
                        case 4 -> pesanan.tampilkanPesanan();
                        case 5 -> {
                            System.out.println("Terima kasih telah menggunakan program ini!");
                            return;
                        }
                        default -> System.out.println("Pilihan tidak valid.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
