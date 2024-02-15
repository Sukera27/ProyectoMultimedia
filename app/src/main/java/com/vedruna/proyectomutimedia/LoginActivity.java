package com.vedruna.proyectomutimedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.internal.NavigationMenu;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
/**
 * Activity para iniciar sesión en la aplicación.
 */
public class LoginActivity extends AppCompatActivity {

    private TextView usuario;
    private EditText contraseña;

    private static final int RC_SIGN_IN = 1;

    private GoogleSignInClient mGoogleSignInClient;

    private FirebaseAuth mAuth;

    private static final String TAG = "LoginActivity";  // Definir una etiqueta para los mensajes de registro


    SignInButton signInButton;

    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState Instancia guardada del estado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario=findViewById(R.id.editTextText);
        contraseña=findViewById(R.id.editTextTextPassword);

        mAuth=FirebaseAuth.getInstance();
        signInButton= findViewById(R.id.btnGoogle);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        // Verificar si el usuario ya está autenticado
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // Si el usuario ya está autenticado, ir directamente a la pantalla de inicio
            goHome();
        }

    }
    /**
     * Método llamado cuando la actividad comienza a interactuar con el usuario.
     * Comprueba si el usuario ha iniciado sesión (no nulo) y actualiza la interfaz de usuario en consecuencia.
     */
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    /**
     * Método para iniciar sesión con Google.
     */
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.e(TAG, "Google Sign In failed. Error code: " + e.getStatusCode());

            }
        }
    }
    /**
     * Método para autenticar con Firebase usando el token de ID de Google.
     *
     * @param idToken Token de ID de Google para autenticación.
     */
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.e(TAG, "Firebase authentication failed.", task.getException());

                            updateUI(null);
                        }
                    }
                });
    }
    /**
     * Método para actualizar la interfaz de usuario después de la autenticación.
     *
     * @param user Usuario actual autenticado.
     */
    private void updateUI(FirebaseUser user) {
        user = mAuth.getCurrentUser();
        if (user != null) {
            // Si el usuario está autenticado, ir a la pantalla de inicio de la aplicación
            goHome();
            // Mostrar un mensaje de inicio de sesión correcto
            showToast("Inicio de sesión exitoso");
        }else{
            if(FirebaseAuth.getInstance().getCurrentUser()==null){
                return;
            }
            showToast("Inicio de sesión fallido");
        }
    }
    /**
     * Método para mostrar toast al usuario después de la autenticación.
     *
     * @param message Usuario actual autenticado.
     */
    // Método para mostrar un Toast
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    /**
     * Método para ir a la pantalla de inicio de la aplicación después de la autenticación.
     */
    private void goHome() {
        Intent intent=new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
    /**
     * Método llamado cuando se hace clic en el botón de inicio de sesión normal.
     *
     * @param view Vista del botón que se hizo clic.
     */
    public void login(View view){
        String user = usuario.getText().toString();
        String password = contraseña.getText().toString();
        if(user.equals("admin") && password.equals("admin")){
            showToast("Inicio de sesión exitoso");

            Intent intent=new Intent(this, NavigationActivity.class);
            intent.putExtra("usuario",user);
            startActivity(intent);
        }else {
            showToast("Inicio de sesión fallido");
        }




    }
}