package com.example.tuananh.module2;

import android.content.Context;
import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.TextView;

public class DataBinding {
    @BindingAdapter("setFont")
    public static void setFont(TextView view, Context context){
        AssetManager assetManager = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(assetManager,"Font/icon.ttf");
        view.setTypeface(typeface);

    }
}
