package LibreriaBusquedaTablasHash;

public class MiListaEnlazada {

    public Nodo head;

    // Constructor que inicializa la lista enlazada vacía
    public MiListaEnlazada() {
        head = null; // Establece el nodo inicial (cabeza) como nulo, indicando una lista vacía
    }

    // Método para insertar un nuevo nodo al final de la lista
    public void insertarAlFinal(VotoBusqueda voto) {
        // Crear un nuevo nodo con el voto proporcionado
        Nodo nuevoNodo = new Nodo(voto);

        // Caso 1: La lista está vacía (head es null)
        if (head == null) {
            head = nuevoNodo; // El nuevo nodo se convierte en el primer nodo de la lista
        } else {
            // Caso 2: La lista no está vacía
            Nodo current = head;

            // Recorrer la lista hasta el último nodo
            while (current.siguiente != null) {  //Se utiliza un bucle while para encontrar el último nodo de la lista enlazada ITERACION
                current = current.siguiente;
            }

            // Agregar el nuevo nodo al final de la lista
            current.siguiente = nuevoNodo;
        }
    }

    // Método para buscar votos en la lista enlazada y retornar resultados como String
    public String buscarVotos(String DISTRITO, String SECCION, String MESA, String PARTIDO) {  // BUSCA A TRAVEZ DE FILTROS COSAS ESPECIFICAS
        StringBuilder resultado = new StringBuilder(); // StringBuilder para almacenar resultados
        Nodo current = head; // Iniciar desde el primer nodo de la lista

        // Recorrer la lista mientras haya nodos
        while (current != null) {  //Se utiliza un bucle while para recorrer todos los nodos de la lista enlazada ITERACION
            // Verificar si el voto actual coincide con los parámetros de búsqueda
            if (current.voto.coincideCon(DISTRITO, SECCION, MESA, PARTIDO)) { //SE HACE EL LLAMADO A MI METODO coincideCon
                // Si coincide, agregar la representación en cadena del voto al resultado
                resultado.append(current.voto.toString()).append("\n");
            }
            current = current.siguiente; // Avanzar al siguiente nodo
        }

        return resultado.toString(); // Devolver los resultados acumulados como String
    }

    // Clase interna Nodo para representar cada nodo de la lista enlazada
    public class Nodo {

        VotoBusqueda voto;  // Almacena el voto asociado al nodo
        Nodo siguiente;     // Referencia al siguiente nodo en la lista enlazada

        // Constructor para inicializar un nodo con un voto y siguiente nodo nulo
        public Nodo(VotoBusqueda voto) {
            this.voto = voto;      // Asigna el voto proporcionado al nodo
            this.siguiente = null; // Inicializa siguiente como nulo, indicando que no hay siguiente nodo
        }
    }

}
