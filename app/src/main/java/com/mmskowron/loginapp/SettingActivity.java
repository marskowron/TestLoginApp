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

    ImageButton sendMailButton;
    ImageButton goToWebsiteButton;
    String email;
    String website;
    EditText websiteField;
    EditText emailField;
    Button returnButton;
    int countMail = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        returnButton = (Button) findViewById(R.id.returnButton);
        sendMailButton = (ImageButton) findViewById(R.id.sendMailButton);
        goToWebsiteButton = (ImageButton) findViewById(R.id.goToWebsiteButton);
        websiteField = (EditText) findViewById(R.id.website);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailField = (EditText) findViewById(R.id.email);
                email = emailField.getText().toString();

                Intent myIntent = new Intent();
                if(countMail > 0) {
                    myIntent.putExtra("mail", "Wysłałeś maila do: " + email);
                }
                else{
                    myIntent.putExtra("mail", "Do nikogo nie wysłaleś maila :( Nie masz przyjaciół???");
                }
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });

        sendMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                emailField = (EditText) findViewById(R.id.email);
                email = emailField.getText().toString();
                countMail++;
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",email, null));
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Testowy temat");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Witam! \nTo jest treść maila \nPozdrawiam \nMMS");
                startActivity(Intent.createChooser(sendIntent, "Send email..."));
            }
        });

        goToWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
