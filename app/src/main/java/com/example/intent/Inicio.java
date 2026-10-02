package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Inicio extends AppCompatActivity {

    EditText etNombre;
    Button btAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNombre = findViewById(R.id.ETNombre);
        btAceptar = findViewById(R.id.BTAceptar);

        btAceptar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            Intent intent = new Intent(Inicio.this, MainActivity.class);
            intent.putExtra("nombre", nombre);
            // Pasar la referencia de la foto (recurso drawable) por Intent
            intent.putExtra("foto", R.drawable.razascaballos);
            startActivity(intent);
        });
    }
}
