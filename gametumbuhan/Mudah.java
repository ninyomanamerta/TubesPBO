package gametumbuhan;

public class Mudah extends Soal{    

    // Merupakan child dari class Soal untuk tipe soal mudah.
    
    public Mudah(String soal, String jawabanBenar) {
        super(soal, jawabanBenar);
    }
    
    
    int getPoint(){
        return 10;
    }
}
