package com.example.leftfragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.leftfragment.fragment.Fragment1;
import com.example.leftfragment.fragment.Fragment2;
import com.example.leftfragment.fragment.JDFragment;
import com.example.leftfragment.fragment.VideoFragment;

public class MainActivity extends FragmentActivity {
    private ListView leftListView;
    private List<Fragment> fragmentlist;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private JDFragment jdFragment;
    private VideoFragment videoFragment;
    private ArrayList<String> leftlist = new ArrayList<String>();// left list
    FragmentAdapter adapter;
    private CustomScrollViewPager fragmentViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        fragmentViewPager = findViewById(R.id.fragmentViewPager);
        leftListView =  findViewById(R.id.leftListView);
        initDatas();
        initDatasViewPager();
    }

    public void initDatas() {
        leftlist.add("终端");
        leftlist.add("投影");
        leftlist.add("强电控制");
        leftlist.add("播放控制");
        List<Map<String, Object>> listitems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < leftlist.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("lefttitle", leftlist.get(i).toString());
            listitems.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, listitems,
                R.layout.leftlistview_item, new String[]{"lefttitle"},
                new int[]{R.id.leftTitleTextView});

        leftListView.setAdapter(adapter);
        // listview点击事件
        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                fragmentViewPager.setCurrentItem(position);
            }
        });
    }

    public void initDatasViewPager() {
        fragmentlist = new ArrayList<Fragment>();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        jdFragment = new JDFragment();
        videoFragment = new VideoFragment();
        fragmentlist.add(fragment1);
        fragmentlist.add(fragment2);
        fragmentlist.add(jdFragment);
        fragmentlist.add(videoFragment);
        adapter = new FragmentAdapter(
                getSupportFragmentManager(), fragmentlist, this);
        fragmentViewPager.setAdapter(adapter);
        fragmentViewPager.setOnPageChangeListener(new MyOnPageChangeListener());

    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            Log.e("TAG", "click:  " + arg0);
        }

    }
}
