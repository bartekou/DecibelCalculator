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
import android.widget.TextView;

public class Decibels extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DecibelLogic decibelLogic = new DecibelLogic();

    Button buttonPower;
    Button buttonVoltage;
    Spinner spinner;
    EditText editPowerText1;
    EditText editPowerText2;
    CheckBox checkBoxPower1;
    CheckBox checkBoxPower2;
    Button buttonCalculate;
    TextView textView2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decibels);

        spinner = findViewById(R.id.spinner1);
        buttonPower = findViewById(R.id.buttonPower);
        buttonVoltage = findViewById(R.id.buttonVoltage);
        editPowerText1 = findViewById(R.id.inputPowerText1);
        editPowerText2 = findViewById(R.id.inputPowerText2);
        checkBoxPower1 = findViewById(R.id.checkBoxPower1);
        checkBoxPower2 = findViewById(R.id.checkBoxPower2);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textView2 = findViewById(R.id.textView2);
        decibelLogic.InitItemsDecibels(buttonPower, buttonVoltage, buttonCalculate, spinner, checkBoxPower1, checkBoxPower2, editPowerText1, editPowerText2);

        LoadPowerSpinner(spinner);
    }
    
    public void onClickPowerButton(View view)
    {
        decibelLogic.SetActualPowerOrVoltage(buttonPower);
        LoadPowerSpinner(spinner);
        textView2.setText("dBm");
    }    
    public void onClickVoltageButton(View view2)
    {
        decibelLogic.SetActualPowerOrVoltage(buttonVoltage);
        LoadVoltageSpinner(spinner);
        textView2.setText("dBuV");
    }

    private void LoadPowerSpinner(Spinner spinner){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.PowerValues, R.layout.spinner_bold_text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void LoadVoltageSpinner(Spinner spinner){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.VoltageValues, R.layout.spinner_bold_text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onClickCheckbox1(View view)
    {
        checkBoxPower1.setChecked(true);
        checkBoxPower2.setChecked(false);
        decibelLogic.SetActualCheckbox(checkBoxPower1);
    }

    public void onClickCheckbox2(View view)
    {
        checkBoxPower2.setChecked(true);
        checkBoxPower1.setChecked(false);
        decibelLogic.SetActualCheckbox(checkBoxPower2);

    }

    public void onClickCalculate(View view)
    {
        decibelLogic.Calculate();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}