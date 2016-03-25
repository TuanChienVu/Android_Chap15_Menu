package com.vutuanchien.android_chap15_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView igNen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        igNen = (ImageView) findViewById(R.id.igNen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
            return true;
        } else if (id == R.id.email) {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("message/rfc822");
            sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jbtuanchien.11@gmail.com"});
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Intent Filters Demo");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is Vu Tuan Chien, long time no see...");
            startActivity(Intent.createChooser(sendIntent, "Choose mail app..."));
            return true;
        } else if (id == R.id.search) {
            //Do something
            return true;
        } else if (id == R.id.activity_a) {
            igNen.setImageResource(R.drawable.h4);
        } else if (id == R.id.activity_b) {
            igNen.setImageResource(R.drawable.h6);
        } else if (id == R.id.activity_c) {
            igNen.setImageResource(R.drawable.h8);
        }

        return super.onOptionsItemSelected(item);
    }
}
