package com.example.parksinyoung.moblieprogramming_syjy.model;

import com.example.parksinyoung.moblieprogramming_syjy.singleton.CalendarSingle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CalendarModel {
    private DatabaseReference databaseReference;
    private OnDataChangedListener onDataChangedListener;

    public void setOnDataChangedListener(OnDataChangedListener listener) {
        this.onDataChangedListener = listener;
    }

    public CalendarModel(String postType) {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child(postType).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (onDataChangedListener != null) {
                    onDataChangedListener.onDataChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

    public void writeCalendar( String postType, int y, int m, int d, String note) {
        databaseReference.child(postType).push().setValue(CalendarSingle.newCalendar(note,y,m,d,postType));
    }//등록

}
