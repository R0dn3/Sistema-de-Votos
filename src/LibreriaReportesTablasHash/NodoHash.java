package LibreriaReportesTablasHash;

// Clase que representa un nodo en una tabla hash.
class NodoHash<K, V> {

    // La clave es inmutable, por eso es 'final' nodo no cambie
    // se utiliza para indexar y buscar elementos en la tabla hash
    final K clave;

    // El valor asociado a la clave, pued modifi
    // representa el tipo del valor asociado a esa clave                                                                                                                                                                                                                                 
    V valor;
    // El siguiente nodo en la lista enlazada (para manejar colisiones)
    // Se usa un enfoque de encademiento 
    // Cada nodo puede tener una referencia (siguiente) a otro nodo de la misma posición en la tabla hash. 
    // Esto permite almacenar múltiples elementos que tienen el mismo índice hash (colisión) en una lista enlazada dentro de la tabla hash.
    NodoHash<K, V> siguiente;

    // Constructor que inicializa el nodo con una clave y un valor.
    NodoHash(K clave, V valor) {
        this.clave = clave;    
        this.valor = valor;    
        this.siguiente = null; // Inicializa la referencia al siguiente nodo como nula
    }
}
