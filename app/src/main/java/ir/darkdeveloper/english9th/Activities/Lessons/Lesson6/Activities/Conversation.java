package ir.darkdeveloper.english9th.Activities.Lessons.Lesson6.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson6.Lesson6;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentCon;
import ir.plant.english9th.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Conversation extends AppCompatActivity {

    private ParentCon parentCon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_conversation);
            parentCon = new ParentCon(this, Lesson6.conversation,
                    Lesson6.practice1, Lesson6.practice2, Lesson6.conversation2,
                    Lesson6.practice1_2, Lesson6.practice2_2,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson6.Lesson6"
                    , R.raw.con6);
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
