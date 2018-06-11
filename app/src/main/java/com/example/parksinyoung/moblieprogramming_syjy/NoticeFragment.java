package com.example.parksinyoung.moblieprogramming_syjy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NoticeFragment extends ToolBarFragment {

    private Button UniNoticeButton;
    private Button scheduleButton;
    private Button majorNoticeButton;
    private Button foodButton;
    private Button noticeButton;

//    @NonNull
//    public static NoticeFragment newInstance() {
//        return new NoticeFragment();
//    }

    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        setToolbar();

        UniNoticeButton = view.findViewById(R.id.notice_button);
        majorNoticeButton = view.findViewById(R.id.major_notice_button);
        foodButton = view.findViewById(R.id.food_button);
        scheduleButton = view.findViewById(R.id.university_schedule_button);
        noticeButton = view.findViewById(R.id.notice_button2);

        UniNoticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ajou.ac.kr/new/ajou/notice.jsp"));
                intent.setPackage("com.android.chrome");
                startActivity(intent);
            }
        });
        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://it.ajou.ac.kr/it/community/community01.jsp"));
                intent.setPackage("com.android.chrome");
                startActivity(intent);
            }
        });
        majorNoticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://media.ajou.ac.kr/media/board/board01.jsp"));
                intent.setPackage("com.android.chrome");
                startActivity(intent);
            }
        });
        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ajou.ac.kr/kr/life/food.jsp"));
                intent.setPackage("com.android.chrome");
                startActivity(intent);
            }
        });
        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ajou.ac.kr/new/life/schedule_haksa_2017.jsp"));
                intent.setPackage("com.android.chrome");
                startActivity(intent);
            }
        });

        return view;
    }

}
