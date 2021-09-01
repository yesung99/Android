package com.example.assignment7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        // 메인 액티비티에서 넘겨준 값 받기 위함
        Intent mainIntent = getIntent();
        // 메인 액티비티에서 보낸 Calc 값 저장
        String calc = (mainIntent.getStringExtra("Calc"));
        int value = 0;

        if (calc.equals("+")) { // Calc = + 일 때
            value = mainIntent.getIntExtra("Num1", 0)
                    + mainIntent.getIntExtra("Num2", 0);
        } else if (calc.equals("-")) { // Calc = - 일 때
            value = mainIntent.getIntExtra("Num1", 0)
                    - mainIntent.getIntExtra("Num2", 0);
        } else if (calc.equals("*")) { // Calc = * 일 때
            value = mainIntent.getIntExtra("Num1", 0)
                    * mainIntent.getIntExtra("Num2", 0);
        } else if(calc.equals("/")){ // Calc = / 일 때
            // 만약 Num1, Num2 둘 중 하나의 값이 0이 존재 할 경우
            if(mainIntent.getIntExtra("Num1", 0) == 0 ||
                    mainIntent.getIntExtra("Num2", 0) == 0 ){
                Toast.makeText(getApplicationContext(),
                        "0으로 입력된 숫자가 있습니다.", Toast.LENGTH_SHORT).show();
                value = 0;
            }
            else {
                value = mainIntent.getIntExtra("Num1", 0)
                        / mainIntent.getIntExtra("Num2", 0);
            }
        }

        final int resultValue = value;

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 메인 액티비티에 전달 할 intent 생성
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                // intent에 resultValue 넣어서 전달
                outIntent.putExtra("resultValue", resultValue);
                // 메인 액티비티의 onActivityResult 메소드 호출
                setResult(RESULT_OK, outIntent);
                finish(); // 현재 액티비티 닫기
            }
        });
    }
}
