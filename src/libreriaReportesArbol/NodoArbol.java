package libreriaReportesArbol;

// Clase que representa un nodo de un árbol binario de búsqueda que almacena votos.
class NodoArbol {

    Voto voto;        // Objeto Voto almacenado en este nodo.
    NodoArbol izquierda;   // Referencia al hijo izquierdo del nodo.
    NodoArbol derecha;     // Referencia al hijo derecho del nodo.

    // Constructor de la clase Nodo, inicializa el nodo con un objeto Voto dado.
    public NodoArbol(Voto voto) {
        this.voto = voto;     // Asignar el objeto Voto al nodo.
        this.izquierda = null;  // Inicializar el hijo izquierdo como nulo.
        this.derecha = null;    // Inicializar el hijo derecho como nulo.
    }
}
