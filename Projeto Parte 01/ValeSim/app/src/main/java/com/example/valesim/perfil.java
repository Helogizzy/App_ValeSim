package com.example.valesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void menu_tela_perfil(View view){
        Intent intent = new Intent(this, menu.class);  //Vai para a tela do menu principal
        startActivity(intent);
    }

    public void extrato_tela_perfil(View view){
        Intent intent = new Intent(this, extrato.class);  //Vai para a tela do extrato
        startActivity(intent);
    }

    public void mais_tela_perfil(View view){
        Intent intent = new Intent(this, mais.class);  //Vai para a tela de mais itens
        startActivity(intent);
    }
}