package com.example.parksinyoung.moblieprogramming_syjy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

public class ScheduleDeleteDialogFragment extends DialogFragment {
    private boolean delete = false;
    private OnMyDeleteDialogResult mOnMyDeleteDialogResult;

    public interface OnMyDeleteDialogResult{

        void delete(boolean result);

    }
    public void setDeleteDialogResult(OnMyDeleteDialogResult dialogResult){

        mOnMyDeleteDialogResult = dialogResult;

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_schedule_delete_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity()).setView(view);
        return alertDialog
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        delete = true;
                        mOnMyDeleteDialogResult.delete(delete);
                    }
                })
                .create();
    }
}
