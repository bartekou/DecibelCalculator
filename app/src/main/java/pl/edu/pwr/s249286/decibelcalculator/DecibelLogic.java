package pl.edu.pwr.s249286.decibelcalculator;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class DecibelLogic {
    private Button m_powerButton;
    private Button m_voltageButton;
    //private Button m_calculateButton;
    private Spinner m_spinner;
    private CheckBox m_powerCheckbox1;
    private CheckBox m_powerCheckbox2;
    private EditText m_etPower1;
    private EditText m_etPower2;

    private Button m_actualPowerOrVoltage;
    //private Spinner m_actualSpinner;
    private CheckBox m_actualCheckbox;

    private double result;

    public void InitItemsDecibels(Button powerButton, Button voltageButton, Button calculateButton, Spinner spinner, CheckBox chPower1,
                                  CheckBox chPower2, EditText etPower1, EditText etPower2){
        m_powerButton = powerButton;
        m_voltageButton = voltageButton;
        //m_calculateButton = calculateButton;
        m_spinner = spinner;
        m_powerCheckbox1 = chPower1;
        m_powerCheckbox2 = chPower2;
        m_etPower1 = etPower1;
        m_etPower2 = etPower2;
    }

    private void CheckPowerOrVoltage(){
        if(m_actualPowerOrVoltage == m_powerButton)
        {
            System.out.println("power");
        }
        else if (m_actualPowerOrVoltage == m_voltageButton)
        {
            System.out.println("voltage");
        }
    }

    public void SetActualPowerOrVoltage(Button button)
    {
        m_actualPowerOrVoltage = button;
        CheckPowerOrVoltage();
    }

    public void SetActualCheckbox(CheckBox checkBox)
    {
        m_actualCheckbox = checkBox;
    }

    public void Calculate()
    {
        try {

            if (m_actualPowerOrVoltage == m_powerButton) {

                if (m_actualCheckbox == m_powerCheckbox1) {
                    double x = wattConverter();
                    CalculatePowerTodBm(x);
                    m_etPower2.setText(String.valueOf(result));
                } else if (m_actualCheckbox == m_powerCheckbox2) {
                    CalculatedBmToPower(Double.valueOf(m_etPower2.getText().toString()));
                    double y = dbmConverter();
                    m_etPower1.setText(String.valueOf(y));
                }
            }

            else if (m_actualPowerOrVoltage == m_voltageButton){
                if (m_actualCheckbox == m_powerCheckbox1)
                {
                    double x = voltageConverter();
                    CalculateVoltageToDbuv(x);
                    m_etPower2.setText(String.valueOf(result));
                }
                else if (m_actualCheckbox == m_powerCheckbox2)
                {
                    CalculateDbuvToVoltage(Double.valueOf(m_etPower2.getText().toString()));
                    double y = dbuvConverter();
                    m_etPower1.setText(String.valueOf(y));
                }
            }
        }

        catch (Exception exception)
        {
            System.out.println("Error");
        }
    }

    private void CalculatePowerTodBm(double x)
    {
        result = 10 * Math.log10(1 * x);
    }

    private void CalculatedBmToPower(double x)
    {
        double p = x / 10;
        result = (1 * Math.pow(10, p))/1;

    }

    private void CalculateVoltageToDbuv(double x)
    {
        result = 20 * Math.log10(x);
    }

    private void CalculateDbuvToVoltage(double x)
    {
        double y = x/20;
        result = Math.pow(10, y);
    }

    private double wattConverter()
    {
        double x = 0;
        switch (m_spinner.getSelectedItem().toString())
        {
            case "pW":
                x = Double.valueOf(m_etPower1.getText().toString()) / (Math.pow(10, 9));
                break;
            case "nW":
                x = Double.valueOf(m_etPower1.getText().toString()) / (Math.pow(10, 6));
                break;
            case "uW":
                x = Double.valueOf(m_etPower1.getText().toString()) / (Math.pow(10, 3));
                break;
            case "mW":
                x = Double.valueOf(m_etPower1.getText().toString());
                break;
            case "W":
                x = Double.valueOf(m_etPower1.getText().toString()) * (Math.pow(10, 3));
                break;
            case "kW":
                x = Double.valueOf(m_etPower1.getText().toString()) * (Math.pow(10, 6));
                break;
            case "MW":
                x = Double.valueOf(m_etPower1.getText().toString()) * (Math.pow(10, 9));
                break;
            default:
                break;
        }
        return x;
    }

    private double dbmConverter()
    {
        double x = 0;
        switch (m_spinner.getSelectedItem().toString())
        {
            case "pW":
                x = result * (Math.pow(10, 9));
                break;
            case "nW":
                x = result * (Math.pow(10, 6));
                break;
            case "uW":
                x = result * (Math.pow(10, 3));
                break;
            case "mW":
                x = result;
                break;
            case "W":
                x = result / (Math.pow(10, 3));
                break;
            case "kW":
                x = result / (Math.pow(10, 6));
                break;
            case "MW":
                x = result / (Math.pow(10, 9));
                break;
            default:
                break;
        }
        return x;
    }

    private double voltageConverter()
    {
        double x = 0;
        switch (m_spinner.getSelectedItem().toString())
        {
            case "pV":
                x = Double.valueOf(m_etPower1.getText().toString()) / (Math.pow(10, 6));
                break;
            case "nV":
                x = Double.valueOf(m_etPower1.getText().toString()) / (Math.pow(10, 3));
                break;
            case "uV":
                x = Double.valueOf(m_etPower1.getText().toString());
                break;
            case "mV":
                x = Double.valueOf(m_etPower1.getText().toString()) * (Math.pow(10, 3));
                break;
            case "V":
                x = Double.valueOf(m_etPower1.getText().toString()) * (Math.pow(10, 6));
                break;
            case "kV":
                x = Double.valueOf(m_etPower1.getText().toString()) * (Math.pow(10, 9));
                break;
            case "MV":
                x = Double.valueOf(m_etPower1.getText().toString()) * (Math.pow(10, 12));
                break;
            default:
                break;
        }
        return x;
    }

    private double dbuvConverter()
    {
        double x = 0;
        switch (m_spinner.getSelectedItem().toString())
        {
            case "pV":
                x = result * (Math.pow(10, 6));
                break;
            case "nV":
                x = result * (Math.pow(10, 3));
                break;
            case "uV":
                x = result;
                break;
            case "mV":
                x = result / (Math.pow(10, 3));
                break;
            case "V":
                x = result / (Math.pow(10, 6));
                break;
            case "kV":
                x = result / (Math.pow(10, 9));
                break;
            case "MV":
                x = result / (Math.pow(10, 12));
                break;
            default:
                break;
        }
        return x;
    }
}
