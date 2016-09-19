package com.margaret.lesson4hw;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/** This is my adapter. It works for an array of tasks and includes an onclick for each testview that opens up an alertdialog.
 * */

public class TasksAdapter extends ArrayAdapter<Task> {
    @BindView(R.id.tvText) TextView tvText;
    private ArrayList<Task> tasks;
    public TasksAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
        this.tasks = tasks;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Task task = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_task, parent, false);
        }

        ButterKnife.bind(this, convertView);
        // Lookup view for data population

        // Populate the data into the template view using the data object
        tvText.setText(task.getText());

        //set an onclick listener to the textview.
        tvText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getContext();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle("Edit the text, or delete an item.");
                final EditText edittext = new EditText(context);
                alertDialogBuilder.setView(edittext);

                //sets the text from the eddittext to the textview.
                alertDialogBuilder.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String textInput = edittext.getText().toString();
                        tvText.setText(textInput);
                        notifyDataSetChanged();
                    }
                });

                //deletes the current task.
                alertDialogBuilder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        tasks.remove(getItem(position));
                        notifyDataSetChanged();
                    }
                });

                AlertDialog alert = alertDialogBuilder.create();
                alert.show();
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

}
