package com.example.parksinyoung.moblieprogramming_syjy.model;

import com.example.parksinyoung.moblieprogramming_syjy.singleton.Schedule;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ScheduleModel {
    private DatabaseReference databaseReference;
    private OnDataChangedListener onDataChangedListener;
    private FirebaseUser user;
    private List<Schedule> mSchedules = new ArrayList<>();

    public void setOnDataChangedListener(OnDataChangedListener listener) {
        this.onDataChangedListener = listener;
    }

    public ScheduleModel() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public void addScheduleModel(Schedule schedule) {
        mSchedules.add(schedule);
    }

    public List<Schedule> getSchedules() {
        return mSchedules;
    }

    public void readScheduleData() {
        databaseReference.child("User").child(user.getUid()).child("Schedule").addValueEventListener(new ValueEventListener() {
            //지정된 데이터베이스 참조 및 하위 위치에서 데이터가 변경될 때마다 호출
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //데이터가 없는 경우 반환 되는 스냅샷 null
                if (dataSnapshot.getValue() == null) {
                    setScheduleData();
                } else {
//                    for (Schedule schedule : mSchedules) {
//                        String name= databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+mSchedules.indexOf(schedule)).child("class name").getKey();
//                        String room= databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+mSchedules.indexOf(schedule)).child("class room").getKey();
//                        String day= databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+mSchedules.indexOf(schedule)).child("class day").getKey();
//                        String time= databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+mSchedules.indexOf(schedule)).child("class time").getKey();
//                        ScheduleDialogFragment scheduleDialogFragment = new ScheduleDialogFragment();
//                        scheduleDialogFragment.createView(name,room,day,time);
//                    }
                    setScheduleData();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void setScheduleData() {
        for (int i = 0; i < mSchedules.size(); i++) {
            System.out.println("set data index:"+i);
            databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+i).child("class name").push().setValue(mSchedules.get(i).getClassName());
            databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+i).child("class room").push().setValue(mSchedules.get(i).getClassRoom());
            databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+i).child("class day").push().setValue(mSchedules.get(i).getClassDay());
            databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+i).child("class time").push().setValue(mSchedules.get(i).getClassTime());

        }
    }
}
