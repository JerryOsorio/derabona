package com.example.jerry.derabona;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class bets extends AppCompatActivity {

    private DatabaseReference firebaseDatabase;

    private EditText edt_input_name;
    private EditText edt_input_password;

    private TextView txt_data;

    private Button btn_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        edt_input_name = (EditText) findViewById(R.id.ab_edt_name);
        edt_input_password =(EditText) findViewById(R.id.ab_edt_password);

        txt_data = (TextView) findViewById(R.id.ab_txt_data);

        btn_add = (Button) findViewById(R.id.ab_btn_add);


        /*

        DatabaseReference example = firebaseDatabase.child("matches").child("1");

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                match match = new match();
                match = dataSnapshot.getValue(match.class);
                txt_data.setText(match.getDate().toString() +"     "+ match.getMatch() +"     "+ match.getStatus()+"     "+match.getWinner());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(bets.this, "Error: ", Toast.LENGTH_LONG).show();
            }
        };
        example.addValueEventListener(eventListener);


         */



        DatabaseReference example = firebaseDatabase.child("matches");


        ValueEventListener eventListener = new ValueEventListener() {

            match match = new match();

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<match> matches = new ArrayList<>();

                for(int i = 1; i <= dataSnapshot.getChildrenCount(); i++){
                    matches.add(dataSnapshot.child(i+"").getValue(match.getClass()));
                    Log.i("test", matches.get(i-1).getMatch());


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(bets.this, "Error: ", Toast.LENGTH_LONG).show();
            }
        };
        example.addValueEventListener(eventListener);



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
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
                 */
                Intent intent = new Intent(this, read.class);
             startActivity();

            }
        });







    }

    public String rowToString(match match){
        String data = "";
        data += match.getDate().toString() +"     "+
                match.getMatch() +"     "+
                match.getStatus()+"     "+
                match.getWinner();

        return data;
    }
}
