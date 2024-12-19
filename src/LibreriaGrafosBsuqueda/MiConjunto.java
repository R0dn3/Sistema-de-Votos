package LibreriaGrafosBsuqueda;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MiConjunto<T> implements Iterable<T> {
    private Nodo<T> head;

    public MiConjunto() {
        head = null;
    }

    public void add(T element) {
        if (!contains(element)) {
            Nodo<T> nuevoNodo = new Nodo<>(element);
            nuevoNodo.next = head;
            head = nuevoNodo;
        }
    }

    public boolean contains(T element) {
        Nodo<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No hay más elementos en la iteración");
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private static class Nodo<T> {
        T data;
        Nodo<T> next;

        Nodo(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
