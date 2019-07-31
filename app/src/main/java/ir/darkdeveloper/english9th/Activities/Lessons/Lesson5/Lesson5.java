package ir.darkdeveloper.english9th.Activities.Lessons.Lesson5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandling;
import ir.darkdeveloper.english9th.Activities.BasicActivities.MainActivity;
import ir.darkdeveloper.english9th.Adapters.RecyclerAdapters.Lessons.AdapterLesson5;
import ir.darkdeveloper.english9th.Contacts.ContactLessons;
import ir.darkdeveloper.english9th.Data.DataBaseStructure;
import ir.darkdeveloper.english9th.Data.Lessons.DataRecyclerLess;
import ir.plant.english9th.R;

public class Lesson5 extends AppCompatActivity {

    public static ArrayList<DataBaseStructure> lesson5 = new ArrayList<>();
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
        try {

            setContentView(R.layout.activity_lesson);
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            ini();
            Themes();
            MainActivity.database = SQLiteDatabase.openOrCreateDatabase(MainActivity.desPath + "data", "plant2113853211", null);
            select_lesson5();
            recyclerView();

        } catch (SQLiteException sqe){

            Bundle bundle = new Bundle();
            bundle.putBoolean("sqlException", true);
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
        List<ContactLessons> lessonsList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerLess);
        for (int i = 0; i <= 6; i++) {
            ContactLessons contactLessons = new ContactLessons();
            DataRecyclerLess dataRecyclerLess = new DataRecyclerLess();
            contactLessons.name = dataRecyclerLess.name[i];
            contactLessons.fileName = dataRecyclerLess.fileName5[i];
            lessonsList.add(contactLessons);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdapterLesson5(getBaseContext(), lessonsList));
    }


    @SuppressLint("SetTextI18n")
    private void ini() {
        color = getSharedPreferences("color?", Context.MODE_PRIVATE);
        cc = color.getInt("color??", 4);
        color1 = getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color1.getInt("color??", 4);
        sh_text = getSharedPreferences("trans", Context.MODE_PRIVATE);
        ct = sh_text.getInt("transs", 1);
        TextView toolbarText = findViewById(R.id.toolbarTextL);
        toolbarText.setText("Lesson5");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    ////DATABASE


    private void select_lesson5() {
        try (Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM 'lesson5'",
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
                lesson5.add(struct);
            }
        }
    }

    private void Themes() {
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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
