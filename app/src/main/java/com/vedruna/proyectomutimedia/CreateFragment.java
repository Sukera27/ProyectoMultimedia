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

/**
 * Fragmento para la creación de un nuevo producto.
 */
public class CreateFragment extends Fragment {

    EditText nameText;

    EditText priceText;

    EditText editTextUrlImagen;
    Button button;

    CRUDInterface crudInterface;

    /**
     * Constructor público vacío requerido por Fragment.
     */
    public CreateFragment() {
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
        // Inflar el diseño del fragmento
        View rootView = inflater.inflate(R.layout.fragment_create, container, false);

        // Inicializar los EditText
        nameText = rootView.findViewById(R.id.editTextNombre);
        priceText = rootView.findViewById(R.id.editTextPrecio);
        editTextUrlImagen = rootView.findViewById(R.id.editTextUrlImagen);

        // Inicializar el botón
        button = rootView.findViewById(R.id.buttonCrearProducto);

        // Puedes agregar un listener al botón si deseas manejar clics
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = nameText.getText().toString();
                String precioString = priceText.getText().toString();
                String urlImagen = editTextUrlImagen.getText().toString();
                // Verificar si algún campo está vacío
                if (nombre.isEmpty() || precioString.isEmpty() || urlImagen.isEmpty()) {
                    // Mostrar un mensaje de error si algún campo está vacío
                    mostrarToast("Todos los campos son obligatorios.");
                    return; // Salir del método onClick
                }
                float precio = Float.parseFloat(precioString);
                ProductDTO dto = new ProductDTO(nombre, precio, urlImagen);
                create(dto);
            }
        });

        return rootView;
    }


    /**
     * Método para agregar un producto.
     *
     * @param dto El DTO (Data Transfer Object) del producto a agregar.
     */
    private void create(ProductDTO dto){
        Retrofit retrofit= new Retrofit.Builder().baseUrl("https://apiecologist-009d53b9d6bb.herokuapp.com/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        crudInterface= retrofit.create(CRUDInterface.class);
        Call<Product> call = crudInterface.create(dto);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if(!response.isSuccessful()){
                    Log.e("Response err ",response.message());
                    return;
                }
                Product product=response.body();
                mostrarToast("Producto añadido correctamente: " + product.getName());


            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.e("Throw err:",t.getMessage());
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