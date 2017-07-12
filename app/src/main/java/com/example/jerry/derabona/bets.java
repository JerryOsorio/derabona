package com.example.jerry.derabona;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class bets extends AppCompatActivity {

    private DatabaseReference firebaseDatabase;

    private EditText edt_input_name;
    private EditText edt_input_password;

    private Button btn_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets);


        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        edt_input_name = (EditText) findViewById(R.id.ab_edt_name);
        edt_input_password =(EditText) findViewById(R.id.ab_edt_password);

        btn_add = (Button) findViewById(R.id.ab_btn_add);




        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edt_input_name.getText().toString().trim();
                String password = edt_input_password.getText().toString().trim();

                HashMap<String,String> data = new HashMap<>();
                data.put("name", name);
                data.put("password", password);

                firebaseDatabase.push().setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(bets.this, "Stored...", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(bets.this, "Error: ", Toast.LENGTH_LONG).show();
                        }
                    }


                });
            }
        });







    }
}
