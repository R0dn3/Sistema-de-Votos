package libreriaReportesArbol;

/**
 * Clase que representa un nodo de una lista enlazada que almacena votos.
 */
class NodoLista {

    Voto voto;            // Objeto Voto almacenado en este nodo.
    NodoLista siguiente;  // Referencia al siguiente nodo en la lista.

    /**
     * Constructor de la clase NodoLista, inicializa el nodo con un objeto Voto dado.
     *
     * @param voto El objeto Voto que se almacenará en este nodo.
     */
    public NodoLista(Voto voto) {
        this.voto = voto;     // Asignar el objeto Voto al nodo.
        this.siguiente = null;  // Inicializar la referencia al siguiente nodo como nula.
    }
}
