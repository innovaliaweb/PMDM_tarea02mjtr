package dam.pmdm.tarea2mjtr;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.splashscreen.SplashScreen;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import dam.pmdm.tarea2mjtr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Mostrar pantalla de splash
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        // Inflar el layout principal con ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar la Toolbar
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        // Configurar DrawerLayout y NavigationView
        DrawerLayout drawerLayout = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configurar NavController
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        // Configurar AppBar con NavigationUI
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setOpenableLayout(drawerLayout)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Listener para cambios en la vista del NavController
        //navController.addOnDestinationChangedListener(this::onChangeView);

        // Cargar el fragmento inicial solo si es necesario
//        if (savedInstanceState == null) {
//            navController.navigate(R.id.listadoPersonajes);
//        }

        // Configurar ActionBarDrawerToggle
        configureToggleMenu();

        // Configurar navegación del NavigationView
        configureNavigation(navigationView, drawerLayout);
    }

    /**
     * Cambia el estado del icono del menú según la pantalla actual.
     */
    private void onChangeView(NavController navController, NavDestination navDestination, Bundle bundle) {
        if (toggle == null) return;

        if (navDestination.getId() == R.id.personaje_detail_fragment) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(R.string.personaje_detail_title);
            }
            toggle.setDrawerIndicatorEnabled(false);
        } else {
            toggle.setDrawerIndicatorEnabled(true);
        }
    }

    /**
     * Configura el ActionBarDrawerToggle.
     */
    private void configureToggleMenu() {
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.abrir_menu,
                R.string.cerrar_menu
        );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    /**
     * Configura la navegación del NavigationView.
     */
    private void configureNavigation(NavigationView navigationView, DrawerLayout drawerLayout) {
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.action_acerca_de) {
                mostrarAcercaDialog();
            } else if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.listadoPersonajes);
            }

            drawerLayout.closeDrawers(); // Cerrar el menú lateral
            return true;
        });
    }

    /**
     * Muestra un diálogo con la información de "Acerca de".
     */
    private void mostrarAcercaDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.acerca_de)
                .setMessage(R.string.textoAcercaDe)
                .setPositiveButton(R.string.labelAceptar, null)
                .show();
    }

    /**
     * Navegación al fragmento de detalles del personaje.
     */
    public void personajeClicked(PersonajeData personaje, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("nombre", personaje.getNombre());
        bundle.putString("descripcion", personaje.getDescripcion());
        bundle.putString("habilidades", personaje.getHabilidades());
        bundle.putInt("imagen", personaje.getImagen());

        Navigation.findNavController(view).navigate(R.id.detallePersonajes, bundle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejar clics en el icono del menú
        if (toggle != null && toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
