package com.example.bamaappredesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StudentFragment extends Fragment {

    public StudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View inputView =  inflater.inflate(R.layout.fragment_student,
                container,
                false
        );

        //Grades button
        Button grades = inputView.findViewById(R.id.grades_button);
        View.OnClickListener gradesListener = new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flMain, new GradesFragment());
                ft.commit();
            }
        };

        //Schedule button
        Button schedule = inputView.findViewById(R.id.schedule_button);
        View.OnClickListener scheduleListener = new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flMain, new ScheduleFragment());
                ft.commit();
            }
        };

        //MyTickets button
        Button tickets = inputView.findViewById(R.id.tickets_button);
        View.OnClickListener ticketsListener = new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flMain, new TicketsFragment());
                ft.commit();
            }
        };

        //Action Card button
        Button card = inputView.findViewById(R.id.action_card_button);
        View.OnClickListener cardListener = new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.flMain, new ActionCardFragment());
                ft.commit();
            }
        };

        grades.setOnClickListener(gradesListener);
        schedule.setOnClickListener(scheduleListener);
        tickets.setOnClickListener(ticketsListener);
        card.setOnClickListener(cardListener);
        return inputView;
    }
}
