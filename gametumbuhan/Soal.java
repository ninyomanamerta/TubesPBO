package gametumbuhan;

public class Soal {
    
    // Merupakan parent class untuk soal pada quiz.
    
    String soal;
    String jawabanBenar;

    public Soal(String soal, String jawabanBenar){
        this.soal = soal;
        this.jawabanBenar = jawabanBenar;
    }
    
    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJawabanBenar() {
        return jawabanBenar;
    }

    public void setJawabanBenar(String jawabanBenar) {
        this.jawabanBenar = jawabanBenar;
    }
    
    int getPoint(){
        return 0;
    };
}
