package com.margaret.lesson3hw;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    public MainActivityFragment() {

    }

    public void setViewText(TextView tv) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //git some goddam textvew
        tv1 = (TextView) view.findViewById(R.id.textView);
        tv2 = (TextView) view.findViewById(R.id.textView3);
        tv3 = (TextView) view.findViewById(R.id.textView4);
        tv4 = (TextView) view.findViewById(R.id.textView5);
        tv5 = (TextView) view.findViewById(R.id.textView6);

        //git some textvew goddamn
        setText(tv1);
        setText(tv2);
        setText(tv3);
        setText(tv4);
        setText(tv5);

        return view;
    }

    public void setText(final TextView tv) {
        //setting all the onclick listeners for a textview
        //http://stackoverflow.com/questions/8813565/alertdialog-inside-onclicklistener
        tv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("On Click", "CLIKKKKCKCKCKKKK");
                Context context = getActivity();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle("Enter an item to do");
                final EditText edittext = new EditText(context);
                alertDialogBuilder.setView(edittext);

                alertDialogBuilder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //get the eddittext text input and put it in the textview
                        String textInput = edittext.getText().toString();
                        tv.setText(textInput);
                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();
            }

        });
    }

}
