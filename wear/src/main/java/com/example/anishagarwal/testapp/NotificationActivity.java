package com.example.anishagarwal.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.activity.InsetActivity;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;


public class NotificationActivity extends InsetActivity {


    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                //Log.d(TAG, "TextView: " + mTextView.getText() + " view=" + mTextView);
            }
        });
    }

    @Override
    public void onReadyForContent() {

    }

}