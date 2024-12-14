package dam.pmdm.tarea2mjtr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Actividad que muestra una pantalla de bienvenida (splash screen) al iniciar la aplicación.
 * Redirige automáticamente a la actividad principal después de un retraso.
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Método llamado al crear la actividad.
     * Muestra el diseño de la pantalla de bienvenida y configura el retraso para redirigir a la actividad principal.
     *
     * @param savedInstanceState Estado guardado de la actividad, si existe.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Retraso antes de iniciar la MainActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finaliza SplashActivity
        }, 3000); // 3 segundos
    }
}
