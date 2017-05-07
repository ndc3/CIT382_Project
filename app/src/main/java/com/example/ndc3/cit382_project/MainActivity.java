package com.example.ndc3.cit382_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Activity1 = (Button) findViewById(R.id.Button01);
        Activity1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent =
                        new Intent(view.getContext(), DigitalClockActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button Activity2 = (Button) findViewById(R.id.Button03);
        Activity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent =
                        new Intent(view.getContext(), GridViewMain.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startService(new Intent(getBaseContext(), MediaPlayerService.class));
            }
        });

        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopService(new Intent(getBaseContext(), MediaPlayerService.class));
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.reset:
                Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(MainActivity.this, "Digital clock app, Click the buttons to start", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.exit:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
