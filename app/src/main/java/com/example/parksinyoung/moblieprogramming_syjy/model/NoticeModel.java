package com.example.parksinyoung.moblieprogramming_syjy.model;

import android.content.Context;

import com.example.parksinyoung.moblieprogramming_syjy.singleton.Notice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoticeModel {
    private Context mContext;
    private static NoticeModel sNoticeModel;
    private List<Notice> mNoticeList;

    public static NoticeModel get(Context context) {
        if (sNoticeModel == null) {
            sNoticeModel = new NoticeModel(context);
        }
        return sNoticeModel;
    }

    private NoticeModel(Context context) {
        mContext = context;
        mNoticeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Notice notice = new Notice();
            notice.setTitle("번호# " + i);
            mNoticeList.add(notice);
        }
    }

    public List<Notice> getNoticeList() {
        return mNoticeList;
    }

//    public Notice getNotice(UUID id) {
//        for (Notice notice : mNoticeList) {
//            if (notice.getId().equals(id)) {
//                return notice;
//            }
//        }
//        return null;
//    }

}