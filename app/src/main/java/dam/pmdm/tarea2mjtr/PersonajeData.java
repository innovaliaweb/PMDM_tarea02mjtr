package dam.pmdm.tarea2mjtr;

/**
 * Clase que representa los datos de un personaje.
 * Contiene información como el nombre, descripción, imagen y habilidades del personaje.
 */
public class PersonajeData {

    private String nombre;
    private String descripcion;
    private int imagen;
    public String habilidades;

    /**
     * Constructor de la clase PersonajeData.
     * Inicializa los datos de un personaje.
     *
     * @param nombre Nombre del personaje.
     * @param descripcion Descripción del personaje.
     * @param imagen ID del recurso de la imagen asociada al personaje.
     * @param habilidades Habilidades del personaje.
     */
    public PersonajeData(String nombre, String descripcion, int imagen, String habilidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.habilidades = habilidades;
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return El nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripción del personaje.
     *
     * @return La descripción del personaje.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el ID del recurso de la imagen asociada al personaje.
     *
     * @return El ID del recurso de la imagen.
     */
    public int getImagen() {
        return imagen;
    }

    /**
     * Obtiene las habilidades del personaje.
     *
     * @return Las habilidades del personaje.
     */
    public String getHabilidades() {
        return habilidades;
    }
}
