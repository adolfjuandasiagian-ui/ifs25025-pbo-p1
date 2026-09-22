import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nim = sc.hasNextLine() ? sc.nextLine().trim() : "";

        // 1 & 2: validasi panjang NIM
        if (nim.length() != 8) {
            System.out.println("NIM harus 8 karakter");
            return;
        }

        // Tabel prefix program studi
        Map<String, String> prodiMap = new HashMap<>();
        prodiMap.put("11S", "Sarjana Informatika");
        prodiMap.put("12S", "Sarjana Sistem Informasi");
        prodiMap.put("13S", "Sarjana Teknik Elektro");
        prodiMap.put("14S", "Sarjana Manajemen Rekayasa");
        prodiMap.put("22S", "Sarjana Teknik Metalurgi");
        prodiMap.put("31S", "Sarjana Teknik Bioproses"); // Ditulis sesuai expected output
        prodiMap.put("114", "Diploma 4 Teknologi Rekayasa Perangkat Lunak");
        prodiMap.put("115", "Diploma 3 Teknologi Informasi");
        prodiMap.put("153", "Diploma 3 Teknologi Komputer");

        // 3 & 4: ambil & cocokkan prefix
        String prefix = nim.substring(0, 3);
        if (!prodiMap.containsKey(prefix)) {
            System.out.println("Kode tidak tersedia");
            return;
        }
        String programStudi = prodiMap.get(prefix);

        // 5 & 6: ambil kode angkatan dan nomor urut
        String kodeAngkatanStr = nim.substring(3, 5);
        String urutanStr = nim.substring(5, 8);

        int angkatan;
        int urutan;
        try {
            angkatan = Integer.parseInt("20" + kodeAngkatanStr);
            urutan = Integer.parseInt(urutanStr);
        } catch (NumberFormatException e) {
            System.out.println("NIM tidak valid");
            return;
        }

        // 7: tampilkan informasi
        System.out.println("Informasi NIM " + nim + ": ");
        System.out.println(">> Program Studi: " + programStudi);
        System.out.println(">> Angkatan: " + angkatan);
        System.out.println(">> Urutan: " + urutan);
    }
}