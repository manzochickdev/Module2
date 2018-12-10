package com.example.tuananh.module2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.tuananh.module2.Map.MapFragment;
import com.example.tuananh.module2.MapManipulation.MapManipulationFragment;
import com.example.tuananh.module2.Nearby.NearbyFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements IModule2 {
    MapFragment mapFragment;
    MapManipulationFragment mapManipulationFragment;
    NearbyFragment nearbyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo check mode : mode search = tat NearbyFragment , mode view = bat
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapManipulationFragment = (MapManipulationFragment) getSupportFragmentManager().findFragmentById(R.id.mapManipulationFragment);
        nearbyFragment = (NearbyFragment) getSupportFragmentManager().findFragmentById(R.id.nearbyFragment);
    }

    @Override
    public void onModeHandle(int mode) {
        mapManipulationFragment.onModeHandle(mode);
    }

    @Override
    public void getCurrentLocation() {
        mapFragment.getCurrentLocation();
    }

    @Override
    public void getPinnedLocation() {
        mapFragment.getPinnedLocation();
    }

    @Override
    public void onAddressBack(String text, LatLng latLng) {
        Log.d("OK", "onAddressBack: "+text);
        mapManipulationFragment.onAddressBack(text,latLng);
    }

    @Override
    public void onDataBack() {
        ModelAddress modelAddress = mapManipulationFragment.getAddress();
        //todo address + latlng here
    }
}