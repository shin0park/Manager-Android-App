package com.example.parksinyoung.moblieprogramming_syjy;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parksinyoung.moblieprogramming_syjy.model.ScheduleModel;
import com.example.parksinyoung.moblieprogramming_syjy.singleton.Schedule;

public class ScheduleDialogFragment extends DialogFragment {
    private ScheduleModel scheduleModel = new ScheduleModel();
    private EditText className;
    private EditText classRoom;
    private Spinner classDay;
    private Spinner classTime;


//    private String monday[] = new String[7];
//    private String tuesday[] = new String[7];
//    private String wednesday[] = new String[7];
//    private String thursday[] = new String[7];
//    private String friday[] = new String[7];

    private TextView monday[] = new TextView[8];
    private TextView tuesday[] = new TextView[8];
    private TextView wednesday[] = new TextView[8];
    private TextView thursday[] = new TextView[8];
    private TextView friday[] = new TextView[8];

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

        monday[0] = getActivity().findViewById(R.id.mondayA);
        monday[1] = getActivity().findViewById(R.id.mondayB);
        monday[2] = getActivity().findViewById(R.id.mondayC);
        monday[3] = getActivity().findViewById(R.id.mondayD);
        monday[4] = getActivity().findViewById(R.id.mondayE);
        monday[5] = getActivity().findViewById(R.id.mondayF);
        monday[6] = getActivity().findViewById(R.id.mondayG);
        monday[7] = getActivity().findViewById(R.id.mondayH);

        tuesday[0] = getActivity().findViewById(R.id.tuesdayA);
        tuesday[1] = getActivity().findViewById(R.id.tuesdayB);
        tuesday[2] = getActivity().findViewById(R.id.tuesdayC);
        tuesday[3] = getActivity().findViewById(R.id.tuesdayD);
        tuesday[4] = getActivity().findViewById(R.id.tuesdayE);
        tuesday[5] = getActivity().findViewById(R.id.tuesdayF);
        tuesday[6] = getActivity().findViewById(R.id.tuesdayG);
        tuesday[7] = getActivity().findViewById(R.id.tuesdayH);

        wednesday[0] = getActivity().findViewById(R.id.wednesdayA);
        wednesday[1] = getActivity().findViewById(R.id.wednesdayB);
        wednesday[2] = getActivity().findViewById(R.id.wednesdayC);
        wednesday[3] = getActivity().findViewById(R.id.wednesdayD);
        wednesday[4] = getActivity().findViewById(R.id.wednesdayE);
        wednesday[5] = getActivity().findViewById(R.id.wednesdayF);
        wednesday[6] = getActivity().findViewById(R.id.wednesdayG);
        wednesday[7] = getActivity().findViewById(R.id.wednesdayH);

        thursday[0] = getActivity().findViewById(R.id.thursdayA);
        thursday[1] = getActivity().findViewById(R.id.thursdayB);
        thursday[2] = getActivity().findViewById(R.id.thursdayC);
        thursday[3] = getActivity().findViewById(R.id.thursdayD);
        thursday[4] = getActivity().findViewById(R.id.thursdayE);
        thursday[5] = getActivity().findViewById(R.id.thursdayF);
        thursday[6] = getActivity().findViewById(R.id.thursdayG);
        thursday[7] = getActivity().findViewById(R.id.thursdayH);

        friday[0] = getActivity().findViewById(R.id.fridayA);
        friday[1] = getActivity().findViewById(R.id.fridayB);
        friday[2] = getActivity().findViewById(R.id.fridayC);
        friday[3] = getActivity().findViewById(R.id.fridayD);
        friday[4] = getActivity().findViewById(R.id.fridayE);
        friday[5] = getActivity().findViewById(R.id.fridayF);
        friday[6] = getActivity().findViewById(R.id.fridayG);
        friday[7] = getActivity().findViewById(R.id.fridayH);


//        for (int i = 0; i < 7; i++) {

//            monday[i] = "";
//            tuesday[i] = "";
//            wednesday[i] = "";
//            thursday[i] = "";
//            friday[i] = "";
//
//        }
        return alertDialog
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Schedule schedule = new Schedule();
                        schedule.setClassName(className.getText().toString());
                        schedule.setClassRoom(classRoom.getText().toString());
                        schedule.setClassDay(classDay.getSelectedItem().toString());
                        schedule.setClassTime(classTime.getSelectedItem().toString());
                        System.out.println(schedule.getClassName());
                        System.out.println(schedule.getClassRoom());
                        System.out.println(schedule.getClassDay());
                        System.out.println(schedule.getClassTime());

                        scheduleModel.addScheduleModel(schedule);
                        scheduleModel.readScheduleData();

                        createView(schedule.getClassName(), schedule.getClassRoom(), schedule.getClassDay(), schedule.getClassTime());
                    }
                })
                .create();
    }
    @SuppressLint("SetTextI18n")
    public void createView(String name, String room, String day, String time) {
        String r = " (" + room + ") ";
        String text = name +"\n"+ r;
        if (day.equals("월요일")) {
            if (time.equals("A")) {
                monday[0].setText(text);
                monday[0].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("B")) {
                monday[1].setText(text);
                monday[1].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("C")) {
                Toast.makeText(getActivity(), name + " (" + room + ") ", Toast.LENGTH_SHORT).show();
                monday[2].setText(text);
                monday[2].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("D")) {
                monday[3].setText(text);
                monday[3].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("E")) {
                monday[4].setText(text);
                monday[4].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("F")) {
                monday[5].setText(text);
                monday[5].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("G")) {
                monday[6].setText(text);
                monday[6].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("H")) {
                monday[7].setText(text);
                monday[7].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        } else if (day.equals("화요일")) {
            if (time.equals("A")) {
                tuesday[0].setText(text);
                tuesday[0].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("B")) {
                tuesday[1].setText(text);
                tuesday[1].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("C")) {
                tuesday[2].setText(text);
                tuesday[2].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("D")) {
                tuesday[3].setText(text);
                tuesday[3].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("E")) {
                tuesday[4].setText(text);
                tuesday[4].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("F")) {
                tuesday[5].setText(text);
                tuesday[5].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("G")) {
                tuesday[6].setText(text);
                tuesday[6].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
            if (time.equals("H")) {
                tuesday[7].setText(text);
                tuesday[7].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        }
    }
}
