package com.example.parksinyoung.moblieprogramming_syjy.model;

import com.example.parksinyoung.moblieprogramming_syjy.singleton.Post;
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
    private List<Schedule> mSchedules = new ArrayList<>();


    public void setOnDataChangedListener(OnDataChangedListener listener) {
        this.onDataChangedListener = listener;
    }

    public void addScheduleModel(Schedule schedule) {
        mSchedules.add(schedule);
    }

    public List<Schedule> getSchedules() {
        return mSchedules;
    }

    public ScheduleModel() {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("시간표").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (onDataChangedListener != null) {
                    onDataChangedListener.onDataChanged();
                }
//                String key = dataSnapshot.getRef().getKey();
//                Schedule schedule = dataSnapshot.getValue(Schedule.class);
//                addScheduleModel(schedule);
//                System.out.println(schedule.getClassName());
                for(DataSnapshot ds :dataSnapshot.getChildren()){
                    String className = ds.getValue(Schedule.class).getClassName();
                    String classRoom = ds.getValue(Schedule.class).getClassRoom();
                    String classDay = ds.getValue(Schedule.class).getClassDay();
                    String classTime = ds.getValue(Schedule.class).getClassTime();

                    Schedule schedule = new Schedule(className,classRoom,classDay,classTime);
                    addScheduleModel(schedule);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

//    public void readScheduleData() {
//        databaseReference.child("User").child(user.getUid()).child("Schedule").addValueEventListener(new ValueEventListener() {
//            //지정된 데이터베이스 참조 및 하위 위치에서 데이터가 변경될 때마다 호출
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                //데이터가 없는 경우 반환 되는 스냅샷 null
//                if (dataSnapshot.getValue() == null) {
//                    for (int i = 0; i < mSchedules.size(); i++) {
//                        writeSchedule(mSchedules.get(i).getClassName(), mSchedules.get(i).getClassRoom(), mSchedules.get(i).getClassDay(), mSchedules.get(i).getClassTime());
//                    }
//                } else {
////                    for (Schedule schedule : mSchedules) {
////                        String name= databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+mSchedules.indexOf(schedule)).child("class name").getKey();
////                        String room= databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+mSchedules.indexOf(schedule)).child("class room").getKey();
////                        String day= databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+mSchedules.indexOf(schedule)).child("class day").getKey();
////                        String time= databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+mSchedules.indexOf(schedule)).child("class time").getKey();
////                        ScheduleDialogFragment scheduleDialogFragment = new ScheduleDialogFragment();
////                        scheduleDialogFragment.createView(name,room,day,time);
////                    }
//                    for (int i = 0; i < mSchedules.size(); i++) {
//                        writeSchedule(mSchedules.get(i).getClassName(), mSchedules.get(i).getClassRoom(), mSchedules.get(i).getClassDay(), mSchedules.get(i).getClassTime());
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }

    public void writeSchedule(String className, String classRoom, String classDay, String classTime) {
        databaseReference.child("시간표").
                push().setValue(Schedule.newSchedule(className, classRoom, classDay, classTime));
    }
//    private void setScheduleData() {
//        for (int i = 0; i < mSchedules.size(); i++) {
//            System.out.println("set data index:"+i);
//            databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+i).child("class name").push().setValue(mSchedules.get(i).getClassName());
//            databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+i).child("class room").push().setValue(mSchedules.get(i).getClassRoom());
//            databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+i).child("class day").push().setValue(mSchedules.get(i).getClassDay());
//            databaseReference.child("User").child(user.getUid()).child("Schedule").child(""+i).child("class time").push().setValue(mSchedules.get(i).getClassTime());
//
//        }
//    }
}
