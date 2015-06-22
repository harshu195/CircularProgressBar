package edu.temple.circularprogressbar;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ExpFragment extends Fragment {
    TextView tv;
    ProgressBar pBar;
    int pStatus = 0;
    int endExp =0 ;
    private Handler handler = new Handler();
    public ExpFragment() {
        // Required empty public constructor
    }
    public ExpFragment(Integer etExp){
        //Getting value from the function call and setting it as a End point
        endExp = etExp;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exp, container, false);
        tv = (TextView) v.findViewById(R.id.textView1);
        pBar = (ProgressBar) v.findViewById(R.id.progressBar1);

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus <= endExp) {

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            pBar.setProgress(pStatus);
                            pBar.setSecondaryProgress(pStatus + 2);
                            tv.setText(pStatus + "/" + pBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 25 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
            }
        }).start();
        return v;
    }
}