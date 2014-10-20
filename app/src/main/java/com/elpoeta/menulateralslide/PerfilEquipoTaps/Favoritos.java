package com.elpoeta.menulateralslide.PerfilEquipoTaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elpoeta.menulateralslide.R;

public class Favoritos extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fm_pe_favoritos, container, false);
        return rootView;
    }
}