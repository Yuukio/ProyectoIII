package com.elpoeta.menulateralslide.AdaptadorListas;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.elpoeta.menulateralslide.R;

/**
 * Created by Luis on 30/11/14.
 */
public class ModelFragment extends Fragment{

    public static final String _image = "image";

    public static final ModelFragment newInstance(int image){
        ModelFragment mf = new ModelFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(_image, image);
        mf.setArguments(bundle);
        return mf;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle bundle){
        View view = inflater.inflate(R.layout.custom_fragment, group, false);
        int image = getArguments().getInt(_image);
        ImageView iv_image = (ImageView) view.findViewById(R.id.iv_image);
        return view;
    }
}
