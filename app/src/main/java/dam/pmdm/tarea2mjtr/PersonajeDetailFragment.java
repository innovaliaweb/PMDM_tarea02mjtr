package dam.pmdm.tarea2mjtr;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import dam.pmdm.tarea2mjtr.databinding.PersonajeDetailFragmentBinding;

/**
 * Fragmento que muestra los detalles de un personaje seleccionado.
 * Permite visualizar información como imagen, nombre, descripción y habilidades del personaje.
 */
public class PersonajeDetailFragment extends Fragment {

    private PersonajeDetailFragmentBinding binding;

    /**
     * Infla el layout correspondiente al fragmento de detalles del personaje.
     *
     * @param inflater Objeto LayoutInflater para inflar vistas en el fragmento.
     * @param container Contenedor padre al que se añadirá la vista del fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     * @return La vista raíz del fragmento.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = PersonajeDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Método llamado después de que la vista ha sido creada.
     * Recupera los argumentos enviados al fragmento y actualiza los componentes de la interfaz.
     *
     * @param view La vista raíz inflada del fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            int imagen = getArguments().getInt("imagen");
            String nombre = getArguments().getString("nombre");
            String descripcion = getArguments().getString("descripcion");
            String habilidades = getArguments().getString("habilidades");

            // Asignar los datos a los componentes
            Picasso.get()
                    .load(imagen)
                    .into(binding.imagen);
            binding.nombre.setText(nombre);
            binding.descripcion.setText(descripcion);
            binding.habilidades.setText(habilidades);
        }
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
