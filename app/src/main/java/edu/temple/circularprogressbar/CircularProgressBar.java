package edu.temple.circularprogressbar;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CircularProgressBar extends Activity {
    EditText etExp, etLevel;
    Button btnExp, btnLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_progress_bar);

        etExp = (EditText) findViewById(R.id.etExp);
        etLevel = (EditText) findViewById(R.id.etLevel);
        btnExp = (Button) findViewById(R.id.btnExp);
        btnLevel = (Button) findViewById(R.id.btnLevel);

        //Setting Button click action which loads a fragment by passing value of number as a
        //parameter in one Constructor.

        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ExpFragment expFragment = new ExpFragment(Integer.parseInt(etExp.getText().toString()));
                fragmentTransaction.replace(R.id.fragmentExp, expFragment);
                fragmentTransaction.commit();
            }
        });

        //Setting Button click action which loads a fragment by passing value of number as a
        //parameter in one Constructor.

        btnLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                LevelFragment levelFragment = new LevelFragment(Integer.parseInt(etLevel.getText().toString()));
                fragmentTransaction.replace(R.id.fragmenLevel, levelFragment);
                fragmentTransaction.commit();
            }
        });
    }
}