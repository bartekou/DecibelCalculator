package pl.edu.pwr.s249286.decibelcalculator;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class WavelengthLogic {

    private Spinner m_spinnerF;
    private Spinner m_spinnerW;
    private EditText m_edTextF;
    private EditText m_edTextW;
    private CheckBox m_chBoxF;
    private CheckBox m_chBoxW;
    private Button m_calculateButton;

    private CheckBox m_actualCheckbox;

    private double result;
    private final double c = 299792458;

    public void InitItemsWavelength(Spinner spinnerF, Spinner spinnerW, EditText edTextF, EditText edTextW, CheckBox chBoxF,
                                    CheckBox chBoxW, Button calculateButton){
        m_spinnerF = spinnerF;
        m_spinnerW = spinnerW;
        m_edTextF = edTextF;
        m_edTextW = edTextW;
        m_chBoxF = chBoxF;
        m_chBoxW = chBoxW;
        m_calculateButton = calculateButton;
    }

    public void SetActualCheckboxWave(CheckBox checkBox)
    {
        m_actualCheckbox = checkBox;
    }

    public void Calculate()
    {
        try {
            if (m_actualCheckbox == m_chBoxF)
            {
                double f = FreqConverter();
                CalculateWavelength(f);
                result = FreqToWaveConverter();
                m_edTextW.setText(String.valueOf(result));
            }
            else if (m_actualCheckbox == m_chBoxW)
            {
                double w = WaveConverter();
                CalculateWavelength(w);
                result = WaveToFreqConverter();
                m_edTextF.setText(String.valueOf(result));
            }
        }
        catch (Exception exception)
        {
            System.out.println("Error");
        }
    }

    private void CalculateWavelength(double x)
    {
        result = c / x;
    }

    private double WaveConverter()
    {
        double x = 0;
        switch(m_spinnerW.getSelectedItem().toString())
        {
            case "cm":
                x = Double.valueOf(m_edTextW.getText().toString()) / Math.pow(10, 2);
                break;
            case "m":
                x = Double.valueOf(m_edTextW.getText().toString());
                break;
            default:
                break;
        }
        return x;
    }

    private double WaveToFreqConverter()
    {
        double x = 0;
        switch (m_spinnerF.getSelectedItem().toString())
        {
            case "Hz":
                x = result;
                break;
            case "kHz":
                x = result / Math.pow(10, 3);
                break;
            case "MHz":
                x = result / Math.pow(10, 6);
                break;
            case "GHz":
                x = result / Math.pow(10, 9);
                break;
            default:
                break;
        }
        return x;
    }

    private double FreqConverter()
    {
        double x = 0;
        switch (m_spinnerF.getSelectedItem().toString())
        {
            case "Hz":
                x = Double.valueOf(m_edTextF.getText().toString());
                break;
            case "kHz":
                x = Double.valueOf(m_edTextF.getText().toString()) * Math.pow(10, 3);
                break;
            case "MHz":
                x = Double.valueOf(m_edTextF.getText().toString()) * Math.pow(10, 6);
                break;
            case "GHz":
                x = Double.valueOf(m_edTextF.getText().toString()) * Math.pow(10, 9);
                break;
            default:
                break;
        }
        return x;
    }

    private double FreqToWaveConverter()
    {
        double x = 0;
        switch (m_spinnerW.getSelectedItem().toString())
        {
            case "cm":
                x = result * Math.pow(10, 2);
                break;
            case "m":
                x = result;
                break;
            default:
                break;
        }
        return x;
    }
}
