package com.kanchan.seekbar.seekbar;

import android.graphics.Color;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     private SeekBar mSeekbar;
     private TextView mTextView;
     private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekbar = (SeekBar) findViewById(R.id.seekBarID);
        mTextView = (TextView) findViewById(R.id.textViewID);
        mEditText = (EditText) findViewById(R.id.editTextID);

        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("SK", "Progress changed");
                mEditText.setTextColor(Color.GRAY);
                mEditText.setText("Pain Level : " + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SK", "Started Tracking");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("SK", "Stop Tracking");
                if (seekBar.getProgress() > 6)  mEditText.setTextColor(Color.RED);
            }
        });
    }
}
