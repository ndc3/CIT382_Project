package com.example.ndc3.cit382_project;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ndc3 on 5/6/2017.
 */

public class DigitalClockActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.digital_clock);

        Button activity2 = (Button) findViewById(R.id.Button01);
        activity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });

        Button startTimer = (Button) findViewById(R.id.startTimer);
        startTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                timerAlert(view);
            }
        });
    }

    public void timerAlert(View view) {
        EditText textField = (EditText) findViewById(R.id.timeInSeconds);
        int i = Integer.parseInt(textField.getText().toString());
        Intent timerIntent = new Intent(this, TimerBroadcastReceiver.class);
        PendingIntent myPendingIntent =
                PendingIntent.getBroadcast(this.getApplicationContext(), 0, timerIntent, 0);
        AlarmManager myAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        myAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                (i * 1000), myPendingIntent);
        Toast.makeText(this, "Alarm is set for " + i + " seconds!",
                Toast.LENGTH_LONG).show();
    }
}
