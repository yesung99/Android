package com.example.termproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mainFoodBtn1, mainFoodBtn2, mainFoodBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("메인 화면");

        mainFoodBtn1 = (Button)findViewById(R.id.mainFoodBtn1);
        mainFoodBtn2 = (Button)findViewById(R.id.mainFoodBtn2);
        mainFoodBtn3 = (Button)findViewById(R.id.mainFoodBtn3);

        mainFoodBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'한식'을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                Intent koreaIntent = new Intent(getApplicationContext(), KoreaFoodActivity.class);
                startActivity(koreaIntent);
            }
        });

        mainFoodBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'중식'을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                Intent chinaIntent = new Intent(getApplicationContext(), ChinaFoodActivity.class);
                startActivity(chinaIntent);
            }
        });

        mainFoodBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "'일식'을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                Intent japanIntent = new Intent(getApplicationContext(), JapanFoodActivity.class);
                startActivity(japanIntent);
            }
        });
    }
}
