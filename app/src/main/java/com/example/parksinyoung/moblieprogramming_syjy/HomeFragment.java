package com.example.parksinyoung.moblieprogramming_syjy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    @NonNull
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ActionBar actionBar =((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("HOME");
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
//        actionBar.setHomeAsUpIndicator(R.mipmap.arrow); //뒤로가기 버튼을 본인이 만든 아이콘으로 하기 위해 필요
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ //toolbar의 back키 눌렀을 때 동작
                getActivity().finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

