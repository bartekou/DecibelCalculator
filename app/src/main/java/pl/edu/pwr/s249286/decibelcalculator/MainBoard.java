package pl.edu.pwr.s249286.decibelcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_board);

        Button dbCalcButton = findViewById(R.id.buttonDbCalc);
        Button waveCalcButton = findViewById(R.id.buttonWaveCalc);

        dbCalcButton.setOnClickListener(v -> {

            Intent intent = new Intent(this, Decibels.class);
            startActivity(intent);
        });

        waveCalcButton.setOnClickListener(v -> {

            Intent intent = new Intent(this, Wavelength.class);
            startActivity(intent);
        });
    }
}