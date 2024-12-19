package LibreriaBusquedaTablasHash;

import LibreriaBusquedaTablasHash.MiListaEnlazada.Nodo;

public class MiTablaHash {

    private MiListaEnlazada[] tabla; // Array de listas enlazadas para la tabla hash
    private int size; // Tamaño actual de la tabla hash (cantidad de elementos)
    private static final int CAPACIDAD_INICIAL = 8255; // Tamaño inicial ajustado de la tabla hash
    private static final double FACTOR_CARGA = 0.75; // Factor de carga para determinar cuándo redimensionar la tabla

    // Constructor para inicializar la tabla hash con capacidad inicial y listas enlazadas vacías
    public MiTablaHash() {
        tabla = new MiListaEnlazada[CAPACIDAD_INICIAL]; // Inicializa el array de listas enlazadas
        size = 0; // Inicializa el tamaño de la tabla a 0
        // Inicializa cada posición del array con una lista enlazada vacía
        for (int i = 0; i < CAPACIDAD_INICIAL; i++) {
            tabla[i] = new MiListaEnlazada();
        }
    }

    // Inserta un nuevo elemento en la tabla hash utilizando una clave
    public void agregar(String clave, VotoBusqueda voto) {
        int indice = hash(clave); // Calcula el índice en la tabla hash usando la función hash
        tabla[indice].insertarAlFinal(voto); // Inserta el voto en la lista enlazada correspondiente para manejar colisiones
        size++; // Aumenta el tamaño de la tabla hash

        // Comprueba si el factor de carga supera el límite y redimensiona la tabla si es necesario
        if ((double) size / tabla.length > FACTOR_CARGA) {
            redimensionar();
        }
    }

    // Método para ordenar los votos en cada lista enlazada utilizando Merge Sort
    public void ordenar() {
        for (MiListaEnlazada lista : tabla) {
            lista.head = mergeSort(lista.head); // Aplica Merge Sort a cada lista enlazada
        }
    }

    // Método recursivo para realizar Merge Sort en una lista enlazada
    private Nodo mergeSort(Nodo head) {
        // Casos base de la recursión
        if (head == null || head.siguiente == null) {
            return head;
        }

        // Encuentra el nodo medio de la lista
        Nodo medio = obtenerNodoMedio(head);
        Nodo siguienteDelMedio = medio.siguiente;
        medio.siguiente = null;

        // Llama recursivamente a mergeSort para las sublistas izquierda y derecha
        Nodo izquierda = mergeSort(head);
        Nodo derecha = mergeSort(siguienteDelMedio);

        // Combina las sublistas ordenadas utilizando la función merge
        return merge(izquierda, derecha);
    }

    // Combina dos sublistas ordenadas en una sola lista ordenada
    private Nodo merge(Nodo izquierda, Nodo derecha) {
        Nodo resultado; // Nodo que almacenará el resultado combinado
        if (izquierda == null) {
            return derecha;
        }
        if (derecha == null) {
            return izquierda;
        }

        // Compara los elementos de las sublistas y los combina en orden
        if (izquierda.voto.compareTo(derecha.voto) <= 0) {
            resultado = izquierda;
            resultado.siguiente = merge(izquierda.siguiente, derecha);
        } else {
            resultado = derecha;
            resultado.siguiente = merge(izquierda, derecha.siguiente);
        }

        return resultado;
    }

    // Encuentra el nodo medio de una lista utilizando el algoritmo de tortuga y liebre (fast-slow)
    private Nodo obtenerNodoMedio(Nodo head) {
        if (head == null) {
            return head;
        }

        Nodo lento = head, rapido = head.siguiente;
        while (rapido != null) {
            rapido = rapido.siguiente;
            if (rapido != null) {
                lento = lento.siguiente;
                rapido = rapido.siguiente;
            }
        }
        return lento;
    }

    // Busca votos en todas las listas enlazadas de la tabla hash que coincidan con los filtros proporcionados
    public String buscarVotosConFiltros(String DISTRITO, String SECCION, String MESA, String PARTIDO) {
        StringBuilder resultado = new StringBuilder(); // Crea un StringBuilder para almacenar los resultados de la búsqueda
        for (MiListaEnlazada lista : tabla) { // Itera sobre cada lista enlazada en la tabla hash
            resultado.append(lista.buscarVotos(DISTRITO, SECCION, MESA, PARTIDO)); // Agrega los resultados de búsqueda de cada lista al StringBuilder
        }
        return resultado.toString(); // Devuelve los resultados acumulados como una cadena de texto
    }

    // Redimensiona la tabla hash cuando el factor de carga supera el límite
    private void redimensionar() {
        int nuevaCapacidad = tabla.length * 2; // Duplica la capacidad de la tabla hash
        MiListaEnlazada[] nuevaTabla = new MiListaEnlazada[nuevaCapacidad]; // Crea una nueva tabla con la nueva capacidad
        for (int i = 0; i < nuevaCapacidad; i++) {
            nuevaTabla[i] = new MiListaEnlazada(); // Inicializa cada posición con una lista enlazada vacía
        }

        // Rehashing de los elementos en la nueva tabla con mayor capacidad
        for (MiListaEnlazada lista : tabla) {
            Nodo current = lista.head;
            while (current != null) {
                int nuevoIndice = Math.abs(current.voto.hashCode() % nuevaCapacidad); // Calcula el nuevo índice con la nueva función hash
                nuevaTabla[nuevoIndice].insertarAlFinal(current.voto); // Inserta el voto en la lista enlazada correspondiente en la nueva tabla
                current = current.siguiente; // Avanza al siguiente nodo en la lista actual
            }
        }
        tabla = nuevaTabla; // Asigna la nueva tabla como la tabla actual redimensionada
    }

    // Calcula el índice de la tabla hash para una clave dada utilizando su valor hash
    private int hash(String clave) {
        return Math.abs(clave.hashCode() % tabla.length); // Calcula el índice usando el valor hash de la clave y la longitud de la tabla
    }
}
