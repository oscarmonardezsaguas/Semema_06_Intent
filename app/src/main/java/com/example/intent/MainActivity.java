package com.example.intent;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;
    ImageView imageViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvResultado = findViewById(R.id.TVResultado);
        imageViewResultado = findViewById(R.id.imageViewResultado);

        // Recibir el nombre enviado por el Intent
        String nombre = getIntent().getStringExtra("nombre");
        if (nombre != null && !nombre.isEmpty()) {
            tvResultado.setText("Foto: " + nombre);
        } else {
            tvResultado.setText("Foto sin nombre");
        }

        // Recibir la foto enviada por el Intent
        int fotoResId = getIntent().getIntExtra("foto", R.drawable.ic_launcher_foreground);
        imageViewResultado.setImageResource(fotoResId);
    }
}
