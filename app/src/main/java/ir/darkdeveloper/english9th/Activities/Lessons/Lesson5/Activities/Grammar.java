package ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Lesson5;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentGram;
import ir.plant.english9th.R;

public class Grammar extends AppCompatActivity {
    ParentGram parentGram;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_grammar);
            parentGram = new ParentGram(this, Lesson5.grammar, Lesson5.grammar2,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Lesson5");
            parentGram.initialize();
            parentGram.onclick();
            parentGram.Texts();

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
        parentGram.onBackPressed();
    }

}