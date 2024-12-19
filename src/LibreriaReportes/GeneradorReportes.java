package LibreriaReportes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class GeneradorReportes {

    //// Declaración de la lista de votos
    private ListaEnlazada<Voto> listaVotos; //especifica que esta lista enlazada contendrá objetos del tipo Voto.

// Constructor de la clase GeneradorReortes
    public GeneradorReportes() {
        listaVotos = new ListaEnlazadaImpl<>(); // Inicializa la lista de votos como una lista enlazada vacía
        ordenarListaDeVotos(); // Cuando se inicializa la lista vacia y luego se llama a este metodo nos aseguramos de que cuando 
                               // vengan nuestros datos defrente de ordenen
    }

    // Método para cargar datos desde un archivo CSV al modelo de la tabla
    public void cargarDatosDesdeCSV(String archivo, DefaultTableModel tableModel) {
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // Leer la primera línea (encabezados) y omitirla
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 8) {
                    int anio = Integer.parseInt(datos[0]);
                    int numVotos = Integer.parseInt(datos[7]);
                    Voto voto = new Voto(anio, datos[1], datos[2], datos[3].toUpperCase(),
                            datos[4].toUpperCase(), datos[5].toUpperCase(), datos[6].toUpperCase(), numVotos);
                    listaVotos.insertar(voto);

                    // Agregar fila al modelo de la tabla
                    Object[] rowData = {voto.getANIO(), voto.getTITULO(), voto.getFECHA_ELECCIONES(),
                        voto.getDISTRITO(), voto.getSECCION(), voto.getMESA(),
                        voto.getPARTIDO(), voto.getNUM_VOTOS()};
                    tableModel.addRow(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para buscar un voto específico en la lista utilizando búsqueda
     * binaria.
     *
     * @param voto El voto a buscar.
     * @return El voto encontrado, o null si no se encuentra.
     */
    public Voto buscarVoto(Voto voto) {
        return listaVotos.busquedaBinaria(voto); // Busca el voto en la lista utilizando búsqueda binaria
    }

    // Método para obtener la cantidad de votos válidos según los filtros de distrito, sección y mesa
    public void cantidadVotosValidos(String distrito, String seccion, String mesa, DefaultTableModel tableModel) {
        int totalVotosValidos = 0;

        for (Voto voto : listaVotos) {
            if ((distrito == null || voto.getDISTRITO().equals(distrito))
                    && (seccion == null || voto.getSECCION().equals(seccion))
                    && (mesa == null || voto.getMESA().equals(mesa))
                    && voto.getPARTIDO().equalsIgnoreCase("VALIDOS")) {
                totalVotosValidos += voto.getNUM_VOTOS();

                // Agregar fila al modelo de la tabla
                Object[] rowData = {voto.getANIO(), voto.getTITULO(), voto.getFECHA_ELECCIONES(),
                    voto.getDISTRITO(), voto.getSECCION(), voto.getMESA(),
                    voto.getPARTIDO(), voto.getNUM_VOTOS()};
                tableModel.addRow(rowData);
            }
        }

        // Agregar fila con el total de votos válidos
        Object[] totalRow = {"", "", "", "", "", "", "Total de votos válidos:", totalVotosValidos};
        tableModel.addRow(totalRow);
    }

    public void cantidadVotosNulos(String distrito, String seccion, String mesa, DefaultTableModel tableModel) {
        int totalVotosNulos = 0;

        // Limpiar el modelo de la tabla antes de actualizar
        tableModel.setRowCount(0);

        for (Voto voto : listaVotos) {
            if ((distrito == null || voto.getDISTRITO().equals(distrito))
                    && (seccion == null || voto.getSECCION().equals(seccion))
                    && (mesa == null || voto.getMESA().equals(mesa))
                    && voto.getPARTIDO().equalsIgnoreCase("NULOS")) {
                totalVotosNulos += voto.getNUM_VOTOS();

                // Agregar fila al modelo de la tabla
                Object[] rowData = {voto.getANIO(), voto.getTITULO(), voto.getFECHA_ELECCIONES(),
                    voto.getDISTRITO(), voto.getSECCION(), voto.getMESA(),
                    voto.getPARTIDO(), voto.getNUM_VOTOS()};
                tableModel.addRow(rowData);
            }
        }

        // Agregar fila con el total de votos nulos
        Object[] totalRow = {"", "", "", "", "", "", "Total de votos nulos:", totalVotosNulos};
        tableModel.addRow(totalRow);
    }

    public void cantidadAbstenciones(String distrito, String seccion, String mesa, DefaultTableModel tableModel) {
        int totalAbstenciones = 0;

        // Limpiar el modelo de la tabla antes de actualizar
        tableModel.setRowCount(0);

        for (Voto voto : listaVotos) {
            if ((distrito == null || voto.getDISTRITO().equals(distrito))
                    && (seccion == null || voto.getSECCION().equals(seccion))
                    && (mesa == null || voto.getMESA().equals(mesa))
                    && voto.getPARTIDO().equalsIgnoreCase("ABSTENCIONES")) {
                totalAbstenciones += voto.getNUM_VOTOS();

                // Agregar fila al modelo de la tabla
                Object[] rowData = {voto.getANIO(), voto.getTITULO(), voto.getFECHA_ELECCIONES(),
                    voto.getDISTRITO(), voto.getSECCION(), voto.getMESA(),
                    voto.getPARTIDO(), voto.getNUM_VOTOS()};
                tableModel.addRow(rowData);
            }
        }

        // Agregar fila con el total de abstenciones
        Object[] totalRow = {"", "", "", "", "", "", "Total de abstenciones:", totalAbstenciones};
        tableModel.addRow(totalRow);
    }

    /**
     * Método para generar un reporte basado en el tipo de reporte especificado.
     *
     * @param tipoReporte El tipo de reporte a generar ("votosValidos",
     * "votosNulos", "abstenciones", "partidoGanador").
     * @param distrito El distrito para filtrar los votos (puede ser null).
     * @param seccion La sección para filtrar los votos (puede ser null).
     * @param mesa La mesa para filtrar los votos (puede ser null).
     * @return Una cadena de texto con los resultados del reporte.
     */
    public void generarReporte(String tipoReporte, String distrito, String seccion, String mesa, DefaultTableModel tableModel) {
        // Limpia el modelo actual de la tabla
        tableModel.setRowCount(0);

        switch (tipoReporte) {
            case "votosValidos":
                cantidadVotosValidos(distrito, seccion, mesa, tableModel); // Actualiza la tabla con el reporte de votos válidos
                break;
            case "votosNulos":
                cantidadVotosNulos(distrito, seccion, mesa, tableModel); // Actualiza la tabla con el reporte de votos nulos
                break;
            case "abstenciones":
                cantidadAbstenciones(distrito, seccion, mesa, tableModel); // Actualiza la tabla con el reporte de abstenciones
                break;
            default:
                // Si el tipo de reporte no es válido, no se hace nada en la tabla
                break;
        }
    }

    /**
     * Método para ordenar la lista de votos utilizando merge sort.
     */
    public void ordenarListaDeVotos() {
        listaVotos.mergeSort(); // Ordena la lista de votos usando el algoritmo merge sort
    }

}
