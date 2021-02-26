package ir.darkdeveloper.english9th.Activities.Lessons.Lesson1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandling;
import ir.darkdeveloper.english9th.Activities.BasicActivities.MainActivity;
import ir.darkdeveloper.english9th.Adapters.RecyclerAdapters.Lessons.AdapterLesson1;
import ir.darkdeveloper.english9th.Contacts.ContactLessons;
import ir.darkdeveloper.english9th.Data.DataBaseStructure;
import ir.darkdeveloper.english9th.Data.Lessons.DataRecyclerLess;
import ir.plant.english9th.R;


public class Lesson1 extends AppCompatActivity {
    public static ArrayList<DataBaseStructure> lesson1 = new ArrayList<>();
    //public static ArrayList<DataBaseStructure> LessonsAll = new ArrayList<>();
    public static String conversation, conversation2;
    public static String practice1, practice1_2;
    public static String practice2, practice2_2;
    public static String language, language2;
    public static String lrw1, ewords;
    public static String lrw2;
    public static String grammar, grammar2;
    public static String findit;
    public static String findit2;
    public static int id;
    SharedPreferences sh_text, color1, color;
    int cs, ct, cc;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //handles crashes of this AppCompatActivity
        try {
            setContentView(R.layout.activity_lesson);
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            ini();
            Themes();
            //initializing database
            MainActivity.database = SQLiteDatabase.openOrCreateDatabase(MainActivity.desPath + "data", null);
            select_lesson1();
            recyclerView();

        } catch (SQLiteException sqe) {

            Bundle bundle = new Bundle();
            bundle.putBoolean("sqlException", true);
            sqe.printStackTrace();
            //this custom class logs crashes
            new CrashHandler().catchException(sqe, this);
            Intent nextActivity = new Intent(this, CrashHandling.class);
            nextActivity.putExtras(bundle);
            startActivity(nextActivity);
            finish();

        } catch (Exception e) {
            e.printStackTrace();
            new CrashHandler().catchException(e, this);
            startActivity(new Intent("ir.darkdeveloper.english9th." +
                    "Activities.BasicActivities.CrashHandler.CrashHandling"));
            finish();
        }
    }

    private void recyclerView() {
        //Recycler init
        List<ContactLessons> lessonsList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerLess);
        for (int i = 0; i <= 6; i++) {
            ContactLessons contactLessons = new ContactLessons();
            DataRecyclerLess dataRecyclerLess = new DataRecyclerLess();
            contactLessons.name = dataRecyclerLess.name[i];
            contactLessons.fileName = dataRecyclerLess.fileName1[i];
            lessonsList.add(contactLessons);
        }

        //Checking for orientation and screen size to manipulate grid span
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridLayoutManager = new GridLayoutManager(this, 3);
        }
        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_XLARGE) {
            gridLayoutManager = new GridLayoutManager(this, 3);

            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                gridLayoutManager = new GridLayoutManager(this, 4);
            }
        }

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdapterLesson1(getBaseContext(), lessonsList));
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @SuppressLint("SetTextI18n")
    private void ini() {
        // You can change it getString for every sharedPref but I don't have time to refactor them in settings
        color = getSharedPreferences("color?", Context.MODE_PRIVATE);
        cc = color.getInt("color??", 4);
        color1 = getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color1.getInt("color??", 4);
        sh_text = getSharedPreferences("trans", Context.MODE_PRIVATE);
        ct = sh_text.getInt("transs", 1);
        TextView textView = findViewById(R.id.toolbarTextL);
        textView.setText("Lesson1");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // defines action of back icon on the toolbar
        if (id == android.R.id.home) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void select_lesson1() {
        // this is a loop so it iterates the whole
        // table with every row and passes data to the lesson1 which is an Array
        // and also you can use this part of code in upper classes and access data
        // in lower classes
        try (Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM lessons WHERE _id = 1",
                null)) {
            while (cursor.moveToNext()) {
                conversation = cursor.getString(cursor.getColumnIndex("content_con"));
                practice1 = cursor.getString(cursor.getColumnIndex("content_practice1"));
                practice2 = cursor.getString(cursor.getColumnIndex("content_practice2"));
                language = cursor.getString(cursor.getColumnIndex("content_language"));
                grammar = cursor.getString(cursor.getColumnIndex("content_grammar"));
                lrw1 = cursor.getString(cursor.getColumnIndex("content_lrw_A"));
                lrw2 = cursor.getString(cursor.getColumnIndex("content_lrw_B"));
                findit = cursor.getString(cursor.getColumnIndex("content_findit"));

                conversation2 = cursor.getString(cursor.getColumnIndex("content_con2"));
                practice1_2 = cursor.getString(cursor.getColumnIndex("content_practice1_2"));
                practice2_2 = cursor.getString(cursor.getColumnIndex("content_practice2_2"));
                language2 = cursor.getString(cursor.getColumnIndex("content_language2"));
                grammar2 = cursor.getString(cursor.getColumnIndex("content_grammar2"));
                ewords = cursor.getString(cursor.getColumnIndex("content_ewords"));
                findit2 = cursor.getString(cursor.getColumnIndex("content_findit2"));
                id = cursor.getInt(cursor.getColumnIndex("_id"));

                DataBaseStructure struct = new DataBaseStructure(conversation, practice1, practice2,
                        language, grammar, lrw1, lrw2, findit, conversation2, practice1_2,
                        practice2_2, language2, grammar2, ewords, findit2, id);
                struct.setId(id);
                struct.setFindit(findit);
                struct.setLrw1(lrw1);
                struct.setLrw2(lrw2);
                struct.setGrammar(grammar);
                struct.setLanguage(language);
                struct.setPractice2(practice2);
                struct.setPractice1(practice1);
                struct.setConversation(conversation);

                struct.setEwords(ewords);
                struct.setGrammar2(grammar2);
                struct.setFindit2(findit2);
                struct.setLanguage2(language2);
                struct.setPractice2_2(practice2_2);
                struct.setPractice1_2(practice1_2);
                struct.setConversation(conversation2);
                lesson1.add(struct);
            }
        }

    }

    private void Themes(){
        // Changes background color
        if (cc == 5) {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.dark));
        } else if (cc == 6) {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.light));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MainActivity.database.close();
    }
}


