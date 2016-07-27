package com.halohoop.ribbentextview_example;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.halohoop.ribbentextview.RibbenTextView;

public class MainActivity extends AppCompatActivity {

    private RibbenTextView rtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rtv = (RibbenTextView) findViewById(R.id.rtv);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rtv.setText("Halohoop-Wong");
            }
        },2000);
    }
}
