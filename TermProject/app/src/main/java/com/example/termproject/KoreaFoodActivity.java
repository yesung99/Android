package com.example.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class KoreaFoodActivity extends AppCompatActivity {
    // 상단의 '한식', '중식', '일식', '계산하기' 버튼
    Button koreaFoodBtn1, chinaFoodBtn1, japanFoodBtn1, calcBtn1;

    Button k_choiceBtn1; // 김치 볶음밥 선택
    TextView k_choiceMenu1; // 김치 볶음밥 선택 개수 출력
    Button k_cancelBtn1; // 김치 볶음밥 선택 취소
    int count1 = 0;

    Button k_choiceBtn2;
    TextView k_choiceMenu2;
    Button k_cancelBtn2;
    int count2 = 0;

    Button k_choiceBtn3;
    TextView k_choiceMenu3;
    Button k_cancelBtn3;
    int count3 = 0;

    int price1 = 0; // 총 '한식' 계산 가격
    int koreaPrice, chinaPrice, japanPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korea_food);
        setTitle("한식 메뉴");

        // 중식이나 일식에서 넘어온 값 받기
        Intent getPriceIntent = getIntent();
        chinaPrice = getPriceIntent.getIntExtra("chinaPrice", 0);
        japanPrice = getPriceIntent.getIntExtra("japanPrice", 0);
        Toast.makeText(this, "중식에서 받은 값 : " + chinaPrice +
                "\n일식에서 받은 값 : " + japanPrice, Toast.LENGTH_SHORT).show();

        // 상단의 버튼 위젯
        koreaFoodBtn1 = (Button)findViewById(R.id.koreaFoodBtn1);
        chinaFoodBtn1 = (Button)findViewById(R.id.chinaFoodBtn1);
        japanFoodBtn1 = (Button)findViewById(R.id.japanFoodBtn1);
        calcBtn1 = (Button)findViewById(R.id.calcBtn1);

        // 김치 볶음밥 선택 위젯
        k_choiceBtn1 = findViewById(R.id.k_choiceBtn1);
        k_choiceMenu1 = findViewById(R.id.k_choiceMenu1);
        k_cancelBtn1 = findViewById(R.id.k_cancelBtn1);
        // 된장 찌개 선택 위젯
        k_choiceBtn2 = findViewById(R.id.k_choiceBtn2);
        k_choiceMenu2 = findViewById(R.id.k_choiceMenu2);
        k_cancelBtn2 = findViewById(R.id.k_cancelBtn2);
        // 비빔밥 선택 위젯
        k_choiceBtn3 = findViewById(R.id.k_choiceBtn3);
        k_choiceMenu3 = findViewById(R.id.k_choiceMenu3);
        k_cancelBtn3 = findViewById(R.id.k_cancelBtn3);

        // 상단 버튼 이벤트 처리
        koreaFoodBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "이미 '한식'을 누르셨습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        chinaFoodBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'중식'을 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent chinaIntent = new Intent(getApplicationContext(), ChinaFoodActivity.class);
                koreaPrice = price1;
                chinaIntent.putExtra("koreaPrice", koreaPrice);
                chinaIntent.putExtra("japanPrice", japanPrice);
                startActivity(chinaIntent);
            }
        });

        japanFoodBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'일식'을 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent japanIntent = new Intent(getApplicationContext(), JapanFoodActivity.class);
                koreaPrice = price1;
                japanIntent.putExtra("koreaPrice", koreaPrice);
                japanIntent.putExtra("chinaPrice", chinaPrice);
                startActivity(japanIntent);
            }
        });

        calcBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'계산하기'를 선택하셨습니다.",
                        Toast.LENGTH_SHORT).show();
                Intent calcIntent = new Intent(getApplicationContext(), CalcActivity.class);
                koreaPrice = price1;
                calcIntent.putExtra("koreaPrice", koreaPrice);
                calcIntent.putExtra("chinaPrice", chinaPrice);
                calcIntent.putExtra("japanPrice", japanPrice);
                startActivityForResult(calcIntent, 0);
            }
        });

        // 김치 볶음밥 선택
        k_choiceBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1++;
                k_choiceMenu1.setText("선택 : " + count1);
                Toast.makeText(getApplicationContext(),
                        "김치 볶음밥을 선택하셨습니다", Toast.LENGTH_SHORT).show();
                price1 += 4000;
            }
        });

        // 김치 볶음밥 선택 취소
        k_cancelBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count1 > 0){
                    count1--;
                    k_choiceMenu1.setText("선택 : " + count1);
                    price1 -= 4000;
                }
            }
        });

        // 된장 찌개 선택
        k_choiceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count2++;
                k_choiceMenu2.setText("선택 : " + count2);
                Toast.makeText(getApplicationContext(),
                        "된장 찌개를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                price1 += 5500;
            }
        });

        // 된장 찌개 선택 취소
        k_cancelBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count2 > 0){
                    count2--;
                    k_choiceMenu2.setText("선택 : " + count2);
                    price1 -= 5500;
                }
            }
        });

        // 비빔밥 선택
        k_choiceBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count3++;
                k_choiceMenu3.setText("선택 : " + count3);
                Toast.makeText(getApplicationContext(),
                        "비빔밥을 선택하셨습니다", Toast.LENGTH_SHORT).show();
                price1 += 5000;
            }
        });

        // 비빔밥 선택 취소
        k_cancelBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count3 > 0){
                    count3--;
                    k_choiceMenu3.setText("선택 : " + count3);
                    price1 -= 5000;
                }
            }
        });
    }

}
