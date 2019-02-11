package com.example.android.firstsportapp;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class TimerActivity extends AppCompatActivity {

    SeekBar workSeekBar;
    SeekBar restSeekBar;
    CountDownTimer countDownTimer;
    TextView workTimerTextView;
    TextView restTimerTextView;
    Button startButton;
    int workResetValue, restResetValue;

    boolean restTimer = false;

    //Declare a variable to hold count down timer's cancelled status
    private boolean isCanceled = false;


    MediaPlayer mediaPlayer;

    public void InitialiseTimers() {
        workTimerTextView.setText("0:60");
        workSeekBar.setProgress(60);
        restTimerTextView.setText("1:00");
        restSeekBar.setProgress(40);
    }

    public void resetTimers() {
        updateTimer(workResetValue);
        updateTimer2(restResetValue);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        startButton = (Button) findViewById(R.id.startButton);

        mediaPlayer = MediaPlayer.create(this, R.raw.boxing_bell_short);
        workSeekBar = (SeekBar) findViewById(R.id.workSeekBar);
        restSeekBar = (SeekBar) findViewById(R.id.restSeekBar);

        workTimerTextView = (TextView) findViewById(R.id.counterTextView);
        restTimerTextView = (TextView) findViewById(R.id.counterTextView2);

        workSeekBar.setMax(90);
        restSeekBar.setMax(90);

        InitialiseTimers();

        workSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
                workResetValue = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        restSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer2(i);
                restResetValue = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void StartButtonClicked (View view) {

        isCanceled = false;

        if (startButton.isEnabled()) {
            startButton.setEnabled(false);
        }
        //Initialise a new CountDownTimer instance
        countDownTimer = new CountDownTimer(workSeekBar.getProgress() * 1000 + 200, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                //determine if timer is cancelled
                if (isCanceled) {
                    //If the user request to cancel the
                    //CounterDownTimer we will cancel the current instance
                    cancel();
                } else {
                    //Display the remaining seconds to app interface
                    //1 second = 1000 milliseconds
                    updateTimer((int) millisUntilFinished / 1000);
                    restTimerTextView.setText("C'mon!");

                }
                //Triggers the next countdown timer
                restTimer = true;
            }

            @Override
            public void onFinish() {

                restTimerTextView.setText("Reset!");

                if (restTimer) {
                    mediaPlayer.start();
                    new CountDownTimer(restSeekBar.getProgress() * 1000 + 100, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished2) {
                            if (isCanceled) {
                                //If the user request to cancel the
                                //CounterDownTimer we will cancel the current instance
                                cancel();
                            } else {

                                //Display the remaining seconds to app interface
                                //1 second = 1000 milliseconds
                                updateTimer2((int) millisUntilFinished2 / 1000);
                                workTimerTextView.setText("Rest!");
                            }
                        }

                        @Override
                        public void onFinish() {
                            mediaPlayer.start();
                            countDownTimer.start();
                        }
                    }.start();
                }
            }
        }.start();
    }

    public void ResetButtonClicked (View view) {
        //When user request to cancel the CountDownTimer
        isCanceled = true;

        //Enable the start button
        startButton.setEnabled(true);
        resetTimers();
    }

    public void updateTimer(int secondsLeft) {
        //Int will round down number in mins and store in variable
        int minutes = secondsLeft / 60;
        //so int seconds will do calculations and store the remainder in second
        int seconds = secondsLeft - (minutes * 60);

        String secondString = Integer.toString(seconds);

        if (seconds <= 9) {
            secondString = "0" + secondString;
        }

        workTimerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    public void updateTimer2(int secondsLeft) {
        //Int will round down number in mins and store in variable
        int minutes = secondsLeft / 60;
        //so int seconds will do calculations and store the remainder in second
        int seconds = secondsLeft - (minutes * 60);

        String secondString = Integer.toString(seconds);

        if (seconds <= 9) {
            secondString = "0" + secondString;
        }

        restTimerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }
}