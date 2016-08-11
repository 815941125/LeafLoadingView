package com.example.administrator.leifdemo;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.FocusFinder;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

/**
 * Created by Administrator on 2016-08-11.
 */
public class AnimationUtils {

    public static RotateAnimation initRotateAnimation(long duration, int fromAngle, int toAngle, boolean isFillAfter, int repeatCount) {
        RotateAnimation mLoadingRotateAnimation = new RotateAnimation(fromAngle, toAngle, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);

        LinearInterpolator linearInterpolator = new LinearInterpolator();
        mLoadingRotateAnimation.setInterpolator(linearInterpolator);
        mLoadingRotateAnimation.setDuration(duration);
        mLoadingRotateAnimation.setFillAfter(isFillAfter);
        mLoadingRotateAnimation.setRepeatCount(repeatCount);
        mLoadingRotateAnimation.setRepeatMode(Animation.RESTART);
        return mLoadingRotateAnimation;
    }

    public static RotateAnimation initRotateAnimation(boolean isClockWise, long duration, boolean isFillAfter, int repeatCount) {
        int endAngle;
        if (isClockWise) {
            endAngle = 360;
        } else {
            endAngle = -360;
        }
        RotateAnimation mLoadingRotateAnimation = new RotateAnimation(0, endAngle, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        mLoadingRotateAnimation.setInterpolator(linearInterpolator);
        mLoadingRotateAnimation.setDuration(duration);
        mLoadingRotateAnimation.setFillAfter(isFillAfter);
        mLoadingRotateAnimation.setRepeatCount(repeatCount);
        mLoadingRotateAnimation.setRepeatMode(Animation.RESTART);
        return mLoadingRotateAnimation;
    }

    public static AnimationDrawable initAnimationDrawable(Context context, int[] drawable, int duration, boolean isOneShot) {
        AnimationDrawable mAnimationDrawable = new AnimationDrawable();
        for (int i = 0; i < drawable.length; i++) {
            int id = drawable[i];
            mAnimationDrawable.addFrame(context.getResources().getDrawable(id), duration);
        }
        mAnimationDrawable.setOneShot(isOneShot);
        return mAnimationDrawable;
    }

    public static Animation initAlphaAnimation(Context context, float fromAngle, float toAngle, long duration) {
        Animation alphaAnimation = new AlphaAnimation(fromAngle, toAngle);
        alphaAnimation.setDuration(duration);
        return alphaAnimation;
    }
}
