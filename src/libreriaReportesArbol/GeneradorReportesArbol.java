package libreriaReportesArbol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class GeneradorReportesArbol {

    private Arbol arbol; // Declara una variable privada llamada arbol que almacena la instancia de un árbol binario de búsqueda.

    // Constructor de la clase GeneradorReportesArbol.
    public GeneradorReportesArbol() {
        this.arbol = new Arbol(); // Inicializa el árbol al crear una nueva instancia de GeneradorReportesArbol.
        String archivoCSV = "D:\\ElecGenEspania2023.csv"; // Ruta del archivo CSV dentro de la clase

        try {
            cargarDatosDesdeCSV(archivoCSV); // Llama al método para cargar datos desde el archivo CSV.
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage()); // Manejo de errores si ocurre una excepción al leer el archivo CSV.
        }
    }

    // Método privado para cargar datos desde un archivo CSV hacia el árbol.
    private void cargarDatosDesdeCSV(String archivoCSV) throws IOException {
        try ( BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String encabezados = br.readLine(); // Leer encabezados (opcional)

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(";");
                int anio = Integer.parseInt(valores[0]);
                String titulo = valores[1];
                String fechaElecciones = valores[2];
                int distrito = Integer.parseInt(valores[3]);
                int seccion = Integer.parseInt(valores[4]);
                String mesa = valores[5];
                String partido = valores[6];
                int numVotos = Integer.parseInt(valores[7]);
                Voto voto = new Voto(anio, titulo, fechaElecciones, distrito, seccion, mesa, partido, numVotos);
                arbol.insertar(voto); // Insertar el voto en el árbol binario de búsqueda.
            }
        }
    }

    // Método para obtener los datos como un DefaultTableModel según criterios de filtro.
    public DefaultTableModel obtenerDatosComoTableModel(String tipoReporte, Integer distrito, Integer seccion, String mesa) {
        DefaultTableModel model = new DefaultTableModel(); // Crear un nuevo modelo de tabla por defecto.

        // Establecer los nombres de las columnas del modelo de tabla.
        model.setColumnIdentifiers(new Object[]{"ANIO", "TITULO", "FECHA_ELECCIONES", "DISTRITO", "SECCION", "MESA", "PARTIDO", "NUM_VOTOS"});

        // Obtener la lista de votos filtrados según los parámetros de filtro.
        ListaVotos listaVotos = arbol.obtenerVotos(distrito, seccion, mesa);

        // Obtener el primer nodo de la lista de votos.
        NodoLista nodoActual = listaVotos.getCabeza();

        // Iterar a través de la lista de votos y agregar filas al modelo de tabla.
        while (nodoActual != null) {
            Voto voto = nodoActual.voto; // Obtener el voto actual desde el nodo.

            // Determinar si se debe aplicar un filtro según el tipo de reporte.
            boolean filtrar = tipoReporte != null && !tipoReporte.isEmpty();
            boolean coincide = !filtrar
                    || (tipoReporte.equalsIgnoreCase("validos") && voto.getPartido().equalsIgnoreCase("Validos"))
                    || (tipoReporte.equalsIgnoreCase("nulos") && voto.getPartido().equalsIgnoreCase("Nulos"))
                    || (tipoReporte.equalsIgnoreCase("abstenciones") && voto.getPartido().equalsIgnoreCase("Abstenciones"));

            // Verificar si el voto cumple con todos los criterios de filtro especificados.
            if ((distrito == null || voto.getDistrito() == distrito.intValue())
                    && (seccion == null || voto.getSeccion() == seccion.intValue())
                    && (mesa == null || voto.getMesa().equalsIgnoreCase(mesa))
                    && (!filtrar || coincide)) {
                // Agregar una nueva fila al modelo de tabla con los datos del voto actual.
                model.addRow(new Object[]{voto.getAnio(), voto.getTitulo(), voto.getFechaElecciones(),
                    voto.getDistrito(), voto.getSeccion(), voto.getMesa(), voto.getPartido(), voto.getNumVotos()});
            }

            nodoActual = nodoActual.siguiente; // Avanzar al siguiente nodo en la lista de votos.
        }

        return model; // Devolver el modelo de datos construido.
    }

    // Getter para obtener el árbol de votos.
    public Arbol getArbol() {
        return arbol;
    }

    // Setter para establecer un árbol de votos.
    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }
}
