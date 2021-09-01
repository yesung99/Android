package com.example.assignment7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editNum1;
    EditText editNum2;
    RadioGroup radioGroup;
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("인텐트 활용");

        editNum1 = (EditText) findViewById(R.id.editNum1);
        editNum2 = (EditText) findViewById(R.id.editNum2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnNewActivity = (Button) findViewById(R.id.btnNewActivity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SecnodActivity intent 생성
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                // 라디오 버튼 판별
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioAdd: // 더하기
                        // intent에 Calc = + 값을 넣는다
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.radioSub: // 빼기
                        // intent에 Calc = - 값을 넣는다
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.radioMul: // 곱하기
                        // intent에 Calc = * 값을 넣는다
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.radioDiv: // 나누기
                        // intent에 Calc = / 값을 넣는다
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }

                // intent에 Num1 = editNum1의 값, Num2 = editNum2의 값을 넣는다
                intent.putExtra("Num1",
                        Integer.parseInt(editNum1.getText().toString()));
                intent.putExtra("Num2",
                        Integer.parseInt(editNum2.getText().toString()));

                // SecondActivity 화면 호출, 값 돌려받기 위해서 requestCode 0 입력
                startActivityForResult(intent, 0);
            }
        });
    }

    // 값을 돌려받았을 때 호출되는 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            // SecondActivity에서 보낸 resultValue 값 받기
            int resultValue = data.getIntExtra("resultValue", 0);
            Toast.makeText(getApplicationContext(),
                    "결과 : " + resultValue, Toast.LENGTH_SHORT).show();
        }
    }
}