package com.example.parksinyoung.moblieprogramming_syjy;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BoardTextbookFragment extends BaseBoardFragment {

    public BoardTextbookFragment() {
    }

    @Override
    public DatabaseReference getRef() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        return databaseReference.child("교재장터");
    }

    @Override
    public String getPostType() {
        return "교재장터";
    }
}
