package dam.pmdm.tarea2mjtr;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import java.util.List;

import dam.pmdm.tarea2mjtr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        // Configura el NavController
//        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController);

    }

    // Método para manejar el clic en un personaje
    public void gameClicked(PersonajeData personaje, View view) {
        // Crear un Bundle para pasar los datos al PersonajeDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("nombre", personaje.getNombre());
        bundle.putString("descripcion", personaje.getDescripcion());
        bundle.putString("habilidades", personaje.getHabilidades());
        bundle.putString("imagen", personaje.getImagen());

        // Navegar al PersonajeDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.personaje_detail_fragment, bundle);
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}