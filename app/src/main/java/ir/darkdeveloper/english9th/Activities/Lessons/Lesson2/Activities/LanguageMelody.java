package ir.darkdeveloper.english9th.Activities.Lessons.Lesson2.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson2.Lesson2;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentLMelo;
import ir.plant.english9th.R;

public class LanguageMelody extends AppCompatActivity {

    private ParentLMelo parentLMelo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_language_melody);
            parentLMelo = new ParentLMelo(this, Lesson2.language, Lesson2.language2,
                    R.raw.l_melody2,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson2.Lesson2");
            parentLMelo.initialize();
            parentLMelo.Texts();
            parentLMelo.sets();
            parentLMelo.onclick();

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
        parentLMelo.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        parentLMelo.onPause();
    }

    @Override
    public void onBackPressed() {
        parentLMelo.onBackPressed();
    }

}