package com.example.parksinyoung.moblieprogramming_syjy;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.main_bnv);

        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_one://홈
                        replaceFragment(HomeFragment.newInstance());
                        return true;
                    case R.id.action_two://시간표
                        replaceFragment(ScheduleFragment.newInstance());
                        return true;
                    case R.id.action_three://캘린더
                        replaceFragment(CalenderFragment.newInstance());
                        return true;
                    case R.id.action_four://공지
                        replaceFragment(NoticeFragment.newInstance());
                        return true;
                    case R.id.action_five://게시판
                        replaceFragment(BoardFragment.newInstance());

                        return true;
                }
                return false;
            }
        });
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, HomeFragment.newInstance()).commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }
    //action bar에 있는 설정 메뉴
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflater함수를 이용해서 menu 리소스를 menu로 변환.
        // getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //action bar에 있는 설정메뉴 클릭시
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.setting_btn:
                // setting_btn 이 눌렸을 경우 이벤트 발생
                Toast.makeText(getApplicationContext(),"setting 버튼 클릭.",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}