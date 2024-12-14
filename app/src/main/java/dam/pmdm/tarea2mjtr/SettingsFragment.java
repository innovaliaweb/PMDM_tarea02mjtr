package dam.pmdm.tarea2mjtr;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import java.util.Locale;

/**
 * Fragmento de configuración de la aplicación.
 * Permite al usuario cambiar el idioma de la interfaz y guarda las preferencias.
 */
public class SettingsFragment extends Fragment {

    /**
     * Constructor predeterminado.
     * Inicializa el fragmento con el layout correspondiente.
     */
    public SettingsFragment() {
        super(R.layout.fragment_settings);
    }

    /**
     * Método llamado cuando la vista del fragmento ha sido creada.
     * Configura el interruptor para cambiar de idioma y carga las preferencias guardadas.
     *
     * @param view Vista raíz inflada del fragmento.
     * @param savedInstanceState Estado guardado del fragmento, si existe.
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener el Switch desde el diseño
        SwitchCompat idiomasSwitch = view.findViewById(R.id.switch_idiomas);

        // Configurar SharedPreferences
        SharedPreferences preferences = requireActivity().getSharedPreferences("AppPrefs", getContext().MODE_PRIVATE);

        // Cargar preferencia guardada
        boolean isEnglish = preferences.getBoolean("idioma", false);
        idiomasSwitch.setChecked(isEnglish);

        // Guardar preferencia al cambiar el idioma
        idiomasSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked != isEnglish) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("idioma", isChecked);
                editor.apply();

                // Cambiar el idioma dinámicamente
                setIdioma(isChecked ? "en" : "es");
            }
        });
    }

    /**
     * Cambia el idioma de la aplicación de manera dinámica.
     * Actualiza la configuración de la aplicación y guarda la preferencia.
     *
     * @param lang Código del idioma (e.g., "en" para inglés o "es" para español).
     */
    private void setIdioma(String lang) {
        // Cambiar la configuración del idioma
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);

        requireContext().getResources().updateConfiguration(config, requireContext().getResources().getDisplayMetrics());

        // Guardar el idioma seleccionado
        SharedPreferences preferences = requireActivity().getSharedPreferences("AppPrefs", requireContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("language", lang);
        editor.apply();

        // Sincronizar el estado del ActionBar si es necesario
        if (requireActivity() instanceof MainActivity) {
            ((MainActivity) requireActivity()).configureToggleMenu(); // Asegura que el toggle esté sincronizado
        }

        // Recrear la actividad para reflejar el cambio de idioma
        requireActivity().recreate();
    }
}
