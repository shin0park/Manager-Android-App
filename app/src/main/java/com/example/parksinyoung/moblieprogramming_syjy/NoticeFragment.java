package com.example.parksinyoung.moblieprogramming_syjy;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parksinyoung.moblieprogramming_syjy.adaper.NoticeAdapter;
import com.example.parksinyoung.moblieprogramming_syjy.model.NoticeModel;
import com.example.parksinyoung.moblieprogramming_syjy.singleton.Notice;

import java.util.ArrayList;
import java.util.List;

public class NoticeFragment extends ToolBarFragment {
    private RecyclerView mNoticeRecyclerView;
    private NoticeModel mNoticeModel;
    private NoticeAdapter mNoticeAdapter;
    private List<Notice> mNoticeList;

    @NonNull
    public static NoticeFragment newInstance() {
        return new NoticeFragment();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        setToolbar();
        mNoticeRecyclerView = view.findViewById(R.id.notice_recycler_view);
        mNoticeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mNoticeModel = NoticeModel.get(getActivity());
        mNoticeList = mNoticeModel.getNoticeList();

        mNoticeAdapter = new NoticeAdapter(mNoticeList);
        mNoticeRecyclerView.setAdapter(mNoticeAdapter);
        return view;
    }

}
