package com.example.android.firstsportapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class WaterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    boolean changeToWater2 = true;
    boolean changeToWater3 = false;
    boolean changeToWater4 = false;
    boolean changeToWater5 = false;
    boolean changeToWater6 = false;

    public void storeWaterOnClick(View view) {

        ImageView water1ImageView = (ImageView) findViewById(R.id.water1ImageView);
        ImageView water2ImageView = (ImageView) findViewById(R.id.water2ImageView);
        ImageView water3ImageView = (ImageView) findViewById(R.id.water3ImageView);
        ImageView water4ImageView = (ImageView) findViewById(R.id.water4ImageView);
        ImageView water5ImageView = (ImageView) findViewById(R.id.water5ImageView);
        ImageView water6ImageView = (ImageView) findViewById(R.id.water6ImageView);

        if (changeToWater2) {

            water1ImageView.animate().alpha(0).setDuration(500);
            water2ImageView.animate().alpha(1).setDuration(500);

            changeToWater2 = false;
            changeToWater3 = true;

        } else if (changeToWater3) {

            water2ImageView.animate().alpha(0).setDuration(500);
            water3ImageView.animate().alpha(1).setDuration(500);

            changeToWater3 = false;
            changeToWater4 = true;

        } else if (changeToWater4) {

            water3ImageView.animate().alpha(0).setDuration(500);
            water4ImageView.animate().alpha(1).setDuration(500);

            changeToWater4 = false;
            changeToWater5 = true;

        } else if (changeToWater5) {

            water4ImageView.animate().alpha(0).setDuration(500);
            water5ImageView.animate().alpha(1).setDuration(500);

            changeToWater5 = false;
            changeToWater6 = true;

        } else if (changeToWater6) {

            water5ImageView.animate().alpha(0).setDuration(500);
            water6ImageView.animate().alpha(1).setDuration(500);

            changeToWater6 = false;

        }

        Log.i("INFO", "Button Clicked");

        EditText editTextAmount = (EditText) findViewById(R.id.editTextAmount);
        Log.i("Amount", editTextAmount.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        Spinner spinnerUnits = (Spinner) findViewById(R.id.spinnerUnits);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.StringArray_WaterUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnits.setAdapter(adapter);
        spinnerUnits.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
