package com.mmskowron.loginapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SettingActivity extends AppCompatActivity {

    private Button returnButton;
    private ImageButton sendMailButton;
    private ImageButton goToWebsiteButton;
    private String email;
    private String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        sendMailButton = (ImageButton) findViewById(R.id.sendMailButton);
        sendMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText emailField = (EditText) findViewById(R.id.email);
                email = emailField.getText().toString();

                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",email, null));
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Testowy temat");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Witam! \nTo jest treść maila \nPozdrawiam \nMMS");
                startActivity(Intent.createChooser(sendIntent, "Send email..."));
            }
        });

        goToWebsiteButton = (ImageButton) findViewById(R.id.goToWebsiteButton);
        goToWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText websiteField = (EditText) findViewById(R.id.website);
                website = websiteField.getText().toString();
                if (website.startsWith("http://") || website.startsWith("https://")){

                } else{
                    website="http://" + website;
                }

                Intent websideIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(websideIntent);
            }
        });

    }
}
