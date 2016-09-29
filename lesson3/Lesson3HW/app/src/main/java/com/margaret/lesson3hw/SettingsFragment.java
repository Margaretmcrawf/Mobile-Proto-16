package com.margaret.lesson3hw;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * This is the settings screen with color changing options.
 */
public class SettingsFragment extends Fragment {


    public SettingsFragment() {
        // Required empty public constructor
    }

//    public static SettingsFragment newInstance(String param1, String param2) {
//        SettingsFragment fragment = new SettingsFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        //get the buttons
        Button red = (Button) view.findViewById(R.id.red);
        Button blue = (Button) view.findViewById(R.id.blue);
        Button green = (Button) view.findViewById(R.id.green);

        //set up the onclick shiz with buttonSettup method
        buttonSetup(red, 0xffff0000);
        buttonSetup(blue, 0xff0000ff);
        buttonSetup(green, 0xff00ff00);

        return view;
    }

    public void buttonSetup(Button name, final int color) {
        //change the background color on click
        name.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getView().setBackgroundColor(color);
            }
        });

    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
