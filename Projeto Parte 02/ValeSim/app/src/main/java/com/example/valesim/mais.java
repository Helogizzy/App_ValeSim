package com.example.valesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mais);
    }

    public void menu(View view){
        Intent intent = new Intent(this, menu.class);  //Vai para a tela do menu principal
        startActivity(intent);
    }

    public void extrato(View view){
        Intent intent = new Intent(this, extrato.class);  //Vai para a tela do extrato
        startActivity(intent);
    }

    public void perfil(View view){
        Intent intent = new Intent(this, perfil.class);  //Vai para a tela do perfil
        startActivity(intent);
    }

    public void termos_uso(View view){
        Intent intent = new Intent(this, Termo_de_uso.class);  //Vai para a tela dos termos
        startActivity(intent);
    }

    public void recarregar(View view){
        Intent intent = new Intent(this, recarregar.class);  //Vai para a tela de recarregar
        startActivity(intent);
    }

    public void noticias(View view){
        Intent intent = new Intent(this, noticias.class);  //Vai para a tela das notícias
        startActivity(intent);
    }

    public void horarios(View view){
        Intent intent = new Intent(this, horarios.class);  //Vai para a tela dos horários
        startActivity(intent);
    }

    public void renovacoes(View view){
        Intent intent = new Intent(this, renovacao.class);  //Vai para a tela das renovações
        startActivity(intent);
    }

    public void atendimentos(View view){
        Intent intent = new Intent(this, Atendimento.class); //Vai para a tela dos atendimentos
        startActivity(intent);
    }
}