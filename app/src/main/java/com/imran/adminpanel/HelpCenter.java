package com.imran.adminpanel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HelpCenter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
    }

    public void Police(View view) {
        Intent intent = new Intent(getApplicationContext(), PoliceHelp.class);
        startActivity(intent);
    }

    public void Resque(View view) {
        Intent intent = new Intent(getApplicationContext(), ResqueHelp.class);
        startActivity(intent);
    }

    public void Firebrigade(View view) {
        Intent intent = new Intent(getApplicationContext(), FirebrigadeHelp.class);
        startActivity(intent);
    }
}