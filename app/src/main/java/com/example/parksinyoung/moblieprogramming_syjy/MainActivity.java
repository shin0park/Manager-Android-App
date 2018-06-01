package com.example.parksinyoung.moblieprogramming_syjy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.parksinyoung.moblieprogramming_syjy.model.UserModel;


public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private TextView toolbarText;
    private ImageButton settingButton;
    private  Fragment fragment;
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserModel userModel = new UserModel();
        userModel.readUserData();

        toolbarText = findViewById(R.id.toolbartext);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 하기 위해 필요
        actionBar.setDisplayShowTitleEnabled(false);

        settingButton = findViewById(R.id.setting_button);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.main_bnv);

        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_one://홈
                        fragment = new HomeFragment();
                        replaceFragment(HomeFragment.newInstance());
                        toolbarText.setText("HOME");
                        return true;
                    case R.id.action_two://시간표
                        fragment = new ScheduleFragment();
                        replaceFragment(ScheduleFragment.newInstance());
                        toolbarText.setText("SCHEDULE");
                        return true;
                    case R.id.action_three://캘린더
                        fragment = new CalenderFragment();
                        replaceFragment(CalenderFragment.newInstance());
                        toolbarText.setText("CALENDER");
                        return true;
                    case R.id.action_four://공지
                        fragment = new NoticeFragment();
                        replaceFragment(NoticeFragment.newInstance());
                        toolbarText.setText("NOTICE");
                        return true;
                    case R.id.action_five://게시판
                        fragment = new BoardFragment();
                        replaceFragment(BoardFragment.newInstance());
                        Intent intent = new Intent(MainActivity.this, BoardActivity.class);
                        startActivity(intent);
                        toolbarText.setText("NOTICE BOARD");
                        return true;
                }
                return false;
            }
        });
        FragmentManager fm = getSupportFragmentManager();
       fragment = fm.findFragmentById(R.id.fragment_container);
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, HomeFragment.newInstance()).commit();

        backPressCloseHandler = new BackPressCloseHandler(this);
    }

    private void replaceFragment(Fragment fm) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fm).commit();
    }


    //tool bar에 있는 설정 메뉴
//    @Override
//    public boolean onCreateOptionsMenu( Menu menu ) {
//        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
//        return true;
//    }

    //tool bar에 있는 설정메뉴 클릭시
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
//            case R.id.setting_button:
//                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
//                startActivity(intent);
//            case R.id.logout:
//                Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.second:
//                Toast.makeText(this, "2222", Toast.LENGTH_SHORT).show();
//                break;

//            default:
//                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override

    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }

}