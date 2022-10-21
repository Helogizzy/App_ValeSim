package com.example.valesim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class esqueci_senha extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText email_rec;
    private Button botao_rec;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);

        email_rec = findViewById(R.id.email_rec);
        botao_rec = (Button)findViewById(R.id.botao_rec);

        auth = FirebaseAuth.getInstance();

        botao();

    }

    private void botao(){
        botao_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarSenha();
            }
        });
    }

    private void recuperarSenha() {
        String r_email = email_rec.getText().toString().trim();

        if(r_email.isEmpty()){
            Toast.makeText(getBaseContext(), "Insira seu email", Toast.LENGTH_LONG).show();
        }else{
            enviarEmail(r_email);
        }
    }

    private void enviarEmail(String r_email) {

        auth.sendPasswordResetEmail(r_email).addOnSuccessListener(new OnSuccessListener<Void>(){
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getBaseContext(),"Enviamos um email com o link para redefinir sua senha", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getBaseContext(),"Erro ao enviar email", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void volta(View view){
        Intent intent = new Intent(esqueci_senha.this, MainActivity.class);
        startActivity(intent);
    }
}