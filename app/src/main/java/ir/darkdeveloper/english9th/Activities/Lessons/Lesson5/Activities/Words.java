package ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Activities;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses.ParentWord;
import ir.darkdeveloper.english9th.Data.Words.DataRecyclerWords5;
import ir.plant.english9th.R;

public class Words extends AppCompatActivity {

    private ParentWord parentWord;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.fragment_words);
            parentWord = new ParentWord(this, new DataRecyclerWords5(), R.raw.word5,
                    "ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Lesson5");
            parentWord.initialize();
            parentWord.onclick();
            parentWord.sets();

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
        parentWord.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        parentWord.onPause();
    }

    @Override
    public void onBackPressed() {
        parentWord.onBackPressed();
    }
}