package com.example.tuananh.module2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.tuananh.module2.Map.MapFragment;
import com.example.tuananh.module2.MapManipulation.MapManipulationFragment;
import com.example.tuananh.module2.Nearby.NearbyFragment;
import com.example.tuananh.module2.databinding.LayoutTempBinding;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements IModule2 {
    MapFragment mapFragment;
    MapManipulationFragment mapManipulationFragment;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo check mode : mode search = tat NearbyFragment , mode view = bat
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapManipulationFragment = (MapManipulationFragment) getSupportFragmentManager().findFragmentById(R.id.mapManipulationFragment);


        mode = getIntent().getStringExtra("mode");
        //todo remove mode here
        mode="view";

        if (mode.equals("view")){
            Button button = findViewById(R.id.btn_ok);
            button.setVisibility(View.GONE);
            NearbyFragment nearbyFragment = new NearbyFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_container,nearbyFragment,"NearbyFragment").commit();
        }

        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDataBack();
            }
        });
    }

    @Override
    public void onModeHandle(int mode) {
        mapManipulationFragment.onModeHandle(mode);
        mapFragment.handleMode(mode);
    }

    @Override
    public void moveCamera(String address) {
        mapFragment.moveCameraByAddress(address);
        Log.d("OK", "moveCamera: "+address);
    }

    @Override
    public void onAddressBack(String text, LatLng latLng) {
        Log.d("OK", "onAddressBack: "+text);
        mapManipulationFragment.onAddressBack(text,latLng);
        if (mode.equals("view")){
            NearbyFragment nearbyFragment = (NearbyFragment) getSupportFragmentManager().findFragmentByTag("NearbyFragment");
            nearbyFragment.onAddressBack(text,latLng);
        }
    }

    public void onDataBack() {
        ModelAddress modelAddress = mapManipulationFragment.getAddress();
        //todo address + latlng here
    }
}
