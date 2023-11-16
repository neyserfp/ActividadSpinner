package com.neyser.actividadspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText e1, e2;
    private Button b1;
    private Spinner sp1;
    private TextView tResultado;

    private List operaciones = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.sp1);

        String[] operaciones = {"sumar", "restar", "multiplicar", "dividir"};

        //Utilizamos  el objeto ArrayAdapter para leer los datos
        ArrayAdapter<String> adaptador1 =new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,operaciones);
        sp1.setAdapter(adaptador1);




    }

    public void calcular(View view){

        tResultado = findViewById(R.id.tResultado);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);

        int valor1 = Integer.valueOf(e1.getText().toString());
        int valor2 = Integer.valueOf(e2.getText().toString());
        int operacion = 0;

        String resultado = "";

        String valor = sp1.getSelectedItem().toString();

        if (valor=="sumar"){
            operacion = valor1+valor2;
            resultado = String.valueOf(operacion);
        } else if (valor=="multiplicar") {
            operacion = valor1*valor2;
            resultado = String.valueOf(operacion);
        } else if (valor=="dividir") {
            try {
                operacion = valor1/valor2;
                resultado = String.valueOf(operacion);
            } catch (Exception e){
                resultado = "El valor: " + valor2 + " no es válido";
                e2.setText("");
            }
        } else if (valor=="restar") {
            operacion = valor1-valor2;
            resultado = String.valueOf(operacion);
        } else {
            Toast.makeText(this,"Debe elegir alguna opción válida", Toast.LENGTH_LONG).show();
        }

        tResultado.setText("Resultado: "+resultado);



        //String valor = "Resultado: "+sp1.getSelectedItem().toString();

        //Toast.makeText(this, valor, Toast.LENGTH_SHORT).show();
        //tResultado.setText(resultado);

    }
}