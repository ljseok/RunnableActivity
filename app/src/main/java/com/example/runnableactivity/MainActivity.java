package com.example.runnableactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG2 = "Thread2";
    private static final String TAG ="Thread" ;
    Thread wr;
    boolean running = true;

    class WorkerThread extends Thread {
        public void run() {
            int i = 0;
            for (i = 0; i < 20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                Log.v(TAG, "Thread time=" + i);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                for(i=0; i<20 && running; i++) {
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    Log.v(TAG,"Thread time=\" + i");
                    Log.v(TAG2,"Runnable time=" +i);

                }
            }
        });
        wr.start();
        Log.v(TAG2, "Now I am onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;

        Log.v(TAG2,"Now I am onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG2,"Now I am onPause");
    }
}