package com.example.bamaappredesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeStudentFragment extends Fragment {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView welcomeText;

    public HomeStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        //Display user's email
        //welcomeText = (TextView) getView().findViewById(R.id.welcomeText);
        //welcomeText.setText("Welcome!");
        final View view = inflater.inflate(R.layout.fragment_home_student, container, false);
        TextView frv = (TextView) view.findViewById(R.id.welcomeText);
        frv.setText("Welcome, " + user.getEmail() + "!");
        return view;
    }

}
