package libreriaReportesArbol;

// Clase que representa una lista de votos implementada como una lista enlazada simple.
class ListaVotos {

    private NodoLista cabeza; // Nodo inicial de la lista de votos.
    private NodoLista cola;   // Nodo final de la lista de votos.

    // Constructor de la clase ListaVotos, inicializa la cabeza y la cola como nulas.
    public ListaVotos() {
        this.cabeza = null;
        this.cola = null;
    }

    // Método para agregar un nuevo voto al final de la lista.
    public void agregarVoto(Voto voto) {
        NodoLista nuevoNodo = new NodoLista(voto); // Crear un nuevo nodo con el voto dado.

        // Si la lista está vacía, el nuevo nodo se convierte tanto en la cabeza como en la cola.
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo; // Conectar el nuevo nodo al final de la lista actual.
            cola = nuevoNodo;           // Actualizar la cola para que sea el nuevo nodo.
        }
    }

    // Método para obtener el nodo inicial (cabeza) de la lista de votos.
    public NodoLista getCabeza() {
        return cabeza;
    }
}
