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

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //todo check mode : mode search = tat NearbyFragment , mode view = bat
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mode = getIntent().getStringExtra("mode");
        //todo remove mode here
        mode="edit";

        Bundle bundle = new Bundle();
        bundle.putString("mode",mode);
        mainFragment = new MainFragment();
        mainFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment,mainFragment.getTag()).commit();

        if (mode.equals("view")){
            Button button = findViewById(R.id.btn_ok);
            button.setVisibility(View.GONE);
        }

        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDataBack();
            }
        });
    }
    public void onDataBack() {
        ModelAddress modelAddress = mainFragment.onAddressBack();
        //todo address + latlng here
        Log.d("OK", "onDataBack: "+modelAddress.address);

    }
}
