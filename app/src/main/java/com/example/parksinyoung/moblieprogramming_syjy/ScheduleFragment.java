package com.example.parksinyoung.moblieprogramming_syjy;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ScheduleFragment extends Fragment {

    @NonNull
    public static ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {

        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        ActionBar actionBar =((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("SCHEDULE");
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        //actionBar.setHomeAsUpIndicator(R.drawable.setting); //뒤로가기 버튼을 본인이 만든 아이콘으로 하기 위해 필요
        return view;
    }
}