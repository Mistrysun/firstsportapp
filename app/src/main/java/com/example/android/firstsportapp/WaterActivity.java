package com.example.android.firstsportapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class WaterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public void clickFunction(View view) {
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
