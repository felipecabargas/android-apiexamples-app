package com.example.cabargasapiexample;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Context;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        Button getcode = (Button)findViewById(R.id.downloadbutton);

        getcode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://www.github.com/felipecabargas/android-apiexamples-app"));
                startActivity(viewIntent);
            }
        });

        final Context context = this;
        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, ExamplesActivity.class);
                startActivity(intent);

            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.about:
                AlertDialog alertDialog1 = new AlertDialog.Builder(this).create();

                // Setting Dialog Title
                alertDialog1.setTitle("About");

                // Setting Dialog Message
                alertDialog1.setMessage("CABARGAS.com (c) All Rights Reserved 2013. The Code of this app is available on GitHub for testing.");

                // Setting OK Button
                alertDialog1.setButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        // closed
                    }
                });

                // Showing Alert Message
                alertDialog1.show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}