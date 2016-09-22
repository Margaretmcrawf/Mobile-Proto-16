package com.margaret.lesson4hw;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The main fragment containing the list of tasks and a button to add tasks. None of my alertdialogs have back buttons. I'm tired and it wasn't ever required.
 */
public class MainActivityFragment extends Fragment {
    //preparing to butter...
    @BindView(R.id.tasklist) ListView listView;
    @BindView(R.id.addButton) Button addButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getting the view
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        //spreading the butter
        ButterKnife.bind(this, view);
        //making a new ArrayList of tasks, making an instance of the adapter for the list.
        ArrayList<Task> list = new ArrayList<Task>();
        final TasksAdapter tasksAdapter = new TasksAdapter(getActivity(), list);
        listView.setAdapter(tasksAdapter);

        //setting an onclick for the button that adds items.
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //building the alertdialog, which pulls up an edittext and sets the value in the ArrayList.
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setTitle(R.string.add_item_title);
                final EditText edittext = new EditText(getActivity());
                alertDialogBuilder.setView(edittext);

                //positive button- enter to change the things.
                alertDialogBuilder.setPositiveButton(R.string.enter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //get the eddittext text input and put it in the textview
                        String textInput = edittext.getText().toString();
                        Task taskInput = new Task(textInput);
                        tasksAdapter.add(taskInput);
                    }
                });

                //calling the alert dialog.
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();
        }
        });

        return view;
    }

}
