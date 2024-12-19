package LibreriaRegistro;

public class Votos {

    //Clase que representa un voto con los campos relevantes para la búsqueda.
    private String ANIO;
    private String TITULO;
    private String FECHA_ELECCIONES;
    private String DISTRITO;
    private String SECCION;
    private String MESA;
    private String PARTIDO;
    private String NUM_VOTOS;

    public Votos(String ANIO, String TITULO, String FECHA_ELECCIONES, String DISTRITO, String SECCION, String MESA, String PARTIDO, String NUM_VOTOS) {
        this.ANIO = ANIO;
        this.TITULO = TITULO;
        this.FECHA_ELECCIONES = FECHA_ELECCIONES;
        this.DISTRITO = DISTRITO;
        this.SECCION = SECCION;
        this.MESA = MESA;
        this.PARTIDO = PARTIDO;
        this.NUM_VOTOS = NUM_VOTOS;
    }

    //Métodos getters para acceder a los campos del voto, SE DISEÑARON PARA SER INMUTABLES (NO MODIFI)
    public String getANIO() {
        return ANIO;
    }

    public String getTITULO() {
        return TITULO;
    }

    public String getFECHA_ELECCIONES() {
        return FECHA_ELECCIONES;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public String getSECCION() {
        return SECCION;
    }

    public String getMESA() {
        return MESA;
    }

    public String getPARTIDO() {
        return PARTIDO;
    }

    public String getNUM_VOTOS() {
        return NUM_VOTOS;
    }

}
