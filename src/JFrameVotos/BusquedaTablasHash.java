package JFrameVotos;

import JFrameVotos.FormularioPrincipal;
import LibreriaBusquedaTablasHash.ConsultaVotos;
import LibreriaBusquedaTablasHash.ConsultaVotos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author familia4
 */
public class BusquedaTablasHash extends javax.swing.JFrame {

    private final ConsultaVotos consultaVotos;
    private final DefaultTableModel tableModel;

    public BusquedaTablasHash() {
        initComponents();
        consultaVotos = new ConsultaVotos();
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ANIO", "TITULO", "FECHA_ELECCIONES", "DISTRITO", "SECCION", "MESA", "PARTIDO", "NUM_VOTOS"}
        );
        jTable1.setModel(tableModel);

        // Cargar datos desde el archivo CSV al iniciar la interfaz
        cargarDatosDesdeCSV("D:\\ElecGenEspania2023.csv");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDistrito = new javax.swing.JTextField();
        txtSeccion = new javax.swing.JTextField();
        txtMesa = new javax.swing.JTextField();
        txtPartido = new javax.swing.JTextField();
        BuscarVotos = new javax.swing.JToggleButton();
        Retroceder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(204, 0, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Busqueda de Votos Tablas Hash");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(457, 457, 457))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mesa:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Partido:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seccion:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Distrito:");

        BuscarVotos.setBackground(new java.awt.Color(204, 0, 51));
        BuscarVotos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BuscarVotos.setForeground(new java.awt.Color(255, 255, 255));
        BuscarVotos.setText("Buscar");
        BuscarVotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarVotosActionPerformed(evt);
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ANIO", "TITULO", "FECHA_ELECCIONES", "DISTRITO", "SECCION", "MESA", "PARTIDO", "NUM_VOTOS"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BuscarVotos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(Retroceder)
                        .addGap(386, 386, 386))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Retroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarVotos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarVotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarVotosActionPerformed
        String distrito = txtDistrito.getText();
        String seccion = txtSeccion.getText();
        String mesa = txtMesa.getText();
        String partido = txtPartido.getText();

// Llamada a la función buscarVotos de ConsultaVotos
        String resultados = consultaVotos.buscarVotos(distrito, seccion, mesa, partido);

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de agregar nuevos resultados

        if (resultados != null && !resultados.isEmpty()) {
            // Dividir el resultado en líneas (cada línea representa un conjunto de datos)
            String[] lineas = resultados.split("\n");

            // Iterar sobre cada línea de resultados y agregar a la tabla como una nueva fila
            for (String linea : lineas) {
                // Separar los datos de la línea
                String[] partes = linea.split(","); // Ajusta el delimitador según tu necesidad

                // Añadir los datos como una nueva fila al modelo de la tabla
                model.addRow(new Object[]{
                    partes[0].substring(partes[0].indexOf(":") + 1).trim(), // ANIO
                    partes[1].substring(partes[1].indexOf(":") + 1).trim(), // TITULO
                    partes[2].substring(partes[2].indexOf(":") + 1).trim(), // FECHA_ELECCIONES
                    partes[3].substring(partes[3].indexOf(":") + 1).trim(), // DISTRITO
                    partes[4].substring(partes[4].indexOf(":") + 1).trim(), // SECCION
                    partes[5].substring(partes[5].indexOf(":") + 1).trim(), // MESA
                    partes[6].substring(partes[6].indexOf(":") + 1).trim(), // PARTIDO
                    partes[7].substring(partes[7].indexOf(":") + 1).trim() // NUM_VOTOS
                });
            }
        } else {
            // Si no se encontraron resultados, mostrar un mensaje con JOptionPane
            JOptionPane.showMessageDialog(this, "No se encontraron resultados para los criterios de búsqueda especificados.",
                    "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_BuscarVotosActionPerformed

    private void RetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetrocederActionPerformed

        // Cerrar el formulario secundario
        this.dispose();

        // Mostrar nuevamente el formulario principal (puedes crear una instancia si es necesario)
        FormularioPrincipal formularioPrincipal = new FormularioPrincipal();
        formularioPrincipal.setVisible(true); //se utiliza para hacer visible un formulario en una aplicación de escritorio desarrollada en Java utilizando
    }//GEN-LAST:event_RetrocederActionPerformed
    // Método para cargar datos desde un archivo CSV
    private void cargarDatosDesdeCSV(String archivoCSV) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";"; // Delimitador del CSV

        try {
            br = new BufferedReader(new FileReader(archivoCSV));

            // Leer la primera línea (encabezados) y descartarla
            br.readLine();

            // Leer las líneas restantes (datos)
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                tableModel.addRow(datos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BusquedaTablasHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaTablasHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaTablasHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaTablasHash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaTablasHash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BuscarVotos;
    private javax.swing.JButton Retroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtMesa;
    private javax.swing.JTextField txtPartido;
    private javax.swing.JTextField txtSeccion;
    // End of variables declaration//GEN-END:variables
}
