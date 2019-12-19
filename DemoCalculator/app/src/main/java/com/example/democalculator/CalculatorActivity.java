package com.example.democalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_add;
    private Button btn_minus;
    private Button btn_divide;
    private Button btn_dot;
    private Button btn_times;
    private Button btn_gen;
    private Button btn_clear;
    private Button btn_enter;
    private Button btn_equal;


    private TextView tv_display;
    private StringBuilder display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        tv_display = findViewById(R.id.tv_display);
        display = new StringBuilder();
        //buttons initialization
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_add = findViewById(R.id.btn_add);
        btn_minus = findViewById(R.id.btn_minus);
        btn_divide = findViewById(R.id.btn_divide);
        btn_dot = findViewById(R.id.btn_dot);
        btn_times = findViewById(R.id.btn_times);
        btn_gen = findViewById(R.id.btn_gen);
        btn_clear = findViewById(R.id.btn_clear);
        btn_enter = findViewById(R.id.btn_enter);
        btn_equal = findViewById(R.id.btn_equal);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_times.setOnClickListener(this);
        btn_gen.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_enter.setOnClickListener(this);
        btn_equal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Log.d("Click:", Integer.toString(v.getId()));

        switch (v.getId()) {
            case R.id.btn_0:
                numbersHandlers(0);
                tv_display.setText(display.toString());
                break;
            case R.id.btn_1:
                numbersHandlers(1);
                tv_display.setText(display.toString());
                break;
            case R.id.btn_2:
                numbersHandlers(2);
                tv_display.setText(display.toString());
                break;
            case R.id.btn_3:
                numbersHandlers(3);
                tv_display.setText(display.toString());
                break;
            case R.id.btn_4:
                numbersHandlers(4);
                tv_display.setText(display.toString());
                break;
            case R.id.btn_5:
                display.append('5');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_6:
                display.append('6');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_7:
                display.append('7');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_8:
                display.append('8');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_9:
                display.append('9');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_add:
                operandsHandler('+');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_minus:
                operandsHandler('-');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_divide:
                operandsHandler('\u00f7');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_times:
                operandsHandler('x');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_dot:
                dotHandler('.');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_gen:
                genHandler('\u221a');
                tv_display.setText(display.toString());
                break;
            case R.id.btn_clear:
                display.delete(0, display.length());
                tv_display.setText(display.toString());
                break;
            case R.id.btn_enter:
                break;
            case R.id.btn_equal:
                calcul();
                tv_display.setText(display.toString());
                break;

        }

    }

    //process integers from [0,9]
    private void numbersHandlers(int dig) {
        if (display != null) {
            display.append(dig);
        }
    }

    //operator handler {+, -, x, /,...}
    private void operandsHandler(char op) {
        if (display.length() != 0) {
            if (Character.isDigit(display.charAt(display.length() - 1))) {
                display.append(op);
            }
        }
    }

    //dot handler {.}
    private void dotHandler(char dot) {
        if (display.length() == 0) {
            display.append("0.");
        } else if (Character.isDigit(display.charAt(display.length() - 1))) {
            String results[] = display.toString().split("\\+|\\-|\u221a|\u00f7|x");
            if (!results[results.length - 1].contains(".")) {
                display.append('.');
            }
        } else {
            display.append("0.");
        }
    }

    //Gen handler {.}
    private void genHandler(char gen) {
        if (display.length() == 0) {
            display.append(gen);
        } else if ((!Character.isDigit(display.charAt(display.length() - 1))) && display.charAt(display.length() - 1) != gen) {
            display.append(gen);
        }

    }

    //  \u221a
    private void calcul() {
        String results[] = display.toString().split("\\+|\\-|\u00f7|x");
        double operand[] = new double[results.length];
        char[] operators = new char[results.length - 1];
        Stack<Double> doubleStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < results.length; i++) {
            if (results[i].startsWith("\u221a")) {
                operand[i] = Math.sqrt(Double.parseDouble(results[i].substring(1, results[i].length())));
            } else {
                operand[i] = Double.parseDouble(results[i]);

            }
            int index = 0;
            for (int j = 0; j <= i && i != results.length - 1; j++) {
                index += results[j].length();
            }
            if (i != results.length - 1) {
                operators[i] = display.charAt(index + i);
            }
        }

        for (int i = 0; i < operand.length; i++) {
            System.out.println("操作数" + i + ":" + operand[i]);
        }
        for (int i = 0; i < operators.length; i++) {
            System.out.println("操作符" + i + ":" + operators[i]);
        }

        int i = 0;
        while (i < operand.length) {

            doubleStack.push(operand[i]);
            if (i != operand.length - 1) {
                if (charStack.isEmpty()) {
                    charStack.push(operators[i]);
                } else {
                    while (!charStack.isEmpty()) {
                        if (getPriority(charStack.peek()) >= getPriority(operators[i])) {
                            calculate(doubleStack, charStack.pop());
                        } else break;
                    }
                    charStack.push(operators[i]);
                }
            }
            i++;
        }
        while (!charStack.isEmpty()) {
            calculate(doubleStack, charStack.pop());
        }


        String res = String.format("=%f", doubleStack.peek());
        display.append(res);
        tv_display.setText(display.toString());
        tv_display.setTextSize(20);

        System.out.println("The result is:" + doubleStack.pop());

    }


    //获取优先级
    private int getPriority(char ch) {

        if (ch == '+' || ch == '-') return 1;
        else if (ch == 'x' || ch == '\u00f7') return 2;
        else return 3;
    }

    private void calculate(Stack<Double> myStack, char operation) {
        double num1, num2, num3 = 0.0;
        num2 = myStack.peek();
        myStack.pop();
        num1 = myStack.peek();
        myStack.pop();
        if (operation == '+') {
            num3 = num1 + num2;
        } else if (operation == '-') {
            num3 = num1 - num2;
        } else if (operation == 'x') {
            num3 = num1 * num2;
        } else if (operation == '\u00f7') {
            num3 = num1 / num2;
        }

        String logText = String.format("operation %c, num3=%f", operation, num3);
        Log.d("calculate()", logText);
        myStack.push(num3);
    }

    private void updateDisplaywithOperator(char c) {

        if (display.length() == 0) return;
        if (isOperatorLastInput()) {
            display.deleteCharAt(display.length() - 1);
            display.append(c);
        } else {
            display.append(c);
        }

    }


    private Boolean isOperatorLastInput() {
        char lastChar = display.charAt(display.length() - 1);
        if (lastChar == 'x')
            return true;
        else if (lastChar == '+')
            return true;
        else if (lastChar == '-')
            return true;
        else if (lastChar == '\u221a')
            return true;
        else if (lastChar == '\u00f7')
            return true;
        else
            return false;
    }


    private void dotHandler() {
        if (isOperatorLastInput()) return;
        String results[] = display.toString().split("\\+|\\-|\u221a|\u00f7|x");
        if (results[results.length - 1].contains(".")) return;
        updateDisplaywithOperator('.');
    }
}
