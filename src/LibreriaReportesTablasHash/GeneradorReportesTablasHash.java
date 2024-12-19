package LibreriaReportesTablasHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class GeneradorReportesTablasHash {
    //La funcion listaVotos me ayuda a ordenar y filtrar votos.
    //La funcion tablaHashVotos sirve para almacenar y buscar votos eficientemente

    //// Declaración de la lista de votos
    private ListaEnlazada<Voto> listaVotos;
    private TablaHash<String, Voto> tablaHashVotos;

// Constructor de la clase GeneradorReortes
    public GeneradorReportesTablasHash() {
        listaVotos = new ListaEnlazadaImpl<>();
        tablaHashVotos = new TablaHash<>(8255); // Ajusta la capacidad según sea necesario
        ordenarListaDeVotos();
        llenarTablaHash();
    }

    // Método para cargar datos desde un archivo CSV al modelo de la tabla
    public void cargarDatosDesdeCSV(String archivo, DefaultTableModel tableModel) {
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // Omitir la primera línea (encabezados)
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 8) {
                    int anio = Integer.parseInt(datos[0]);
                    int numVotos = Integer.parseInt(datos[7]);
                    Voto voto = new Voto(anio, datos[1], datos[2], datos[3].toUpperCase(), datos[4].toUpperCase(), datos[5].toUpperCase(), datos[6].toUpperCase(), numVotos);
                    listaVotos.insertar(voto);
                    tablaHashVotos.put(generarClave(voto), voto);
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

// Método para generar una clave única para cada voto en la tabla hash
    private String generarClave(Voto voto) {
        return voto.getDISTRITO() + "-" + voto.getSECCION() + "-" + voto.getMESA();
    }

    //Llena la tabla hash con los votos almacenados en la lista enlazada.
    private void llenarTablaHash() {
        for (Voto voto : listaVotos) {
            // Genera la clave única para el voto
            String clave = generarClave(voto); //utliza el metodo generarClave para almacenar 
            // Almacena el voto en la tabla hash usando la clave generada
            tablaHashVotos.put(clave, voto);
        }
    }

    //Busca un voto específico en la tabla hash. Utiliza la clave generada a partir del voto proporcionado para realizar la búsqueda.
    public Voto buscarVoto(Voto voto) {
        // Genera la clave única para el voto a buscar
        String clave = generarClave(voto);
        // Realiza la búsqueda del voto en la tabla hash usando la clave generada
        return tablaHashVotos.get(clave);
    }

    // Método para obtener la cantidad de votos válidos según los filtros de distrito, sección y mesa
    //tablaHashVotos.containsKey(generarClave(voto) Esto permite una verificación rápida antes de realizar operaciones adicionales, 
    //como la comparación de filtros y la suma de votos VALIDOS.
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
    //Esto permite una verificación rápida antes de realizar operaciones adicionales, 
    //como la comparación de filtros y la suma de votos NULOS.

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

    //Esto permite una verificación rápida antes de realizar operaciones adicionales, 
    //como la comparación de filtros y la suma de votos ABSTENCIONES.
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
