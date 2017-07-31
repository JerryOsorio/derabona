package com.example.jerry.derabona;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener{

    private Button btn_sign_in;
    private EditText edt_email;
    private EditText edt_password;
    private TextView txt_sign_up;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_sign_in = (Button) findViewById(R.id.al_btn_sign_in);
        edt_email = (EditText) findViewById(R.id.al_edt_email);
        edt_password = (EditText) findViewById(R.id.al_edt_password);
        txt_sign_up = (TextView) findViewById(R.id.al_txt_sign_up);

        progressBar = new ProgressBar(this);

        btn_sign_in.setOnClickListener(this);
        txt_sign_up.setOnClickListener(this);

        //if the user is already logged in, start the read activity
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            startActivity(new Intent(getApplicationContext(),read.class));
        }
    }

    public void userLogin(){
        String email = edt_email.getText().toString().trim();
        String password = edt_password.getText().toString().trim();

        //check if email is empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        //check if password is empty
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        //if all goes well
        progressBar.isShown();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //start read activity
                            finish();
                            startActivity(new Intent(getApplicationContext(),read.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == btn_sign_in){
            userLogin();
        }
        if(view == txt_sign_up){
            finish();
            startActivity(new Intent(this, register.class));
        }
    }
}
