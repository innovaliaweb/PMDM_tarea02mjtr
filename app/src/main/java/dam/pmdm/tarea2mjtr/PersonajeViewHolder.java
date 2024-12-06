package dam.pmdm.tarea2mjtr;


import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import dam.pmdm.tarea2mjtr.databinding.PersonajeCardviewBinding;

public class PersonajeViewHolder extends RecyclerView.ViewHolder {
    private final PersonajeCardviewBinding binding;

    public PersonajeViewHolder(PersonajeCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bind (PersonajeData personaje){
        Picasso.get()
                .load(personaje.getImagen())
                .into(binding.imagen);
        binding.nombre.setText(personaje.getNombre());
        binding.descripcion.setText(personaje.getDescripcion());
        binding.habilidades.setText(personaje.getHabilidades());
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}
