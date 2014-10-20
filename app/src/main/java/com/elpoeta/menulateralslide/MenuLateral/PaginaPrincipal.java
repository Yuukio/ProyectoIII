package com.elpoeta.menulateralslide.MenuLateral;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elpoeta.menulateralslide.R;

/**
 * Created by Luis on 19/10/14.
 */
public class PaginaPrincipal extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fm_paginaprincipal, container, false);

        return rootView;
    }
}
