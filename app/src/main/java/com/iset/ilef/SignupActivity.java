package com.iset.ilef;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iset.ilef.model.*;
import com.iset.ilef.service.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private EditText editNom, editPrenom, editEmail, editMotDePasse, editRole;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize views
        editNom = findViewById(R.id.editNom);
        editPrenom = findViewById(R.id.editPrenom);
        editEmail = findViewById(R.id.editEmail);
        editMotDePasse = findViewById(R.id.editMotDePasse);
        editRole = findViewById(R.id.editRole);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(view -> performSignup());
    }

    private void performSignup() {
        String nom = editNom.getText().toString();
        String prenom = editPrenom.getText().toString();
        String email = editEmail.getText().toString();
        String motDePasse = editMotDePasse.getText().toString();
        String role = editRole.getText().toString();

        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || motDePasse.isEmpty() || role.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create the request object
        SignUpRequest signUpRequest = new SignUpRequest(nom, prenom, email, motDePasse, role);

        // Make the API call
        AuthService authService = RetrofitClient.getClient().create(AuthService.class);
        Call<SignUpResponse> call = authService.registerUser(signUpRequest);

        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(SignupActivity.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupActivity.this, "Signup failed: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(SignupActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
