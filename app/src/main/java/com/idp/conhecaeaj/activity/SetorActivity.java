package com.idp.conhecaeaj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.idp.conhecaeaj.R;
import com.idp.conhecaeaj.Setor;
import com.idp.conhecaeaj.fragments.FixedTabsPageAdapter;

public class SetorActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTablayout = (TabLayout) findViewById(R.id.tabSetor);
        mViewPager = (ViewPager) findViewById(R.id.viewPageSetor);


//        Intent i = getIntent();
//        Setor setor = (Setor) i.getSerializableExtra("objSetor");
////        setTitle(setor.getNomeSetor());

        PagerAdapter mPageAdapter = new FixedTabsPageAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mPageAdapter);
        mTablayout.setupWithViewPager(mViewPager);



    }

}
