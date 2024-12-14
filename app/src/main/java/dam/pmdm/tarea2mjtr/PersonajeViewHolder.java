package dam.pmdm.tarea2mjtr;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import dam.pmdm.tarea2mjtr.databinding.PersonajeCardviewBinding;

/**
 * ViewHolder personalizado para gestionar la vista de cada personaje en el RecyclerView.
 * Se encarga de enlazar los datos de un personaje con los elementos visuales correspondientes.
 */
public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    private final PersonajeCardviewBinding binding;

    /**
     * Constructor de la clase PersonajeViewHolder.
     * Inicializa el binding para acceder a los componentes de la vista.
     *
     * @param binding Objeto de enlace generado automáticamente para el diseño del cardview.
     */
    public PersonajeViewHolder(PersonajeCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Enlaza los datos de un personaje con los elementos visuales de la vista.
     * Asigna el nombre, descripción, habilidades e imagen al layout correspondiente.
     *
     * @param personaje Objeto de tipo PersonajeData que contiene los datos del personaje.
     */
    public void bind(PersonajeData personaje) {
        Picasso.get()
                .load(personaje.getImagen())
                .into(binding.imagen);
        binding.nombre.setText(personaje.getNombre());
        binding.descripcion.setText(personaje.getDescripcion());
        binding.habilidades.setText(personaje.getHabilidades());
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}
