package JFrameVotos;

import LibreriaRegistro.Votos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class RegistroVotos extends javax.swing.JFrame {

    public RegistroVotos() {
        initComponents(); // Inicializa los componentes de la interfaz gráfica.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboPartido = new javax.swing.JComboBox<>();
        cboMesa = new javax.swing.JComboBox<>();
        Guardar = new javax.swing.JButton();
        tpDistrito = new javax.swing.JTextField();
        Eliminar = new javax.swing.JToggleButton();
        Retroceder = new javax.swing.JButton();
        tpSeccion = new javax.swing.JTextField();
        tpNumVotos = new javax.swing.JTextField();
        RegistroVotos = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(204, 0, 51));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DISTRITO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PARTIDO");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MESA");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SECCION");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NUM_VOTOS");

        cboPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AEEV", "FO", "PACMA", "PCTE", "PP", "PSOE", "PUEDE", "PUM J", "RC", "SUMAR", "VOX", "VALIDOS", "NULOS", "ABSTENCIONES" }));

        cboMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "U" }));
        cboMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesaActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(204, 0, 51));
        Guardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        tpDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpDistritoActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(204, 0, 51));
        Eliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("Eliminar Datos");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Retroceder.setBackground(new java.awt.Color(204, 0, 51));
        Retroceder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Retroceder.setForeground(new java.awt.Color(255, 255, 255));
        Retroceder.setText("Retroceder");
        Retroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetrocederActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Guardar))
                .addGap(123, 123, 123)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Eliminar)
                        .addGap(100, 100, 100)
                        .addComponent(Retroceder)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tpNumVotos, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPartido, javax.swing.GroupLayout.Alignment.LEADING, 0, 180, Short.MAX_VALUE)
                            .addComponent(cboMesa, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tpDistrito, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tpSeccion, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(283, 283, 283))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tpDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tpSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tpNumVotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Eliminar)
                    .addComponent(Retroceder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        RegistroVotos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        RegistroVotos.setForeground(new java.awt.Color(255, 255, 255));
        RegistroVotos.setText("Registrar Votos\n");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(RegistroVotos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(RegistroVotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesaActionPerformed

    }//GEN-LAST:event_cboMesaActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        String distrito = tpDistrito.getText();
        String seccion = tpSeccion.getText();
        String mesa = (String) cboMesa.getSelectedItem();
        String partido = (String) cboPartido.getSelectedItem();
        String cantidad = tpNumVotos.getText();

        Votos voto = new Votos("2023", "Elecciones Generales", "23/07/2023", distrito, seccion, mesa, partido, cantidad);
        guardarVotoEnArchivo(voto);

        JOptionPane.showMessageDialog(this, "Los votos se han registrado correctamente.");


    }//GEN-LAST:event_GuardarActionPerformed

    private void tpDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpDistritoActionPerformed

    }//GEN-LAST:event_tpDistritoActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // Limpiar los campos de texto
        tpDistrito.setText("");
        tpSeccion.setText("");
        tpNumVotos.setText("");
    }//GEN-LAST:event_EliminarActionPerformed

    private void RetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetrocederActionPerformed
// Cierra la ventana actual de RegistroVotos
        this.dispose();

// Crea una instancia de la clase FormularioPrincipal para abrir una nueva ventana
        FormularioPrincipal formularioPrincipal = new FormularioPrincipal();

// Hace visible la nueva ventana del formulario principal
        formularioPrincipal.setVisible(true);

    }//GEN-LAST:event_RetrocederActionPerformed
    /**
     * Método para guardar un voto en un archivo de texto.
     *
     * @param voto Objeto de tipo Votos que representa el voto a guardar.
     * @throws IOException Si ocurre un error de entrada/salida al escribir en
     * el archivo.
     */
    public void guardarVotoEnArchivo(Votos voto) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\ElecGenEspania2023.csv", true))) {
            writer.write(voto.getANIO() + ";" + voto.getTITULO() + ";" + voto.getFECHA_ELECCIONES() + ";"
                    + voto.getDISTRITO() + ";" + voto.getSECCION() + ";" + voto.getMESA() + ";"
                    + voto.getPARTIDO() + ";" + voto.getNUM_VOTOS());
            writer.newLine(); // Asegura que se añade una nueva línea después de cada voto
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVotos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel RegistroVotos;
    private javax.swing.JButton Retroceder;
    private javax.swing.JComboBox<String> cboMesa;
    private javax.swing.JComboBox<String> cboPartido;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tpDistrito;
    private javax.swing.JTextField tpNumVotos;
    private javax.swing.JTextField tpSeccion;
    // End of variables declaration//GEN-END:variables
}
