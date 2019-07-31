package ir.darkdeveloper.english9th.Activities.Lessons.Lesson4.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson4.Lesson4;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentFind;
import ir.plant.english9th.R;

public class FindIt extends AppCompatActivity {

    ParentFind parentFind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_find_it);
            parentFind = new ParentFind(this, Lesson4.findit,  Lesson4.findit2,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson4.Lesson4");
            parentFind.initialize();
            parentFind.sets();
            parentFind.onclick();
            parentFind.Texts();
            parentFind.check4();

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