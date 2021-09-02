package com.example.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JapanFoodActivity extends AppCompatActivity {
    // 상단의 '한식', '중식', '일식', '계산하기' 버튼

    Button koreaFoodBtn3, chinaFoodBtn3, japanFoodBtn3, calcBtn3;
    Button j_choiceBtn1; // 돈까스 선택
    TextView j_choiceMenu1; // 돈까스 선택 개수 출력
    Button j_cancelBtn1; // 돈까스 선택 취소
    int count1 = 0;

    Button j_choiceBtn2;
    TextView j_choiceMenu2;
    Button j_cancelBtn2;
    int count2 = 0;

    Button j_choiceBtn3;
    TextView j_choiceMenu3;
    Button j_cancelBtn3;
    int count3 = 0;

    int price3 = 0; // 총 '일식' 계산 가격
    int koreaPrice, chinaPrice, japanPrice;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japan_food);
        setTitle("일식 메뉴");

        // 한식이나 중식에서 넘어온 값 받기
        Intent getPriceIntent = getIntent();
        koreaPrice = getPriceIntent.getIntExtra("koreaPrice", 0);
        chinaPrice = getPriceIntent.getIntExtra("chinaPrice", 0);
        Toast.makeText(this, "한식에서 받은 값 : " + koreaPrice +
                "\n중식에서 받은 값 : " + chinaPrice, Toast.LENGTH_SHORT).show();

        // 상단의 버튼 위젯
        koreaFoodBtn3 = (Button)findViewById(R.id.koreaFoodBtn3);
        chinaFoodBtn3 = (Button)findViewById(R.id.chinaFoodBtn3);
        japanFoodBtn3 = (Button)findViewById(R.id.japanFoodBtn3);
        calcBtn3 = (Button)findViewById(R.id.calcBtn3);

        // 돈까스 선택 위젯
        j_choiceBtn1 = findViewById(R.id.j_choiceBtn1);
        j_choiceMenu1 = findViewById(R.id.j_choiceMenu1);
        j_cancelBtn1 = findViewById(R.id.j_cancelBtn1);
        // 우동 선택 위젯
        j_choiceBtn2 = findViewById(R.id.j_choiceBtn2);
        j_choiceMenu2 = findViewById(R.id.j_choiceMenu2);
        j_cancelBtn2 = findViewById(R.id.j_cancelBtn2);
        // 규동 선택 위젯
        j_choiceBtn3 = findViewById(R.id.j_choiceBtn3);
        j_choiceMenu3 = findViewById(R.id.j_choiceMenu3);
        j_cancelBtn3 = findViewById(R.id.j_cancelBtn3);

        // 상단 버튼 이벤트 처리
        koreaFoodBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'한식'을 누르셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent koreaIntent = new Intent(getApplicationContext(), KoreaFoodActivity.class);
                japanPrice = price3;
                koreaIntent.putExtra("chinaPrice", chinaPrice);
                koreaIntent.putExtra("japanPrice", japanPrice);
                startActivity(koreaIntent);
            }
        });

        chinaFoodBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'중식'을 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent chinaIntent = new Intent(getApplicationContext(), ChinaFoodActivity.class);
                japanPrice = price3;
                chinaIntent.putExtra("koreaPrice", koreaPrice);
                chinaIntent.putExtra("japanPrice", japanPrice);
                startActivity(chinaIntent);
            }
        });

        japanFoodBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "이미 '일식'을 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        calcBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'계산하기'를 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent calcIntent = new Intent(getApplicationContext(), CalcActivity.class);
                japanPrice = price3;

                calcIntent.putExtra("koreaPrice", koreaPrice);
                calcIntent.putExtra("chinaPrice", chinaPrice);
                calcIntent.putExtra("japanPrice", japanPrice);
                startActivity(calcIntent);
            }
        });

        // 돈까스 선택
        j_choiceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1++;
                j_choiceMenu1.setText("선택 : " + count1);
                Toast.makeText(getApplicationContext(), "돈까스를 선택하셨습니다",
                        Toast.LENGTH_SHORT).show();
                price3 += 6000;
            }
        });

        // 돈까스 선택 취소
        j_cancelBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count1 > 0){
                    count1--;
                    j_choiceMenu1.setText("선택 : " + count1);
                    price3 -= 6000;
                }
            }
        });

        // 우동 선택
        j_choiceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2++;
                j_choiceMenu2.setText("선택 : " + count2);
                Toast.makeText(getApplicationContext(), "우동을 선택하셨습니다",
                        Toast.LENGTH_SHORT).show();
                price3 += 3500;
            }
        });

        // 우동 선택 취소
        j_cancelBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count2 > 0){
                    count2--;
                    j_choiceMenu2.setText("선택 : " + count2);
                    price3 -= 3500;
                }
            }
        });

        // 규동 선택
        j_choiceBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count3++;
                j_choiceMenu3.setText("선택 : " + count3);
                Toast.makeText(getApplicationContext(), "규동을 선택하셨습니다",
                        Toast.LENGTH_SHORT).show();
                price3 += 5000;
            }
        });

        // 규동 선택 취소
        j_cancelBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count3 > 0){
                    count3--;
                    j_choiceMenu3.setText("선택 : " + count3);
                    price3 -= 5000;
                }
            }
        });
    }
}
