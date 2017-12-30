package com.example.amandeepaujla.lab5_amandeep_jishnu;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity  implements OnMapReadyCallback {

    static LatLng TORONTO;
    private GoogleMap gMap;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_restaurant);

        Bundle extras = getIntent().getExtras();
        double latitude = extras.getDouble("lat");
        double longitude = extras.getDouble("long");
        name = extras.getString("placename");

        TORONTO = new LatLng(latitude, longitude);
        Log.d("Acitivity", "in maps");
        Log.d("lat", "latitude"+latitude);
        Log.d("long", "longitude"+longitude);

        System.out.print("In sat view");
        System.out.print(latitude);
        System.out.print(longitude);
        this.getSupportActionBar().setTitle("Restaurants");
        MapFragment mapFragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));

        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap map) {
        gMap = map;
        gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Marker Toronto = gMap.addMarker(new MarkerOptions().position(TORONTO)
                .title(name));

        // Move the camera instantly to toronto with a zoom of 15.
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TORONTO, 10));
        // Zoom in, animating the camera.
        gMap.animateCamera(CameraUpdateFactory.zoomTo(20), 5000, null);
    }


}
