package ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Lesson1;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentFind;
import ir.plant.english9th.R;


public class FindIt extends AppCompatActivity {

    // Some parts of this project are same with same actions
    // so I made a Parent class that I can pass specific data.
    // this helps code maintainable!
    ParentFind parentFind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_find_it);
            parentFind = new ParentFind(this, Lesson1.findit, Lesson1.findit2,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Lesson1");
            parentFind.initialize();
            parentFind.sets();
            parentFind.onclick();
            parentFind.Texts();
            parentFind.check1();

        } catch (Exception e) {
            e.printStackTrace();
            new CrashHandler().catchException(e, this);
            startActivity(new Intent("ir.darkdeveloper.english9th." +
                    "Activities.BasicActivities.CrashHandler.CrashHandling"));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        parentFind.onBackPressed();
    }
}

