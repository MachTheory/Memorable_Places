package com.example.memorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    static ArrayList places;
    static ArrayList latLong;
    static ArrayAdapter arrayAdapter;

    //make the lists and array adapter static to reference in other activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        final ArrayList <String> places = new ArrayList<String>();
        final ArrayList <String> locations = new ArrayList<String>();
        //add new latlong array list

        places.add("Add a new place");
        //locations.add(new LatLng(0,0));

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, places);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("places", places.get(i));

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("address", 0);
                startActivity(intent);

            }
        });
       /* Intent intent = getIntent();
        int address = intent.getIntExtra("address", 0);
        Toast.makeText(this, Integer.toString(address), Toast.LENGTH_SHORT).show();

        */

    }
}
