package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ir.plant.english9th.R;


public class ParentHelp {

    private Context context;
    private List<View> objects = new ArrayList<>();
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public ParentHelp(Context context, View... views) {
        this.context = context;
        objects.addAll(Arrays.asList(views));
    }

    void initializeConWord() {

        String[] titles = {"ترجمه", "فایل صوتی", "راهنما"};
        String[] contents = {
                "برای ترجمه آنی متن از این استفاده کنید"
                , "با این دکمه فایل صوتی پخش می شود"
                , "با لمس این راهنما دوباره باز می شود"};

        preferences = context.getSharedPreferences("prompt", Context.MODE_PRIVATE);


        TapTarget[] targets = new TapTarget[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            targets[i] = TapTarget.forView(objects.get(i), titles[i], contents[i])
                    .transparentTarget(true)
                    .outerCircleColor(R.color.colorAccent)
                    .descriptionTextColor(R.color.white)
                    .cancelable(true)
                    .targetCircleColor(R.color.colorPrimary)
                    .textColor(R.color.white);
        }

        if (!preferences.getBoolean("showed?", false)) {

            new TapTargetSequence((Activity) context)
                    .continueOnCancel(true)
                    .targets(targets)
                    .start();

            editor = preferences.edit();
            editor.putBoolean("showed?", true);
            editor.apply();
        }


    }

    public void initializeRead() {

        String[] titles = {"تمرینات", "ترجمه", "فایل صوتی", "سایر قسمت ها", "پنهان کردن", "راهنما"};
        String[] contents = {
                "برای دسترسی به تمرینات این بخش این دکمه را لمس کنید"
                , "برای ترجمه آنی متن از این استفاده کنید"
                , "با این دکمه فایل صوتی پخش می شود"
                , "برای دسترسی به سایر قسمت های برنامه از این بخش استفاده کنید"
                , "با این دکمه سایر قسمت ها پنهان می شوند"
                , "با لمس این راهنما دوباره باز می شود"};

        TapTarget[] targets = new TapTarget[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            targets[i] = TapTarget.forView(objects.get(i), titles[i], contents[i])
                    .transparentTarget(true)
                    .outerCircleColor(R.color.colorAccent)
                    .descriptionTextColor(R.color.white)
                    .cancelable(true)
                    .targetCircleColor(R.color.colorPrimary)
                    .textColor(R.color.white);
        }

        preferences = context.getSharedPreferences("prompt", Context.MODE_PRIVATE);
        if (!preferences.getBoolean("read_showed?", false)) {

            new TapTargetSequence((Activity) context)
                    .continueOnCancel(true)
                    .targets(targets)
                    .start();


            editor = preferences.edit();
            editor.putBoolean("read_showed?", true);
            editor.apply();
        }


    }

    public void initializeLRW() {
        String[] titles = {"فایل صوتی", "راهنما"};
        String[] contents = {"با این دکمه فایل صوتی پخش می شود"
                , "با لمس این راهنما دوباره باز می شود"};

        preferences = context.getSharedPreferences("prompt", Context.MODE_PRIVATE);


        TapTarget[] targets = new TapTarget[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            targets[i] = TapTarget.forView(objects.get(i), titles[i], contents[i])
                    .transparentTarget(true)
                    .outerCircleColor(R.color.colorAccent)
                    .descriptionTextColor(R.color.white)
                    .cancelable(true)
                    .targetCircleColor(R.color.colorPrimary)
                    .textColor(R.color.white);
        }

        if (!preferences.getBoolean("showed?", false)) {

            new TapTargetSequence((Activity) context)
                    .continueOnCancel(true)
                    .targets(targets)
                    .start();

            editor = preferences.edit();
            editor.putBoolean("showed?", true);
            editor.apply();
        }

    }

    void initializeGramFind(){
        String[] titles = {"ترجمه",  "راهنما"};
        String[] contents = {
                "برای ترجمه آنی متن از این استفاده کنید"
                , "با لمس این راهنما دوباره باز می شود"};

        preferences = context.getSharedPreferences("prompt", Context.MODE_PRIVATE);


        TapTarget[] targets = new TapTarget[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            targets[i] = TapTarget.forView(objects.get(i), titles[i], contents[i])
                    .transparentTarget(true)
                    .outerCircleColor(R.color.colorAccent)
                    .descriptionTextColor(R.color.white)
                    .cancelable(true)
                    .targetCircleColor(R.color.colorPrimary)
                    .textColor(R.color.white);
        }

        if (!preferences.getBoolean("showed?", false)) {

            new TapTargetSequence((Activity) context)
                    .continueOnCancel(true)
                    .targets(targets)
                    .start();

            editor = preferences.edit();
            editor.putBoolean("showed?", true);
            editor.apply();
        }

    }

}
