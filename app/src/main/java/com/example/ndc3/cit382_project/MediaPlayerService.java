package com.example.ndc3.cit382_project;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by ndc3 on 5/6/2017.
 */

    public class MediaPlayerService extends Service {
    MediaPlayer myMediaPlayer;

    @Override
        public IBinder onBind(Intent intent) {

            return null;
        }

        @Override
        public void onCreate() {
            myMediaPlayer = MediaPlayer.create(this, R.raw.turning_point);
            myMediaPlayer.setLooping(true);
        }

        @Override
        public void onStart(Intent intent, int startid) {
            myMediaPlayer.start();
        }
        @Override
        public void onDestroy() {
            myMediaPlayer.stop();
        }
    }
