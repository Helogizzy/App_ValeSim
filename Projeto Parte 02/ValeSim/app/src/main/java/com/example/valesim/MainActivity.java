package com.example.valesim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth; //verifica se há uma seção aberta de autenticação

    private EditText t_email;
    private EditText t_senha;
    private CheckBox m_senha;
    private Button b_cadastrar;
    private Button b_recuperar;
    private Button b_entrar;
    private ProgressBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //passar referencia dos dados:
        t_email = findViewById(R.id.t_email);
        t_senha = findViewById(R.id.t_senha);
        m_senha = findViewById(R.id.m_senha);
        b_entrar = findViewById(R.id.b_entrar);
        b_cadastrar = findViewById(R.id.b_cadastrar);
        b_recuperar = findViewById(R.id.b_recuperar);
        m_senha = findViewById(R.id.m_senha);
        barra = findViewById(R.id.barra);

        mAuth = FirebaseAuth.getInstance();

        //botão de entrar (logar) no app
        b_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginemail = t_email.getText().toString();
                String loginsenha = t_senha.getText().toString();

                //verifica se tudo está preenchido, caso não esteja não vai fazer nada
                if(!TextUtils.isEmpty(loginemail) || !TextUtils.isEmpty(loginsenha)){
                    barra.setVisibility(View.VISIBLE);
                    //consulta o firebase para ver ser o usuário existe
                    mAuth.signInWithEmailAndPassword(loginemail, loginsenha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //se existir vai para o app, senão apresenta uma mensagem de erro
                                    if(task.isSuccessful()){
                                        abrirTelaPrincipal();
                                    }
                                    else{
                                        String error = task.getException().getMessage();
                                        Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                                        barra.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });
                }
            }
        });

        b_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, registro.class);  //Vai para a tela de registro
                startActivity(intent);
                finish();
            }
        });

        b_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, esqueci_senha.class);  //Vai para a tela de esqueci a senha
                startActivity(intent);
                finish();
            }
        });

       //caixinha de mostrar a senha
       m_senha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               //se tiver marcado a caixinha mostra a senha
               if(isChecked){
                   t_senha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
               }
               else{
                   t_senha.setTransformationMethod(PasswordTransformationMethod.getInstance());
               }
           }
       });
    }

    private void abrirTelaPrincipal() {
        Intent intent = new Intent(MainActivity.this, menu.class);
        startActivity(intent);
        finish();
    }
}