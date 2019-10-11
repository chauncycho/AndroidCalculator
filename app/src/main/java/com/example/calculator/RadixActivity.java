package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RadixActivity extends AppCompatActivity {

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
    private Button a, b, c, d, e, f;

    private Button delete;
    private Button clear;
    private Button ok;

    private EditText editText1, editText2;
    private Spinner s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radix);
        initialize();

    }

    public void onClick(View view) {
        int item1 = s1.getSelectedItemPosition();       //获得当前spinner的选项
        int item2 = s2.getSelectedItemPosition();

        String input = editText1.getText().toString();  //获得当前输入框

        switch (item1) {                            //监听输入按钮
            case 0:                                 //binary
                switch (view.getId()) {             //二进制只允许输入0和1
                    case R.id.radix_button_0:
                    case R.id.radix_button_1:
                        editText1.setText(input + ((Button) view).getText().toString());
                        break;
                }
                break;
            case 1:                                 //decimal
                switch (view.getId()) {             //十进制只允许输入0-9
                    case R.id.radix_button_0:
                    case R.id.radix_button_1:
                    case R.id.radix_button_2:
                    case R.id.radix_button_3:
                    case R.id.radix_button_4:
                    case R.id.radix_button_5:
                    case R.id.radix_button_6:
                    case R.id.radix_button_7:
                    case R.id.radix_button_8:
                    case R.id.radix_button_9:
                        editText1.setText(input + ((Button) view).getText().toString());
                        break;
                }
                break;
            case 2:                                    //hexadecimal
                switch (view.getId()) {                //16进制可以输入0-9、a-f
                    case R.id.radix_button_0:
                    case R.id.radix_button_1:
                    case R.id.radix_button_2:
                    case R.id.radix_button_3:
                    case R.id.radix_button_4:
                    case R.id.radix_button_5:
                    case R.id.radix_button_6:
                    case R.id.radix_button_7:
                    case R.id.radix_button_8:
                    case R.id.radix_button_9:
                    case R.id.radix_button_a:
                    case R.id.radix_button_b:
                    case R.id.radix_button_c:
                    case R.id.radix_button_d:
                    case R.id.radix_button_e:
                    case R.id.radix_button_f:
                        editText1.setText(input + ((Button) view).getText().toString());
                        break;
                }
                break;
        }   //switch(item1)
        Log.d("this", "时刻1: " + input);

        input = editText1.getText().toString();
        Log.d("this", "时刻2: " + input);
        switch (view.getId()) {                     //监听“=“ “del” “C”
            case R.id.radix_button_ok: {
                if (item1 == item2) {                           //若选项相同，则直接输出
                    editText2.setText(editText1.getText());
                    return;
                }
                try {                               //先把当前进制转换成十进制，再由十进制转换为要转换的进制
                    switch (item1) {                //将要处理的数据的进制
                        case 0: {                   //二进制
                            int integer = Integer.parseInt(input, 2);   //二进制转成十进制
                            switch (item2) {
                                case 1:
                                    editText2.setText(Integer.toString(integer));
                                    break;
                                case 2:
                                    editText2.setText(Integer.toHexString(integer));
                                    break;
                            }
                            break;
                        }
                        case 1: {                   //十进制
                            int integer = Integer.valueOf(input);
                            switch (item2) {
                                case 0:
                                    editText2.setText(Integer.toBinaryString(integer));
                                    break;
                                case 2:
                                    editText2.setText(Integer.toHexString(integer));
                                    break;
                            }
                            break;
                        }
                        case 2: {                   //十六进制
                            int integer = Integer.parseInt(input, 16);  //十六进制转十进制
                            switch (item2) {
                                case 0:
                                    editText2.setText(Integer.toBinaryString(integer));
                                    break;
                                case 1:
                                    editText2.setText(Integer.toString(integer));
                                    break;
                            }
                            break;
                        }   //case 2
                    }//switch(item1)
                } catch (Exception e) {
                    editText2.setText("Invalid Expression");
                    e.printStackTrace();
                }
                break;
            }//case R.id.radix_button_ok
            case R.id.radix_button_delete:
                if (editText1.getText() != null) {
                    editText1.setText(input.substring(0, input.length() - 1));
                }
                break;
            case R.id.radix_button_clear:
                if (input.equals(""))
                    editText2.setText("");
                input = "";
                editText1.setText("");
                break;
        }//switch(view.getId())
    }//onClick(View view)

    private void initialize() {
        editText1 = (EditText) findViewById(R.id.radix_editText_1);
        editText2 = (EditText) findViewById(R.id.radix_editText_2);
        s1 = (Spinner) findViewById(R.id.radix_spinner1);
        s2 = (Spinner) findViewById(R.id.radix_spinner2);

        num0 = (Button) findViewById(R.id.radix_button_0);
        num1 = (Button) findViewById(R.id.radix_button_1);
        num2 = (Button) findViewById(R.id.radix_button_2);
        num3 = (Button) findViewById(R.id.radix_button_3);
        num4 = (Button) findViewById(R.id.radix_button_4);
        num5 = (Button) findViewById(R.id.radix_button_5);
        num6 = (Button) findViewById(R.id.radix_button_6);
        num7 = (Button) findViewById(R.id.radix_button_7);
        num8 = (Button) findViewById(R.id.radix_button_8);
        num9 = (Button) findViewById(R.id.radix_button_9);
        a = (Button) findViewById(R.id.radix_button_a);
        b = (Button) findViewById(R.id.radix_button_b);
        c = (Button) findViewById(R.id.radix_button_c);
        d = (Button) findViewById(R.id.radix_button_d);
        e = (Button) findViewById(R.id.radix_button_e);
        f = (Button) findViewById(R.id.radix_button_f);

        clear = (Button) findViewById(R.id.radix_button_clear);
        delete = (Button) findViewById(R.id.radix_button_delete);
        ok = (Button) findViewById(R.id.radix_button_ok);
    }

}
