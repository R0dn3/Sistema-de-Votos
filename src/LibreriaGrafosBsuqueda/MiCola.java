package LibreriaGrafosBsuqueda;

public class MiCola<T> {
    private Nodo<T> head;
    private Nodo<T> tail;

    public MiCola() {
        head = null;
        tail = null;
    }

    public void add(T element) {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        if (tail == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            tail.next = nuevoNodo;
            tail = nuevoNodo;
        }
    }

    public T poll() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return head == null;
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