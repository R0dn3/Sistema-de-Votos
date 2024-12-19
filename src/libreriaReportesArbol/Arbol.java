/*
 * Esta clase representa un árbol binario de búsqueda que almacena votos.
 */
package libreriaReportesArbol;

//Esta clase representa un árbol binario de búsqueda que almacena votos.
public class Arbol {

    private NodoArbol raiz; //declara una variable privada llamada raiz que almacena la raíz del árbol, utilizando nodos del tipo Nodo

    //Constructor de la clase Arbol, inicializa la raíz como nula.
    public Arbol() {
        this.raiz = null;
    }

    //Método para insertar un voto en el árbol.
    public void insertar(Voto voto) {
        raiz = insertarRec(raiz, voto);
    }

    //Método recursivo para insertar un voto en el árbol
    //Se hace busqueda
    private NodoArbol insertarRec(NodoArbol raiz, Voto voto) {
        if (raiz == null) {
            raiz = new NodoArbol(voto); // Crear un nuevo nodo si la raíz es nula.
            return raiz;
        }

        // Comparar y colocar el voto en el subárbol izquierdo o derecho según distrito y sección.
        if (voto.getDistrito() < raiz.voto.getDistrito()) {
            raiz.izquierda = insertarRec(raiz.izquierda, voto); // Insertar en el subárbol izquierdo.
        } else if (voto.getDistrito() > raiz.voto.getDistrito()) {
            raiz.derecha = insertarRec(raiz.derecha, voto); // Insertar en el subárbol derecho.
        } else { // Si los distritos son iguales, comparar por sección.
            if (voto.getSeccion() < raiz.voto.getSeccion()) {
                raiz.izquierda = insertarRec(raiz.izquierda, voto); // Insertar en el subárbol izquierdo.
            } else {
                raiz.derecha = insertarRec(raiz.derecha, voto); // Insertar en el subárbol derecho.
            }
        }
        return raiz; // Devolver la raíz actualizada.
    }

    //Método para obtener una lista de votos según los criterios de búsqueda.
    //Se hace busqueda
    public ListaVotos obtenerVotos(Integer distrito, Integer seccion, String mesa) {
        ListaVotos listaVotos = new ListaVotos(); // Inicializar una nueva lista de votos.
        obtenerVotosRec(raiz, distrito, seccion, mesa, listaVotos); // Llamar al método recursivo para obtener votos.
        return listaVotos; // Devolver la lista de votos resultante.Una ListaVotos que contiene los votos que cumplen con los criterios de búsqueda.
    }

    //Método recursivo para obtener votos que coinciden con los criterios de búsqueda.
    private void obtenerVotosRec(NodoArbol nodo, Integer distrito, Integer seccion, String mesa, ListaVotos listaVotos) {
        if (nodo != null) {
            // Verificar si el voto cumple con los criterios de búsqueda.
            boolean distritoValido = (distrito == null || nodo.voto.getDistrito() == distrito.intValue()); //distrito El distrito del voto (puede ser null 
            //para no filtrar por distrito).
            boolean seccionValida = (seccion == null || nodo.voto.getSeccion() == seccion.intValue());
            boolean mesaValida = (mesa == null || nodo.voto.getMesa().equalsIgnoreCase(mesa));

            // Si el voto cumple con los criterios, agregarlo a la lista de votos.
            if (distritoValido && seccionValida && mesaValida) {
                listaVotos.agregarVoto(nodo.voto); //listaVotos La lista donde se agregarán los votos que cumplen con los criterios.
            }

            // Llamar recursivamente para el subárbol izquierdo y derecho.
            obtenerVotosRec(nodo.izquierda, distrito, seccion, mesa, listaVotos);
            obtenerVotosRec(nodo.derecha, distrito, seccion, mesa, listaVotos);
        }
    }


    //Método para realizar un recorrido inorder del árbol.
    //Imprime los votos en orden ascendente según el distrito, sección, mesa y partido.
    public void inorden() {
        inordenRec(raiz); // Llamar al método recursivo para recorrido inorder.
    }

    //Método recursivo para realizar un recorrido inorder del árbol.
    public void inordenRec(NodoArbol nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierda); // Visita el subárbol izquierdo.
            System.out.println(nodo.voto); // Imprime el voto del nodo actual.
            inordenRec(nodo.derecha); // Visita el subárbol derecho.
        }
    }
}
