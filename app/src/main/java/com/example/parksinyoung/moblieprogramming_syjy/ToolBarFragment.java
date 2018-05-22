package com.example.parksinyoung.moblieprogramming_syjy;


import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;

public class ToolBarFragment extends Fragment {
    ActionBar actionBar;

    public void setToolbarTitle(String title) {
        actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        // actionBar.setHomeAsUpIndicator(R.drawable.arrow); //뒤로가기 버튼을 본인이 만든 아이콘으로 하기 위해 필요
    }
}
