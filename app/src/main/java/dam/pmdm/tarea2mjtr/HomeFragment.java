package dam.pmdm.tarea2mjtr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import dam.pmdm.tarea2mjtr.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding; // No es necesario lateinit en Java, solo declaración

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inicializar binding
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // Retornar la vista raíz
        return binding.getRoot();
    }
}