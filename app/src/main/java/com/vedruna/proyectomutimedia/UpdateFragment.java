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

import com.vedruna.proyectomutimedia.dto.ProductDTO;
import com.vedruna.proyectomutimedia.interfaz.CRUDInterface;
import com.vedruna.proyectomutimedia.model.Product;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateFragment extends Fragment {

    EditText nameText;
    EditText priceText;
    EditText editTextUrlImagen;
    Button button;
    EditText idText;  // Nuevo EditText para el ID

    private Retrofit retrofit;
    CRUDInterface crudInterface;

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View rootView = inflater.inflate(R.layout.fragment_update, container, false);

        // Inicializar los EditText
        idText = rootView.findViewById(R.id.editTextID);  // Nuevo EditText para el ID
        nameText = rootView.findViewById(R.id.editTextNombre);
        priceText = rootView.findViewById(R.id.editTextPrecio);
        editTextUrlImagen = rootView.findViewById(R.id.editTextUrlImagen);

        retrofit = new Retrofit.Builder().baseUrl("http://192.168.217.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Inicializar el botón
        button = rootView.findViewById(R.id.buttonActualizarProducto);

        // Puedes agregar un listener al botón si deseas manejar clics
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });

        return rootView;
    }

    private void actualizar() {
        String id = idText.getText().toString().trim();
        String nombre = nameText.getText().toString().trim();
        String precio = priceText.getText().toString().trim();
        String imagen = editTextUrlImagen.getText().toString().trim();

        // Crear un objeto ProductDTO en lugar de Product
        ProductDTO productDTO = new ProductDTO(nombre, Float.parseFloat(precio), imagen);

        crudInterface = retrofit.create(CRUDInterface.class);

        // Llamar al método actualizar con el DTO y el ID
        Call<Product> call = crudInterface.actualizar(Integer.parseInt(id), productDTO);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err ", response.message());
                    return;
                }
                Product product = response.body();
                // Hacer algo con el producto actualizado si es necesario
                mostrarToast("Producto actualizado: " + product.getName());

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.e("Throw err:", t.getMessage());
                mostrarToast("Error al actualizar el producto");
            }
        });
    }
    // Método para mostrar un Toast
    private void mostrarToast(String mensaje) {
        Toast.makeText(getActivity(), mensaje, Toast.LENGTH_SHORT).show();
    }
}