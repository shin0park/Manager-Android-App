package com.example.parksinyoung.moblieprogramming_syjy;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class DatePickerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public void onTimeSet( TimePicker timePicker, int i, int i1 ) {

    }

//    @Override
//    public Dialog onCreateDialog( Bundle savedInstanceState ) {
//        Calendar calendar = Calendar.getInstance();
////        int hour = Calendar.get(Calendar.getInstance());
////        int min = Calendar.get((Calendar.MINUTE));
////        TimePickerDialog timePickerDialog = new TimePickerDialog(
////                getContext(), this, hour, min, DateFormat.getDateInstance()
////        );
//        return ;
////}
//    }
}
