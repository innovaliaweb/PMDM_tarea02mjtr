package dam.pmdm.tarea2mjtr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import dam.pmdm.tarea2mjtr.databinding.PersonajeCardviewBinding;

import android.view.View;

/**
 * Adaptador personalizado para gestionar la lista de personajes en un RecyclerView.
 * Permite enlazar los datos de los personajes con la vista correspondiente.
 */
public class PersonajeRecyclerViewAdapter extends RecyclerView.Adapter<PersonajeViewHolder> {

    private final ArrayList<PersonajeData> personajes; // Lista de personajes a mostrar
    private final Context context; // Contexto de la actividad o fragmento

    /**
     * Constructor del adaptador.
     *
     * @param personajes Lista de personajes a mostrar.
     * @param context Contexto de la actividad o fragmento.
     */
    public PersonajeRecyclerViewAdapter(ArrayList<PersonajeData> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }

    /**
     * Crea una nueva instancia del ViewHolder para el RecyclerView.
     *
     * @param parent Vista padre a la que se añadirá el ViewHolder.
     * @param viewType Tipo de vista (no utilizado aquí).
     * @return Una instancia de PersonajeViewHolder.
     */
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonajeCardviewBinding binding = PersonajeCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new PersonajeViewHolder(binding);
    }

    /**
     * Enlaza los datos del personaje con el ViewHolder correspondiente.
     *
     * @param holder ViewHolder donde se mostrarán los datos.
     * @param position Posición del personaje en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        PersonajeData currentPersonaje = this.personajes.get(position);
        holder.bind(currentPersonaje);

        // Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentPersonaje, view));
    }

    /**
     * Devuelve el número total de personajes en la lista.
     *
     * @return El número de personajes en la lista.
     */
    @Override
    public int getItemCount() {
        return personajes.size();
    }

    /**
     * Maneja el evento de clic en un elemento de la lista.
     * Llama al método correspondiente de MainActivity para realizar la navegación.
     *
     * @param currentPersonaje El personaje seleccionado.
     * @param view La vista que fue clicada.
     */
    private void itemClicked(PersonajeData currentPersonaje, View view) {
        // Llama a la función personajeClicked de MainActivity, pasando la vista
        ((MainActivity) context).personajeClicked(currentPersonaje, view);
    }
}
