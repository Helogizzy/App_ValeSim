package com.example.valesim;

import static com.example.valesim.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class registro extends AppCompatActivity {

    private EditText email_pessoa;
    private EditText id_pessoa;
    private EditText senha_pessoa;
    private EditText nome_pessoa;
    private CheckBox mostrar_senha;
    private Button cadastrar;
    String[] mensagens = {"Preeencha todos os campos!", "Cadastro realizado com sucesso!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        IniciarComponetes();

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nome_pessoa.getText().toString();
                String email = email_pessoa.getText().toString();
                String id = id_pessoa.getText().toString();
                String senha = senha_pessoa.getText().toString();

                //verifica se está tudo preenchido
                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty() || id.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    cadastrar_usuario(v);
                }
            }
        });

        //caixinha de mostrar a senha
        mostrar_senha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    senha_pessoa.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    senha_pessoa.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void cadastrar_usuario(View v) {
        String email = email_pessoa.getText().toString();
        String senha = senha_pessoa.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Snackbar snackbar = Snackbar.make(v, mensagens[1], Snackbar.LENGTH_SHORT);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }

    private void IniciarComponetes(){
        email_pessoa = findViewById(R.id.email_pessoa);
        id_pessoa = findViewById(R.id.id_pessoa);
        senha_pessoa = findViewById(R.id.senha_pessoa);
        nome_pessoa = findViewById(R.id.nome_pessoa);
        mostrar_senha = findViewById(R.id.mostrar_senha);
        cadastrar = findViewById(R.id.cadastrar);
    }

    public void voltar(View view){
        Intent intent = new Intent(registro.this, MainActivity.class);
        startActivity(intent);
    }
}