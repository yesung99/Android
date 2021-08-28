package com.example.assignment3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    Button btnADD, btnSUB, btnMUT, btnDIV;
    TextView textResult;
    String num1, num2;
    Double result;
    Button numButtons[] = new Button[10];
    int numBtnIDs[] = { R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                        R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");
        // xml에서 만든 위젯을 findViewById 메소드를 사용해서 변수로 제어할 수 있게 했다
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        btnADD = (Button)findViewById(R.id.btnADD);
        btnSUB = (Button)findViewById(R.id.btnSUB);
        btnMUT = (Button)findViewById(R.id.btnMUT);
        btnDIV = (Button)findViewById(R.id.btnDIV);
        textResult = (TextView) findViewById(R.id.textResult);

        for(int i=0; i<numButtons.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(int i=0; i<numButtons.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(editText1.isFocused() == true){
                        num1 = editText1.getText().toString() + numButtons[index].getText().toString();
                        editText1.setText(num1);
                    }
                    else if(editText2.isFocused() == true){
                        num2 = editText2.getText().toString() + numButtons[index].getText().toString();
                        editText2.setText(num2);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Double.valueOf(num1) + Double.valueOf(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnSUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Double.valueOf(num1) - Double.valueOf(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnMUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Double.valueOf(num1) * Double.valueOf(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });

        btnDIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Double.valueOf(num1) / Double.valueOf(num2);
                textResult.setText("계산 결과 : " + result);
            }
        });
    }
}