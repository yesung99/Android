package com.example.assignment6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // 메뉴에서 무엇을 선택했는지 구분 위해 사용
    final static int LINE = 1, CIRCLE = 2, Rectangle = 3;
    static int curShape = LINE; // 현재 선택된 도형 판단, default = 선
    static int curColor = Color.RED; // 현재 선택된 색깔 판단, default = 빨간색

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View 클래스에서 상속받은 MyGraphicView 클래스를 화면에 출력
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX= -1, stopY = -1; // 시작점, 끝점 좌표
        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){ // 터치 액션 판단
                case MotionEvent.ACTION_DOWN: // 터치 되면
                    startX = (int)event.getX(); // 시작점 저장
                    startY = (int)event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP: // 손가락 떼면 실행됨
                    stopX = (int)event.getX(); // 끝점 저장
                    stopY = (int)event.getY();
                    this.invalidate(); // 화면 무효화 및 onDraw 메소드 호출
                    break;
            }
            return true;
        }

        // 실제 도형이 그려진 onDraw 메소드
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint(); // 페인트 객체 생성
            paint.setAntiAlias(true); // 끝 부드럽게 처리
            paint.setStrokeWidth(5); // 선 굵기
            paint.setStyle(Paint.Style.STROKE); // 선만 표현
            paint.setColor(curColor); // 색깔 지정

            switch (curShape){
                case LINE: // 손 터치한 점부터 터치를 뗀 부분을 선으로 그린다
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE: // 시작점과 끝점 거리 계산하여 반지름으로 사용함
                    int radius = (int)Math.sqrt(Math.pow(stopX - startX, 2)
                            + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
                case Rectangle: // 시작 좌표와 끝 좌표 활용해서 사각형으로 그림
                    canvas.drawRect(startX, startY, stopX, stopY, paint);
                    break;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // 메뉴 추가
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");

        // 서브 메뉴 추가
        SubMenu subMenu = menu.addSubMenu("색깔 변경");
        subMenu.add(0,4,0,"빨간색");
        subMenu.add(0,5,0,"초록색");
        subMenu.add(0,6,0,"파란색");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1: // 메뉴에서 선 선택
                curShape = LINE;
                return true;
            case 2: // 메뉴에서 원 선택
                curShape = CIRCLE;
                return true;
            case 3: // 메뉴에서 사각형 선택
                curShape = Rectangle;
                return true;
            case 4: // 서브 메뉴에서 빨간색 선택
                curColor = Color.RED;
                return true;
            case 5: // 서브 메뉴에서 초록색 선택
                curColor = Color.GREEN;
                return true;
            case 6: // 서브 메뉴에서 파란색 선택
                curColor = Color.BLUE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}