package LibreriaEstadisticoBusqueda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//ConsultaVotos es la lista enlazada
public class ConsultaVotos implements VotoCollection {

    public ListNode head; // Nodo cabeza de la lista enlazada, referencia al primer nodo de la lista enlazada

    public ConsultaVotos() {
        head = null; // Inicialización de la lista enlazada

        // Medir el tiempo de inicio de carga de datos
        long startTime = System.nanoTime();

        // Cargar los datos desde el archivo CSV
        cargarDatosDesdeCSV("D:\\ElecGenEspania2023.csv");

        // Medir el tiempo de finalización de carga de datos
        long endTime = System.nanoTime();

        // Mostrar el tiempo que tomó cargar los datos desde el archivo CSV
        System.out.println("Cargando datos desde el archivo CSV...");
        System.out.println("Tiempo de carga de datos: " + (endTime - startTime) + " nanosegundos");

        // Ordenar la lista una vez después de cargar los datos
        ordenarPorCampos();
    }

    public void cargarDatosDesdeCSV(String archivo) {
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Leer la primera línea (encabezados) y omitirla, ya que son descriptivos de nuestros verda datos
            br.readLine();
            // Leer cada línea del archivo CSV y crear un objeto Voto con los datos
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                // Verificar que haya al menos ocho elementos en la línea
                if (datos.length >= 8) {
                    String ANIO = datos[0];
                    String TITULO = datos[1];
                    String FECHA_ELECCIONES = datos[2];
                    String DISTRITO = datos[3].toUpperCase();
                    String SECCION = datos[4].toUpperCase();
                    String MESA = datos[5].toUpperCase();
                    String PARTIDO = datos[6].toUpperCase();
                    String NUM_VOTOS = datos[7];
                    // Crear un objeto Voto y agregarlo a la lista
                    VotoBusqueda voto = new VotoBusqueda(ANIO, TITULO, FECHA_ELECCIONES, DISTRITO, SECCION, MESA, PARTIDO, NUM_VOTOS);
                    insertarAlFinal(voto); // Insertar el voto al final de la lista enlazada
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza el algoritmo Merge Sort para ordenar la lista enlazada.
     *
     * @param head La cabeza de la lista enlazada a ordenar.
     * @return La cabeza de la lista enlazada ordenada.
     */
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) { //VERIFICAR VACIO O NO 
            return head;
        }
        ListNode middle = getMiddle(head); //METODO GETMIDDLE, encontrar el nodo central de la lista enlazada 
        ListNode nextOfMiddle = middle.next; //Se obtiene el siguiente nodo después del nodo central para dividir la lista en dos partes.
        middle.next = null; //Se corta la conexión del nodo central con el siguiente nodo para dividir la lista en dos sublistas independientes.

        ListNode left = mergeSort(head); //SE LLAMA AL METODO MERGESORT
        ListNode right = mergeSort(nextOfMiddle); //ordenar las sublistas izquierda y derecha generadas anteriormente.

        return merge(left, right); //METODO MERGE, combina las sublistas ordenadas izquierda y derecha utilizando.
    }

    /**
     * Encuentra el nodo medio de la lista enlazada.
     *
     * @param head La cabeza de la lista enlazada.
     * @return El nodo medio de la lista enlazada.
     */
    private ListNode getMiddle(ListNode head) {
        if (head == null) { //VERIFICA VACIA
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next; //ESTO ASEGURA QUE SI LA LISTA ES IMPAR ASEGURA QUE EL PUNTERO NO ESTE EN NULL

        while (fast != null && fast.next != null) { //BUCLE QUE NOS AYUDARA A RECORRER LA LISTA POR MEDIO DE UN PUNTERO "RAPIDO" Y "LENTO"
            slow = slow.next; //QUE RECORRA EL PUNTERO AVANCE UN NODO A LA VEZ
            fast = fast.next.next;  //HACEQ QUE EL PUNTERO AVANCE DOS NODOS A LA VEZ 
        }
        return slow; //ESTOS PUNTOS HACE QUE SE ENCUENTRE EL PUNTO MEDIO DE LA LISTA
    }

    /**
     * Ordena la lista enlazada por múltiples campos: distrito, sección, mesa y
     * partido.
     */
    private void ordenarPorCampos() { //METODO MERGE
        if (head == null || head.next == null) {
            return; // La lista está vacía o tiene solo un elemento, ya está ordenada
        }
        // Ordena por múltiples campos: distrito, sección, mesa y partido
        head = mergeSort(head);
    }

    /**
     * Combina dos sublistas ordenadas en una sola lista ordenada.
     *
     * @param left La sublista izquierda.
     * @param right La sublista derecha.
     * @return La lista combinada y ordenada.
     */
    private ListNode merge(ListNode left, ListNode right) { //ESTE BLOQUE FUSIONA LAS DOS SUBLISTAS QUE PARTIERON EN EL getMiddle
        if (left == null) { //RECORRE LA LISTA A LA IZQUIERDA HASTA QUE LLEGA AL LIMITE, ES PARA VER SI HAY ALGO PARA ORDENAR
            return right;
        }
        if (right == null) { //LO MISMO QUE EL ANTERIOR
            return left;
        }

        ListNode result;  //Comparamos los nodos left y right y elegimos el nodo más pequeño para ser el próximo nodo en la lista fusionada
        if (compararVotos(left.voto, right.voto) <= 0) { //METODO compararVotos
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next); // Y ASI HASTA RECORRER TODA LISTA
        }
        return result; //devolvemos el nodo resultante
    }

