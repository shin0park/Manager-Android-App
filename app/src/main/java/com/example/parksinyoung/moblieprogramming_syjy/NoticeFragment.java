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
    private Button majorNoticeButton;
    private Button foodButton;
    private Button scheduleButton;

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

        UniNoticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ajou.ac.kr/new/ajou/notice.jsp"));
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
//        //recyclerview 는 LayoutManager가 view위치시키는 일을 함. 설정 안할 시 작동 안함.
//        mNoticeRecyclerView = view.findViewById(R.id.notice_recycler_view);
//        mNoticeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        //model
//        mNoticeModel = new NoticeModel();
//        mNoticeList = new ArrayList<>();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setStackFromEnd(true);
//        linearLayoutManager.setReverseLayout(true);
//        linearLayoutManager.scrollToPositionWithOffset(0, 0);
//
//        //adapter 생성 및 sett
//        mNoticeAdapter = new NoticeAdapter(mNoticeList);
//        mNoticeRecyclerView.setAdapter(mNoticeAdapter);
//        mNoticeRecyclerView.setLayoutManager(linearLayoutManager);
//
//        mNoticeModel.readLimitFirstData(new OnNoticeChangeListener<Notice>() {
//
//            @Override
//            public void onChange(List noticeList, List keyList) {
//                mNoticeAdapter.setList(noticeList);
//                mNoticeRecyclerView.getLayoutManager().scrollToPosition(mNoticeRecyclerView.getAdapter().getItemCount() - 1);
//
//            }
//
//        });

        return view;
    }

}
