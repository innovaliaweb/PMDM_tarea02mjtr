package dam.pmdm.tarea2mjtr;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dam.pmdm.tarea2mjtr.databinding.PersonajeListFragmentBinding;

import java.util.ArrayList;

/**
 * Fragmento que muestra una lista de personajes.
 * Utiliza un RecyclerView para visualizar los datos de los personajes.
 */
public class PersonajeListaFragment extends Fragment {

    private PersonajeListFragmentBinding binding; // Binding para el layout
    private ArrayList<PersonajeData> personajes; // Lista de personajes
    private PersonajeRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    /**
     * Infla el layout correspondiente al fragmento de la lista de personajes.
     *
     * @param inflater Objeto LayoutInflater para inflar vistas en el fragmento.
     * @param container Contenedor padre al que se añadirá la vista del fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     * @return La vista raíz del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = PersonajeListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Método llamado después de que la vista ha sido creada.
     * Configura el RecyclerView con los datos de los personajes.
     *
     * @param view La vista raíz inflada del fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadPersonajes(); // Cargar los personajes

        // Configurar el RecyclerView
        adapter = new PersonajeRecyclerViewAdapter(personajes, getActivity());
        binding.personajesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.personajesRecyclerview.setAdapter(adapter);
    }

    /**
     * Método para inicializar y cargar los datos de los personajes.
     * Aquí se define una lista predefinida de personajes.
     */
    private void loadPersonajes() {
        personajes = new ArrayList<>();
        // Llenar la lista con datos de personajes
        personajes.add(new PersonajeData("Mario", "Héroe del Reino Champiñón", R.drawable.mario, "Salta alto, lanza bolas de fuego"));
        personajes.add(new PersonajeData("Luigi", "Hermano de Mario", R.drawable.luigi, "Salta alto, captura fantasmas"));
        personajes.add(new PersonajeData("Peach", "Princesa del Reino Champiñón", R.drawable.peach, "Flotar, lanzar objetos"));
        personajes.add(new PersonajeData("Toad", "Habitante del Reino Champiñón", R.drawable.toad, "Corre rápido, lanza esporas"));
    }

    /**
     * Método llamado cuando el fragmento pasa al estado de "visible".
     * Cambia el título del ActionBar al título correspondiente.
     */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_de_personajes);
        }
    }
}
