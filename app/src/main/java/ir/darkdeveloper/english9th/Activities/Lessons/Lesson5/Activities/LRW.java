package ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Lesson5;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentLrw;
import ir.plant.english9th.R;

public class LRW extends AppCompatActivity {

    ParentLrw parentLrw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_lrw);
            parentLrw = new ParentLrw(this, Lesson5.lrw1, Lesson5.lrw2, "lrw5.mp3",
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Lesson5");
            parentLrw.initialize();
            parentLrw.Texts();
            parentLrw.sets();
            parentLrw.onclick();
            parentLrw.check5();

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