    /**
     * Compara dos votos según los campos: distrito, sección, mesa y partido.
     *
     * @param voto1 El primer voto a comparar.
     * @param voto2 El segundo voto a comparar.
     * @return Un valor negativo si voto1 es menor, cero si son iguales y un
     * valor positivo si voto2 es mayor.
     */
    private int compararVotos(VotoBusqueda voto1, VotoBusqueda voto2) { //SOLO HAY DOS voto1 y voto2 porque asi lo requiere 
        //la funcion compararVotos y que la función de comparación merge le basta con dos, 
        //pero si puede por mas, pero en pares
        // Comparación por múltiples campos: distrito, sección, mesa y partido
        int comparacion = voto1.getDISTRITO().compareTo(voto2.getDISTRITO());
        if (comparacion != 0) {
            return comparacion;
        }
        comparacion = voto1.getSECCION().compareTo(voto2.getSECCION()); //LOGICA DE COMPARACION DE LOS voto1 y voto2, PRIMERO ES DISTRITO POR EL ORDEN EN QUE ESTAN 
        if (comparacion != 0) {
            return comparacion;
        }
        comparacion = voto1.getMESA().compareTo(voto2.getMESA());
        if (comparacion != 0) {
            return comparacion;
        }
        return voto1.getPARTIDO().compareTo(voto2.getPARTIDO());
        //HAY COMPARETO PORQUE ESTAMOS TRATANDO CON STRING
    }

    // Método para realizar la búsqueda binaria en la lista enlazada ordenada
    /**
     * Realiza una búsqueda binaria en la lista enlazada ordenada por múltiples
     * campos.
     *
     * @param DISTRITO El distrito del voto a buscar.
     * @param SECCION La sección del voto a buscar.
     * @param MESA La mesa del voto a buscar.
     * @param PARTIDO El partido del voto a buscar.
     * @return La posición del voto que coincide con los criterios de búsqueda,
     * o -1 si no se encuentra.
     */
    private int busquedaBinaria(String DISTRITO, String SECCION, String MESA, String PARTIDO) {
        int low = 0; //Inicializan los índices para la búsqueda binaria. low es el índice del primer elemento en la lista.
        int high = contarVotos() - 1; //high es el índice del último elemento.

        while (low <= high) { //Inicia un bucle que se ejecutará mientras el índice inferior sea menor o igual al índice superior.
            int mid = low + (high - low) / 2;  //Calcula el índice medio de la lista.
            VotoBusqueda voto = obtenerVotoEnPosicion(mid); //Obtiene el voto en la posición media de la lista.
            int comparacion = compararVotosBusqueda(voto, DISTRITO, SECCION, MESA, PARTIDO); //Compara el voto obtenido con los criterios de búsqueda.

            if (comparacion == 0) {  //Si el voto coincide con los criterios de búsqueda, devuelve el índice medio.
                // Se encontró un voto que coincide con los criterios de búsqueda
                return mid;
            } else if (comparacion < 0) { //Si el voto es menor que los criterios de búsqueda, actualiza el índice inferior para buscar en la mitad derecha de la lista.
                low = mid + 1;
            } else {
                high = mid - 1; //Si el voto es mayor que los criterios de búsqueda, actualiza el índice superior para buscar en la mitad izquierda de la lista.
            }
        }

        // No se encontró ningún voto que coincida
        return -1;
    }

    /**
     * Cuenta el número de votos en la lista enlazada.
     *
     * @return El número de votos en la lista.
     */
    // Método para obtener el número de votos en la lista enlazada
    private int contarVotos() {
        int count = 0; // SE CUENTA DE 0
        ListNode current = head; // SE ESTABLECE UN PUNTERO current al incio de liesta (HEAD)
        while (current != null) { //SE EJECUTA EL current mientras haya nodos, null solo cuando termine de recorrer
            count++; // ESTO PERMITE QUE SE CORRA 
            current = current.next; //HACE QUE AVANCE PUNTERO
        }
        return count; //CUANDO TECORRE HASTA EL ULTIMO RETORNA CON EL TOTAL DE VOTOS
    }

