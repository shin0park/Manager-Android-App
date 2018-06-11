package com.example.parksinyoung.moblieprogramming_syjy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.example.parksinyoung.moblieprogramming_syjy.singleton.CalendarSingle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {
    public static final String RESULT = "result";
    public static final String EVENT = "event";
    private static final int ADD_NOTE = 44;
    private CalendarView mCalendarView;
    //private TextView textView;
    private List<EventDay> mEventDays = new ArrayList<>();
    private List<EventDay> gEventDays = new ArrayList <>();

    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;



    public String getPostType() {
        return "캘린더";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
       // textView = findViewById(R.id.preview_note);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });
        mCalendarView.setOnDayClickListener(new OnDayClickListener() {
            @Override
            public void onDayClick(EventDay eventDay) {
                previewNote(eventDay);
               // setTextPreview(eventDay);
            }
        });
        ValueEventListener calendarlistener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get CalendarSingle object and use the values to update the UI
//                CalendarSingle calendarSingle = dataSnapshot.getValue(CalendarSingle.class);
//                MyEventDay myEventDay;
//                Intent returnIntent = new Intent();
//                Calendar calendar = Calendar.getInstance();
//                calendar.set(calendarSingle.getYear(),calendarSingle.getMonth(),calendarSingle.getDay());
//                myEventDay = new MyEventDay(calendar, R.drawable.ic_message_black_48dp, calendarSingle.getNote());
//                returnIntent.putExtra(CalendarActivity.RESULT, myEventDay);
//                setResult(Activity.RESULT_OK, returnIntent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("cancelled", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        databaseReference.addValueEventListener(calendarlistener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_NOTE && resultCode == RESULT_OK) {
            MyEventDay myEventDay = data.getParcelableExtra(RESULT);
            mCalendarView.setDate(myEventDay.getCalendar());
            mEventDays.add(myEventDay);
            mCalendarView.setEvents(mEventDays);
        }
    }
    private void addNote() {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivityForResult(intent, ADD_NOTE);
    }

    private void previewNote(EventDay eventDay) {
        Intent intent = new Intent(this, NotePreviewActivity.class);
        if(eventDay instanceof MyEventDay){
            intent.putExtra(EVENT, (MyEventDay) eventDay);
        }
        startActivity(intent);
    }
//    private void setTextPreview(EventDay eventDay) {
//        textView.setText();
//        //이후에 캘린더 텍스트뷰에 미리보기 추가
//    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading..");
        progressDialog.show();
    }

}
