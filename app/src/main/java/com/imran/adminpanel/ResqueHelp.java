package com.imran.adminpanel;

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

public class ResqueHelp extends AppCompatActivity {
    TextView Latitude, Longitude, Address, Emergerncy;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resque_help);
        Latitude = findViewById(R.id.latitude);
        Longitude = findViewById(R.id.longitude);
        Address = findViewById(R.id.address);
        Emergerncy = findViewById(R.id.stopemergency);
        databaseReference = FirebaseDatabase.getInstance().getReference("Resque Emergency");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String latitude = snapshot.child("RLatitude").getValue(String.class);
                String longitude = snapshot.child("RLongitude").getValue(String.class);
                String address = snapshot.child("Raddress").getValue(String.class);
                String Emergencymsg = snapshot.child("RStopEmergency").getValue(String.class);
                Latitude.setText(latitude);
                Latitude.setVisibility(View.VISIBLE);
                Longitude.setText(longitude);
                Longitude.setVisibility(View.VISIBLE);
                Address.setText(address);
                Address.setVisibility(View.VISIBLE);
                Emergerncy.setText(Emergencymsg);
                Emergerncy.setVisibility(View.VISIBLE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void Map(View view) {

        String latitude = Latitude.getText().toString();
        String longitude = Longitude.getText().toString();
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);

        Bundle params = new Bundle();
        params.putDouble("doubleA", Double.parseDouble(latitude));
        params.putDouble("doubleB", Double.parseDouble(longitude));
        intent.putExtras(params);
        startActivity(intent);


    }
}
