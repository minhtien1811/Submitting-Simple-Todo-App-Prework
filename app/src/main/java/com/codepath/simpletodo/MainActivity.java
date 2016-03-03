package com.codepath.simpletodo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;

    private final int REQUEST_CODE1 = 20;
    private final int REQUEST_CODE2 = 1;
    int n;
    boolean bool = false;
    String color = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lvItems = (ListView) findViewById(R.id.lvItems);
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    public void setupListViewListener() {
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, final int position, long id) {
                AlertDialog.Builder ask = new AlertDialog.Builder(MainActivity.this);
                ask.setMessage("Are you sure you want to REMOVE this item?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        items.remove(position);
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = ask.create();
                alert.setTitle("Warning!!!");
                alert.show();
                return true;
            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditItemActivity.class);
                intent.putExtra("Text_to_edit", items.get(position).toString());
                startActivityForResult(intent, REQUEST_CODE1);
                n = position;
                bool = true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, ColorPickActivity.class);
            startActivityForResult(intent, REQUEST_CODE2);
        } else if (item.getItemId() == R.id.action_about_me) {
            Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //thêm to do vô list
    public void onAddItem(View v) {
        Intent intent = new Intent(MainActivity.this, EnterNewItem.class);
        startActivityForResult(intent, REQUEST_CODE1);
    }

    /*tạo file todo.txt để lưu các to do list*/
    //đọc từ file todo.txt
    public void readItems() {
        File fileDir = getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    //viết vô file todo.txt
    public void writeItems() {
        File fileDir = getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE1) {
            String edited = data.getExtras().getString("Text_edited");
            if (bool == false) {
                items.add(edited);
            } else {
                items.set(n, edited);
                n = 0;
                bool = false;
            }
            itemsAdapter.notifyDataSetChanged();
            writeItems();
        } else if (resultCode == RESULT_OK && requestCode == REQUEST_CODE2) {
            String edited = data.getExtras().getString("Color");
            color = edited;
        }
    }
}