    /**
     * Obtiene el voto en la posición especificada de la lista enlazada.
     *
     * @param index La posición del voto que se desea obtener.
     * @return El voto en la posición especificada, o null si la posición está
     * fuera de rango.
     */
    private VotoBusqueda obtenerVotoEnPosicion(int index) { //index ES UN NUMERO ENTEROR QUE REPRESENTA 
        //LA POSICION DEL VOTO QUE SE DESEA OBTENER
        int count = 0;
        ListNode current = head;
        while (current != null) { //PARA RECORRER POR EL BUCLE
            if (count == index) { //VERIFICAMOS SI EL count es igual al index, si coinciden significa que hemos llegado y retornamos
                return current.voto;
            }
            count++; //PERMITE EL INCREMENTOS DE count 
            current = current.next; //PERMITE AVANZAR AL SIFUIENTE NODO
        }
        return null; //SI NO SE ENCUENTRA NADA Y SE RETORNA A NULL
    }

    /**
     * Compara un voto con los criterios de búsqueda especificados.
     *
     * @param voto El voto a comparar.
     * @param DISTRITO El distrito a comparar.
     * @param SECCION La sección a comparar.
     * @param MESA La mesa a comparar.
     * @param PARTIDO El partido a comparar.
     * @return Un valor negativo si el voto es menor, cero si son iguales y un
     * valor positivo si el voto es mayor.
     */
// Método para comparar un voto con los criterios de búsqueda especificados
    private int compararVotosBusqueda(VotoBusqueda voto, String DISTRITO, String SECCION, String MESA, String PARTIDO) { //AQUI SOLO HAY voto porque 
        //esto se compara con los CRITERIOS DE BUSQUEDA
        //QUE NOSOTROS QUERAMOS (JFrame)
        // Comparación por múltiples campos AL OBJETO voto: distrito, sección, mesa y partido
        int comparacion = voto.getDISTRITO().compareTo(DISTRITO);
        if (comparacion != 0) {
            return comparacion;
        }
        comparacion = voto.getSECCION().compareTo(SECCION);
        if (comparacion != 0) {
            return comparacion;
        }
        comparacion = voto.getMESA().compareTo(MESA);
        if (comparacion != 0) {
            return comparacion;
        }
        return voto.getPARTIDO().compareTo(PARTIDO);
    }

    @Override
    public String buscarVotos(String DISTRITO, String SECCION, String MESA, String PARTIDO) {
        // StringBuilder para almacenar los resultados de la búsqueda
        StringBuilder resultado = new StringBuilder();

        // Se inicia desde el primer nodo de la lista enlazada
        ListNode current = head;

        // Recorre la lista enlazada mientras haya nodos
        while (current != null) {
            boolean match = true; // Indica si el voto coincide con los criterios de búsqueda

            // Verifica si los criterios de búsqueda no están vacíos y si el voto actual coincide con ellos
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

            // Si el voto coincide con todos los criterios de búsqueda, se agrega al resultado
            if (match) {
                resultado.append(current.voto.toString()).append("\n");
            }

            // Se pasa al siguiente nodo en la lista enlazada
            current = current.next;
        }

        // Se devuelve una cadena con los votos que coincidieron con los criterios de búsqueda
        return resultado.toString();
    }

    // Clase privada para el nodo de la lista enlazada
    //ListNode es específica para la implementación de ConsultaVotos
    public class ListNode {

        public VotoBusqueda voto;
        public ListNode next;

        public ListNode(VotoBusqueda voto) {
            this.voto = voto;
            this.next = null;
        }
    }

    public ListNode getHead() {
        return head;
    }

    /**
     * Inserta un nuevo voto al final de la lista enlazada.
     *
     * @param voto El voto a insertar.
     */
    private void insertarAlFinal(VotoBusqueda voto) {
        if (head == null) { //VERIFICA SI LA LISTA ESTA VACIA 
            head = new ListNode(voto); //SI ES ASI SE CREA UN NUEVO NODO CON EL VOTO PROPORCIONADO
        } else {
            ListNode current = head; // NI NO ESTA VACIA SE CREA UN NODO TEMPORAL 
            while (current.next != null) { //RECORRE LA LISTA HASTA ENCONTAR EL ULTIMO NODO
                current = current.next;
            }
            current.next = new ListNode(voto);  //CUANDO LO ENCUENTRA, SE CREA UN NODO Y SE VUELVE COMO EL SIGUIENTE NODO DEL ÚLTIMO NODO
        }
    }

}
