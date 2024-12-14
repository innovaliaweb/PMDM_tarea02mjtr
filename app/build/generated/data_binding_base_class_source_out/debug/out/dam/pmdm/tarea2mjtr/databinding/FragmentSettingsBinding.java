// Generated by view binder compiler. Do not edit!
package dam.pmdm.tarea2mjtr.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dam.pmdm.tarea2mjtr.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSettingsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView selectedLanguage;

  @NonNull
  public final SwitchCompat switchIdiomas;

  private FragmentSettingsBinding(@NonNull LinearLayout rootView,
      @NonNull TextView selectedLanguage, @NonNull SwitchCompat switchIdiomas) {
    this.rootView = rootView;
    this.selectedLanguage = selectedLanguage;
    this.switchIdiomas = switchIdiomas;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.selected_language;
      TextView selectedLanguage = ViewBindings.findChildViewById(rootView, id);
      if (selectedLanguage == null) {
        break missingId;
      }

      id = R.id.switch_idiomas;
      SwitchCompat switchIdiomas = ViewBindings.findChildViewById(rootView, id);
      if (switchIdiomas == null) {
        break missingId;
      }

      return new FragmentSettingsBinding((LinearLayout) rootView, selectedLanguage, switchIdiomas);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
