package com.example.parksinyoung.moblieprogramming_syjy;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BoardClassEstimFragment extends CommonBoardFragment {

    public BoardClassEstimFragment() {}

    @Override
    public DatabaseReference getRef() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference.child("수업평가");
    }

    @Override
    public String getPostType() {
        return "수업평가";
    }

}
