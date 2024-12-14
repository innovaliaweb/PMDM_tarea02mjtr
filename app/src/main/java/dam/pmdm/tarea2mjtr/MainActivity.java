package dam.pmdm.tarea2mjtr;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.splashscreen.SplashScreen;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.snackbar.Snackbar;

import dam.pmdm.tarea2mjtr.databinding.ActivityMainBinding;

/**
 * Clase principal de la aplicación.
 * Gestiona la navegación entre fragmentos, la interacción con el menú lateral y
 * proporciona la estructura base de la interfaz principal de la aplicación.
 */

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;

    /**
     * Método llamado al iniciar la actividad.
     * Configura la navegación, el menú lateral y muestra un mensaje de bienvenida.
     *
     * @param savedInstanceState Estado guardado de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);

        // Inflar el layout con ViewBinding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar Toolbar
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);



        // Configurar NavController
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        // Configurar AppBar con NavigationUI
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setOpenableLayout(binding.drawerLayout)
                .build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);




        // Configurar DrawerToggle
        configureToggleMenu();


        // Configurar NavigationView
        configureNavigation();


        // Listener para cambios en la vista
        navController.addOnDestinationChangedListener(this::onChangeView);

        // Mostrar Snackbar al cargar la lista de elementos
        binding.getRoot().post(() -> Snackbar.make(binding.getRoot(), "Bienvenidos al mundo de Mario", Snackbar.LENGTH_LONG).show());


    }
    /**
     * Configura el menú hamburguesa para sincronizarlo con el DrawerLayout.
     */
    public void configureToggleMenu() {
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
     * Maneja los clics de los elementos del menú lateral.
     */
    private void configureNavigation() {
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Manejar la selección de elementos del menú

        binding.navView.setNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.nav_home) {
                navController.navigate(R.id.listadoPersonajes);
            } else if (menuItem.getItemId() == R.id.nav_ajustes) {
                navController.navigate(R.id.settings_layout);
            } else if (menuItem.getItemId() == R.id.action_acerca_de) {
                mostrarAcercaDialog();
            }

            binding.drawerLayout.closeDrawers(); // Cerrar el menú lateral
            return true;
        });


    }

    /**
     * Listener que maneja los cambios de vistas durante la navegación.
     * Actualiza el título del ActionBar y el ícono del menú según el fragmento actual.
     *
     * @param navController Controlador de navegación.
     * @param navDestination Destino actual de la navegación.
     * @param bundle Argumentos pasados al fragmento actual.
     */
    void onChangeView(NavController navController, NavDestination navDestination, Bundle bundle) {
        if (toggle == null || getSupportActionBar() == null) return;


        if (navDestination.getId() == R.id.listadoPersonajes) {
            // Fragmento principal: habilita el menú hamburguesa
            toggle.setDrawerIndicatorEnabled(true);
            getSupportActionBar().setTitle(R.string.lista_de_personajes);
        } else {
            // Fragmentos secundarios: habilita el botón de retroceso
            toggle.setDrawerIndicatorEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(navDestination.getLabel());
        }

        // Sincroniza el estado
        toggle.syncState();
    }








    /**
     * Muestra un diálogo informativo sobre la aplicación.
     */
    private void mostrarAcercaDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.acerca_de)
                .setMessage(R.string.textoAcercaDe)
                .setPositiveButton(R.string.labelAceptar, null)
                .show();
    }

    /**
     * Navega al fragmento de detalles del personaje.
     * Pasa los datos del personaje seleccionado como argumentos al fragmento.
     *
     * @param personaje Objeto que contiene los datos del personaje seleccionado.
     * @param view Vista desde donde se realiza la navegación.
     */
    public void personajeClicked(PersonajeData personaje, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("nombre", personaje.getNombre());
        bundle.putString("descripcion", personaje.getDescripcion());
        bundle.putString("habilidades", personaje.getHabilidades());
        bundle.putInt("imagen", personaje.getImagen());

        Navigation.findNavController(view).navigate(R.id.detallePersonajes, bundle);
    }

    /**
     * Gestiona la navegación hacia arriba (botón de retroceso).
     *
     * @return `true` si la navegación fue exitosa, `false` de lo contrario.
     */
    @Override
    public boolean onSupportNavigateUp() {

       return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();

    }

    /**
     * Maneja la interacción con el botón del menú lateral.
     *
     * @param item Elemento seleccionado en el menú.
     * @return `true` si el evento fue manejado, `false` de lo contrario.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle != null && toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
