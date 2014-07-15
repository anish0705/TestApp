package com.example.anishagarwal.testapp;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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
                //toOperate.putExtra(num1,num2);
                PendingIntent viewPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, toOperate, 0);
                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.calculator_background);


                NotificationCompat.Builder notificationBuilder =
                        new NotificationCompat.Builder(getApplicationContext())
                                .setSmallIcon(R.drawable.ic_launcher)
                                .setContentTitle("Calculator")
                                .setContentText("Num1: " + num1 + ", Num2: " + num2)
                                .setContentIntent(viewPendingIntent)
                                .setLargeIcon(largeIcon);

                //for addition option
                Intent addIntent = new Intent();
                addIntent.setAction("ACTION_ADD");
                Bundle b1 = new Bundle();
                b1.putInt("number1",num1);
                b1.putInt("number2",num2);
                b1.putString("action", "plus");
                addIntent.putExtras(b1);

                PendingIntent addPendingIntent =
                        PendingIntent.getBroadcast(getApplicationContext(), 0, addIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                  notificationBuilder.addAction(R.drawable.plus, getString(R.string.plus_button), addPendingIntent);

                //for subtraction option

                Intent subIntent = new Intent();
                subIntent.setAction("ACTION_SUB");
                Bundle b2 = new Bundle();
                b2.putInt("number1", num1);
                b2.putInt("number2", num2);
                b2.putString("action", "minus");
                subIntent.putExtras(b2);
                subIntent.setAction("ACTION_SUB");
                PendingIntent subPendingIntent =
                        PendingIntent.getBroadcast(getApplicationContext(), 0, subIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    notificationBuilder.addAction(R.drawable.minus, getString(R.string.minus_button), subPendingIntent);

                //for multiplication option
                Intent mulIntent = new Intent();
                mulIntent.setAction("ACTION_MUL");
                Bundle b3 = new Bundle();
                b3.putInt("number1", num1);
                b3.putInt("number2", num2);
                b3.putString("action", "minus");
                mulIntent.putExtras(b3);
                PendingIntent mulPendingIntent =
                        PendingIntent.getBroadcast(getApplicationContext(),0 , mulIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                          notificationBuilder.addAction(R.drawable.multiply, getString(R.string.multiply_button), mulPendingIntent);

                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(getApplicationContext());

                NotificationCompat.BigTextStyle secondPageStyle = new NotificationCompat.BigTextStyle();
                secondPageStyle.setBigContentTitle("Numbers Entered");
                secondPageStyle.bigText("Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text Text");

                Notification secondPageNotification = new NotificationCompat.Builder(getApplicationContext())
                        .setStyle(secondPageStyle)
                        .setGroup("Hello")
                        .build();

                Notification twoPageNotification = new WearableExtender().addPage(secondPageNotification).extend(notificationBuilder).build();

// Build the notification and issues it with notification manager.
                notificationManager.notify(notificationId, twoPageNotification);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
