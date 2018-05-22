package com.example.parksinyoung.moblieprogramming_syjy.adaper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parksinyoung.moblieprogramming_syjy.R;
import com.example.parksinyoung.moblieprogramming_syjy.singleton.Notice;
import com.example.parksinyoung.moblieprogramming_syjy.viewholder.NoticeHolder;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeHolder> {
    private List<Notice> mNoticeList;

    public NoticeAdapter(List<Notice> noticeList) {
        mNoticeList = noticeList;
    }

    @Override
    public NoticeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater
                .inflate(R.layout.list_item_notice,parent,false);
        return new NoticeHolder(view);
    }

    @Override
    public void onBindViewHolder(NoticeHolder holder, int position) {
        Notice notice = mNoticeList.get(position);
        holder.bindNotice(notice);

    }

    @Override
    public int getItemCount() {
        return mNoticeList.size();
    }
}
