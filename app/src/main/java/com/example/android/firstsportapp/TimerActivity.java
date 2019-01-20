package com.example.android.firstsportapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class TimerActivity extends AppCompatActivity {

    //Declare a variable to hold count down timer's cancelled status
    private boolean isCanceled = false;
    private boolean fortySecondsComplete = false;

    //Declare a variable to hold CountDownTimer remaining time
    long timeRemaining = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        final Button btnStart = (Button) findViewById(R.id.startButton);
        final Button btnReset = (Button) findViewById(R.id.resetButton);
        final TextView viewTimer = (TextView) findViewById(R.id.counterTextView);
        final TextView viewTimer2 = (TextView) findViewById(R.id.counterTextView2);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCanceled = false;

                if (btnStart.isEnabled()) {
                    btnStart.setEnabled(false);
                }


                //Initialise a new CountDownTimer instance
                new CountDownTimer(41000, 1000){
                    public void onTick(long millisUntilFinished) {
                        //determine if timer is cancelled
                        if (isCanceled) {
                            //If the user request to cancel the
                            //CounterDownTimer we will cancel the current instance
                            cancel();
                        }
                        else {
                            //Display the remaining seconds to app interface
                            //1 second = 1000 milliseconds
                            viewTimer2.setText("C'mon!");
                            viewTimer.setText(String.valueOf(millisUntilFinished / 1000));
                            //Put count down timer remaining in a variable
                            timeRemaining = millisUntilFinished;
                            }
                        }

                    public void onFinish(){
                        //Enable the start button
                        btnStart.setEnabled(true);
                        viewTimer2.setText("Reset!");

                        //Next if statement starts 20 sec countdown
                        fortySecondsComplete = true;

                        if (fortySecondsComplete) {
                            new CountDownTimer(21000,1000) {

                                @Override
                                public void onTick(long millisUntilFinished2) {
                                    if (isCanceled) {
                                        //If the user request to cancel the
                                        //CounterDownTimer we will cancel the current instance
                                        cancel();
                                    }
                                    else {
                                        viewTimer.setText("Rest!");
                                        //Display the remaining seconds to app interface
                                        //1 second = 1000 milliseconds
                                        viewTimer2.setText(String.valueOf(millisUntilFinished2 / 1000));
                                        //Put count down timer remaining in a variable
                                        timeRemaining = millisUntilFinished2;
                                    }
                                }

                                @Override
                                public void onFinish() {

                                }
                            }.start();
                        }
                    }
                }.start();


            }
        });



        //Set a Click Listener for cancel/stop button
        btnReset.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                //When user request to cancel the CountDownTimer
                isCanceled = true;

                //Enable the start button
                btnStart.setEnabled(true);

                //Notify the user that CountDownTimer is canceled/stopped
                viewTimer.setText("40");
                viewTimer2.setText("20");
            }
        });

    }
}