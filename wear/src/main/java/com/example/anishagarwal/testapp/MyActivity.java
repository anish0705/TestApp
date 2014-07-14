package com.example.anishagarwal.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.activity.InsetActivity;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;

<<<<<<< HEAD
public class MyActivity  extends InsetActivity {
=======
public class MyActivity  extends Activity {
>>>>>>> fe4b395db8d7dd47008f24c55b52f87636a5493d

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