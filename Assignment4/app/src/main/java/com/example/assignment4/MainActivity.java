package com.example.assignment4;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout baseLayout;
    Button button1;
    Button button2;
    int colorCheck = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        baseLayout = (LinearLayout)findViewById(R.id.baseLayout);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Display display = ((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffset = (int)(Math.random() * display.getWidth());
                int yOffset = (int)(Math.random() * display.getHeight());

                if(colorCheck == 0){
                    Toast toast = Toast.makeText(MainActivity.this, "아직 색상이 바뀌지 않았습니다.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                    toast.show();
                }
                else if(colorCheck == Color.RED){
                    Toast toast = Toast.makeText(MainActivity.this, "색상이 빨간색으로 바뀌었습니다.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                    toast.show();
                }
                else if(colorCheck == Color.GREEN){
                    Toast toast = Toast.makeText(MainActivity.this, "색상이 초록색으로 바뀌었습니다.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                    toast.show();
                }
                else if(colorCheck == Color.BLUE){
                    Toast toast = Toast.makeText(MainActivity.this, "색상이 파란색으로 바뀌었습니다.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                    toast.show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // xml 코드 사용한 옵션 메뉴 구현
//        MenuInflater mInflater = getMenuInflater();
//        mInflater.inflate(R.menu.menu1, menu);
        // Java 코드 사용한 옵션 메뉴 구현
        menu.add(0,1,0,"배경색(빨강)");
        menu.add(0,2,0,"배경색(초록)");
        menu.add(0,3,0,"배경색(파랑)");

        SubMenu subMenu = menu.addSubMenu("버튼 변경 >> ");
        subMenu.add(0,4,0,"버튼 45도 회전");
        subMenu.add(0,5,0,"버튼 2배 확대");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case 1: // xml 일 때 R.id.itemRed->1
                baseLayout.setBackgroundColor(Color.RED);
                colorCheck = Color.RED;
                return true;
            case 2: // xml 일 때 R.id.itemRed->2
                baseLayout.setBackgroundColor(Color.GREEN);
                colorCheck = Color.GREEN;
                return true;
            case 3: // xml 일 때 R.id.itemRed->3
                baseLayout.setBackgroundColor(Color.BLUE);
                colorCheck = Color.BLUE;
                return true;
            case 4: // xml 일 때 R.id.itemRed->4
                button1.setRotation(45);
                return true;
            case 5: // xml 일 때 R.id.itemRed->5
                button1.setScaleX(2);
                return true;
        }
        return false;
    }
}