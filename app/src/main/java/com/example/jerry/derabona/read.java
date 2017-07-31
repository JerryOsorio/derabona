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

    private user user1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        txt_data = (TextView) findViewById(R.id.ab_txt_data);


        DatabaseReference ref_matches = firebaseDatabase.child("matches");
        DatabaseReference ref_users = firebaseDatabase.child("users").child("1");

        final ArrayList<match> matches = new ArrayList<>();
        final ArrayList<user> users = new ArrayList<>();

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
        ref_matches.addValueEventListener(eventListener);


        ref_users.addValueEventListener(new ValueEventListener() {

            user user1 = new user();

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    users.add(dataSnapshot.getValue(user1.getClass()));
                    Log.i("test", users.get(0).getEmail());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(read.this, "Error: ", Toast.LENGTH_LONG).show();
            }
        });

        ListAdapter customAdapter = new read_adapter(this, matches);
        ListView list = findViewById(R.id.ar_list);
        list.setAdapter(customAdapter);

        Button btn_bet = findViewById(R.id.ar_btn_bet);
        btn_bet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
