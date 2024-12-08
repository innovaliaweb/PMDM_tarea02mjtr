package dam.pmdm.tarea2mjtr;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.splashscreen.SplashScreen;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import java.util.List;

import dam.pmdm.tarea2mjtr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura la Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        // Configura el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController);


        // Configura el Toolbar para trabajar con el NavController
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_acerca_de) {
            new AlertDialog.Builder(this)
                    .setTitle("@string/acerca_de")
                    .setMessage("@string/textoAcercaDe")
                    .setPositiveButton("@string/labelAceptar", null)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // Método para manejar el clic en un personaje
    public void personajeClicked(PersonajeData personaje, View view) {
        // Crear un Bundle para pasar los datos al PersonajeDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("nombre", personaje.getNombre());
        bundle.putString("descripcion", personaje.getDescripcion());
        bundle.putString("habilidades", personaje.getHabilidades());
        bundle.putInt("imagen", personaje.getImagen());

        // Navegar al PersonajeDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.personajeDetailFragment, bundle);
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}