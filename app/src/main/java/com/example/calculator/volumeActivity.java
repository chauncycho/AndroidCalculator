package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class volumeActivity extends AppCompatActivity {

    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button point;

    private Button delete;
    private Button clear;
    private Button ok;

    private EditText editText1, editText2;
    private Spinner s1, s2;

    private ConvertingUnits.Length convertLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        initialize();
        convertLength = new ConvertingUnits.Length();
    }

    public void onClick(View view) {
        String input = editText1.getText().toString();  //获得当前输入
        switch (view.getId()) {
            case R.id.length_button_point:
                if (input.length() == 0||input.charAt(input.length()-1)=='.')
                    break;
            case R.id.length_button_0:
            case R.id.length_button_1:
            case R.id.length_button_2:
            case R.id.length_button_3:
            case R.id.length_button_4:
            case R.id.length_button_5:
            case R.id.length_button_6:
            case R.id.length_button_7:
            case R.id.length_button_8:
            case R.id.length_button_9:
                editText1.setText(input + ((Button) view).getText().toString());
                break;
            case R.id.length_button_delete:
                if (editText1.getText() != null) {
                    editText1.setText(input.substring(0, input.length() - 1));
                }
                break;
            case R.id.length_button_clear:
                if (input.equals(""))
                    editText2.setText("");
                input = "";
                editText1.setText("");
                break;
            case R.id.length_button_ok:
                int item1 = s1.getSelectedItemPosition();
                int item2 = s2.getSelectedItemPosition();
                double value1 = Double.parseDouble(editText1.getText().toString());
                double result = convert(item1, item2, value1);
                editText2.setText(result + "");
                break;
        }   //switch (view.getId())
    }//onClick(View view)

    public double convert(int item1, int item2, double value) { //先转换成米，再由米转换成其他单位
        double temp = 0.0;
        if (item1 == item2)
            return value;
        else {
            switch (item1) {
                case 0:
                    temp = convertLength.KiloToMeter(value);
                    break;
                case 1:
                    temp = value;
                    break;
                case 2:
                    temp = convertLength.CentiToMeter(value);
                    break;
                case 3:
                    temp = convertLength.MilliToMeter(value);
                    break;
                case 4:
                    temp = convertLength.NanoToMeter(value);
                    break;
            }

            switch (item2) {
                case 0:
                    temp = convertLength.MeterToKilo(temp);
                    break;
                case 1:
                    temp = convertLength.MeterToCenti(temp);
                    break;
                case 2:
                    temp = convertLength.MeterToMilli(temp);
                    break;
                case 4:
                    temp = convertLength.MeterToNano(temp);
                    break;
            }
            return temp;
        }
    }

    public void initialize() {
        editText1 = (EditText) findViewById(R.id.length_editText_1);
        editText2 = (EditText) findViewById(R.id.length_editText_2);
        s1 = (Spinner) findViewById(R.id.length_spinner1);
        s2 = (Spinner) findViewById(R.id.length_spinner2);

        num0 = (Button) findViewById(R.id.length_button_0);
        num1 = (Button) findViewById(R.id.length_button_1);
        num2 = (Button) findViewById(R.id.length_button_2);
        num3 = (Button) findViewById(R.id.length_button_3);
        num4 = (Button) findViewById(R.id.length_button_4);
        num5 = (Button) findViewById(R.id.length_button_5);
        num6 = (Button) findViewById(R.id.length_button_6);
        num7 = (Button) findViewById(R.id.length_button_7);
        num8 = (Button) findViewById(R.id.length_button_8);
        num9 = (Button) findViewById(R.id.length_button_9);
        point = (Button) findViewById(R.id.length_button_point);

        clear = (Button) findViewById(R.id.length_button_clear);
        delete = (Button) findViewById(R.id.length_button_delete);
        ok = (Button) findViewById(R.id.length_button_ok);
    }
}
