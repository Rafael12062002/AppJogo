package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){

        this.opcaoSelecionada("Pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view){

        this.opcaoSelecionada("Tesoura");
    }
    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView resultadoImagem = findViewById(R.id.resultadoImagem);
        TextView text = findViewById(R.id.textResultado);
        
        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opcaoApp = opcoes[numero];

        switch(opcaoApp){
            case "Pedra" :
                resultadoImagem.setImageResource(R.drawable.pedra);
                break;
            case "Papel" :
                resultadoImagem.setImageResource(R.drawable.papel);
                break;
            case "Tesoura" :
                resultadoImagem.setImageResource(R.drawable.tesoura);
                break;
        }

        if((opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") ||
           (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
           (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura")){
            text.setText("Você perdeu");
        }else if((opcaoApp == "Tesoura" && opcaoSelecionada == "Pedra") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Tesoura") ||
                (opcaoApp == "Pedra" && opcaoSelecionada == "Papel")){
            text.setText("Você ganhou");
        }else{
            text.setText("Empate");
        }
    }
}