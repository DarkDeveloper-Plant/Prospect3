package ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Lesson5;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentEWords;
import ir.plant.english9th.R;

public class EWords extends AppCompatActivity {

    ParentEWords parentEWords;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_ewords);
            parentEWords = new ParentEWords(this, Lesson5.ewords,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Lesson5");
            parentEWords.initialize();
            parentEWords.Texts();
            parentEWords.onclick();

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
        parentEWords.onBackPressed();
    }
}
