package LibreriaBusquedaTablasHash;

public class VotoBusqueda implements Comparable<VotoBusqueda> {

    private String ANIO;
    private String TITULO;
    private String FECHA_ELECCIONES;
    private String DISTRITO;
    private String SECCION;
    private String MESA;
    private String PARTIDO;
    private String NUM_VOTOS;

    // Constructor para inicializar todos los campos de la clase
    public VotoBusqueda(String ANIO, String TITULO, String FECHA_ELECCIONES, String DISTRITO, String SECCION, String MESA, String PARTIDO, String NUM_VOTOS) {
        this.ANIO = ANIO;
        this.TITULO = TITULO;
        this.FECHA_ELECCIONES = FECHA_ELECCIONES;
        this.DISTRITO = DISTRITO;
        this.SECCION = SECCION;
        this.MESA = MESA;
        this.PARTIDO = PARTIDO;
        this.NUM_VOTOS = NUM_VOTOS;
    }

    // Métodos getters para obtener los valores de los atributos privados
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

    // Método toString para obtener una representación textual del objeto
    @Override
    public String toString() {
        return "ANIO: " + ANIO + ", TITULO: " + TITULO + ", FECHA_ELECCIONES: " + FECHA_ELECCIONES
                + ", DISTRITO: " + DISTRITO + ", SECCION: " + SECCION + ", MESA: " + MESA
                + ", PARTIDO: " + PARTIDO + ", NUM_VOTOS: " + NUM_VOTOS;
    }
    
    // Método compareTo para comparar por el número de votos
    // encapsula la lógica de comparación directamente dentro de la clase que se está comparando
    @Override
    public int compareTo(VotoBusqueda otroVoto) {
        return Integer.compare(Integer.parseInt(this.NUM_VOTOS), Integer.parseInt(otroVoto.NUM_VOTOS));
    }

    // Método para verificar si el voto coincide con los filtros proporcionados
    public boolean coincideCon(String DISTRITO, String SECCION, String MESA, String PARTIDO) {
        if (!DISTRITO.isEmpty() && !this.DISTRITO.equals(DISTRITO)) {
            return false;
        }
        if (!SECCION.isEmpty() && !this.SECCION.equals(SECCION)) {
            return false;
        }
        if (!MESA.isEmpty() && !this.MESA.equals(MESA)) {
            return false;
        }
        if (!PARTIDO.isEmpty() && !this.PARTIDO.equals(PARTIDO)) {
            return false;
        }
        return true;
    }
}
