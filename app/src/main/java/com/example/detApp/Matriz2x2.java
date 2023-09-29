package com.example.detApp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Matriz2x2 extends AppCompatActivity {

    EditText m11;
    EditText m12;
    EditText m21;
    EditText m22;
    Button btnCalcular;
    TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz2x2);

        m11 = findViewById(R.id.m3x1);
        m12 = findViewById(R.id.m2x3);
        m21 = findViewById(R.id.m3x1);
        m22 = findViewById(R.id.m3x2);
        btnCalcular = findViewById(R.id.btnCalcular);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularDeterminante();
            }
        });
    }

    private void calcularDeterminante() {
        // Obter os valores
        String valorM11Str = m11.getText().toString();
        String valorM12Str = m12.getText().toString();
        String valorM21Str = m21.getText().toString();
        String valorM22Str = m22.getText().toString();

        // Verificar se algum dos campos de entrada está vazio
        if (valorM11Str.isEmpty() || valorM12Str.isEmpty() || valorM21Str.isEmpty() || valorM22Str.isEmpty()) {
            // Exibir um Toast indicando que todos os valores precisam ser inseridos
            Toast toast = Toast.makeText(getApplicationContext(), "Por favor, insira todos os valores.", Toast.LENGTH_SHORT);
            View toastView = toast.getView();
            toastView.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            toast.show();
        } else {
            // Todos os valores estão presentes, então calcular o determinante
            double valorM11 = Double.parseDouble(valorM11Str);
            double valorM12 = Double.parseDouble(valorM12Str);
            double valorM21 = Double.parseDouble(valorM21Str);
            double valorM22 = Double.parseDouble(valorM22Str);

            // Calcular o determinante da matriz 2x2
            double determinante = (valorM11 * valorM22) - (valorM12 * valorM21);

            // Exibir o resultado na TextView
            resultadoTextView.setText("Determinante: " + determinante);
        }
    }

}
