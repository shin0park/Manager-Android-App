package com.example.parksinyoung.moblieprogramming_syjy;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.parksinyoung.moblieprogramming_syjy.model.ScheduleModel;
import com.example.parksinyoung.moblieprogramming_syjy.singleton.Schedule;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ScheduleFragment extends ToolBarFragment {
    private static final String DIALOG_SCHEDULE = "DialogSchedule";
//    private static ScheduleFragment sFragment = new ScheduleFragment();
    private static ScheduleModel scheduleModel = new ScheduleModel();
    private Schedule schedule;
    private List<Schedule> mSchedules;
    private boolean scheduleDelete = false;
    private DatabaseReference databaseReference;

    private TextView monday[] = new TextView[8];
    private TextView tuesday[] = new TextView[8];
    private TextView wednesday[] = new TextView[8];
    private TextView thursday[] = new TextView[8];
    private TextView friday[] = new TextView[8];

//
//    @NonNull
//    public static ScheduleFragment newInstance() {
//        return sFragment;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_schedule2, container, false);

        monday[0] = view.findViewById(R.id.mondayA);
        monday[1] = view.findViewById(R.id.mondayB);
        monday[2] = view.findViewById(R.id.mondayC);
        monday[3] = view.findViewById(R.id.mondayD);
        monday[4] = view.findViewById(R.id.mondayE);
        monday[5] = view.findViewById(R.id.mondayF);
        monday[6] = view.findViewById(R.id.mondayG);
        monday[7] = view.findViewById(R.id.mondayH);

        tuesday[0] = view.findViewById(R.id.tuesdayA);
        tuesday[1] = view.findViewById(R.id.tuesdayB);
        tuesday[2] = view.findViewById(R.id.tuesdayC);
        tuesday[3] = view.findViewById(R.id.tuesdayD);
        tuesday[4] = view.findViewById(R.id.tuesdayE);
        tuesday[5] = view.findViewById(R.id.tuesdayF);
        tuesday[6] = view.findViewById(R.id.tuesdayG);
        tuesday[7] = view.findViewById(R.id.tuesdayH);

        wednesday[0] = view.findViewById(R.id.wednesdayA);
        wednesday[1] = view.findViewById(R.id.wednesdayB);
        wednesday[2] = view.findViewById(R.id.wednesdayC);
        wednesday[3] = view.findViewById(R.id.wednesdayD);
        wednesday[4] = view.findViewById(R.id.wednesdayE);
        wednesday[5] = view.findViewById(R.id.wednesdayF);
        wednesday[6] = view.findViewById(R.id.wednesdayG);
        wednesday[7] = view.findViewById(R.id.wednesdayH);

        thursday[0] = view.findViewById(R.id.thursdayA);
        thursday[1] = view.findViewById(R.id.thursdayB);
        thursday[2] = view.findViewById(R.id.thursdayC);
        thursday[3] = view.findViewById(R.id.thursdayD);
        thursday[4] = view.findViewById(R.id.thursdayE);
        thursday[5] = view.findViewById(R.id.thursdayF);
        thursday[6] = view.findViewById(R.id.thursdayG);
        thursday[7] = view.findViewById(R.id.thursdayH);

        friday[0] = view.findViewById(R.id.fridayA);
        friday[1] = view.findViewById(R.id.fridayB);
        friday[2] = view.findViewById(R.id.fridayC);
        friday[3] = view.findViewById(R.id.fridayD);
        friday[4] = view.findViewById(R.id.fridayE);
        friday[5] = view.findViewById(R.id.fridayF);
        friday[6] = view.findViewById(R.id.fridayG);
        friday[7] = view.findViewById(R.id.fridayH);

        monday[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteClass(view);
            }
        });

        StartCreateView();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                ScheduleDialogFragment dialogFragment = new ScheduleDialogFragment();
                dialogFragment.show(manager, DIALOG_SCHEDULE);
                dialogFragment.setDialogResult(new ScheduleDialogFragment.OnMyDialogResult() {
                    @Override
                    public void finish(Object result) {
                        schedule = (Schedule) result;
                        scheduleModel.writeSchedule(schedule.getClassName(), schedule.getClassRoom(), schedule.getClassDay(), schedule.getClassTime());
                        createView(schedule.getClassName(), schedule.getClassRoom(), schedule.getClassDay(), schedule.getClassTime());
                    }
                });
            }
        });

        return view;
    }




    public void StartCreateView(){
        this.mSchedules = scheduleModel.getSchedules();
        for (int i = 0; i < mSchedules.size(); i++) {
            createView(mSchedules.get(i).getClassName(), mSchedules.get(i).getClassRoom(), mSchedules.get(i).getClassDay(), mSchedules.get(i).getClassTime());
        }
    }
    public void ListRemove(String name, String time) {
        mSchedules = scheduleModel.getSchedules();
        for (int i = 0; i < mSchedules.size(); i++) {
            if (mSchedules.get(i).getClassDay().equals(name)) {
                if (mSchedules.get(i).getClassTime().equals(time)) {
                    mSchedules.remove(mSchedules.get(i));
                }
            }
        }
    }

    public void DeleteClass(View v) {
        FragmentManager manager = getFragmentManager();
        ScheduleDeleteDialogFragment deleteDialogFragment = new ScheduleDeleteDialogFragment();
        deleteDialogFragment.show(manager, DIALOG_SCHEDULE);
        final TextView text = (TextView) v;
        deleteDialogFragment.setDeleteDialogResult(new ScheduleDeleteDialogFragment.OnMyDeleteDialogResult() {
            @Override
            public void delete(boolean result) {
                scheduleDelete = result;
                if (scheduleDelete) {
                    switch (text.getId()) {
                        case R.id.mondayA:
                            ListRemove("월요일", "A");
                            StartCreateView();
                        case R.id.mondayB:
                            ListRemove("월요일", "B");
                        case R.id.mondayC:
                            ListRemove("월요일", "C");
                        case R.id.mondayD:
                            ListRemove("월요일", "D");
                        case R.id.mondayE:
                            ListRemove("월요일", "E");
                        case R.id.mondayF:
                            ListRemove("월요일", "F");
                        case R.id.mondayG:
                            ListRemove("월요일", "G");
                        case R.id.mondayH:
                            ListRemove("월요일", "H");

                    }

                }
            }
        });

    }

    public void createView(String name, String room, String day, String time) {
        String r = " (" + room + ") ";
        String text = name + "\n" + r;
        if (day.equals("월요일")) {
            if (time.equals("A")) {
                monday[0].setText(text);
                monday[0].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("B")) {
                monday[1].setText(text);
                monday[1].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("C")) {
                Toast.makeText(getActivity(), name + " (" + room + ") ", Toast.LENGTH_SHORT).show();
                monday[2].setText(text);
                monday[2].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));

            } else if (time.equals("D")) {
                monday[3].setText(text);

                monday[3].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("E")) {
                monday[4].setText(text);

                monday[4].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));

            } else if (time.equals("F")) {
                monday[5].setText(text);

                monday[5].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));

            } else if (time.equals("G")) {
                monday[6].setText(text);

                monday[6].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));

            } else if (time.equals("H")) {
                monday[7].setText(text);

                monday[7].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            }

        } else if (day.equals("화요일")) {
            if (time.equals("A")) {
                tuesday[0].setText(text);
                tuesday[0].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));

            } else if (time.equals("B")) {
                tuesday[1].setText(text);
                tuesday[1].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));

            } else if (time.equals("C")) {
                tuesday[2].setText(text);
                tuesday[2].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("D")) {
                tuesday[3].setText(text);
                tuesday[3].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("E")) {
                tuesday[4].setText(text);
                tuesday[4].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("F")) {
                tuesday[5].setText(text);
                tuesday[5].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("G")) {
                tuesday[6].setText(text);
                tuesday[6].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("H")) {
                tuesday[7].setText(text);
                tuesday[7].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            }
        } else if (day.equals("수요일")) {
            if (time.equals("A")) {
                wednesday[0].setText(text);
                wednesday[0].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("B")) {
                wednesday[1].setText(text);
                wednesday[1].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("C")) {
                wednesday[2].setText(text);
                wednesday[2].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("D")) {
                wednesday[3].setText(text);
                wednesday[3].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("E")) {
                wednesday[4].setText(text);
                wednesday[4].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("F")) {
                wednesday[5].setText(text);
                wednesday[5].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("G")) {
                wednesday[6].setText(text);
                wednesday[6].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("H")) {
                wednesday[7].setText(text);
                wednesday[7].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            }
        } else if (day.equals("목요일")) {
            if (time.equals("A")) {
                thursday[0].setText(text);
                thursday[0].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("B")) {
                thursday[1].setText(text);
                thursday[1].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("C")) {
                thursday[2].setText(text);
                thursday[2].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("D")) {
                thursday[3].setText(text);
                thursday[3].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("E")) {
                thursday[4].setText(text);
                thursday[4].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("F")) {
                thursday[5].setText(text);
                thursday[5].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("G")) {
                thursday[6].setText(text);
                thursday[6].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("H")) {
                thursday[7].setText(text);
                thursday[7].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            }
        } else if (day.equals("금요일")) {
            if (time.equals("A")) {
                friday[0].setText(text);
                friday[0].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("B")) {
                friday[1].setText(text);
                friday[1].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("C")) {
                friday[2].setText(text);
                friday[2].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("D")) {
                friday[3].setText(text);
                friday[3].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("E")) {
                friday[4].setText(text);
                friday[4].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("F")) {
                friday[5].setText(text);
                friday[5].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("G")) {
                friday[6].setText(text);
                friday[6].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            } else if (time.equals("H")) {
                friday[7].setText(text);
                friday[7].setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.cell_shape_update));
            }
        }

    }

}