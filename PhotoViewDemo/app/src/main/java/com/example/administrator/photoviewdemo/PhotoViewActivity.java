package com.example.administrator.photoviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/10/8.
 */

public class PhotoViewActivity extends AppCompatActivity{
    @BindView(R.id.vp_photo_view)
    ViewPager vp;
    @BindView(R.id.tv_index)
    TextView tvIndex;
    private ArrayList<String> list;
    private int index;
    PhotoViewAdapter adapter;
    FragmentManager manager;
    List<Fragment> mList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_photo_view);
        ButterKnife.bind(this);
        manager = getSupportFragmentManager();
        initData();
    }

    private void initData() {
        list = getIntent().getStringArrayListExtra("imgs");
        index = getIntent().getIntExtra("index",0);
        initFragments();
        adapter = new PhotoViewAdapter(manager,mList);
        tvIndex.setText((index+1)+"/"+list.size());
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvIndex.setText((position+1)+"/"+list.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp.setCurrentItem(index);
    }

    private void initFragments() {
        mList = new ArrayList<Fragment>();
        for (int i = 0; i < list.size(); i++) {
            PhotoViewFragment fm = new PhotoViewFragment(list.get(i));
            mList.add(fm);
        }
    }

}
