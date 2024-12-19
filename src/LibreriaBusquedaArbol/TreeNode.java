package LibreriaBusquedaArbol;

//Clase que representa un nodo en un árbol binario de búsqueda.
public class TreeNode {

    // Atributo que almacena el voto en el nodo actual
    VotoBusquedaArbol voto;

    // Referencia al hijo izquierdo del nodo
    TreeNode left;

    // Referencia al hijo derecho del nodo
    TreeNode right;

    /**
     * Constructor para inicializar un nodo con un voto.
     *
     * @param voto El voto que será almacenado en el nodo.
     */
    public TreeNode(VotoBusquedaArbol voto) {
        this.voto = voto; // Asignar el voto al nodo
        this.left = null; // Inicializar la referencia al hijo izquierdo como nula
        this.right = null; // Inicializar la referencia al hijo derecho como nula
    }
}
