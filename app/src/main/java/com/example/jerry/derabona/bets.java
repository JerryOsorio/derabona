package com.example.jerry.derabona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class bets extends AppCompatActivity {

    private DatabaseReference firebaseDatabase;

    private EditText edt_input;

    private Button btn_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets);


        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        edt_input = (EditText) findViewById(R.id.ab_edt_input);

        btn_add = (Button) findViewById(R.id.ab_btn_add);




        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_input = edt_input.getText().toString().trim();

                firebaseDatabase.push().setValue(str_input);
            }
        });







    }
}
