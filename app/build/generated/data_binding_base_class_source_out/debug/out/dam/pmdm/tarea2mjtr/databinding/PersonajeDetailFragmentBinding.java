// Generated by view binder compiler. Do not edit!
package dam.pmdm.tarea2mjtr.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dam.pmdm.tarea2mjtr.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PersonajeDetailFragmentBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextView descripcion;

  @NonNull
  public final TextView descripcionLabel;

  @NonNull
  public final TextView habilidades;

  @NonNull
  public final TextView habilidadesLabel;

  @NonNull
  public final ImageView imagen;

  @NonNull
  public final TextView nombre;

  @NonNull
  public final LinearLayout personajeDetailFragment;

  private PersonajeDetailFragmentBinding(@NonNull ScrollView rootView,
      @NonNull TextView descripcion, @NonNull TextView descripcionLabel,
      @NonNull TextView habilidades, @NonNull TextView habilidadesLabel, @NonNull ImageView imagen,
      @NonNull TextView nombre, @NonNull LinearLayout personajeDetailFragment) {
    this.rootView = rootView;
    this.descripcion = descripcion;
    this.descripcionLabel = descripcionLabel;
    this.habilidades = habilidades;
    this.habilidadesLabel = habilidadesLabel;
    this.imagen = imagen;
    this.nombre = nombre;
    this.personajeDetailFragment = personajeDetailFragment;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static PersonajeDetailFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PersonajeDetailFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.personaje_detail_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PersonajeDetailFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.descripcion;
      TextView descripcion = ViewBindings.findChildViewById(rootView, id);
      if (descripcion == null) {
        break missingId;
      }

      id = R.id.descripcionLabel;
      TextView descripcionLabel = ViewBindings.findChildViewById(rootView, id);
      if (descripcionLabel == null) {
        break missingId;
      }

      id = R.id.habilidades;
      TextView habilidades = ViewBindings.findChildViewById(rootView, id);
      if (habilidades == null) {
        break missingId;
      }

      id = R.id.habilidadesLabel;
      TextView habilidadesLabel = ViewBindings.findChildViewById(rootView, id);
      if (habilidadesLabel == null) {
        break missingId;
      }

      id = R.id.imagen;
      ImageView imagen = ViewBindings.findChildViewById(rootView, id);
      if (imagen == null) {
        break missingId;
      }

      id = R.id.nombre;
      TextView nombre = ViewBindings.findChildViewById(rootView, id);
      if (nombre == null) {
        break missingId;
      }

      id = R.id.personaje_detail_fragment;
      LinearLayout personajeDetailFragment = ViewBindings.findChildViewById(rootView, id);
      if (personajeDetailFragment == null) {
        break missingId;
      }

      return new PersonajeDetailFragmentBinding((ScrollView) rootView, descripcion,
          descripcionLabel, habilidades, habilidadesLabel, imagen, nombre, personajeDetailFragment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}