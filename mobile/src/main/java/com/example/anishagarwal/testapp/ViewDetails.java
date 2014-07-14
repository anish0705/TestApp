package com.example.anishagarwal.testapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.anishagarwal.testapp.R;

public class ViewDetails extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        System.out.println("here :P");

        if("YES_ACTION".equals(action)) {
            Log.v("shuffTest", "Pressed YES");
            System.out.println("Pressed YES");
        } else if("MAYBE_ACTION".equals(action)) {
            Log.v("shuffTest","Pressed NO");
            System.out.println("Pressed NO");
        } else if("NO_ACTION".equals(action)) {
            Log.v("shuffTest","Pressed MAYBE");
            System.out.println("Pressed MAYBE");
        }
    }
}