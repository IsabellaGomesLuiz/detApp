package com.example.detApp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Matriz3x3 extends AppCompatActivity {

    EditText m11, m12, m13;
    EditText m21, m22, m23;
    EditText m31, m32, m33;
    Button btnCalcular;
    TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz3x3);

        m11 = findViewById(R.id.m3x1);
        m12 = findViewById(R.id.m2x3);
        m13 = findViewById(R.id.m1x3);
        m21 = findViewById(R.id.m3x1);
        m22 = findViewById(R.id.m3x2);
        m23 = findViewById(R.id.m2x3);
        m31 = findViewById(R.id.m3x1);
        m32 = findViewById(R.id.m3x2);
        m33 = findViewById(R.id.m3x3);
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
        String valorM13Str = m13.getText().toString();
        String valorM21Str = m21.getText().toString();
        String valorM22Str = m22.getText().toString();
        String valorM23Str = m23.getText().toString();
        String valorM31Str = m31.getText().toString();
        String valorM32Str = m32.getText().toString();
        String valorM33Str = m33.getText().toString();

        // Verificar se algum dos campos de entrada está vazio
        if (valorM11Str.isEmpty() || valorM12Str.isEmpty() || valorM13Str.isEmpty() ||
                valorM21Str.isEmpty() || valorM22Str.isEmpty() || valorM23Str.isEmpty() ||
                valorM31Str.isEmpty() || valorM32Str.isEmpty() || valorM33Str.isEmpty()) {

            // Exibir um Toast em vermelho indicando que todos os valores precisam ser inseridos
            Toast toast = Toast.makeText(getApplicationContext(), "Por favor, insira todos os valores.", Toast.LENGTH_SHORT);
            View toastView = toast.getView();
            toastView.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            toast.show();

            // Não calcular o determinante se algum valor estiver faltando
            return;
        }

        // Todos os valores estão presentes, então calcular o determinante
        double valorM11 = Double.parseDouble(valorM11Str);
        double valorM12 = Double.parseDouble(valorM12Str);
        double valorM13 = Double.parseDouble(valorM13Str);
        double valorM21 = Double.parseDouble(valorM21Str);
        double valorM22 = Double.parseDouble(valorM22Str);
        double valorM23 = Double.parseDouble(valorM23Str);
        double valorM31 = Double.parseDouble(valorM31Str);
        double valorM32 = Double.parseDouble(valorM32Str);
        double valorM33 = Double.parseDouble(valorM33Str);

        // Calcular o determinante da matriz 3x3
        double determinante = valorM11 * ((valorM22 * valorM33) - (valorM23 * valorM32))
                - valorM12 * ((valorM21 * valorM33) - (valorM23 * valorM31))
                + valorM13 * ((valorM21 * valorM32) - (valorM22 * valorM31));

        // Exibir o resultado na TextView
        resultadoTextView.setText("Determinante: " + determinante);
    }

}
