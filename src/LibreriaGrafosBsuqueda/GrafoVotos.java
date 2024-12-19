package LibreriaGrafosBsuqueda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class GrafoVotos implements VotoCollection {

    private NodoVoto head; // Nodo cabeza del grafo

    public GrafoVotos() {
        head = null; // Inicialización del grafo

        long startTime = System.nanoTime();
        cargarDatosDesdeCSV("D:\\ElecGenEspania2023.csv");
        long endTime = System.nanoTime();

        System.out.println("Cargando datos desde el archivo CSV...");
        System.out.println("Tiempo de carga de datos: " + (endTime - startTime) + " nanosegundos");

        conectarNodos(); // Conectar nodos en el grafo
    }

    private void cargarDatosDesdeCSV(String archivo) {
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        br.readLine(); // Leer la primera línea (encabezados) y omitirla
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
                VotoBusqueda voto = new VotoBusqueda(ANIO, TITULO, FECHA_ELECCIONES, DISTRITO, SECCION, MESA, PARTIDO, NUM_VOTOS);
                insertarNodo(voto); // Insertar el voto como nodo en el grafo
            } else {
                System.out.println("Línea con formato incorrecto: " + linea);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    private void insertarNodo(VotoBusqueda voto) {
        NodoVoto nuevoNodo = new NodoVoto(voto);
        if (head == null) {
            head = nuevoNodo;
        } else {
            NodoVoto current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = nuevoNodo;
        }
    }

    private void conectarNodos() {
        if (head == null) {
            return;
        }

        NodoVoto current = head;
        while (current != null) {
            NodoVoto temp = head;
            while (temp != null) {
                if (!current.equals(temp) && current.voto.getDISTRITO().equals(temp.voto.getDISTRITO())) {
                    current.addConnection(temp);
                }
                temp = temp.next;
            }
            current = current.next;
        }
    }

    @Override
    public String buscarVotos(String DISTRITO, String SECCION, String MESA, String PARTIDO) {
        StringBuilder resultado = new StringBuilder();
        MiConjunto<NodoVoto> visited = new MiConjunto<>();
        MiCola<NodoVoto> queue = new MiCola<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            NodoVoto current = queue.poll();

            if (current != null && !visited.contains(current)) {
                visited.add(current);

                boolean match = true;
                if (!DISTRITO.isEmpty() && !current.voto.getDISTRITO().equals(DISTRITO)) {
                    match = false;
                }
                if (!SECCION.isEmpty() && !current.voto.getSECCION().equals(SECCION)) {
                    match = false;
                }
                if (!MESA.isEmpty() && !current.voto.getMESA().equals(MESA)) {
                    match = false;
                }
                if (!PARTIDO.isEmpty() && !current.voto.getPARTIDO().equals(PARTIDO)) {
                    match = false;
                }
                if (match) {
                    resultado.append(current.voto.toString()).append("\n");
                }

                Iterator<NodoVoto> iter = current.connections.iterator();
                while (iter.hasNext()) {
                    queue.add(iter.next());
                }
            }
        }

        return resultado.toString();
    }

    private class NodoVoto {

        VotoBusqueda voto;
        NodoVoto next;
        MiConjunto<NodoVoto> connections; // Utilizando la implementación personalizada

        NodoVoto(VotoBusqueda voto) {
            this.voto = voto;
            this.next = null;
            this.connections = new MiConjunto<>(); // Inicializando con la implementación personalizada
        }

        void addConnection(NodoVoto nodo) {
            connections.add(nodo);
        }
    }

}
