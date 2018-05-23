package com.example.parksinyoung.moblieprogramming_syjy;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BoardFragment extends ToolBarFragment {
    private Button boardButtonBoard;
    private Button boardButtonClass;
    private Button boardButtonLost;
    private Button boardButtonDeal;



    @NonNull
    public static BoardFragment newInstance() {
        return new BoardFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        setToolbar();
        boardButtonBoard=(Button)view.findViewById(R.id.boardbtn1);
        boardButtonClass=(Button)view.findViewById(R.id.boardbtn2);
        boardButtonLost=(Button)view.findViewById(R.id.boardbtn3);
        boardButtonDeal=(Button)view.findViewById(R.id.boardbtn4);

        boardButtonBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ItemListActivity.class);
                startActivity(intent);
            }
        });

        boardButtonClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });

        boardButtonLost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });

        boardButtonDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }


}
