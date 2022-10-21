package com.example.valesim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void extrato(View view){
        Intent intent = new Intent(this, extrato.class);  //Vai para a tela do extrato
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