package dam.pmdm.tarea2mjtr;

public class PersonajeData {

    private String nombre;
    private String descripcion;
    private String imagen;
    public String habilidades;

    public PersonajeData(String nombre, String descripcion, int imagen, String habilidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }
    public String getHabilidades() {
        return habilidades;
    }
}
