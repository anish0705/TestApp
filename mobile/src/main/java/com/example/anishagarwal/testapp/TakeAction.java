package com.example.anishagarwal.testapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Anish Agarwal on 7/14/2014.
 */
public class TakeAction extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if("YES_ACTION".equals(action)) {
            Log.v("shuffTest", "Pressed YES");
        } else if("MAYBE_ACTION".equals(action)) {
            Log.v("shuffTest","Pressed NO");
        } else if("NO_ACTION".equals(action)) {
            Log.v("shuffTest","Pressed MAYBE");
        }
    }
}
