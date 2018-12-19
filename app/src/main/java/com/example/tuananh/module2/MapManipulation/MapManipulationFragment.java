package com.example.tuananh.module2.MapManipulation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.tuananh.module2.IModule2;
import com.example.tuananh.module2.MapManipulation.PlaceSearch.PlaceSearchFragment;
import com.example.tuananh.module2.ModelAddress;
import com.example.tuananh.module2.R;
import com.example.tuananh.module2.databinding.FragmentMapManipulationBinding;
import com.google.android.gms.maps.model.LatLng;


public class MapManipulationFragment extends Fragment {
    FragmentMapManipulationBinding fragmentMapManipulationBinding;
    String address="";
    TextView textView;
    ModelAddress modelAddress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMapManipulationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_manipulation, container, false);
        ViewHandle viewHandle = new ViewHandle(true,getContext(),(IModule2)getParentFragment());
        onModeHandle(0);
        fragmentMapManipulationBinding.setViewHandle(viewHandle);
        return fragmentMapManipulationBinding.getRoot();


    }

    public void onModeHandle(int mode) {
        FrameLayout frameLayout = fragmentMapManipulationBinding.fragContainer;
        frameLayout.removeAllViewsInLayout();
        if (mode==0){
            PlaceSearchFragment placeSearchFragment = new PlaceSearchFragment();
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frag_container,placeSearchFragment,"PlaceSearchFragment");
            fragmentTransaction.commit();
        }
        else if (mode==2 || mode==3){
            Log.d("OK", "onModeHandle: "+mode);
            textView = new TextView(getContext());
            textView.setText(address);
            textView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setPadding(4,4,4,4);
            frameLayout.addView(textView);
        }
    }

    public void onAddressBack(String text, LatLng latLng) {
        modelAddress = new ModelAddress(text,latLng);

        this.address = text;
        if(textView!=null){
            textView.setText(text);
        }
    }

    public ModelAddress getAddress(){
        return modelAddress;
    }
}
