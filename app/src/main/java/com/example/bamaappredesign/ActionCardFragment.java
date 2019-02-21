package com.example.bamaappredesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ActionCardFragment extends Fragment
{
    public ActionCardFragment()
    {
        //required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_card, container, false);
        View inputView =  inflater.inflate(R.layout.fragment_card,
                container,
                false
        );

         //Bama Cash button
        Button bamaCash = inputView.findViewById(R.id.bCash_button);
        View.OnClickListener bCashListener = new View.OnClickListener()
        {
            @Override
            public void onClick(android.view.View view)
            {
                assert getFragmentManager() != null;
                FragmentTransaction fragTran = getFragmentManager().beginTransaction();
                fragTran.replace(R.id.flMain, new CashFragment());
                fragTran.addToBackStack(null);
                fragTran.commit();
            }
         };

        //Dining Dollars button
        Button diningDollars = inputView.findViewById(R.id.dDollars_button);
        View.OnClickListener dDollarsListener = new View.onClickListener()
        {
            @Override
            public void onClick(android.view.View view)
            {
                assert getFragmentManager() != null;
                FragmentTransaction fragTran = getFragmentManager().beginTransaction();
                fragTran.replace(R.id.flMain, new DollarFragment());
                fragTran.addToBackStack(null);
                fragTran.commit();
            }
        };

        bamaCash.setOnClickListener(bCashListener);
        diningDollars.setOnClickListener(dDollarsListener);
        return inputView;
    }
}
