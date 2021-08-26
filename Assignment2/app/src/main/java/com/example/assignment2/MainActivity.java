package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText EditText1;
    EditText EditText2;
    Button BtnAdd;
    Button BtnSub;
    Button BtnMul;
    Button BtnDiv;
    Button BtnRest;
    TextView TextResult;
    String num1, num2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        // xml에서 만든 위젯을 findViewById 메소드를 사용해서 변수로 제어할 수 있도록 했다
        EditText1 = (EditText)findViewById(R.id.EditText1); // 숫자1 위젯 연결
        EditText2 = (EditText)findViewById(R.id.EditText2); // 숫자2
        BtnAdd = (Button)findViewById(R.id.BtnAdd); // 더하기
        BtnSub = (Button)findViewById(R.id.BtnSub); // 빼기
        BtnMul = (Button)findViewById(R.id.BtnMul); // 곱하기
        BtnDiv = (Button)findViewById(R.id.BtnDiv); // 나누기
        BtnRest = (Button)findViewById(R.id.BtnRest); // 나머지
        TextResult = (TextView)findViewById(R.id.TextResult); // 결과

        // 더하기 버튼 눌렀을 때 발생되는 메소드
        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = EditText1.getText().toString();
                num2 = EditText2.getText().toString();
                result = Double.valueOf(num1) + Double.valueOf(num2);
                TextResult.setText("계산 결과 : " + result);
            }
        });

        // 빼기 버튼 눌렀을 때 발생되는 메소드
        BtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = EditText1.getText().toString();
                num2 = EditText2.getText().toString();
                result = Double.valueOf(num1) - Double.valueOf(num2);
                TextResult.setText("계산 결과 : " + result);
            }
        });

        // 곱하기 버튼 눌렀을 때 발생되는 메소드
        BtnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = EditText1.getText().toString();
                num2 = EditText2.getText().toString();
                result = Double.valueOf(num1) * Double.valueOf(num2);
                TextResult.setText("계산 결과 : " + result);
            }
        });

        // 나누기 버튼 눌렀을 때 발생되는 메소드
        BtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = EditText1.getText().toString();
                num2 = EditText2.getText().toString();
                result = Double.valueOf(num1) / Double.valueOf(num2);
                TextResult.setText("계산 결과 : " + result);
            }
        });

        // 나머지 버튼 눌렀을 때 발생되는 메소드
        BtnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = EditText1.getText().toString();
                num2 = EditText2.getText().toString();
                if(Double.valueOf(num1) == 0 || Double.valueOf(num2) == 0){
                    TextResult.setText("계산 결과 : 계산 불가");
                }
                else{
                    result = Double.valueOf(num1) % Double.valueOf(num2);
                    TextResult.setText("계산 결과 : " + result);
                }

            }
        });
    }
}