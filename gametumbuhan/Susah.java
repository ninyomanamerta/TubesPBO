package gametumbuhan;

public class Susah extends Soal{
    
    public Susah(String soal, String jawabanBenar) {
        super(soal, jawabanBenar);
    }
    
    String[] pilihanGanda = new String[4];

    public String[] getPilihanGanda() {
        return pilihanGanda;
    }

    public void setPilihanGanda(String a, String b, String c, String d) {
        this.pilihanGanda[0] = a;
        this.pilihanGanda[1] = b;
        this.pilihanGanda[2] = c;
        this.pilihanGanda[3] = d;
    }
    
    int getPoint(){
        return 40;
    };
}
