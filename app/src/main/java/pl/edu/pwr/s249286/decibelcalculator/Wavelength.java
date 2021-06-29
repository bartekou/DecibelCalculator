package pl.edu.pwr.s249286.decibelcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class Wavelength extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    WavelengthLogic wavelengthLogic = new WavelengthLogic();

    Spinner spinnerWave;
    Spinner spinnerFreq;
    EditText edTextWave;
    EditText edTextFreq;
    CheckBox chBoxWave;
    CheckBox chBoxFreq;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wavelength);

        spinnerWave = findViewById(R.id.spinnerWave);
        spinnerFreq = findViewById(R.id.spinnerFreq);
        edTextWave = findViewById(R.id.editTextWave);
        edTextFreq = findViewById(R.id.editTextFreq);
        chBoxWave = findViewById(R.id.checkBoxWave);
        chBoxFreq = findViewById(R.id.checkBoxFreq);
        calculateButton = findViewById(R.id.buttonCalculateWave);
        wavelengthLogic.InitItemsWavelength(spinnerFreq, spinnerWave, edTextFreq, edTextWave, chBoxFreq, chBoxWave, calculateButton);

        LoadWaveSpinner(spinnerWave);
        LoadFreqSpinner(spinnerFreq);
    }

    private void LoadWaveSpinner(Spinner spinner){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.WavelengthValues, R.layout.spinner_bold_text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void LoadFreqSpinner(Spinner spinner){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.FrequencyValues, R.layout.spinner_bold_text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onClickCheckboxWave(View view)
    {
        chBoxWave.setChecked(true);
        chBoxFreq.setChecked(false);
        wavelengthLogic.SetActualCheckboxWave(chBoxWave);
    }

    public void onClickCheckboxFreq(View view)
    {
        chBoxWave.setChecked(false);
        chBoxFreq.setChecked(true);
        wavelengthLogic.SetActualCheckboxWave(chBoxFreq);
    }

    public void onClickCalculateWave(View view)
    {
        wavelengthLogic.Calculate();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}