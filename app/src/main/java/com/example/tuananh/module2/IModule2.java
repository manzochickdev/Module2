package com.example.tuananh.module2;

import com.google.android.gms.maps.model.LatLng;

public interface IModule2 {
    void onModeHandle(int mode);

    void onAddressBack(String text, LatLng latLng);

    void onDataBack();
}
