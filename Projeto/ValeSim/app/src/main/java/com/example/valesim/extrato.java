package com.example.valesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class extrato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);
    }

    public void menu(View view){
        Intent intent = new Intent(this, menu.class);  //Vai para a tela do menu principal
        startActivity(intent);
    }

    public void perfil(View view){
        Intent intent = new Intent(this, perfil.class);  //Vai para a tela do perfil
        startActivity(intent);
    }

    public void mais(View view){
        Intent intent = new Intent(this, mais.class);  //Vai para a tela de mais itens
        startActivity(intent);
    }
}