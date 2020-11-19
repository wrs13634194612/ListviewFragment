package com.example.leftfragment;


import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;


public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> listmVp;
    private Context context;

    public FragmentAdapter(FragmentManager fm, List<Fragment> listmVp, Context context) {
        super(fm);
        this.listmVp = listmVp;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listmVp.size();
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return listmVp.get(arg0);
    }
}
