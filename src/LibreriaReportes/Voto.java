package LibreriaReportes;

/**
 *
 * @author familia4
 */
//FACILITA LA ORDENACION EN ESTE CASO MERGESORT
//Clase que representa un voto en una elección
public class Voto implements Comparable<Voto> {

    private int ANIO;
    private String TITULO;
    private String FECHA_ELECCIONES;
    private String DISTRITO;
    private String SECCION;
    private String MESA;
    private String PARTIDO;
    private int NUM_VOTOS;

    // Constructor de la clase Voto
    public Voto(int ANIO, String TITULO, String FECHA_ELECCIONES, String DISTRITO, String SECCION, String MESA, String PARTIDO, int NUM_VOTOS) {
        this.ANIO = ANIO;
        this.TITULO = TITULO;
        this.FECHA_ELECCIONES = FECHA_ELECCIONES;
        this.DISTRITO = DISTRITO;
        this.SECCION = SECCION;
        this.MESA = MESA;
        this.PARTIDO = PARTIDO;
        this.NUM_VOTOS = NUM_VOTOS;
    }

    public int getANIO() {
        return ANIO;
    }

    public void setANIO(int ANIO) {
        this.ANIO = ANIO;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String TITULO) {
        this.TITULO = TITULO;
    }

    public String getFECHA_ELECCIONES() {
        return FECHA_ELECCIONES;
    }

    public void setFECHA_ELECCIONES(String FECHA_ELECCIONES) {
        this.FECHA_ELECCIONES = FECHA_ELECCIONES;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public void setDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
    }

    public String getSECCION() {
        return SECCION;
    }

    public void setSECCION(String SECCION) {
        this.SECCION = SECCION;
    }

    public String getMESA() {
        return MESA;
    }

    public void setMESA(String MESA) {
        this.MESA = MESA;
    }

    public String getPARTIDO() {
        return PARTIDO;
    }

    public void setPARTIDO(String PARTIDO) {
        this.PARTIDO = PARTIDO;
    }

    public int getNUM_VOTOS() {
        return NUM_VOTOS;
    }

    public void setNUM_VOTOS(int NUM_VOTOS) {
        this.NUM_VOTOS = NUM_VOTOS;
    }

    @Override
    //devuelve una cadena que contiene información sobre todos los atributos de un objeto Voto, esto se vera en el TXTAREA
    public String toString() {
        return "ANIO: " + ANIO + ", TITULO: " + TITULO + ", FECHA_ELECCIONES: " + FECHA_ELECCIONES
                + ", DISTRITO: " + DISTRITO + ", SECCION: " + SECCION + ", MESA: " + MESA
                + ", PARTIDO: " + PARTIDO + ", NUM_VOTOS: " + NUM_VOTOS;
    }

    @Override
    //ESCOGER EL ANIO FUE ELECCION EN ESTE CASO POR EL AÑO EN QUE SE LLEVA LAS ELECCIONES
    //Método de comparación para permitir la ordenación de votos
    public int compareTo(Voto otroVoto) {
        // Implementa la lógica de comparación aquí
        // Por ejemplo, podrías comparar por año, distrito, etc.
        // En este caso, compara por año de elecciones
        return Integer.compare(this.ANIO, otroVoto.getANIO());
    }
}
