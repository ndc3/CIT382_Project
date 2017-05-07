package com.example.ndc3.cit382_project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ndc3 on 5/6/2017.
 */

public class TimerBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm Notification", Toast.LENGTH_LONG).show();
    }
}
