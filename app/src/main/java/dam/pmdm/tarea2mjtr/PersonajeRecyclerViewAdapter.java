package dam.pmdm.tarea2mjtr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import dam.pmdm.tarea2mjtr.databinding.PersonajeRecyclerViewAdapterBinding;
import android.view.View;

public abstract class PersonajeRecyclerViewAdapter  extends RecyclerView.Adapter<PersonajeViewHolder> {

    private final ArrayList<PersonajeData> personajes;
    private final Context context;

    public PersonajeRecyclerViewAdapter(ArrayList<PersonajeData> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }
    // Método que crea el ViewHolder
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonajeRecyclerViewAdapterBinding binding = PersonajeRecyclerViewAdapterBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new PersonajeViewHolder(binding);
    }

    //    Método para enlazar datos con ek ViewHolder
    @Override
    public void onBindViewHolder(@NonNull personajeViewHolder holder, int position) {
        PersonajeData currentPersonaje = this.personajes.get(position);
        holder.bind(currentPersonaje);

        //        Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentPersonaje, view));
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    private void itemClicked(PersonajeItem currentPersonaje, View view) {
        // Llama a la función gameClicked de MainActivity, pasando la vista
        ((MainActivity) context).gameClicked(currentPersonaje, view);
    }
}
