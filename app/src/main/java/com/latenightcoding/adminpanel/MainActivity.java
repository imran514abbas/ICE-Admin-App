package com.latenightcoding.adminpanel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView Latitude, Longitude, Address, Emergerncy;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Latitude = findViewById(R.id.latitude);
        Longitude = findViewById(R.id.longitude);
        Address = findViewById(R.id.address);
        Emergerncy = findViewById(R.id.stopemergency);
        databaseReference = FirebaseDatabase.getInstance().getReference("Current Location");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String latitude = snapshot.child("PLatitude").getValue(String.class);
                String longitude = snapshot.child("PLongitude").getValue(String.class);
                String address = snapshot.child("Paddress").getValue(String.class);
                Latitude.setText(latitude);
                Latitude.setVisibility(View.VISIBLE);
                Longitude.setText(longitude);
                Longitude.setVisibility(View.VISIBLE);
                Address.setText(address);
                Address.setVisibility(View.VISIBLE);

                Emergerncy.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Emergerncy.setVisibility(View.INVISIBLE);
                    }
                }, 20000);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void Map(View view) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);


    }
}