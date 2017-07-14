package com.example.jerry.derabona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class read extends AppCompatActivity {

    private TextView txt_name;
    private DatabaseReference firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        txt_name = (TextView) findViewById(R.id.ar_txt_name);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference().child("matches");

        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txt_name.setText(dataSnapshot.toString().trim());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
