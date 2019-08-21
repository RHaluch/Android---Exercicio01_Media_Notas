package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText nota1, nota2, nota3;
    Button calcular;
    CheckBox trocarCalculo;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        calcular = findViewById(R.id.calcular);
        trocarCalculo = findViewById(R.id.trocarCalculo);
        resultado = findViewById(R.id.resultado);

        trocarCalculo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    calcular.setText("Calcular Media Ponderada");
                }else{
                    calcular.setText("Calcular Media Simples");
                }
            }
        });
    }

    public void calcularMedia(View view) {
        if(!nota1.getText().toString().isEmpty() && !nota2.getText().toString().isEmpty() && !nota3.getText().toString().isEmpty()){
            DecimalFormat df = new DecimalFormat("#0.00");
            if(trocarCalculo.isChecked()){
                //ponderada
                float calculoNota1 = (Float.parseFloat(nota1.getText().toString())*1);
                float calculoNota2 = (Float.parseFloat(nota2.getText().toString())*2);
                float calculoNota3 = (Float.parseFloat(nota3.getText().toString())*3);
                float media = (calculoNota1 + calculoNota2 + calculoNota3)/6;
                String conceito;
                if(media>9){
                    conceito = "A";
                }else if(media<=9 && media>=8){
                    conceito = "B";
                }else if(media<8 && media>=7) {
                    conceito = "C";
                }else if(media<7 && media>=4) {
                    conceito = "D";
                }else if(media<4){
                    conceito = "E";
                }else{
                    conceito = "Fora do intervalo";
                }
                String saida = "Media: "+ df.format(media)+ " Conceito:" + conceito;
                resultado.setText(saida);

            }else{
                //simples
                float calculoNota1 = (Float.parseFloat(nota1.getText().toString()));
                float calculoNota2 = (Float.parseFloat(nota2.getText().toString()));
                float calculoNota3 = (Float.parseFloat(nota3.getText().toString()));
                float media = (calculoNota1+calculoNota2+calculoNota3)/3;
                String conceito;
                if(media>9){
                    conceito = "A";
                }else if(media<=9 && media>=8){
                    conceito = "B";
                }else if(media<8 && media>=7) {
                    conceito = "C";
                }else if(media<7 && media>=4) {
                    conceito = "D";
                }else if(media<4){
                    conceito = "E";
                }else{
                    conceito = "Fora do intervalo";
                }
                String saida = "Media: "+ df.format(media)+ " Conceito:" + conceito;
                resultado.setText(saida);
            }
        }
    }
}
