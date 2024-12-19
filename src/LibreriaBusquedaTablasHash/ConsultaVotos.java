package LibreriaBusquedaTablasHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaVotos {

    private MiTablaHash votosTabla;

    public ConsultaVotos() {
        votosTabla = new MiTablaHash(); // Inicializa la tabla hash al crear una instancia de ConsultaVotos

        long startTime = System.nanoTime(); // Toma el tiempo antes de cargar los datos

        cargarDatosDesdeCSV("D:\\ElecGenEspania2023.csv"); // Carga los datos desde el archivo CSV especificado

        long endTime = System.nanoTime(); // Toma el tiempo después de cargar los datos

        System.out.println("Cargando datos desde el archivo CSV...");
        System.out.println("Tiempo de carga de datos: " + (endTime - startTime) + " nanosegundos");

        // Ordena las listas enlazadas en la tabla hash después de cargar los datos
        votosTabla.ordenar();
        System.out.println("Datos ordenados.");
    }

    // Método privado para cargar datos desde un archivo CSV
    private void cargarDatosDesdeCSV(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // Salta la primera línea (encabezados)

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                if (datos.length >= 8) {
                    String ANIO = datos[0];
                    String TITULO = datos[1];
                    String FECHA_ELECCIONES = datos[2];
                    String DISTRITO = datos[3].toUpperCase();
                    String SECCION = datos[4].toUpperCase();
                    String MESA = datos[5].toUpperCase();
                    String PARTIDO = datos[6].toUpperCase();
                    String NUM_VOTOS = datos[7];

                    // Crea un objeto VotoBusqueda con los datos del CSV
                    VotoBusqueda voto = new VotoBusqueda(ANIO, TITULO, FECHA_ELECCIONES, DISTRITO, SECCION, MESA, PARTIDO, NUM_VOTOS);

                    // Inserta el voto en la tabla hash utilizando una clave formada por la concatenación de los campos relevantes
                    votosTabla.agregar(DISTRITO + SECCION + MESA + PARTIDO, voto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar votos en la tabla hash utilizando filtros de distrito, sección, mesa y partido
    public String buscarVotos(String DISTRITO, String SECCION, String MESA, String PARTIDO) {
        return votosTabla.buscarVotosConFiltros(DISTRITO, SECCION, MESA, PARTIDO);
    }
}
