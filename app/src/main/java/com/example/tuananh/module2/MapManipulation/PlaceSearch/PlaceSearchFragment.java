package com.example.tuananh.module2.MapManipulation.PlaceSearch;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import com.example.tuananh.module2.IModule2;
import com.example.tuananh.module2.R;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Places;


public class PlaceSearchFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_search, container, false);
        Context context = getContext();
        final IModule2 iModule2 = (IModule2) context;
        GeoDataClient geoDataClient = Places.getGeoDataClient(context, null);
        PlaceAutocompleteAdapter placeAutocompleteAdapter = new PlaceAutocompleteAdapter(context,geoDataClient,null);
        final AutoCompleteTextView textView = view.findViewById(R.id.et_search);
        textView.setAdapter(placeAutocompleteAdapter);
        textView.setDropDownVerticalOffset(20);
        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = textView.getText().toString();
                iModule2.moveCamera(data);
            }
        });
        textView.setThreshold(3);
        return view;
    }
}
