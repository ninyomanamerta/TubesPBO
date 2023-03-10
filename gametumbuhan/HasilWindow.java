package gametumbuhan;

public class HasilWindow extends javax.swing.JFrame {

    int jmlSoal;
    int totalPoint;
    int nyawa;
    
    public HasilWindow(int jmlSoal, int totalPoint, int nyawa) {
        this.jmlSoal = jmlSoal;
        this.totalPoint = totalPoint;
        this.nyawa = nyawa;
        initComponents();
        
        // Menampilkan score dan keterangan score.
        labelScore.setText("Score Akhir : " + String.valueOf(totalPoint));
        if(totalPoint <= 20){
            labelKet.setText("Kamu masih perlu belajar lagi!");
        }
        else if(totalPoint >=21 && totalPoint <=60){
            labelKet.setText("Kamu hebat, tapi masih perlu belajar lagi, ya.");
        }
        else{
            labelKet.setText("Kamu luar biasa!");
        }
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelScore = new javax.swing.JLabel();
        labelKet = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel1.setText("Hasil Permainan");

        labelScore.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        labelScore.setText("(Score)");

        labelKet.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        labelKet.setText("(Keterangan)");

        btnHome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHome)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelKet, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(labelScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelKet)
                .addGap(51, 51, 51)
                .addComponent(btnHome)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        new Welcome().setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelKet;
    private javax.swing.JLabel labelScore;
    // End of variables declaration//GEN-END:variables
}
