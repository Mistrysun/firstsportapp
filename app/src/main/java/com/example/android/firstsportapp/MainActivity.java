package com.example.android.firstsportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnSchedule;
    private Button btnMyFoodDiary;
    private Button btnWorkouts;
    private Button btnWater;
    private Button btnLog;
    private Button btnScience;
    private Button btnTimer;
    private Button btnLogOut;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSchedule = (Button) findViewById(R.id.btnRoutines);
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenScheduleActivity();
            }
        });

        btnMyFoodDiary = (Button) findViewById(R.id.btnMyFoodDiary);
        btnMyFoodDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMyFoodDiaryActivity();
            }
        });

        btnWorkouts = (Button) findViewById(R.id.btnWorkouts);
        btnWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenWorkoutsActivity();
            }
        });

        btnWater = (Button) findViewById(R.id.btnWater);
        btnWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenWaterActivity();
            }
        });

        btnLog = (Button) findViewById(R.id.btnLog);
        btnLog.setEnabled(false);

        btnScience = (Button) findViewById(R.id.btnScience);
        btnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenScienceActivity();
            }
        });

        btnTimer = (Button) findViewById(R.id.btnTimer);
        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenTimerActivity();
            }
        });

        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                OpenLogOutActivity();
            }
        });

    }

    public void OpenScheduleActivity() {
        Intent OnClickOperation = new Intent(this, FiveDaySplitActivity.class);
        startActivity(OnClickOperation);
    }

    public void OpenMyFoodDiaryActivity() {
        Intent OnClickOperation = new Intent(this, MyFoodDiaryActivity.class);
        startActivity(OnClickOperation);
    }

    public void OpenWorkoutsActivity() {
        Intent OnClickOperation = new Intent(this, WorkOutsActivity.class);
        startActivity(OnClickOperation);
    }

    public void OpenWaterActivity() {
        Intent OnClickOperation = new Intent(this, WaterActivity.class);
        startActivity(OnClickOperation);
    }

    public void OpenScienceActivity() {
        Intent OnClickOperation = new Intent(this, ScienceActivity.class);
        startActivity(OnClickOperation);
    }

    public void OpenTimerActivity() {
        Intent OnClickOperation = new Intent(this, TimerActivity.class);
        startActivity(OnClickOperation);
    }

    public void OpenLogOutActivity() {
        Intent onClickOperation = new Intent(this, LoginActivity.class);
        startActivity(onClickOperation);
        Toast.makeText(this, "Logged Out!", Toast.LENGTH_SHORT).show();
    }
}
