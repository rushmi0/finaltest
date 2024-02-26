package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Step 1
    EditText firstName, lastName;
    Button submitBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.fName);
        lastName = findViewById(R.id.lName);
        submitBTN = findViewById(R.id.subMit);

        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = firstName.getText().toString();
                String n2 = lastName.getText().toString();

                if (n1.equals("")) {
                    firstName.setError("First Name is null");
                } else if (n2.equals("")) {
                    lastName.setError("Last Name is null");
                } else {
                    Toast.makeText(getApplicationContext(), "OK!!", Toast.LENGTH_SHORT).show();

                    Intent openHome = new Intent(getApplicationContext(), Home.class);
                    openHome.putExtra("name", n1 + " " + n2);
                    startActivity(openHome);
                }
            }
        });
    }
}
