package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterNewItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_new_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onSave(View v) {
        EditText editText = (EditText) findViewById(R.id.editNewItem);
        Intent data = new Intent();
        if (editText.getText().toString().matches(""))
            Toast.makeText(this, "Please enter something!", Toast.LENGTH_SHORT).show();
        else {
            data.putExtra("Text_edited", editText.getText().toString());
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
