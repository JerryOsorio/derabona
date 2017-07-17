package com.example.jerry.derabona;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class read extends Activity {

    private DatabaseReference firebaseDatabase;

    private EditText edt_input_name;
    private EditText edt_input_password;

    private TextView txt_data;

    private Button btn_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Log.i("test", "on create called");

        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        txt_data = (TextView) findViewById(R.id.ab_txt_data);


        DatabaseReference example = firebaseDatabase.child("matches");

        final ArrayList<match> matches = new ArrayList<>();

        ValueEventListener eventListener = new ValueEventListener() {

            match match = new match();

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(int i = 1; i <= dataSnapshot.getChildrenCount(); i++){
                    matches.add(dataSnapshot.child(i+"").getValue(match.getClass()));
                    Log.i("test", matches.get(i-1).getMatch());


                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(read.this, "Error: ", Toast.LENGTH_LONG).show();
            }
        };
        example.addValueEventListener(eventListener);


        ListAdapter customAdapter = new read_adapter(this, matches);
        ListView list = findViewById(R.id.ar_list);
        list.setAdapter(customAdapter);

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
