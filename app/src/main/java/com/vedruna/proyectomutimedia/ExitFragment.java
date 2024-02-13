package com.vedruna.proyectomutimedia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Fragment para cerrar sesión y salir de la aplicación.
 */
public class ExitFragment extends Fragment {

    FirebaseAuth firebaseAuth;

    /**
     * Constructor público vacío requerido por Fragment.
     */
    public ExitFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    /**
     * Método llamado para crear y devolver la vista asociada con el fragmento.
     *
     * @param inflater           El LayoutInflater que se utiliza para inflar la vista.
     * @param container          El ViewGroup en el que se debe inflar la vista.
     * @param savedInstanceState El estado anteriormente guardado del fragmento (si lo hay).
     * @return La vista asociada con el fragmento.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View view = inflater.inflate(R.layout.fragment_exit, container, false);

        // Aquí puedes agregar cualquier lógica adicional que necesites para el fragmento de salida
        firebaseAuth=FirebaseAuth.getInstance();
        // Cuando el usuario hace clic en el botón de salida, cierra la aplicación
        view.findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });

        return view;
    }

    /**
     * Método para cerrar sesión y salir de la aplicación.
     */
    private void logOut() {
        firebaseAuth.signOut();
        backToLogin();
    }
    /**
     * Método para volver a la pantalla de inicio de sesión.
     */
    private void backToLogin(){
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

}