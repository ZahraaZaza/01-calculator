package ca.campbell.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.*;

//  TODO: add buttons & methods for subtract, multiply, divide
//  TODO: extra input validation: no divide by zero

//  TODO: add a clear button that will clear the result & input fields

//  TODO: the hint for the result widget is hard coded, put it in the strings file

public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView result;
    private TextView msgHeaderNum1, msgHeaderNum2, msg;
    String num1Str, num2Str;

    double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get a handle on the text fields
        etNum1 = (EditText) findViewById(R.id.num1);
        etNum2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);

    }  //onCreate()

    // TODO: input validation: set text to show error
    public void addNums(View v) {
        num1Str = etNum1.getText().toString();
        num2Str = etNum2.getText().toString();

        if (isValid(num1Str) && isValid(num2Str)) {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
            result.setText(Double.toString(num1 + num2));
        }
        else
            result.setText(R.string.invInput);



    }  //addNums()

    public void substractNums(View v){
        num1Str = etNum1.getText().toString();
        num2Str = etNum2.getText().toString();

        if (isValid(num1Str) && isValid(num2Str)) {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
            result.setText(Double.toString(num1 - num2));
        }
        else
            result.setText(R.string.invInput);
    }

    public void divideNums(View v){
        num1Str = etNum1.getText().toString();
        num2Str = etNum2.getText().toString();

        if ( isValid(num1Str) && num2Str.equals("0")) {
            // display error message
            result.setText(R.string.invDivision);
        }

        else if (isValid(num1Str) && isValid(num2Str)) {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
            result.setText(Double.toString(num1 / num2));
        }

        else
            result.setText(R.string.invInput);

    }

    public void multiplyNums(View v) {
        num1Str = etNum1.getText().toString();
        num2Str = etNum2.getText().toString();

        if (isValid(num1Str) && isValid(num2Str)) {
            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
            result.setText(Double.toString(num1 * num2));
        }
        else
            result.setText(R.string.invInput);
    }

    public boolean isValid(String num){
        String regexStr = "-?[0-9]*[.]?[0-9]+";

        if(num.matches(regexStr))
            return true;

        else
            return false;
    }

    public void clearData(View v){
        etNum1.setText("");
        etNum2.setText("");
        result.setText("");
    }

}