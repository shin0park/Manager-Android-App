package com.example.parksinyoung.moblieprogramming_syjy;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BoardQAFragment extends BaseBoardFragment {

    @Override
    public DatabaseReference getRef() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference.child("질문답변");
    }

    @Override
    public String getPostType() {
        return "질문답변";
    }

    public BoardQAFragment() {
    }
}