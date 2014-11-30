package com.elpoeta.menulateralslide.AdaptadorListas;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.elpoeta.menulateralslide.R;

import java.util.List;

/**
 * Created by Luis on 30/11/14.
 */
public class ControllerFragment extends FragmentPagerAdapter{

    List<Fragment> fragments;
    Context context;

    public ControllerFragment(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public Object instantiateItem(View view, int position){
        LinearLayout linearLayout = (LinearLayout) view.inflate(context, R.layout.custom_fragment, null);
        ImageView iv_image = (ImageView) linearLayout.findViewById(R.id.iv_image);
        ((ViewPager) view).addView(linearLayout);
        return linearLayout;
    }
}
