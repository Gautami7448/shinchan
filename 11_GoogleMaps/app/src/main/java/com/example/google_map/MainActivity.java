package com.example.google_map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mymap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mymap = googleMap;

        LatLng walchandclg = new LatLng(16.845511,74.601625);
        mymap.addMarker(new AdvancedMarkerOptions().position(walchandclg).title("Walchand College of Engineering"));
        mymap.moveCamera(CameraUpdateFactory.newLatLngZoom(walchandclg,17));

        mymap.getUiSettings().setZoomControlsEnabled(true);
        mymap.getUiSettings().setCompassEnabled(true);
    }
}