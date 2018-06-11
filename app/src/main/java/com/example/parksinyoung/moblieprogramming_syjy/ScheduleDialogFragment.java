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


}
