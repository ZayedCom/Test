package com.app_nfusion.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //You can also use array with arrayAdapter only but for baseAdapter or a custom adapter you will need an arrayList for that
    //String listData[] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

    ArrayList<String> arrayList;

    ArrayAdapter arrayAdapter;

    TextView listViewType;
    ListView listView;
    Button nextButton;
    Button backButton;

    public void setNextButton(View view){
        Intent intent = new Intent(this, BaseAdapterActivity.class);
        startActivity(intent);
        finish();
    }

    public void setBackButton(View view){
        Intent intent = new Intent(this, CustomAdapterActivity.class);
        startActivity(intent);
        finish();
    }

    public void listGenerator(){
        arrayList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++){
            arrayList.add("Item " + i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listGenerator();

        listViewType = (TextView) findViewById(R.id.listType);
        listView = (ListView) findViewById(R.id.listView);
        nextButton = (Button) findViewById(R.id.nextButton);
        backButton = (Button) findViewById(R.id.backButton);

        listViewType.setText("Array Adapter");

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);

        listView.setAdapter(arrayAdapter);
    }
}
