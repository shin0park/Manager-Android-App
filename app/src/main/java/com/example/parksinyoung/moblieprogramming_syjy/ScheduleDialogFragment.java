package com.example.parksinyoung.moblieprogramming_syjy;

import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.parksinyoung.moblieprogramming_syjy.singleton.Schedule;

public class ScheduleDialogFragment extends DialogFragment {

    private EditText className;
    private EditText classRoom;
    private Spinner classDay;
    private Spinner classTime;
    private OnMyDialogResult mDialogResult;


    public interface OnMyDialogResult{

        void finish(Object result);

    }
    public void setDialogResult(OnMyDialogResult dialogResult){

        mDialogResult = dialogResult;

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_schedule_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity()).setView(view);
        className = view.findViewById(R.id.class_name);
        classRoom = view.findViewById(R.id.class_room);
        classDay = view.findViewById(R.id.class_day);
        classTime = view.findViewById(R.id.class_time);

        return alertDialog
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Schedule schedule = new Schedule(className.getText().toString(),classRoom.getText().toString(),classDay.getSelectedItem().toString(),classTime.getSelectedItem().toString());

                        System.out.println(schedule.getClassName());
                        System.out.println(schedule.getClassRoom());
                        System.out.println(schedule.getClassDay());
                        System.out.println(schedule.getClassTime());

                        mDialogResult.finish(schedule);
//                        createView(schedule.getClassName(), schedule.getClassRoom(), schedule.getClassDay(), schedule.getClassTime());
                    }
                })
                .create();
    }
//    @SuppressLint("SetTextI18n")
//    public void createView(String name, String room, String day, String time) {
//        String r = " (" + room + ") ";
//        String text = name +"\n"+ r;
//        if (day.equals("월요일")) {
//            if (time.equals("A")) {
//                monday[0].setText(text);
//                monday[0].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("B")) {
//                monday[1].setText(text);
//                monday[1].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("C")) {
//                Toast.makeText(getActivity(), name + " (" + room + ") ", Toast.LENGTH_SHORT).show();
//                monday[2].setText(text);
//                monday[2].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("D")) {
//                monday[3].setText(text);
//                monday[3].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("E")) {
//                monday[4].setText(text);
//                monday[4].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("F")) {
//                monday[5].setText(text);
//                monday[5].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("G")) {
//                monday[6].setText(text);
//                monday[6].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("H")) {
//                monday[7].setText(text);
//                monday[7].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//        } else if (day.equals("화요일")) {
//            if (time.equals("A")) {
//                tuesday[0].setText(text);
//                tuesday[0].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("B")) {
//                tuesday[1].setText(text);
//                tuesday[1].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("C")) {
//                tuesday[2].setText(text);
//                tuesday[2].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("D")) {
//                tuesday[3].setText(text);
//                tuesday[3].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("E")) {
//                tuesday[4].setText(text);
//                tuesday[4].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("F")) {
//                tuesday[5].setText(text);
//                tuesday[5].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("G")) {
//                tuesday[6].setText(text);
//                tuesday[6].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//            if (time.equals("H")) {
//                tuesday[7].setText(text);
//                tuesday[7].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            }
//        }
//    }


}
