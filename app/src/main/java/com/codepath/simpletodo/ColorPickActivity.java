package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorPickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_pick);
    }

    public void onColorSave(View v) {
        Intent data = new Intent();
        data.putExtra("Color", color);
        setResult(RESULT_OK, data);
        finish();
    }

    String color = "";

    public void ColorRedPress(View v) {
        ResetColorPress(color);
        Button btnRed = (Button) findViewById(R.id.btnRed);
        btnRed.setBackgroundResource(R.drawable.ic_color_red_focused);
        color = "Red";
    }

    public void ColorOgrangePress(View v) {
        ResetColorPress(color);
        Button btnOgrange = (Button) findViewById(R.id.btnOgrange);
        btnOgrange.setBackgroundResource(R.drawable.ic_color_ogrange_focused);
        color = "Ogrange";
    }

    public void ColorGreenPress(View v) {
        ResetColorPress(color);
        Button btnGreen = (Button) findViewById(R.id.btnGreen);
        btnGreen.setBackgroundResource(R.drawable.ic_color_green_focused);
        color = "Green";
    }

    public void ColorBluePress(View v) {
        ResetColorPress(color);
        Button btnBlue = (Button) findViewById(R.id.btnBlue);
        btnBlue.setBackgroundResource(R.drawable.ic_color_blue_focused);
        color = "Blue";
    }

    public void ColorPurplePress(View v) {
        ResetColorPress(color);
        Button btnPurple = (Button) findViewById(R.id.btnPurple);
        btnPurple.setBackgroundResource(R.drawable.ic_color_purple_focused);
        color = "Purple";
    }

    public void ColorPinkPress(View v) {
        ResetColorPress(color);
        Button btnPink = (Button) findViewById(R.id.btnPink);
        btnPink.setBackgroundResource(R.drawable.ic_color_pink_focused);
        color = "Pink";
    }

    public void ColorYellowPress(View v) {
        ResetColorPress(color);
        Button btnYellow = (Button) findViewById(R.id.btnYellow);
        btnYellow.setBackgroundResource(R.drawable.ic_color_yellow_focused);
        color = "Yellow";
    }

    public void ColorBlackPress(View v) {
        ResetColorPress(color);
        Button btnBlack = (Button) findViewById(R.id.btnBlack);
        btnBlack.setBackgroundResource(R.drawable.ic_color_black_focused);
        color = "Black";
    }

    public void ResetColorPress(String cl) {
        switch (cl) {
            case "Red":
                Button btnRed = (Button) findViewById(R.id.btnRed);
                btnRed.setBackgroundResource(R.drawable.ic_color_red);
                break;
            case "Ogrange":
                Button btnOgrange = (Button) findViewById(R.id.btnOgrange);
                btnOgrange.setBackgroundResource(R.drawable.ic_color_ogrange);
                break;
            case "Green":
                Button btnGreen = (Button) findViewById(R.id.btnGreen);
                btnGreen.setBackgroundResource(R.drawable.ic_color_green);
                break;
            case "Blue":
                Button btnBlue = (Button) findViewById(R.id.btnBlue);
                btnBlue.setBackgroundResource(R.drawable.ic_color_blue);
                break;
            case "Purple":
                Button btnPurple = (Button) findViewById(R.id.btnPurple);
                btnPurple.setBackgroundResource(R.drawable.ic_color_purple);
                break;
            case "Pink":
                Button btnPink = (Button) findViewById(R.id.btnPink);
                btnPink.setBackgroundResource(R.drawable.ic_color_pink);
                break;
            case "Yellow":
                Button btnGray = (Button) findViewById(R.id.btnYellow);
                btnGray.setBackgroundResource(R.drawable.ic_color_yellow);
                break;
            case "Black":
                Button btnBlack = (Button) findViewById(R.id.btnBlack);
                btnBlack.setBackgroundResource(R.drawable.ic_color_black);
                break;
            default:
                break;
        }
    }
}
