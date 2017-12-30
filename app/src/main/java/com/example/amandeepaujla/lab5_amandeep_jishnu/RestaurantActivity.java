package com.example.amandeepaujla.lab5_amandeep_jishnu;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {

    int selectedCuisine;

    ListView listView;
    String[] listValue;
    String[] sublistValue;
    LocationManager location = null;
    Button viewMapBtn;
    String placeName;
    Geocoder coder;
    double latitude;
    double longitude;
    List<Address> geocodeResults;
    Iterator<Address> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coder = new Geocoder(getApplicationContext());
        setContentView(R.layout.activity_restaurant);
        location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        viewMapBtn = (Button) findViewById(R.id.button3);
        listView = (ListView) findViewById(R.id.listviewRest);

        Bundle gt = getIntent().getExtras();
        selectedCuisine = gt.getInt("selectedCuisine");
        PopulateRestaurants(selectedCuisine);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //try {

                    //latitude = 43.6426f;
                    //longitude = -79.3871f;
                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                //String item = (String) lstView.getItemAtPosition(position);
                switch (itemPosition) {
                    case 0:
                        //placeName = listView.getSelectedItem().toString();
                        placeName = (String) listView.getItemAtPosition(position);
                        break;
                    case 1:
                        placeName = (String) listView.getItemAtPosition(position);
                        break;
                    case 2:
                        placeName = (String) listView.getItemAtPosition(position);
                        break;
                    default:
                        break;
                }

               switch(placeName)
                {
                    case "Anjappar Chettinad Restaurant":latitude = 37.421243;
                        longitude = -121.917243;
                        break;
                    case "Aroman Fine Indian Cuisine":latitude = 43.646273 ;
                        longitude = -79.389817;
                        break;
                    case "Feast of Dilli":latitude = 43.600725;
                        longitude = -79.544793;
                        break;
                    case "Goubuli":latitude = 43.843725;
                        longitude = -79.388589;
                        break;
                    case "Dragon Pearl Restaurant":latitude = 43.753866;
                        longitude = -79.350035;
                        break;
                    case "Congee Queen":latitude = 43.735915;
                        longitude = -79.347398;
                        break;
                    case "Remezzo Italian Bistro":latitude = 43.777628;
                        longitude = -79.307905;
                        break;
                    case "Fabbrica":latitude = 43.736620;
                        longitude = -79.344650;
                    break;
                    case "Spoon and Fork":latitude = 43.754733;
                        longitude = -79.349711;
                        break;
                   default: break;

                }
                   // geocodeResults = coder.getFromLocationName(placeName, 3);
                   // locations = geocodeResults.iterator();
                   // String locInfo = "Results:\n";
                   // while (locations.hasNext()) {
                     //   Address loc = locations.next();
                      //  locInfo += String.format("Location: %f, %f\n", loc.getLatitude(), loc.getLongitude());

                       // latitude = loc.getLatitude();
                        //longitude = loc.getLongitude();
                        //Log.d("Acitivity", "restuarant");
                        //Log.d("lat", "latitude"+latitude);
                        //Log.d("long", "longitude"+longitude);
                       // break;

                   // }
               // } catch (Exception e) {
                    //Log.e("GeoAddress", "Failed to get location info", e);
               //}

            }
        });
    }






    public void PleaseOpen(View view) {

        Toast.makeText(RestaurantActivity.this, "Starting....", Toast.LENGTH_SHORT).show();
        final String geoURI = String.format("geo:%f,%f", latitude, longitude);
        Log.d("Acitivity", "in maps");
        Log.d("lat", "latitude"+latitude);
        Log.d("long", "longitude"+longitude);
        Uri geo = Uri.parse(geoURI);
        Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
        startActivity(geoMap);
    }

    public void viewSat(View v)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("lat", latitude);
        intent.putExtra("long",longitude);
        intent.putExtra("placename",placeName);
        startActivity(intent);
    }
    private void PopulateRestaurants(int selectedCuisine)
    {
        ArrayAdapter<String> adapter;
        switch (selectedCuisine)
        {
            case 0:
                // Function for assign string.xml file array to loacal array.
                listValue = getResources().getStringArray(R.array.indianRest);
                sublistValue = getResources().getStringArray(R.array.addressboxindian);
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, listValue);
                listView.setAdapter(adapter);

                break;
            case 1:
                listValue = getResources().getStringArray(R.array.chineseRest);
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, listValue);
                listView.setAdapter(adapter);
                break;

            case 2:
                listValue = getResources().getStringArray(R.array.italianRest);
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, listValue);
                listView.setAdapter(adapter);
                break;
                default:
                    break;

        }
    }
}
