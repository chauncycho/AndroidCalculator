package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//http://javaluator.sourceforge.net/en/home
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {
    private EditText main_et_result, editTextShow;

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

    private Button add;
    private Button subtract;
    private Button multiply;
    private Button divide;

    private Button leftBrackets;
    private Button rightBrackets;
    private Button point;

    private Button delete;
    private Button clear;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         //加载菜单
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {      //监听菜单按钮
        Intent intent;
        switch (item.getItemId()) {
            case R.id.help_item:
                intent = new Intent(this, HelpActivity.class);
                startActivity(intent);
                break;
            case R.id.length_item:
                intent = new Intent(this, LengthActivity.class);
                startActivity(intent);
                break;
            case R.id.radix_item:
                intent = new Intent(this, RadixActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_et_result = findViewById(R.id.main_et_result);
        editTextShow = findViewById(R.id.edit_text_show);
        initialize();       //将各个View与按钮绑定
    }

    public void onClick(View v) { //监听当前activity的点击
        //int id = v.getId();
        String input = main_et_result.getText().toString();     //当前输入
        switch (v.getId()) {
            case R.id.main_btn_btn0:
            case R.id.main_btn_btn1:
            case R.id.main_btn_btn2:
            case R.id.main_btn_btn3:
            case R.id.main_btn_btn4:
            case R.id.main_btn_btn5:
            case R.id.main_btn_btn6:
            case R.id.main_btn_btn7:
            case R.id.main_btn_btn8:
            case R.id.main_btn_btn9:
                if (input.length() != 0) {
                    String regex = ".*pi";      //pi后不可接入数字
                    if (input.matches(regex))
                        break;
                }
                main_et_result.setText(input + ((Button) v).getText().toString());
                break;
            case R.id.main_btn_pi:
                if (input.length() != 0) {
                    String regex = ".*[\\d\\.]";    //数字后不可接pi
                    if (input.matches(regex))
                        break;
                }
                main_et_result.setText(input + ((Button) v).getText().toString());
                break;

            case R.id.main_btn_add:
            case R.id.main_btn_subtract:
            case R.id.main_btn_multiply:
            case R.id.main_btn_divide:
            case R.id.main_btn_power:
            case R.id.main_btn_point:
                if (input.length() == 0 || distinguishOperator(input.charAt(input.length() - 1)))  //操作符后不可接操作符
                    break;
                main_et_result.setText(input + ((Button) v).getText().toString());
                break;
            case R.id.main_btn_left_brackets:
                if (input.length() != 0) {
                    final char operator = input.charAt(input.length() - 1);
                    if (operator == '.' || operator == '(' || operator == ')')    //点、左括号、右括号前不可接左括号
                        break;
                }
                main_et_result.setText((input + ((Button) v).getText().toString()));
                break;
            case R.id.main_btn_right_brackets:
                if (input.length() == 0 || distinguishOperator(input.charAt(input.length() - 1))    //操作符后不可接右括号
                        || input.charAt(input.length() - 1) == ')')
                    break;
                main_et_result.setText(input + ((Button) v).getText().toString());
                break;

            case R.id.main_btn_sin:
            case R.id.main_btn_cos:
                if (input.length() != 0 && input.charAt(input.length() - 1) == '.') //点后不能接sin和cos
                    break;
                main_et_result.setText(input + ((Button) v).getText().toString() + "(");
                break;

            case R.id.main_btn_ok:
                getResult(input); //输出表达式的结果
                break;

            case R.id.main_btn_del:
                if (input != null || !input.equals("")) {
                    main_et_result.setText(input.substring(0, input.length() - 1)); //删除上一个字符
                }
                break;
            case R.id.main_btn_clear:   //清空
                if (input.equals(""))
                    editTextShow.setText("");
                input = "";
                main_et_result.setText("");
                break;
        }
    }

    private boolean distinguishOperator(final char operator) {      //判断是否为操作符
        return operator == '+' || operator == '-' || operator == '*' || operator == '/'
                || operator == '.' || operator == '(';
    }

    private void getResult(final String input) {
        if (main_et_result.length() == 0)
            return;

        DoubleEvaluator evaluator = new DoubleEvaluator();
        try {

            editTextShow.setText(new DoubleEvaluator().evaluate(input).toString()); //使用api计算出结果
        } catch (Exception e) {
            editTextShow.setText("Invalid Expression"); //表达式有异常
            e.printStackTrace();
        }
    }

    protected void initialize() { //绑定按钮
        num0 = (Button) findViewById(R.id.main_btn_btn0);
        num1 = (Button) findViewById(R.id.main_btn_btn1);
        num2 = (Button) findViewById(R.id.main_btn_btn2);
        num3 = (Button) findViewById(R.id.main_btn_btn3);
        num4 = (Button) findViewById(R.id.main_btn_btn4);
        num5 = (Button) findViewById(R.id.main_btn_btn5);
        num6 = (Button) findViewById(R.id.main_btn_btn6);
        num7 = (Button) findViewById(R.id.main_btn_btn7);
        num8 = (Button) findViewById(R.id.main_btn_btn8);
        num9 = (Button) findViewById(R.id.main_btn_btn9);

        add = (Button) findViewById(R.id.main_btn_add);
        subtract = (Button) findViewById(R.id.main_btn_subtract);
        multiply = (Button) findViewById(R.id.main_btn_multiply);
        divide = (Button) findViewById(R.id.main_btn_divide);

        leftBrackets = (Button) findViewById(R.id.main_btn_left_brackets);
        rightBrackets = (Button) findViewById(R.id.main_btn_right_brackets);
        point = (Button) findViewById(R.id.main_btn_point);

        clear = (Button) findViewById(R.id.main_btn_clear);
        delete = (Button) findViewById(R.id.main_btn_del);
    }

}