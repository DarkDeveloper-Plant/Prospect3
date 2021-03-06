package ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Lesson1;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentLrw;
import ir.plant.english9th.R;


public class LRW extends AppCompatActivity {

    // Some parts of this project are same with same actions
    // so I made a Parent class that I can pass specific data.
    // this helps code maintainable!
    ParentLrw parentLrw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_lrw);
            parentLrw = new ParentLrw(this, Lesson1.lrw1, Lesson1.lrw2, R.raw.lrw1,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Lesson1");
            parentLrw.initialize();
            parentLrw.Texts();
            parentLrw.sets();
            parentLrw.onclick();
            parentLrw.check1();

        } catch (Exception e) {
            e.printStackTrace();
            new CrashHandler().catchException(e, this);
            startActivity(new Intent("ir.darkdeveloper.english9th." +
                    "Activities.BasicActivities.CrashHandler.CrashHandling"));
            finish();
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        parentLrw.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        parentLrw.onPause();
    }

    @Override
    public void onBackPressed() {
        parentLrw.onBackPressed();
    }
}