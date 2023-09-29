package com.example.detApp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Matriz4x4 extends AppCompatActivity {

    EditText m11, m12, m13, m14;
    EditText m21, m22, m23, m24;
    EditText m31, m32, m33, m34;
    EditText m41, m42, m43, m44;
    Button btnCalcular;
    TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz4x4);

        m11 = findViewById(R.id.m3x1);
        m12 = findViewById(R.id.m2x3);
        m13 = findViewById(R.id.m1x3);
        m14 = findViewById(R.id.m1x4);
        m21 = findViewById(R.id.m3x1);
        m22 = findViewById(R.id.m3x2);
        m23 = findViewById(R.id.m2x3);
        m24 = findViewById(R.id.m2x4);
        m31 = findViewById(R.id.m3x1);
        m32 = findViewById(R.id.m3x2);
        m33 = findViewById(R.id.m3x3);
        m34 = findViewById(R.id.m3x4);
        m41 = findViewById(R.id.m4x1);
        m42 = findViewById(R.id.m4x2);
        m43 = findViewById(R.id.m4x3);
        m44 = findViewById(R.id.m4x4);
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
        String valorM14Str = m14.getText().toString();
        String valorM21Str = m21.getText().toString();
        String valorM22Str = m22.getText().toString();
        String valorM23Str = m23.getText().toString();
        String valorM24Str = m24.getText().toString();
        String valorM31Str = m31.getText().toString();
        String valorM32Str = m32.getText().toString();
        String valorM33Str = m33.getText().toString();
        String valorM34Str = m34.getText().toString();
        String valorM41Str = m41.getText().toString();
        String valorM42Str = m42.getText().toString();
        String valorM43Str = m43.getText().toString();
        String valorM44Str = m44.getText().toString();

        // Verificar se algum dos campos de entrada está vazio
        if (valorM11Str.isEmpty() || valorM12Str.isEmpty() || valorM13Str.isEmpty() || valorM14Str.isEmpty() ||
                valorM21Str.isEmpty() || valorM22Str.isEmpty() || valorM23Str.isEmpty() || valorM24Str.isEmpty() ||
                valorM31Str.isEmpty() || valorM32Str.isEmpty() || valorM33Str.isEmpty() || valorM34Str.isEmpty() ||
                valorM41Str.isEmpty() || valorM42Str.isEmpty() || valorM43Str.isEmpty() || valorM44Str.isEmpty()) {

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
        double valorM14 = Double.parseDouble(valorM14Str);
        double valorM21 = Double.parseDouble(valorM21Str);
        double valorM22 = Double.parseDouble(valorM22Str);
        double valorM23 = Double.parseDouble(valorM23Str);
        double valorM24 = Double.parseDouble(valorM24Str);
        double valorM31 = Double.parseDouble(valorM31Str);
        double valorM32 = Double.parseDouble(valorM32Str);
        double valorM33 = Double.parseDouble(valorM33Str);
        double valorM34 = Double.parseDouble(valorM34Str);
        double valorM41 = Double.parseDouble(valorM41Str);
        double valorM42 = Double.parseDouble(valorM42Str);
        double valorM43 = Double.parseDouble(valorM43Str);
        double valorM44 = Double.parseDouble(valorM44Str);

        // Calcular o determinante da matriz 4x4
        double determinante =
                valorM11 * (
                        valorM22 * (valorM33 * valorM44 - valorM34 * valorM43) -
                                valorM23 * (valorM32 * valorM44 - valorM34 * valorM42) +
                                valorM24 * (valorM32 * valorM43 - valorM33 * valorM42)
                ) -
                        valorM12 * (
                                valorM21 * (valorM33 * valorM44 - valorM34 * valorM43) -
                                        valorM23 * (valorM31 * valorM44 - valorM34 * valorM41) +
                                        valorM24 * (valorM31 * valorM43 - valorM33 * valorM41)
                        ) +
                        valorM13 * (
                                valorM21 * (valorM32 * valorM44 - valorM34 * valorM42) -
                                        valorM22 * (valorM31 * valorM44 - valorM34 * valorM41) +
                                        valorM24 * (valorM31 * valorM42 - valorM32 * valorM41)
                        ) -
                        valorM14 * (
                                valorM21 * (valorM32 * valorM43 - valorM33 * valorM42) -
                                        valorM22 * (valorM31 * valorM43 - valorM33 * valorM41) +
                                        valorM23 * (valorM31 * valorM42 - valorM32 * valorM41)
                        );

        // Exibir o resultado na TextView
        resultadoTextView.setText("Determinante: " + determinante);
    }

}
