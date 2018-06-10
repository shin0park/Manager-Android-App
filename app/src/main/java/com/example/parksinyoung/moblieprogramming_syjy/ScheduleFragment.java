package com.example.parksinyoung.moblieprogramming_syjy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ScheduleFragment extends ToolBarFragment {
    private List<TextView> mTextViews;
    private static final String DIALOG_SCHEDULE = "DialogSchedule";
    private static ScheduleFragment sFragment = new ScheduleFragment();


    @NonNull
    public static ScheduleFragment newInstance() {
        return sFragment;
    }

    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState ) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                ScheduleDialogFragment dialogFragment = new ScheduleDialogFragment();
                dialogFragment.show(manager, DIALOG_SCHEDULE);
            }
        });
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}