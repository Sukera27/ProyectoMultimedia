package com.vedruna.proyectomutimedia;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vedruna.proyectomutimedia.interfaz.CRUDInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Fragment para eliminar un producto.
 */
public class DeleteFragment extends Fragment {

    CRUDInterface crudInterface;
    Button button;
    EditText idEditText;

    /**
     * Constructor público vacío requerido por Fragment.
     */
    public DeleteFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        // Inicializar el EditText para el ID
        idEditText = view.findViewById(R.id.editTextID);

        // Configurar el botón de borrado con el clic
        setupDeleteButton(view);

        return view;
    }
    /**
     * Método para configurar el botón de borrado.
     *
     * @param view La vista del fragmento.
     */
    private void setupDeleteButton(View view) {
        button = view.findViewById(R.id.buttonBorrarProducto);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el ID ingresado por el usuario
                String idString = idEditText.getText().toString().trim();

                // Verificar si el campo del ID está vacío
                if (idString.isEmpty()) {
                    // Mostrar un mensaje de error si el campo del ID está vacío
                    mostrarToast("Debe ingresar un ID para eliminar el producto.");
                    return; // Salir del método onClick
                }

                // Convertir el ID a entero
                int productId = Integer.parseInt(idString);

                // Llamar al método de borrado con el ID del producto
                delete(productId);
            }
        });
    }
    /**
     * Método para eliminar un producto.
     *
     * @param id El ID del producto a eliminar.
     */
    private void delete(int id) {
        // Construir la instancia de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.217.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crear la interfaz CRUDInterface
        crudInterface = retrofit.create(CRUDInterface.class);

        // Llamar al método de borrado con el ID del producto
        Call<Void> call = crudInterface.delete(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err ", response.message());
                    return;
                }
                mostrarToast("Producto eliminado");
                // Borrado exitoso, puedes realizar acciones adicionales si es necesario
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Throw err:", t.getMessage());
            }
        });
    }
    /**
     * Método para mostrar un mensaje en forma de Toast.
     *
     * @param mensaje El mensaje a mostrar.
     */
    private void mostrarToast(String mensaje) {
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
