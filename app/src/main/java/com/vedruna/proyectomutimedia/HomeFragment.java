package com.vedruna.proyectomutimedia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vedruna.proyectomutimedia.adapters.ProductAdapter;
import com.vedruna.proyectomutimedia.interfaz.CRUDInterface;
import com.vedruna.proyectomutimedia.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {

    List<Product> productList;
    CRUDInterface crudInterface;



    ListView listView;

    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void gelAll(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://192.168.217.1:8080/").
                addConverterFactory(GsonConverterFactory.create()).build();
        crudInterface=retrofit.create(CRUDInterface.class);
        Call<List<Product>> call=crudInterface.getAll();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(!response.isSuccessful()){
                    Log.e("Response err ",response.message());
                    return;
                }
                productList=response.body();
                ProductAdapter productAdapter = new ProductAdapter(requireContext(), productList);
                listView.setAdapter(productAdapter);
                productList.forEach(p-> Log.i("Productos: ",p.toString()));
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("Throw err:",t.getMessage());
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.listView);


        gelAll();
        return view;
    }



}