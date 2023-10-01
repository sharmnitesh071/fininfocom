package com.example.taskapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskapplication.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.loginin.setOnClickListener(v -> {
            if (condition()) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private boolean condition() {
        String username = binding.username.getText().toString().trim();
        String password = binding.password.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            binding.username.setError("Enter Username");
            return false;
        }
        if (username.length() != 10) {
            binding.username.setError("Username must be 10 characters");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            binding.password.setError("Enter password");
            return false;
        }
        if (password.length() != 7) {
            binding.password.setError("Password must be 7 characters long");
            return false;
        }

        // Check if the password contains at least 1 uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            binding.password.setError("Password must contain at least 1 uppercase letter");
            return false;
        }  // Check if the password contains at least 1 special character
        if (!password.matches(".*[!@#$%^&*()].*")) {
            binding.password.setError("Password must contain at least 1 special character");
            return false;
        }

        // Check if the password contains at least 1 numeric digit
        if (!password.matches(".*\\d.*")) {
            binding.password.setError("Password must contain at least 1 numeric digit");
            return false;
        }
        if (!username.equals("Fininfocom") || !password.equals("Fin@123")) {
            binding.username.setError("Invalid credentials");
            return false;
        }
        return true;
    }
}