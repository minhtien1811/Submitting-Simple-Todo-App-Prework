package com.codepath.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AboutMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        TextView phone = (TextView) findViewById(R.id.PhoneNumber);
        TextView google_plus = (TextView) findViewById(R.id.GooglePlus);
        TextView facebook = (TextView) findViewById(R.id.Facebook);
        phone.setMovementMethod(LinkMovementMethod.getInstance());
        google_plus.setMovementMethod(LinkMovementMethod.getInstance());
        facebook.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
