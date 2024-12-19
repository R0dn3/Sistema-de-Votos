package LibreriaBusquedaArbol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsultaVotosArbol implements VotoCollectionArbol {

    private TreeNode root; // Raíz del árbol binario de búsqueda
    private int count; // Contador para los elementos del árbol

    public ConsultaVotosArbol() {
        root = null; // Vacio
        count = 0; // Inicializar el contador

        // Medir el tiempo de inicio de carga de datos
        long startTime = System.nanoTime();

        // Cargar los datos desde el archivo CSV
        cargarDatosDesdeCSV("D:\\ElecGenEspania2023.csv");

        // Medir el tiempo de finalización de carga de datos
        long endTime = System.nanoTime();

        // Mostrar el tiempo que tomó cargar los datos desde el archivo CSV
        System.out.println("Cargando datos desde el archivo CSV...");
        System.out.println("Tiempo de carga de datos: " + (endTime - startTime) + " nanosegundos");

    }

    //Método para cargar datos desde un archivo CSV.
    private void cargarDatosDesdeCSV(String archivo) {
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // Leer la primera línea (encabezados) y omitirla

            while ((linea = br.readLine()) != null) {
                // Dividir la línea leída en campos usando ";" como separador
                String[] datos = linea.split(";");
                if (datos.length >= 8) {
                    // Asignar los valores correspondientes a cada campo
                    String ANIO = datos[0];
                    String TITULO = datos[1];
                    String FECHA_ELECCIONES = datos[2];
                    String DISTRITO = datos[3].toUpperCase();
                    String SECCION = datos[4].toUpperCase();
                    String MESA = datos[5].toUpperCase();
                    String PARTIDO = datos[6].toUpperCase();
                    String NUM_VOTOS = datos[7];

                    // Crear un nuevo objeto VotoBusquedaArbol con los datos leídos
                    VotoBusquedaArbol voto = new VotoBusquedaArbol(ANIO, TITULO, FECHA_ELECCIONES, DISTRITO, SECCION, MESA, PARTIDO, NUM_VOTOS);

                    // Insertar el voto en el árbol binario de búsqueda
                    root = insertar(root, voto);

                    // Incrementar el contador de votos
                    count++;
                }
            }
        } catch (IOException e) {
            // Imprimir el stack trace si ocurre una excepción de entrada/salida
            e.printStackTrace();
        }
    }

    //Método para insertar un voto en el árbol binario de búsqueda.
    private TreeNode insertar(TreeNode node, VotoBusquedaArbol voto) {
        if (node == null) {
            // Si el nodo actual es nulo, crear un nuevo nodo con el voto y retornarlo
            return new TreeNode(voto);
        }

        // Comparar el voto actual con el voto del nodo para determinar la posición de inserción
        if (compararVotos(voto, node.voto) < 0) {
            // Si el voto es menor, insertarlo en el subárbol izquierdo
            node.left = insertar(node.left, voto);
        } else {
            // Si el voto es mayor o igual, insertarlo en el subárbol derecho
            node.right = insertar(node.right, voto);
        }

        // Retornar el nodo actual después de la inserción
        return node;
    }

    //Método para comparar dos votos en base a DISTRITO, SECCION, MESA y PARTIDO.
    private int compararVotos(VotoBusquedaArbol voto1, VotoBusquedaArbol voto2) {
        // Comparar los votos en base a DISTRITO, SECCION, MESA y PARTIDO, en ese orden
        int comparacion = voto1.getDISTRITO().compareTo(voto2.getDISTRITO());
        if (comparacion != 0) {
            return comparacion;
        }
        comparacion = voto1.getSECCION().compareTo(voto2.getSECCION());
        if (comparacion != 0) {
            return comparacion;
        }
        comparacion = voto1.getMESA().compareTo(voto2.getMESA());
        if (comparacion != 0) {
            return comparacion;
        }
        return voto1.getPARTIDO().compareTo(voto2.getPARTIDO());
    }

    //Método para buscar votos en el árbol binario de búsqueda en base a criterios específicos.
    @Override
    public String buscarVotos(String DISTRITO, String SECCION, String MESA, String PARTIDO) {
        // Usar StringBuilder para construir el resultado de la búsqueda
        StringBuilder resultado = new StringBuilder();

        // Realizar la búsqueda recursiva en el árbol
        buscarVotosRec(root, DISTRITO, SECCION, MESA, PARTIDO, resultado);

        // Retornar el resultado como una cadena
        return resultado.toString();
    }

    //Método recursivo para buscar votos en el árbol binario de búsqueda.
    private void buscarVotosRec(TreeNode node, String DISTRITO, String SECCION, String MESA, String PARTIDO, StringBuilder resultado) {
        if (node != null) {
            // Variable para verificar si el nodo actual coincide con los criterios de búsqueda
            boolean match = true;

            // Verificar cada criterio de búsqueda
            if (!DISTRITO.isEmpty() && !node.voto.getDISTRITO().equals(DISTRITO)) {
                match = false;
            }
            if (!SECCION.isEmpty() && !node.voto.getSECCION().equals(SECCION)) {
                match = false;
            }
            if (!MESA.isEmpty() && !node.voto.getMESA().equals(MESA)) {
                match = false;
            }
            if (!PARTIDO.isEmpty() && !node.voto.getPARTIDO().equals(PARTIDO)) {
                match = false;
            }

            // Si el nodo coincide con los criterios, agregarlo al resultado
            if (match) {
                resultado.append(node.voto.toString()).append("\n");
            }

            // Continuar la búsqueda en el subárbol izquierdo
            buscarVotosRec(node.left, DISTRITO, SECCION, MESA, PARTIDO, resultado);

            // Continuar la búsqueda en el subárbol derecho
            buscarVotosRec(node.right, DISTRITO, SECCION, MESA, PARTIDO, resultado);
        }
    }

    // Método para recorrido INORDER
    // ayuda a que los votos están correctamente ordenados de una forma ascendente en el árbol QUE SON distrito, sección, mesa y partido
    public void inorder() {
        inorderRec(root); // Comienza el recorrido desde la raíz del árbol
    }

    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left); // Recorrer subárbol izquierdo
            System.out.println(node.voto.toString()); // Procesar nodo actual
            inorderRec(node.right); // Recorrer subárbol derecho
        }
    }

    //Método para obtener los datos en un formato adecuado para ser usados en una tabla.
    public String[][] obtenerDatosParaTabla() {
        // Crear un arreglo bidimensional para almacenar los datos de los votos
        String[][] datos = new String[count][8];

        // Llenar el arreglo con los datos de los votos comenzando desde la raíz del árbol
        llenarDatosParaTabla(root, datos, new int[]{0});

        // Retornar el arreglo de datos
        return datos;
    }

    //Método recursivo para llenar un arreglo con los datos de los votos del árbol binario de búsqueda.
    private void llenarDatosParaTabla(TreeNode node, String[][] datos, int[] index) {
        if (node != null) {
            // Llenar el arreglo con los datos del subárbol izquierdo
            llenarDatosParaTabla(node.left, datos, index);

            // Asignar los valores de los atributos del voto a la posición actual del arreglo
            datos[index[0]][0] = node.voto.getANIO();
            datos[index[0]][1] = node.voto.getTITULO();
            datos[index[0]][2] = node.voto.getFECHA_ELECCIONES();
            datos[index[0]][3] = node.voto.getDISTRITO();
            datos[index[0]][4] = node.voto.getSECCION();
            datos[index[0]][5] = node.voto.getMESA();
            datos[index[0]][6] = node.voto.getPARTIDO();
            datos[index[0]][7] = node.voto.getNUM_VOTOS();

            // Incrementar el índice para la siguiente posición del arreglo
            index[0]++;

            // Llenar el arreglo con los datos del subárbol derecho
            llenarDatosParaTabla(node.right, datos, index);
        }
    }


}
