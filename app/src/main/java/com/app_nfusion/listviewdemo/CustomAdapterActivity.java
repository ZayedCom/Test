package com.app_nfusion.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CustomAdapterActivity extends AppCompatActivity {

    ArrayList<String> textArrayList;
    ArrayList<String> descriptionTextArrayList;
    ArrayList<Integer> imagesArrayList = new ArrayList<Integer>();

    CustomAdapter customAdapter;

    TextView listViewType;
    ListView listView;
    Button nextButton;
    Button backButton;

    public void setNextButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setBackButton(View view){
        Intent intent = new Intent(this, BaseAdapterActivity.class);
        startActivity(intent);
        finish();
    }

    public void listGenerator(){
        textArrayList = new ArrayList<>();
        descriptionTextArrayList = new ArrayList<>();

        for (int i = 1; i <= 1000; i++){
            textArrayList.add("Name No." + i);
            descriptionTextArrayList.add("The Description of Person No." + i);

            Random random = new Random();
            int randomImage = random.nextInt(5) + 1;

            if (randomImage == 1){
                imagesArrayList.add(R.drawable.ic_image_1);
            }
            else if (randomImage == 2){
                imagesArrayList.add(R.drawable.ic_image_2);
            }
            else if (randomImage == 3){
                imagesArrayList.add(R.drawable.ic_image_3);
            }
            else if (randomImage == 4){
                imagesArrayList.add(R.drawable.ic_image_4);
            }
            else if (randomImage == 5){
                imagesArrayList.add(R.drawable.ic_image_5);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        listGenerator();

        listViewType = (TextView) findViewById(R.id.listType);
        listView = (ListView) findViewById(R.id.listView);
        nextButton = (Button) findViewById(R.id.nextButton);
        backButton = (Button) findViewById(R.id.backButton);

        listViewType.setText("Custom Adapter");

        customAdapter = new CustomAdapter(this, textArrayList, descriptionTextArrayList, imagesArrayList);

        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {

        Context context;

        ArrayList<String> textArrayList;
        ArrayList<String> descriptionTextArrayList;
        ArrayList<Integer> imagesArrayList;

        public CustomAdapter(Context tempContext, ArrayList<String> tempTextArrayList, ArrayList<String> tempDescriptionTextArrayList, ArrayList<Integer> tempImagesArrayList) {
            this.context = tempContext;
            this.textArrayList = tempTextArrayList;
            this.descriptionTextArrayList = tempDescriptionTextArrayList;
            this.imagesArrayList = tempImagesArrayList;
        }

        @Override
        public int getCount() {
            return textArrayList.size();
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
            LayoutInflater layoutInflater = (LayoutInflater) getApplication().getSystemService(LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_adapter_item, parent, false);

            TextView itemText = convertView.findViewById(R.id.itemText);
            TextView itemTextDescription = convertView.findViewById(R.id.itemTextDescription);
            ImageView image = convertView.findViewById(R.id.image);

            itemText.setText(textArrayList.get(position));
            itemTextDescription.setText(descriptionTextArrayList.get(position));
            image.setImageResource(imagesArrayList.get(position));

            return convertView;
        }
    }
}
