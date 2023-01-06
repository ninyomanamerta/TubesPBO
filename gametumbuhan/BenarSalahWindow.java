package gametumbuhan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class BenarSalahWindow extends javax.swing.JFrame {

    int jmlSoal = 0;
    int totalPoint = 0;
    int nyawa = 3;
    int currentSoalIndex;
    Timer timer; // Untuk mengatur batas waktu sebelum window di-close.
    ArrayList<Mudah> listSoalMudah = new ArrayList<Mudah>(); // Menampung list 
                                                             // soal level mudah.
    
    public BenarSalahWindow() {
        initComponents();
        
        // Menambahkan soal ke list soal level mudah, beserta jawabannya.
        listSoalMudah.add(new Mudah("Aku adalah jenis batang tumbuhan yang menjadi tempat pertumbuhan " +
                            "sekunder dan aku adalah batang dikotil.", "Benar"));
        listSoalMudah.add(new Mudah("Aku adalah jaringan yang membuat batang tumbuhan monokotil " +
                            "tumbuh membesar dan akulah kambium", "Salah"));
        listSoalMudah.add(new Mudah("Tugasku sebagai jaringan kambium adalah membentuk sel-sel xilem " +
                            "dan floem pada batang monokotil.", "Salah"));
        listSoalMudah.add(new Mudah("Aku tumbuhan pisang, jenis batang tumbuhanku kayu.", "Salah"));
        listSoalMudah.add(new Mudah("Aku adalah tumbuhan kaktus yang menyimpan cadangan makanan " +
                            "berupa air pada batang", "Benar"));
        
        tampilSoal();
    
        this.setLocationRelativeTo(null);
    }

    void tampilSoal(){
        int no_soal = (int) ((Math.random() * (3 - 0)) + 0); // Mencari nomor random 
                                                             // antara 0-3 untuk menentukan soal yang ditampilkan
        labelSoal.setText("<html>"+ listSoalMudah.get(no_soal).getSoal() +"</html>");
        this.currentSoalIndex = no_soal;
        
        // Mengatur batasan waktu menjadi 1.5 menit.
        timer = new Timer(90000, new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new HasilWindow(jmlSoal, totalPoint, nyawa).setVisible(true);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelSoal = new javax.swing.JLabel();
        btnJawab = new javax.swing.JButton();
        jawabBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Ayo Tebak Siapa Aku");

        labelSoal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSoal.setText("(Soal)");

        btnJawab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnJawab.setText("Jawab");
        btnJawab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJawabActionPerformed(evt);
            }
        });

        jawabBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jawabBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Benar", "Salah" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jawabBox, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnJawab))
                            .addComponent(labelSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(labelSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJawab)
                    .addComponent(jawabBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJawabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJawabActionPerformed
        // Menambahkan jumlah soal saat ini untuk 
        // mengatur apakah quiz selesai atau belum
        jmlSoal += 1;
        
        // Jika Quiz level mudah sudah 2 soal
        if(this.jmlSoal == 2){
            if(jawabBox.getSelectedItem().toString() == listSoalMudah.get(currentSoalIndex).getJawabanBenar()){
                this.totalPoint += listSoalMudah.get(currentSoalIndex).getPoint(); // Menghitung poin jika benar
            }
            else{
                this.nyawa -= 1; // Mengurangi nyawa karena salah
            }
            this.dispose();
            new PilihanGandaWindow(this.jmlSoal, this.totalPoint, this.nyawa).setVisible(true);
        }
        else{ // Jika quiz level mudah baru 1 soal
            if(jawabBox.getSelectedItem().toString() == listSoalMudah.get(currentSoalIndex).getJawabanBenar()){
                this.totalPoint += listSoalMudah.get(currentSoalIndex).getPoint();
            }
            else{
                this.nyawa -= 1;
            }
            tampilSoal();
        }
    }//GEN-LAST:event_btnJawabActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJawab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jawabBox;
    private javax.swing.JLabel labelSoal;
    // End of variables declaration//GEN-END:variables
}
