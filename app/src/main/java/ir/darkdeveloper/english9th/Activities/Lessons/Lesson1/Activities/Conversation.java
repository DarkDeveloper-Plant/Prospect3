package ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Lesson1;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentCon;
import ir.plant.english9th.R;

public class Conversation extends AppCompatActivity {

    // Some parts of this project are same with same actions
    // so I made a Parent class that I can pass specific data.
    // this helps code maintainable!
    private ParentCon parentCon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_conversation);
            parentCon = new ParentCon(this, Lesson1.conversation,
                    Lesson1.practice1, Lesson1.practice2, Lesson1.conversation2,
                    Lesson1.practice1_2, Lesson1.practice2_2,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Lesson1"
                    , R.raw.con1);
            parentCon.initialize();
            parentCon.onclick();
            parentCon.sets();
            parentCon.Texts();

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
        parentCon.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        parentCon.onPause();
    }

    @Override
    public void onBackPressed() {
        parentCon.onBackPressed();
    }
}
