package com.example.valesim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Atendimento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendimento);
    }

    public void mais(View view){
        Intent intent = new Intent(this, mais.class);  //Vai para a tela de mais itens
        startActivity(intent);
    }
}