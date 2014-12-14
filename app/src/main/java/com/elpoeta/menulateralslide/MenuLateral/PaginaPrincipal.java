package com.elpoeta.menulateralslide.MenuLateral;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elpoeta.menulateralslide.PaginaPrincipal.Canchas;
import com.elpoeta.menulateralslide.PaginaPrincipal.Equipos;
import com.elpoeta.menulateralslide.PaginaPrincipal.Publicidad;
import com.elpoeta.menulateralslide.PaginaPrincipal.Ranking;
import com.elpoeta.menulateralslide.R;

/**
 * Created by Luis on 19/10/14.
 */
public class PaginaPrincipal extends Fragment{

    Publicidad p = new Publicidad();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fm_ml_paginaprincipal, container, false);

        if(rootView != null){
            Button btn1 = (Button) rootView.findViewById(R.id.btn_canchas);
            Button btn2 = (Button) rootView.findViewById(R.id.btn_equipos);
            Button btn3 = (Button) rootView.findViewById(R.id.btn_ranking);
            Button btn4 = (Button) rootView.findViewById(R.id.btn_eventos);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(rootView.getContext(), Canchas.class);
                    startActivity(intent);
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(rootView.getContext(), Equipos.class);
                    startActivity(intent);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(rootView.getContext(), Ranking.class);
                    startActivity(intent);
                }
            });

        }

        return rootView;
    }
}
