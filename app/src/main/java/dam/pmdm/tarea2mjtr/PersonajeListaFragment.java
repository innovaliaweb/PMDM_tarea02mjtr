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

import dam.pmdm.tarea2mjtr.databinding.FragmentPersonajeListaBinding;

import java.util.ArrayList;

public class PersonajeListaFragment extends Fragment {

    private FragmentPersonajeListaBinding binding; // Binding para el layout
    private ArrayList<PersonajeData> personajes; // Lista de personajes
    private PersonajeRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = FragmentPersonajeListaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadPersonajes(); // Cargar los personajes (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new PersonajeRecyclerViewAdapter(personajes, getActivity());
        binding.personajesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.personajesRecyclerview.setAdapter(adapter);


    }

    // Método para cargar personajes (puedes implementar tu lógica aquí)
    private void loadPersonajes() {
        personajes = new ArrayList<PersonajeData>();
        // Llenar la lista con datos de personajes
        personajes.add(new PersonajeData("Mario","Héroe del Reino Champiñón", R.drawable.mario, "Salta alto, lanza bolas de fuego" ));
        personajes.add(new PersonajeData("Luigi", "Hermano de Mario", R.drawable.luigi,  "Salta alto, captura fantasmas"));
        personajes.add(new PersonajeData("Peach", "Princesa del Reino Champiñón", R.drawable.peach,  "Flotar, lanzar objetos"));
        personajes.add(new PersonajeData("Toad", "Habitante del Reino Champiñón", R.drawable.toad,  "Corre rápido, lanza esporas"));


    }


    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_personajes);
        }
    }
}