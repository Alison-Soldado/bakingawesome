package com.example.alissonsoldado.bakingawesome.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Recipe;

public class DetailActivity extends AppCompatActivity {

    private Recipe recipe;
    private ViewPager viewPagerDetail;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initComponents();
        initIntent();
        setupToolbar();
        setupViewPager();
    }

    private void initComponents() {
        viewPagerDetail = findViewById(R.id.activity_detail_view_pager);
        toolbar = findViewById(R.id.activity_detail_toolbar);
    }

    private void initIntent() {
        recipe = getIntent().getParcelableExtra("recipe");
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPager() {
        DetailAdapter detailAdapter = new DetailAdapter(getSupportFragmentManager(), recipe);
        viewPagerDetail.setAdapter(detailAdapter);
    }
}
