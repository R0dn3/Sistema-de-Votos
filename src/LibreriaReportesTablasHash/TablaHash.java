package LibreriaReportesTablasHash;

public class TablaHash<K, V> {

    private int capacidad; // Capacidad inicial de la tabla hash
    private int tamaño; // se incrementa cada vez que se añade un nuevo par clave-valor por el put
    private static final double FACTOR_CARGA_MAXIMO = 0.75; // Factor de carga máximo antes de redimensionar

    private NodoHash<K, V>[] tabla; // Arreglo generico que contiene los nodos de la tabla hash almacena referencias de mi clase NodoHash
    //actuara como la estructura principal de almacenamiento

    @SuppressWarnings("unchecked")
    public TablaHash(int capacidadInicial) {
        // Asigna la capacidad inicial proporcionada al atributo capacidad
        this.capacidad = capacidadInicial;

        // Inicializa el tamaño actual de la tabla como 0 porque aún no se han añadido elementos
        this.tamaño = 0;

        // Crea un nuevo arreglo de nodos (tabla hash) con la capacidad inicial proporcionada
        tabla = new NodoHash[capacidad]; //ignore advertencias relacionadas con operaciones de mi Arreglo generico
    }

    // Método privado para redimensionar la tabla cuando se alcanza el factor de carga máximo
    private void redimensionarTabla() {
        int nuevaCapacidad = capacidad * 2; // Duplica la capacidad actual
        NodoHash<K, V>[] nuevaTabla = new NodoHash[nuevaCapacidad]; // Crea una nueva tabla con la nueva capacidad

        // Rehashing: Reinserta todos los elementos en la nueva tabla
        for (int i = 0; i < capacidad; i++) {
            NodoHash<K, V> actual = tabla[i];
            while (actual != null) {
                K clave = actual.clave;
                V valor = actual.valor;
                int nuevoIndice = Math.abs(clave.hashCode()) % nuevaCapacidad; // Calcula el nuevo índice en la nueva tabla

                // Inserta en la nueva tabla
                if (nuevaTabla[nuevoIndice] == null) {
                    nuevaTabla[nuevoIndice] = new NodoHash<>(clave, valor);
                } else {
                    NodoHash<K, V> nodoActual = nuevaTabla[nuevoIndice];
                    while (nodoActual.siguiente != null) {
                        nodoActual = nodoActual.siguiente;
                    }
                    nodoActual.siguiente = new NodoHash<>(clave, valor);
                }

                actual = actual.siguiente;
            }
        }

        // Actualiza la tabla y la capacidad con la nueva tabla y capacidad
        tabla = nuevaTabla;
        capacidad = nuevaCapacidad;
    }

    // Método para INSERTAR un par clave-valor en la tabla hash
    //K se utiliza para calcular el índice de la tabla hash y recuperar los valores asociados. 
    //V se utiliza como el tipo del valor que se almacena y se recupera según la clave
    public void put(K clave, V valor) { 
        int indice = Math.abs(clave.hashCode()) % capacidad; // Calcula el índice de la tabla para la clave

        // Si no hay ningún nodo en el índice, crea un nuevo nodo y lo asigna
        if (tabla[indice] == null) {
            tabla[indice] = new NodoHash<>(clave, valor);
        } else {
            // Si ya hay nodos en ese índice, recorre la lista enlazada
            NodoHash<K, V> actual = tabla[indice];
            while (actual.siguiente != null) {
                // Si encuentra un nodo con la misma clave, actualiza su valor y termina
                if (actual.clave.equals(clave)) {
                    actual.valor = valor;
                    return;
                }
                // Avanza al siguiente nodo
                actual = actual.siguiente;
            }

            // Si llega al final y encuentra un nodo con la misma clave, actualiza su valor
            if (actual.clave.equals(clave)) {
                actual.valor = valor;
            } else {
                // Si no encuentra un nodo con la misma clave, añade el nuevo nodo al final de la lista enlazada
                actual.siguiente = new NodoHash<>(clave, valor);
            }
        }

        tamaño++; // Incrementa el tamaño después de agregar un elemento

        // Verifica si se necesita redimensionar la tabla
        if ((double) tamaño / capacidad >= FACTOR_CARGA_MAXIMO) {
            redimensionarTabla();
        }
    }

    // Método para BUSCAR el valor asociado a una clave en la tabla hash
    // K se utiliza para buscar el valor asociado en la tabla hash
    // V Representa el tipo de dato del valor asociado a la clave en la tabla hash
    public V get(K clave) {
        int indice = Math.abs(clave.hashCode()) % capacidad; // Calcula el índice de la tabla para la clave
        NodoHash<K, V> actual = tabla[indice]; // Obtiene el primer nodo en ese índice

        // Recorre la lista enlazada en ese índice
        while (actual != null) {
            // Si encuentra un nodo con la clave buscada, retorna su valor
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            // Avanza al siguiente nodo en la lista enlazada
            actual = actual.siguiente;
        }

        return null; // Si no encuentra la clave, retorna null
    }
}
