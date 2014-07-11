package com.example.anishagarwal.testapp;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.widget.*;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;

public class MyActivity extends ActionBarActivity {

    Button okButton;
    Button cancelButton;

    private int num1;
    private int num2;

    EditText firstET;
    EditText secondET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        okButton = (Button) findViewById(R.id.buttonOK);
        cancelButton = (Button) findViewById(R.id.buttonCancel);

        firstET = (EditText) findViewById(R.id.editTextNum1);
        secondET = (EditText) findViewById(R.id.editTextNum2);


        setButtonListeners();

    }

    private void setButtonListeners() {
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get both the numbers
                num1 = Integer.parseInt(firstET.getText().toString());
                num2 = Integer.parseInt(secondET.getText().toString());
                //on click notification to the device followed by the wear
                int notificationId = 001;
// Build intent for notification content
                Intent toOperate = new Intent(getApplicationContext(), ViewDetails.class);
                //toOperate.putExtra(EXTRA_EVENT_ID, eventId);
                PendingIntent viewPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, toOperate, 0);

                NotificationCompat.Builder notificationBuilder =
                        new NotificationCompat.Builder(getApplicationContext())
                                .setSmallIcon(R.drawable.ic_launcher)
                                .setContentTitle("Test Title")
                                .setContentText("Test text")
                                .setContentIntent(viewPendingIntent);

// Get an instance of the NotificationManager service
                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(getApplicationContext());

// Build the notification and issues it with notification manager.
                notificationManager.notify(notificationId, notificationBuilder.build());

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancel the job
                num1 = 0;
                num2 = 0;

                //reset editable areas to null
                firstET.setText("");
                secondET.setText("");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
