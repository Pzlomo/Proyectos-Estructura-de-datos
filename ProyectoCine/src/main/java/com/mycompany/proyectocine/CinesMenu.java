package com.mycompany.proyectocine;

public class CinesMenu extends javax.swing.JFrame {
    public CinesMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnPelicula2 = new javax.swing.JButton();
        BtnPelicula3 = new javax.swing.JButton();
        BtnPelicula1 = new javax.swing.JButton();
        BtnInformeVentas = new javax.swing.JButton();

        jButton3.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MI SALAS DE CINE VIP");

        BtnPelicula2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnPelicula2.setText("Chainsaw Man: Reze");
        BtnPelicula2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, new java.awt.Color(204, 204, 204), java.awt.Color.lightGray, java.awt.Color.lightGray));
        BtnPelicula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPelicula2ActionPerformed(evt);
            }
        });

        BtnPelicula3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnPelicula3.setText("A pesar de ti");
        BtnPelicula3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, new java.awt.Color(204, 204, 204), java.awt.Color.lightGray, java.awt.Color.lightGray));
        BtnPelicula3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPelicula3ActionPerformed(evt);
            }
        });

        BtnPelicula1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnPelicula1.setText("Telefono Negro");
        BtnPelicula1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, new java.awt.Color(204, 204, 204), java.awt.Color.lightGray, java.awt.Color.lightGray));
        BtnPelicula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPelicula1ActionPerformed(evt);
            }
        });

        BtnInformeVentas.setBackground(new java.awt.Color(204, 204, 204));
        BtnInformeVentas.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        BtnInformeVentas.setText("Ver informe de ventas");
        BtnInformeVentas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, new java.awt.Color(204, 204, 204), java.awt.Color.lightGray, java.awt.Color.lightGray));
        BtnInformeVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInformeVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BtnPelicula2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(BtnPelicula1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(BtnPelicula3, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(BtnInformeVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPelicula1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnPelicula2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnPelicula3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(BtnInformeVentas)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInformeVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInformeVentasActionPerformed
    CineReporteVentas reporte = new CineReporteVentas();
    reporte.setVisible(true);
    }//GEN-LAST:event_BtnInformeVentasActionPerformed

    private void BtnPelicula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula1ActionPerformed
    CineSala ventana = new CineSala();
    ventana.cargarDatosSala(0); // El 0 es la primera película de la lista
    ventana.setVisible(true);
    }//GEN-LAST:event_BtnPelicula1ActionPerformed

    private void BtnPelicula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula2ActionPerformed
    CineSala ventana = new CineSala();
    ventana.cargarDatosSala(1); // 1 = Segunda película
    ventana.setVisible(true);
    }//GEN-LAST:event_BtnPelicula2ActionPerformed

    private void BtnPelicula3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelicula3ActionPerformed
    CineSala ventana = new CineSala();
    ventana.cargarDatosSala(2); // 2 = Tercera película
    ventana.setVisible(true);
    }//GEN-LAST:event_BtnPelicula3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CinesMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInformeVentas;
    private javax.swing.JButton BtnPelicula1;
    private javax.swing.JButton BtnPelicula2;
    private javax.swing.JButton BtnPelicula3;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
