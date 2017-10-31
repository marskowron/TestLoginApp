package com.mmskowron.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AppActivity extends AppCompatActivity {

    private Button LogOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        String name = getIntent().getStringExtra("name");
        Toast.makeText(this, "Witaj " + name + "!", Toast.LENGTH_LONG).show();

        TextView welcomeField = (TextView) findViewById(R.id.HelloTextView);
        welcomeField.setText("Cześć " + name + "!");

        LogOutButton = (Button) findViewById(R.id.LogOutButton);
        LogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
