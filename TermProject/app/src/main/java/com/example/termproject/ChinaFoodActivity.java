package com.example.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChinaFoodActivity extends AppCompatActivity {
    // 상단의 '한식', '중식', '일식', '계산하기' 버튼
    Button koreaFoodBtn2, chinaFoodBtn2, japanFoodBtn2, calcBtn2;

    Button c_choiceBtn1; // 짜장면 선택
    TextView c_choiceMenu1; // 짜장면 선택 개수 출력
    Button c_cancelBtn1; // 짜장면 선택 취소
    int count1 = 0;

    Button c_choiceBtn2;
    TextView c_choiceMenu2;
    Button c_cancelBtn2;
    int count2 = 0;

    Button c_choiceBtn3;
    TextView c_choiceMenu3;
    Button c_cancelBtn3;
    int count3 = 0;

    int price2 = 0; // 총 '중식' 계산 가격
    int koreaPrice, chinaPrice, japanPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_food);
        setTitle("중식 메뉴");

        // 한식이나 일식에서 넘어온 값 받기
        Intent getPriceIntent = getIntent();
        koreaPrice = getPriceIntent.getIntExtra("koreaPrice", 0);
        japanPrice = getPriceIntent.getIntExtra("japanPrice", 0);
        // 정상 출력 된다.
        Toast.makeText(this, "한식에서 받은 값 : " + koreaPrice +
                "\n일식에서 받은 값 : " + japanPrice, Toast.LENGTH_SHORT).show();

        // 상단의 버튼 위젯
        koreaFoodBtn2 = (Button)findViewById(R.id.koreaFoodBtn2);
        chinaFoodBtn2 = (Button)findViewById(R.id.chinaFoodBtn2);
        japanFoodBtn2 = (Button)findViewById(R.id.japanFoodBtn2);
        calcBtn2 = (Button)findViewById(R.id.calcBtn2);

        // 짜장면 선택 위젯
        c_choiceBtn1 = findViewById(R.id.c_choiceBtn1);
        c_choiceMenu1 = findViewById(R.id.c_choiceMenu1);
        c_cancelBtn1 = findViewById(R.id.c_cancelBtn1);
        // 짬뽕 선택 위젯
        c_choiceBtn2 = findViewById(R.id.c_choiceBtn2);
        c_choiceMenu2 = findViewById(R.id.c_choiceMenu2);
        c_cancelBtn2 = findViewById(R.id.c_cancelBtn2);
        // 볶음밥 선택 위젯
        c_choiceBtn3 = findViewById(R.id.c_choiceBtn3);
        c_choiceMenu3 = findViewById(R.id.c_choiceMenu3);
        c_cancelBtn3 = findViewById(R.id.c_cancelBtn3);

        // 상단 버튼 이벤트 처리
        koreaFoodBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'한식'을 누르셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent koreaIntent = new Intent(getApplicationContext(), KoreaFoodActivity.class);
                chinaPrice = price2;
                koreaIntent.putExtra("chinaPrice", chinaPrice);
                koreaIntent.putExtra("japanPrice", japanPrice);
                startActivity(koreaIntent);
            }
        });

        chinaFoodBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "이미 '중식'을 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        japanFoodBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'일식'을 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent japanIntent = new Intent(getApplicationContext(), JapanFoodActivity.class);
                chinaPrice = price2;
                japanIntent.putExtra("chinaPrice", chinaPrice);
                japanIntent.putExtra("koreaPrice", koreaPrice);
                startActivity(japanIntent);
            }
        });

        calcBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'계산하기'를 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent calcIntent = new Intent(getApplicationContext(), CalcActivity.class);
                chinaPrice = price2;
                calcIntent.putExtra("koreaPrice", koreaPrice);
                calcIntent.putExtra("chinaPrice", chinaPrice);
                calcIntent.putExtra("japanPrice", japanPrice);
                startActivity(calcIntent);
            }
        });

        // 짜장면 선택
        c_choiceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1++;
                c_choiceMenu1.setText("선택 : " + count1);
                Toast.makeText(getApplicationContext(), "짜장면을 선택하셨습니다",
                        Toast.LENGTH_SHORT).show();
                price2 += 3500;
            }
        });

        // 짜장면 선택 취소
        c_cancelBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count1 > 0){
                    count1--;
                    c_choiceMenu1.setText("선택 : " + count1);
                    price2 -= 3500;
                }
            }
        });

        // 짬뽕 선택
        c_choiceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2++;
                c_choiceMenu2.setText("선택 : " + count2);
                Toast.makeText(getApplicationContext(), "짬뽕을 선택하셨습니다",
                        Toast.LENGTH_SHORT).show();
                price2 += 4000;
            }
        });

        // 짬뽕 선택 취소
        c_cancelBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count2 > 0){
                    count2--;
                    c_choiceMenu2.setText("선택 : " + count2);
                    price2 -= 4000;
                }
            }
        });

        // 볶음밥 선택
        c_choiceBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count3++;
                c_choiceMenu3.setText("선택 : " + count3);
                Toast.makeText(getApplicationContext(),
                        "볶음밥을 선택하셨습니다", Toast.LENGTH_SHORT).show();
                price2 += 4500;
            }
        });

        // 볶음밥 선택 취소
        c_cancelBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count3 > 0){
                    count3--;
                    c_choiceMenu3.setText("선택 : " + count3);
                    price2 -= 4500;
                }
            }
        });
    }

}

