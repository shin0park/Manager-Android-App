package com.example.parksinyoung.moblieprogramming_syjy;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private TextView toolbartext;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbartext = findViewById(R.id.toolbartext);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 하기 위해 필요
        actionBar.setDisplayShowTitleEnabled(false);

        BottomNavigationView bottomNavigationView = findViewById(R.id.main_bnv);

        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( @NonNull MenuItem item ) {
                switch (item.getItemId()) {
                    case R.id.action_one://홈
                        replaceFragment(HomeFragment.newInstance());
                        toolbartext.setText("HOME");
                        return true;
                    case R.id.action_two://시간표
                        replaceFragment(ScheduleFragment.newInstance());
                        toolbartext.setText("SCHEDULE");
                        return true;
                    case R.id.action_three://캘린더
                        replaceFragment(CalenderFragment.newInstance());
                        toolbartext.setText("CALENDER");
                        return true;
                    case R.id.action_four://공지
                        replaceFragment(NoticeFragment.newInstance());
                        toolbartext.setText("NOTICE");
                        return true;
                    case R.id.action_five://게시판
                        replaceFragment(BoardFragment.newInstance());
                        toolbartext.setText("NOTICE BOARD");
                        return true;
                }
                return false;
            }
        });

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, HomeFragment.newInstance()).commit();
    }

    private void replaceFragment( Fragment fragment ) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }


    //tool bar에 있는 설정 메뉴
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        return true;
    }

    //tool bar에 있는 설정메뉴 클릭시
    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.logout:
                Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second:
                Toast.makeText(this, "2222", Toast.LENGTH_SHORT).show();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}