package com.example.tuananh.module2.MapManipulation.PlaceSearch;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import com.example.tuananh.module2.R;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Places;


public class PlaceSearchFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_search, container, false);
        GeoDataClient geoDataClient = Places.getGeoDataClient(getContext(), null);
        PlaceAutocompleteAdapter placeAutocompleteAdapter = new PlaceAutocompleteAdapter(getContext(),geoDataClient,null);
        AutoCompleteTextView textView = view.findViewById(R.id.et_search);
        textView.setAdapter(placeAutocompleteAdapter);
        textView.setDropDownVerticalOffset(68);
        textView.setThreshold(3);
        return view;
    }
}
