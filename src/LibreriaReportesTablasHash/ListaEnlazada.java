package LibreriaReportesTablasHash;

// Interfaz para una lista enlazada genérica
// Una interfaz define un contrato para implementar ciertas funcionalidades en las clases que la implementan
import java.util.Iterator;

public interface ListaEnlazada<T> extends Iterable<T> {
    // El parámetro <T> indica que la interfaz es genérica y puede trabajar con cualquier tipo de dato

    // Método para insertar un dato en la lista
    void insertar(T dato);

    // Método para verificar si la lista está vacía
    boolean estaVacia();

    // Método para ordenar la lista utilizando el algoritmo merge sort
    void mergeSort();



}
