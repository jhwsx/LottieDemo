package com.wzc.lottiedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

/**
 * @author wzc
 * @date 2018/5/8
 */
public class CachingAnimationsActivity extends AppCompatActivity {
    private static final String TAG = CachingAnimationsActivity.class.getSimpleName();
    private LottieAnimationView mLottieAnimationViewCache;
    private LottieAnimationView mLottieAnimationViewCacheNone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caching_animations);
        mLottieAnimationViewCache = findViewById(R.id.lottie_animation_view_cache);
        mLottieAnimationViewCacheNone = findViewById(R.id.lottie_animation_view_cache_none);
        findViewById(R.id.load_cache).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLottieAnimationViewCache.setAnimation(R.raw.play_fill_loader, LottieAnimationView.CacheStrategy.Strong);
                mLottieAnimationViewCache.playAnimation();
            }
        });

        findViewById(R.id.load_cache_none).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLottieAnimationViewCacheNone.setAnimation(R.raw.play_fill_loader, LottieAnimationView.CacheStrategy.None);
                mLottieAnimationViewCacheNone.playAnimation();

//                Cancellable cancellable = LottieComposition.Factory.fromInputStream(getResources().openRawResource(R.raw.play_fill_loader), new OnCompositionLoadedListener() {
//                    @Override
//                    public void onCompositionLoaded(@Nullable LottieComposition composition) {
//
//                    }
//                });
            }
        });
    }
}
