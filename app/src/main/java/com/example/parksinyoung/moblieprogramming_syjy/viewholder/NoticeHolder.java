//package com.example.parksinyoung.moblieprogramming_syjy.viewholder;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.parksinyoung.moblieprogramming_syjy.R;
//import com.example.parksinyoung.moblieprogramming_syjy.singleton.Notice;
//
//public class NoticeHolder extends RecyclerView.ViewHolder {
//    private Context context;
//    private Notice mNotice;
//    public TextView mTitleTextView;
//    //viewholder는 view를 보존하는 일을 한다.
//    public NoticeHolder(View itemView) {
//        super(itemView);
//        this.context = itemView.getContext();
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,
//                        mNotice.getTitle() + " 선택됨!", Toast.LENGTH_SHORT)
//                        .show();
//            }
//        });
//        mTitleTextView = itemView.findViewById(R.id.list_item_title_text_view);
//        mTitleTextView.setFocusableInTouchMode(true);
//    }
//
//    public void bindNotice(Notice notice) {
//        mNotice = notice;
//        mTitleTextView.setText(mNotice.getTitle());
//
//    }
//
//}
