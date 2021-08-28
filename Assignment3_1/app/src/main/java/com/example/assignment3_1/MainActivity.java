package com.example.assignment3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView1, textView2;
    CheckBox checkBox1;
    RadioGroup radioGroup1;
    RadioButton dog, cat, rabbit;
    Button btnOK;
    ImageView imgPet1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("애완동물 사진 보기");
        // xml에서 만든 위젯을 findViewById 메소드를 사용해서 변수로 제어 가능하게 했다
        textView1 = (TextView)findViewById(R.id.textView1);
        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        textView2 = (TextView)findViewById(R.id.textView2);
        radioGroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
        dog = (RadioButton)findViewById(R.id.dog);
        cat = (RadioButton)findViewById(R.id.cat);
        rabbit = (RadioButton)findViewById(R.id.rabbit);
        btnOK = (Button)findViewById(R.id.btnOK);
        imgPet1 = (ImageView)findViewById(R.id.imgPet1);

        // checkBox1이 선택 되었을 때 발생하는 메소드
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox1.isChecked() == true){ // 체크가 되어 있으면
                    textView2.setVisibility(View.VISIBLE);
                    radioGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet1.setVisibility(View.VISIBLE);
                }
                else{ // 체크가 되어 있지 않으면
                    textView2.setVisibility(View.INVISIBLE);
                    radioGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet1.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 선택 완료 버튼 눌렀을 때 발생하는 메소드
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 현재 라디오 그룹에서 선택된 라디오버튼의 id 값 반환 해준다
                switch (radioGroup1.getCheckedRadioButtonId()){
                    case R.id.dog: // id가 dog이면 강아지 사진으로 교체
                        imgPet1.setImageResource(R.drawable.dog);
                        break;
                    case R.id.cat:
                        imgPet1.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rabbit:
                        imgPet1.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}