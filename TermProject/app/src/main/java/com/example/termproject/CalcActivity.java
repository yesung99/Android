package com.example.termproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class CalcActivity extends AppCompatActivity {
    Button backBtn, menuPriceBtn, couponBtn, submitBtn, payBtn;
    TextView couponText, textView1, textView2, textView3, textView4, curTime;
    EditText couponEdit;

    int koreaPrice, chinaPrice, japanPrice;
    double totalPrice;
    int couponIssue[] = new int[6];
    String coupon = "";
    boolean couponState = false;

    // 현재시간을 msec 으로 구한다.
    long now = System.currentTimeMillis();
    // 현재시간을 date 변수에 저장한다.
    Date date = new Date(now);
    // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )
    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    // nowDate 변수에 값을 저장한다.
    String formatDate = sdfNow.format(date);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        setTitle("계산 화면");

        backBtn = (Button)findViewById(R.id.backBtn); // 메인 화면 가기
        menuPriceBtn = (Button)findViewById(R.id.menuPriceBtn); // 메뉴 가격 출력하기
        couponBtn = (Button)findViewById(R.id.couponBtn); // 쿠폰 발급 받기
        couponText = (TextView)findViewById(R.id.couponText); // 쿠폰 번호(invisible)상태
        couponEdit = (EditText)findViewById(R.id.couponEdit); // 쿠폰 입력 창
        submitBtn = (Button)findViewById(R.id.submitBtn); // 쿠폰 제출
        textView1 = (TextView)findViewById(R.id.textView1); // 한식
        textView2 = (TextView)findViewById(R.id.textView2); // 중식
        textView3 = (TextView)findViewById(R.id.textView3); // 일식
        textView4 = (TextView)findViewById(R.id.textView4); // 총 지불 금액
        payBtn = (Button)findViewById(R.id.payBtn); // 계산하기
        curTime = (TextView)findViewById(R.id.curTime); // 현재시간

        // 메인 화면 가기 버튼
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(backIntent);
            }
        });

        // 메뉴 가격 출력
        menuPriceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 한식, 일식, 중식 액티비티에서 넘어온 값을 받는다
                Intent intent = getIntent();
                koreaPrice = intent.getIntExtra("koreaPrice", 0);
                chinaPrice = intent.getIntExtra("chinaPrice", 0);
                japanPrice = intent.getIntExtra("japanPrice", 0);

                textView1.setText("한식에서 넘어 온 값 : " + koreaPrice);
                textView2.setText("중식에서 넘어온 값 : " + chinaPrice);
                textView3.setText("일식에서 넘어온 값 : " + japanPrice);
            }
        });


        // 쿠폰 발급 받기
        couponBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i<couponIssue.length; i++){
                    couponIssue[i] = (int)(Math.random() * 10); // 0~9사이 값 랜덤으로 받아온다
                    coupon += couponIssue[i]; // 쿠폰 String 값에 랜덤 값 넣는다
                }

                // 쿠폰 발급 받기 버튼을 누르면 쿠폰 텍스트가 visible 상태가 되고 쿠폰 번호 보여준다
                couponText.setVisibility(View.VISIBLE);
                couponText.setText("쿠폰 번호 : " + coupon);
            }
        });

        // 쿠폰 제출
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalcActivity.this,
                        "쿠폰 번호 : " + coupon + "\n입력 값 : " + couponEdit.getText().toString(),
                        Toast.LENGTH_SHORT).show();
                if(couponEdit.getText().toString().equals(coupon)){
                    Toast.makeText(CalcActivity.this,
                            "쿠폰 번호가 맞습니다.\n10% 할인이 됩니다.",
                            Toast.LENGTH_SHORT).show();
                    couponState = true;
                }
                else{
                    Toast.makeText(CalcActivity.this, "쿠폰 번호가 틀립니다.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        // 계산하기 버튼
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(couponState == false){ // 쿠폰 번호가 틀렸을 경우
                    totalPrice = koreaPrice + chinaPrice + japanPrice;
                    AlertDialog.Builder dlg = new AlertDialog.Builder(CalcActivity.this);
                    dlg.setTitle("계산하기");
                    dlg.setMessage("총 계산 가격 : " + totalPrice + "\n현재 시각 : " + formatDate);
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(CalcActivity.this,
                                    "결제가 완료되었습니다. 감사합니다. 또 와주세요!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    dlg.show();

                    textView4.setText("총 지불 금액 : " + totalPrice);
                    curTime.setText("현재 시각 : " + formatDate);
                }
                else{ // 쿠폰 번호가 맞았을 경우
                    totalPrice = koreaPrice + chinaPrice + japanPrice;
                    totalPrice = totalPrice - (totalPrice * 0.1);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(CalcActivity.this);
                    dlg.setTitle("계산하기");
                    dlg.setMessage("총 계산 가격(10% 할인) : " + totalPrice +
                            "\n현재 시각 : " + formatDate);
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(CalcActivity.this,
                                    "결제가 완료되었습니다. 감사합니다. 또 와주세요!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                    dlg.show();

                    textView4.setText("총 지불 금액(10% 할인) : " + totalPrice);
                    curTime.setText("현재 시각 : " + formatDate);
                }
            }
        });

    }
}
