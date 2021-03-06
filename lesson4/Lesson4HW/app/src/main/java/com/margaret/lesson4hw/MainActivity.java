package com.margaret.lesson4hw;

import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

/** The main activity, its got 2 whole fragments.
 *  */
public class MainActivity extends AppCompatActivity implements SettingsFragment.OnFragmentInteractionListener {

    public static final String SAVED_COLOR = "saved_color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment defaultFragment = new MainActivityFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //set the default to be the list view
        fragmentTransaction.add(R.id.fragmentcontainer, defaultFragment);
        fragmentTransaction.commit();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        int defaultValue = getResources().getColor(R.color.white);
        int background = sharedPref.getInt(SAVED_COLOR, defaultValue);

        getWindow().getDecorView().setBackgroundColor(background);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Fragment settingsFragment = new SettingsFragment();

            fragmentTransaction.replace(R.id.fragmentcontainer, settingsFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        if (id == R.id.home) {
            Fragment defaultFragment = new MainActivityFragment();

            fragmentTransaction.replace(R.id.fragmentcontainer, defaultFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onMainFragmentInteraction(Uri uri){

    }

    public void onSettingsFragmentInteraction(Uri uri){

    }

    public void onStop() {
        super.onStop();
    }

}
