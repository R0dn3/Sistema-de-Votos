package libreriaReportesArbol;

//Clase que representa un voto registrado en las elecciones.
class Voto {

    private int anio;
    private String titulo;
    private String fechaElecciones;
    private int distrito;
    private int seccion;
    private String mesa;
    private String partido;
    private int numVotos;

    //Constructor de la clase Voto, inicializa los datos del voto.
    public Voto(int anio, String titulo, String fechaElecciones, int distrito, int seccion, String mesa, String partido, int numVotos) {
        this.anio = anio;
        this.titulo = titulo;
        this.fechaElecciones = fechaElecciones;
        this.distrito = distrito;
        this.seccion = seccion;
        this.mesa = mesa;
        this.partido = partido;
        this.numVotos = numVotos;
    }

    // Métodos de acceso (getters)
    public int getAnio() {
        return anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaElecciones() {
        return fechaElecciones;
    }

    public int getDistrito() {
        return distrito;
    }

    public int getSeccion() {
        return seccion;
    }

    public String getMesa() {
        return mesa;
    }

    public String getPartido() {
        return partido;
    }

    public int getNumVotos() {
        return numVotos;
    }

    @Override
    public String toString() {
        return "ANIO: " + anio + ", TITULO: " + titulo + ", FECHA_ELECCIONES: " + fechaElecciones + ", DISTRITO: " + distrito + ", SECCION: " + seccion + ", MESA: " + mesa + ", PARTIDO: " + partido + ", NUM_VOTOS: " + numVotos;
    }
}
