package com.app_nfusion.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BaseAdapterActivity extends AppCompatActivity {

    ArrayList<String> arrayList;

    BaseAdapter baseAdapter;

    TextView listViewType;
    ListView listView;
    Button nextButton;
    Button backButton;

    public void setNextButton(View view){
        Intent intent = new Intent(this, CustomAdapterActivity.class);
        startActivity(intent);
        finish();
    }

    public void setBackButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
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
        setContentView(R.layout.activity_base_adapter);

        listGenerator();

        listViewType = (TextView) findViewById(R.id.listType);
        listView = (ListView) findViewById(R.id.listView);
        nextButton = (Button) findViewById(R.id.nextButton);
        backButton = (Button) findViewById(R.id.backButton);

        listViewType.setText("Base Adapter");

        baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = getLayoutInflater().inflate(R.layout.base_adapter_item, null);

                TextView textView = convertView.findViewById(R.id.itemText);

                textView.setText(arrayList.get(position));

                return convertView;
            }
        };

        listView.setAdapter(baseAdapter);
    }
}
