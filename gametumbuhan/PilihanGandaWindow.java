package gametumbuhan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class PilihanGandaWindow extends javax.swing.JFrame {

    int jmlSoal;
    int totalPoint;
    int nyawa;
    int currentSoalIndex;
    Timer timer;
    ArrayList<Sedang> listSoalSedang = new ArrayList<Sedang>();
    ArrayList<Susah> listSoalSusah = new ArrayList<Susah>();
    
    public PilihanGandaWindow(int jmlSoal, int totalPoint, int nyawa) {
        this.jmlSoal = jmlSoal;
        this.totalPoint = totalPoint;
        this.nyawa = nyawa;
        
        // Menambahkan data soal ke list soal sedang.
        listSoalSedang.add(new Sedang("Haii, aku bisa memperluas bidang penyerapan air dan garam mineral, " +
                                        "bagian akar apakah aku?", "D"));
        listSoalSedang.get(0).setPilihanGanda("Ujung Akar", "Korteks Akar", "Epidermis", "Rambut Akar");
        listSoalSedang.add(new Sedang("Aku adalah akar. Aku biasanya mengisap udara untuk bernafas dan " +
                                        "tumbuh di pohon beringin. Akar jenis apakah aku?", "A"));
        listSoalSedang.get(1).setPilihanGanda("Akar Gantung", "Akar Serabut", "Akar Tunggang", "Akar Nafas");
        listSoalSedang.add(new Sedang("Hai aku adalah akar yang besar, panjang dan kuat sebagai pusat untuk " +
                                        "menambus jauh ke permukaan tanah. Akar jenis apakah aku?", "C"));
        listSoalSedang.get(2).setPilihanGanda("Akar Gantung", "Akar Serabut", "Akar Tunggang", "Akar Nafas");
        listSoalSedang.add(new Sedang("Haloo, aku tanaman padi. Apakah kamu bisa membantu menyebutkan " +
                                        "jenis akar ku?", "B"));
        listSoalSedang.get(3).setPilihanGanda("Akar Gantung", "Akar Serabut", "Akar Tunggang", "Akar Nafas");
        listSoalSedang.add(new Sedang("Haii, aku tanaman bakau. Aku biasanya naik keatas air untuk membantu " +
                                        "pernapasan. Apakah jenis akar ku?", "D"));
        listSoalSedang.get(4).setPilihanGanda("Akar Gantung", "Akar Serabut", "Akar Tunggang", "Akar Nafas");
        
        
        // Menambahkan data soal ke list soal susah.
        listSoalSusah.add(new Susah("Haii, aku bisa membuat makanan untuk tumbuhan dan menyerap " +
                                    "cahaya, apakah aku?", "C"));
        listSoalSusah.get(0).setPilihanGanda("Batang", "Daun", "Klorofil", "Stomata");
        listSoalSusah.add(new Susah("Aku adalah daun, mempunyai satu tulang di tengah yang besar dan " +
                                    "lurus, biasanya aku tumbuh di pohon tebu atau padi. Daun jenis apakah aku?", "B"));
        listSoalSusah.get(1).setPilihanGanda("Daun Melengkung", "Daun Sejajar", "Daun Menyirip", "Daun Menjari");
        listSoalSusah.add(new Susah("Hai, aku daun yang memiliki tulang berbentuk seperti ikan, daun jenis " +
                                        "apakah aku?", "D"));
        listSoalSusah.get(2).setPilihanGanda("Daun Melengkung", "Daun Menjari", "Daun Sejajar", "Daun Menyirip");
        listSoalSusah.add(new Susah("Halo, aku daun sirih, apakah kamu bisa membantu menyebutkan jenis " +
                                        "daun ku?", "D"));
        listSoalSusah.get(3).setPilihanGanda("Daun Menyirip", "Daun Menjari", "Daun Sejajar", "Daun Melengkung");
        listSoalSusah.add(new Susah("Hai, aku adalah daun yang tumbuh di pohon jarak. Bagaimanakah " +
                                        "bentuk daun ku?", "C"));
        listSoalSusah.get(4).setPilihanGanda("Sejajar", "Menyirip", "Menjari", "Melengkung");
        
        initComponents();
        
        tampilSoal();
    
        this.setLocationRelativeTo(null);

    }

    void tampilSoal(){
        int no_soal = (int) ((Math.random() * (4 - 0)) + 0);
        
        if(this.jmlSoal < 4){
            // Jika sudah selesai level sedang (sudah 4 soal),
            labelSoal.setText("<html>"+ listSoalSedang.get(no_soal).getSoal() +"</html>");
            labelA.setText("<html>"+ "A. " + listSoalSedang.get(no_soal).getPilihanGanda()[0] +"</html>");
            labelB.setText("<html>"+ "B. " + listSoalSedang.get(no_soal).getPilihanGanda()[1] +"</html>");
            labelC.setText("<html>"+ "C. " + listSoalSedang.get(no_soal).getPilihanGanda()[2] +"</html>");
            labelD.setText("<html>"+ "D. " + listSoalSedang.get(no_soal).getPilihanGanda()[3] +"</html>");
            this.currentSoalIndex = no_soal;
            timer = new Timer(120000, new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    dispose();
                    new HasilWindow(jmlSoal, totalPoint, nyawa).setVisible(true);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
        else{
            // Jika masih level soal sedang,
            labelSoal.setText("<html>"+ listSoalSusah.get(no_soal).getSoal() +"</html>");
            labelA.setText("<html>"+ "A. " + listSoalSusah.get(no_soal).getPilihanGanda()[0] +"</html>");
            labelB.setText("<html>"+ "B. " + listSoalSusah.get(no_soal).getPilihanGanda()[1] +"</html>");
            labelC.setText("<html>"+ "C. " + listSoalSusah.get(no_soal).getPilihanGanda()[2] +"</html>");
            labelD.setText("<html>"+ "D. " + listSoalSusah.get(no_soal).getPilihanGanda()[3] +"</html>");
            this.currentSoalIndex = no_soal;
            timer = new Timer(180000, new ActionListener(){
                public void actionPerformed(ActionEvent evt) {
                    dispose();
                    new HasilWindow(jmlSoal, totalPoint, nyawa).setVisible(true);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jawabBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labelSoal = new javax.swing.JLabel();
        btnJawab = new javax.swing.JButton();
        labelA = new javax.swing.JLabel();
        labelB = new javax.swing.JLabel();
        labelC = new javax.swing.JLabel();
        labelD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 205, 170));

        jawabBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jawabBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        jLabel1.setBackground(new java.awt.Color(153, 255, 153));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
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

        labelA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelA.setText("Jawaban A");

        labelB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelB.setText("Jawaban B");

        labelC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelC.setText("Jawaban C");

        labelD.setBackground(new java.awt.Color(153, 255, 153));
        labelD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelD.setText("Jawaban D");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jawabBox, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnJawab))
                            .addComponent(labelSoal, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                            .addComponent(labelA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(labelSoal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(labelA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelD)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jawabBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJawab))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJawabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJawabActionPerformed
        this.jmlSoal += 1;
        if(this.jmlSoal == 5){
            // Jika sudah selesai level susah.
            if(jawabBox.getSelectedItem().toString() == listSoalSusah.get(currentSoalIndex).getJawabanBenar()){
                    this.totalPoint += listSoalSusah.get(currentSoalIndex).getPoint();
            }
            else{
                this.nyawa -= 1;
            }
            this.dispose();
            new HasilWindow(this.jmlSoal, this.totalPoint, this.nyawa).setVisible(true);
        }
        else{
            // Jika masih level sedang.
            if(jawabBox.getSelectedItem().toString() == listSoalSedang.get(currentSoalIndex).getJawabanBenar()){
                this.totalPoint += listSoalSedang.get(currentSoalIndex).getPoint();
            }
            else{
                this.nyawa -= 1;
            }
            if(nyawa == 0){
                this.dispose();
                new HasilWindow(this.jmlSoal, this.totalPoint, this.nyawa).setVisible(true);
            }
            else{
                tampilSoal();
            }
        }
    }//GEN-LAST:event_btnJawabActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJawab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jawabBox;
    private javax.swing.JLabel labelA;
    private javax.swing.JLabel labelB;
    private javax.swing.JLabel labelC;
    private javax.swing.JLabel labelD;
    private javax.swing.JLabel labelSoal;
    // End of variables declaration//GEN-END:variables
}
