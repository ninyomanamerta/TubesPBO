package gametumbuhan;

public class Sedang extends Soal{
    
    // Merupakan child dari class Soal untuk tipe soal sedang.
    
    public Sedang(String soal, String jawabanBenar) {
        super(soal, jawabanBenar);
    }
    
    String[] pilihanGanda = new String[4]; // Array jawaban pilihan ganda.

    public String[] getPilihanGanda() {
        return pilihanGanda;
    }

    // Fungsi untuk menyimpan semua daftar jawaban pilihan ganda.
    public void setPilihanGanda(String a, String b, String c, String d) {
        this.pilihanGanda[0] = a;
        this.pilihanGanda[1] = b;
        this.pilihanGanda[2] = c;
        this.pilihanGanda[3] = d;
    }
    
    int getPoint(){
        return 20;
    };
}
