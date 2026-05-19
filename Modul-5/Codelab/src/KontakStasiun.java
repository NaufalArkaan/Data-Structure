import java.util.HashMap;
import java.util.Map;

public class KontakStasiun {
    public static void main(String[] args) {
        HashMap<String, String> kontakStasiun = new HashMap<>();

        kontakStasiun.put("FATIH - Kepala Stasiun", "081234567890");
        kontakStasiun.put("WIRA - Customer Service", "081298765432");
        kontakStasiun.put("EGA - Keamanan", "081255555555");

        System.out.println("== Daftar Kontak Stasiun ==");
        for(Map.Entry<String, String> entry : kontakStasiun.entrySet()){
            System.out.println(
                    "Nama: " + entry.getKey() + " | Telepon: " + entry.getValue()
            );
        }

        String namaDicari = "WIRA - Customer Service";
        String nomorTelepon = kontakStasiun.get(namaDicari);

        if(nomorTelepon != null){
            System.out.println("\nNomor telepon " + namaDicari + ": " + nomorTelepon);
        } else {
            System.out.println("\nKontak " + namaDicari + " tidak ditemukan.");
        }

        String namaPengecekan = "Keamanan";
        if(kontakStasiun.containsKey(namaPengecekan)){
            System.out.println("Kontak " + namaPengecekan + " tersedia di sistem.");
        }else{
            System.out.println("Kontak " + namaPengecekan + " tidak tersedia.");
        }

        String namaHapus = "FATIH - Kepala Stasiun";
        kontakStasiun.remove(namaHapus);
        System.out.println("\nIsi kontak setelah menghapus " + namaHapus + ":");
        System.out.println(kontakStasiun);
    }
}
