package LibreriaBusquedaArbol;

//Interfaz que define métodos para buscar votos en una colección.
public interface VotoCollectionArbol {

    //Busca votos en la colección en base a criterios específicos.
    String buscarVotos(String DISTRITO, String SECCION, String MESA, String PARTIDO);
}
