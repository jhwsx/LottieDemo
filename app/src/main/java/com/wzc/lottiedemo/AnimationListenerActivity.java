package com.wzc.lottiedemo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.LinearInterpolator;

import com.airbnb.lottie.LottieAnimationView;

/**
 * @author wzc
 * @date 2018/5/8
 */
public class AnimationListenerActivity extends AppCompatActivity {
private static final String TAG = AnimationListenerActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_listener);
        final LottieAnimationView lottieAnimationView = findViewById(R.id.lottie_animation_view);
        lottieAnimationView.setAnimation(R.raw.like);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f, 0f);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float animatedValue = (Float) animation.getAnimatedValue();
                Log.d(TAG, "onAnimationUpdate: animatedValue = " + animatedValue );
                lottieAnimationView.setProgress(animatedValue);
                lottieAnimationView.playAnimation();
            }
        });
        valueAnimator.start();
    }
}
