package ir.darkdeveloper.english9th.Activities.BasicActivities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import java.util.Random;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/**
 * Created by darkdeveloper on 9/11/17.
 */

public class Background {

        private static final int MIN = 1500;
        private static final int MAX = 1500;

        private final Random random;

        public Background() {
            random = new Random();
        }

        public void animate(@NonNull final View target, @ColorInt final int color1,
                            @ColorInt final int color2) {

            final ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), color1, color2);

            valueAnimator.setDuration(randInt(MIN, MAX));

            valueAnimator.addUpdateListener(animation -> target.setBackgroundColor((int) animation.getAnimatedValue()));
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override public void onAnimationEnd(Animator animation) {
                    //reverse animation
                    animate(target, color2, color1);
                }
            });

            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.start();
        }

        private int randInt(int min, int max) {
            return random.nextInt((max - min) + 1) + min;
        }

}
