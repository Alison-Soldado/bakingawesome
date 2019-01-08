package com.example.alissonsoldado.bakingawesome.ui.detail.step;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.example.alissonsoldado.bakingawesome.R;
import com.example.alissonsoldado.bakingawesome.data.model.Step;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


public class DetailStepActivity extends AppCompatActivity {

    private PlayerView playerView;
    private AppCompatTextView textViewShortDescription;
    private SimpleExoPlayer player;
    private Step step;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_step);
        initComponent();
        setupActionBar();
        initIntent();
        fillComponent();
    }

    private void initComponent() {
        playerView = findViewById(R.id.activity_detail_step_player);
        textViewShortDescription = findViewById(R.id.activity_detail_step_shortDescription);
    }

    private void setupActionBar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initIntent() {
        step = getIntent().getParcelableExtra("step");
    }

    private void fillComponent() {
        textViewShortDescription.setText(step.getShortDescription());
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupPlayer();
    }

    private void setupPlayer() {
        player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
        playerView.setPlayer(player);

        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "ExoPlayer"));

        ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(step.getVideoURL()));

        player.prepare(extractorMediaSource, true, false);
        player.setPlayWhenReady(true);
    }


    @Override
    protected void onStop() {
        super.onStop();
        playerView.setPlayer(null);
        player.release();
        player = null;
    }
}
