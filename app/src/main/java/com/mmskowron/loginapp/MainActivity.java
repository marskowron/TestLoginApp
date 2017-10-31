package com.mmskowron.loginapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int clickCount = 0;
   // public Button LogIn;

    public void hello (View view) throws InterruptedException {

        clickCount++;
        EditText editName = (EditText) findViewById(R.id.nameEditText);
        String name = editName.getText().toString();

        EditText editPassword = (EditText) findViewById(R.id.passwordEditText);
        String password = editPassword.getText().toString();

        Log.i("Info", "Username: " + name + " |Password: " + password);

        Toast.makeText(MainActivity.this, "Hello "+ name + "! Rabbit is watching you...", Toast.LENGTH_LONG).show();

        ImageView image = (ImageView) findViewById(R.id.rabbitImage);
        ImageView hiddenImage = (ImageView) findViewById(R.id.secondRabbitImaga);

        if (clickCount % 2 == 1)
        {
            //image.setImageResource(R.drawable.rabbit2);
            image.animate().alpha(0f).setDuration(1500);
            hiddenImage.animate().alpha(1f).setDuration(1500);}
        else
        {
            //image.setImageResource(R.drawable.rabbit);
            image.animate().alpha(1f).setDuration(1500);
            hiddenImage.animate().alpha(0f).setDuration(1500);}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logIn = (Button) findViewById(R.id.logInButton);
        logIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                EditText editName = (EditText) findViewById(R.id.nameEditText);
                String name = editName.getText().toString();
                Intent intent = new Intent(MainActivity.this, AppActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("test", "to jest jestowy przyklad");
                startActivity(intent);
                finish();
            }
        });

        ImageView settingButton = (ImageButton) findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SettingActivity.class);
                startActivityForResult(myIntent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK){
            Toast.makeText(this, data.getStringExtra("mail"), Toast.LENGTH_LONG).show();
        }
    }
}
