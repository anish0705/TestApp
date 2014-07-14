package com.example.anishagarwal.testapp;

import android.app.Activity;
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


                Intent addIntent = new Intent(Intent.ACTION_VIEW);
                addIntent.putExtra("action","+");
                PendingIntent addPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, addIntent, 0);



                NotificationCompat.Builder notificationBuilder =
                        new NotificationCompat.Builder(getApplicationContext())
                                .setSmallIcon(R.drawable.ic_launcher)
                                .setContentTitle("Calculator")
                                .setContentText("Num1: " + num1 + ", Num2: " + num2)
                                .setContentIntent(viewPendingIntent)
                                .setLargeIcon(largeIcon);

               /* //for addition option
                Intent addIntent = new Intent();
                //Uri geoUri = Uri.parse("geo:38.89,-77.03");
                //addIntent.setData(geoUri);
                Bundle b1 = new Bundle();
                b1.putInt("number1",num1);
                b1.putInt("number2",num2);
                b1.putString("action", "plus");
                addIntent.putExtras(b1);
                //addIntent.setAction(ACTION_ADD);
                //addIntent.putExtra("action", "plus");
                //addIntent.putExtra();
                //addIntent.putExtra("number2",num2);
                PendingIntent mapPendingIntent1 =
                        PendingIntent.getActivity(getApplicationContext(), 0, addIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                  notificationBuilder.addAction(R.drawable.plus, getString(R.string.plus_button), mapPendingIntent1);

                //for subtraction option

                Intent subIntent = new Intent(Intent.ACTION_VIEW);
                //subIntent.putExtra("action", "minus");
                Bundle b2 = new Bundle();
                b2.putInt("number1", num1);
                b2.putInt("number2", num2);
                b2.putString("action", "minus");
                subIntent.putExtras(b2);
                PendingIntent mapPendingIntent2 =
                        PendingIntent.getActivity(getApplicationContext(), 0, subIntent, 0);
                    notificationBuilder.addAction(R.drawable.minus, getString(R.string.minus_button), mapPendingIntent2);

                //for multiplication option
                Intent mulIntent = new Intent(Intent.ACTION_VIEW);
                //mulIntent.putExtra("action", "multiply");
                Bundle b3 = new Bundle();
                b3.putInt("number1", num1);
                b3.putInt("number2", num2);
                b3.putString("action", "minus");
                subIntent.putExtras(b3);
                PendingIntent mapPendingIntent3 =
                        PendingIntent.getActivity(getApplicationContext(),0 , mulIntent, 0);

                          notificationBuilder.addAction(R.drawable.multiply, getString(R.string.multiply_button), mapPendingIntent3);


                /*if(addIntent.resolveActivity(getPackageManager())!=null) {
                    startActivity(toOperate);
                }*/


                Intent yesReceive = new Intent();
                yesReceive.setAction("YES_ACTION");
                PendingIntent pendingIntentYes = PendingIntent.getBroadcast(getApplicationContext(), 0, yesReceive, PendingIntent.FLAG_UPDATE_CURRENT);
                notificationBuilder.addAction(R.drawable.plus, "Yes", pendingIntentYes);

//Maybe intent
                Intent maybeReceive = new Intent();
                maybeReceive.setAction("MAYBE_ACTION");
                PendingIntent pendingIntentMaybe = PendingIntent.getBroadcast(getApplicationContext(), 0, maybeReceive, PendingIntent.FLAG_UPDATE_CURRENT);
                notificationBuilder.addAction(R.drawable.minus, "Partly", pendingIntentMaybe);

//No intent
                Intent noReceive = new Intent();
                noReceive.setAction("NO_ACTION");
                PendingIntent pendingIntentNo = PendingIntent.getBroadcast(getApplicationContext(), 0, noReceive, PendingIntent.FLAG_UPDATE_CURRENT);
                notificationBuilder.addAction(R.drawable.multiply, "No", pendingIntentNo);



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
                //num1 = 0;
                //num2 = 0;

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
