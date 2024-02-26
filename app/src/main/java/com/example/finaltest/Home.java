package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView showName;

    Button myHome, myCalBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        showName = findViewById(R.id.textName);
        myHome = findViewById(R.id.HomeBTN);
        myCalBTN = findViewById(R.id.calBTN);


        // Check if there are extras before accessing them
        Bundle getExtras = getIntent().getExtras();
        if (getExtras != null) {
            String getName = getExtras.getString("name");
            showName.setText("Mr: " + getName);
        }


        myHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHome = new Intent(getApplicationContext(), Home.class);
                startActivity(openHome);
            }
        });

        myCalBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHome = new Intent(getApplicationContext(), Calculate.class);
                startActivity(openHome);
            }
        });
    }
}
