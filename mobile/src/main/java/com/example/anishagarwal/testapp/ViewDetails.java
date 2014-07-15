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
        System.out.println(action);
        System.out.println("here :P");
        Bundle b1 = intent.getExtras();
        System.out.println(b1.isEmpty());
        int no1 = b1.getInt("number1");
        int no2 = b1.getInt("number2");
        System.out.println(no1);
        System.out.println(no2);
        if("ACTION_ADD".equals(action)) {
            Log.v("shuffTest", "Pressed YES");
            Intent viewIntent = new Intent(context,MyActivity.class);
            viewIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(viewIntent);
            System.out.println(no1 + no2);
        } else if("ACTION_SUB".equals(action)) {
            Log.v("shuffTest","Pressed NO");
            System.out.println(no1 - no2);
        } else if("ACTION_MUL".equals(action)) {
            Log.v("shuffTest","Pressed MAYBE");
            System.out.println(no1 * no2);
        }
    }
}