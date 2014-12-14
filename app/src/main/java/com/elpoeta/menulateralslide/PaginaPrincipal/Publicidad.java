package com.elpoeta.menulateralslide.PaginaPrincipal;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.elpoeta.menulateralslide.R;

/**
 * Created by Luis on 13/12/14.
 */
public class Publicidad extends FragmentActivity {

    private ViewPager _mViewPager;
    private ViewPagerAdapter _adapter;
    private Button _btn1,_btn2,_btn3;

    private void setUpView(){
       // _mViewPager = (ViewPager) findViewById(R.id.viewPager);
        _adapter = new ViewPagerAdapter(getApplicationContext(),getSupportFragmentManager());
        _mViewPager.setAdapter(_adapter);
        _mViewPager.setCurrentItem(0);
        initButton();
    }

    private void setTab(){
        _mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrollStateChanged(int position) {}
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {}
            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                btnAction(position);
            }
        });
    }

    private void btnAction(int action){
        switch(action){
            case 0: setButton(_btn1,"",30,30); setButton(_btn2,"",20,20); setButton(_btn3,"",20,20);break;

            case 1: setButton(_btn2,"",30,30); setButton(_btn3,"",20,20); setButton(_btn1,"",20,20);break;

            case 2: setButton(_btn3,"",30,30); setButton(_btn1,"",20,20); setButton(_btn2,"",20,20);break;
        }
    }

    private void initButton(){
        _btn1=(Button)findViewById(R.id.btn1);
        _btn2=(Button)findViewById(R.id.btn2);
        _btn3=(Button)findViewById(R.id.btn3);
        setButton(_btn1,"",30,30);
        setButton(_btn2,"",20,20);
        setButton(_btn3,"",20,20);
    }

    private void setButton(Button btn,String text,int h, int w){
        btn.setWidth(w);
        btn.setHeight(h);
        btn.setText(text);
    }
}