package com.vedruna.proyectomutimedia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
/**
 * Activity principal que gestiona la navegación entre fragmentos a través de un menú inferior.
 */
public class NavigationActivity extends AppCompatActivity {
    /**
     * Método llamado cuando se crea la Activity.
     * Se encarga de establecer el diseño y configurar la navegación en el menú inferior.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationmenu);
        onNavigationItemSelectedListener();


    }
    /**
     * Método para configurar la navegación en el menú inferior.
     */

    protected void onNavigationItemSelectedListener(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();


        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navigation_home) {
                navController.navigate(R.id.homeFragment);
            } else if (item.getItemId() == R.id.navigation_create) {
                navController.navigate(R.id.createFragment);
            } else if (item.getItemId() == R.id.navigation_update) {
                navController.navigate(R.id.updateFragment);
            }else if (item.getItemId() == R.id.navigation_delete) {
                navController.navigate(R.id.deleteFragment);
            }else if (item.getItemId() == R.id.navigation_exit) {
                navController.navigate(R.id.exitFragment);
            }
            return true;
        });
    }
}
