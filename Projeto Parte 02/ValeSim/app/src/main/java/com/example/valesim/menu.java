package com.example.valesim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

public class menu extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button b_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth = FirebaseAuth.getInstance();
        b_logout = findViewById(R.id.b_logout);

        //desloga o usuário
        b_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();

                //retorna para a tela de login
                Intent intent = new Intent(menu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart(){ //verifica se há algum usuário logado no app
        super.onStart();
        FirebaseUser currentuser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentuser == null){ //se não tem nenhum usuário logado vai para a tela de login
            Intent intent = new Intent(menu.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
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

    public void recarregar(View view){
        Intent intent = new Intent(this, recarregar.class);  //Vai para a tela de recarregar
        startActivity(intent);
    }
}