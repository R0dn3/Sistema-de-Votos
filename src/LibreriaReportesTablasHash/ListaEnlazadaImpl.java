package LibreriaReportesTablasHash;

import java.util.Iterator;

// Implementación de una lista enlazada genérica
//ListaEnlazadaImpl es la lista enlazada
public class ListaEnlazadaImpl<T extends Comparable<T>> implements ListaEnlazada<T> {

    private Nodo<T> primero; // Primer nodo de la lista
    private int tamaño; // Tamaño de la lista

    // Constructor de la lista enlazada
    public ListaEnlazadaImpl() {
        primero = null; // Inicializa el primer nodo como nulo
        tamaño = 0; // Inicializa el tamaño de la lista como cero
    }

    // Clase interna Nodo que representa un nodo en la lista enlazada
    // NO es exclusiva
    public class Nodo<T> {

        public T dato; // Dato almacenado en el nodo
        public Nodo<T> siguiente; // Referencia al siguiente nodo en la lista

        // Constructor de la clase Nodo
        public Nodo(T dato) {
            this.dato = dato; // Asigna el dato al nodo
            this.siguiente = null; // Inicializa la referencia al siguiente nodo como nulo
        }
    }

    // Método para insertar un nuevo dato en la lista en orden ascendente
    // Más simple de implementar y entender 
    // Este método de inserción es crucial para mantener la lista ordenada para el correcto funcionamiento del algoritmo de ordenación mergeSort
    @Override
    public void insertar(T dato) {
        // Crea un nuevo nodo con el dato proporcionado
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        // Si la lista está vacía o el dato es menor que el dato del primer nodo
        if (estaVacia() || dato.compareTo(primero.dato) < 0) {
            nuevoNodo.siguiente = primero; // El nuevo nodo apunta al primer nodo actual
            primero = nuevoNodo; // El primer nodo ahora es el nuevo nodo
        } else {
            Nodo<T> actual = primero;
            // Busca la posición correcta para insertar el nuevo nodo
            while (actual.siguiente != null && dato.compareTo(actual.siguiente.dato) > 0) {
                actual = actual.siguiente; // Avanza al siguiente nodo
            }
            nuevoNodo.siguiente = actual.siguiente; // El nuevo nodo apunta al siguiente nodo del actual
            actual.siguiente = nuevoNodo; // El nodo actual apunta al nuevo nodo
        }
        tamaño++; // Incrementa el tamaño de la lista
    }

    // Método para verificar si la lista está vacía
    @Override
    public boolean estaVacia() {
        return primero == null; // Retorna true si el primer nodo es nulo
    }

    // Método para obtener un iterador sobre los elementos de la lista
    @Override
    public Iterator<T> iterator() {
        return new IteradorLista<>(primero); // Retorna una nueva instancia de IteradorLista
    }

    // Clase interna IteradorLista que implementa la interfaz Iterator
    private class IteradorLista<T> implements Iterator<T> {

        private Nodo<T> actual; // Nodo actual del iterador

        // Constructor de la clase IteradorLista
        public IteradorLista(Nodo<T> primero) {
            actual = primero; // Inicializa el nodo actual con el primer nodo de la lista
        }

        // Método para verificar si hay un siguiente elemento en la lista
        @Override
        public boolean hasNext() {
            return actual != null; // Retorna true si el nodo actual no es nulo
        }

        // Método para obtener el siguiente elemento de la lista
        @Override
        public T next() {
            T dato = actual.dato; // Obtiene el dato del nodo actual
            actual = actual.siguiente; // Avanza al siguiente nodo
            return dato; // Retorna el dato del nodo actual
        }
    }

    // Método para ordenar la lista utilizando el algoritmo de merge sort
    @Override
    public void mergeSort() {
        if (tamaño <= 1) {
            return; // Si el tamaño de la lista es 0 o 1, ya está ordenada, por lo que retorna
        }

        // Se divide la lista en dos partes
        ListaEnlazadaImpl<T> left = new ListaEnlazadaImpl<>();
        ListaEnlazadaImpl<T> right = new ListaEnlazadaImpl<>();
        Nodo<T> current = primero;
        int mid = tamaño / 2;
        int count = 0;
        while (current != null) {
            if (count < mid) {
                left.insertar(current.dato); // Se inserta el dato en la lista izquierda
            } else {
                right.insertar(current.dato); // Se inserta el dato en la lista derecha
            }
            current = current.siguiente; // Se avanza al siguiente nodo
            count++;
        }

        // Se aplica merge sort recursivamente en ambas sublistas
        left.mergeSort();
        right.mergeSort();

        // Se mezclan las sublistas ordenadas
        merge(left, right);
    }

    // Método privado para mezclar dos sublistas ordenadas
    private void merge(ListaEnlazadaImpl<T> left, ListaEnlazadaImpl<T> right) {
        Nodo<T> leftCurrent = left.primero; // Nodo actual de la lista izquierda
        Nodo<T> rightCurrent = right.primero; // Nodo actual de la lista derecha
        Nodo<T> mergedCurrent = null; // Nodo actual de la lista mezclada

        // Se selecciona el primer nodo de la lista izquierda o derecha como nodo inicial de la lista mezclada
        if (leftCurrent != null && (rightCurrent == null || leftCurrent.dato.compareTo(rightCurrent.dato) <= 0)) {
            primero = leftCurrent;
            leftCurrent = leftCurrent.siguiente;
        } else if (rightCurrent != null) {
            primero = rightCurrent;
            rightCurrent = rightCurrent.siguiente;
        }

        mergedCurrent = primero; // El primer nodo de la lista mezclada es el nodo actual

        // Se recorren ambas sublistas ordenadas y se van seleccionando los nodos menores para agregar a la lista mezclada
        while (leftCurrent != null && rightCurrent != null) {
            if (leftCurrent.dato.compareTo(rightCurrent.dato) <= 0) {
                mergedCurrent.siguiente = leftCurrent; // Se agrega el nodo de la lista izquierda a la lista mezclada
                leftCurrent = leftCurrent.siguiente; // Se avanza al siguiente nodo de la lista izquierda
            } else {
                mergedCurrent.siguiente = rightCurrent; // Se agrega el nodo de la lista derecha a la lista mezclada
                rightCurrent = rightCurrent.siguiente; // Se avanza al siguiente nodo de la lista derecha
            }
            mergedCurrent = mergedCurrent.siguiente; // Se avanza al siguiente nodo de la lista mezclada
        }

        // Se agregan los nodos restantes de la lista izquierda o derecha a la lista mezclada
        if (leftCurrent != null) {
            mergedCurrent.siguiente = leftCurrent;
        } else if (rightCurrent != null) {
            mergedCurrent.siguiente = rightCurrent;
        }
    }

}
