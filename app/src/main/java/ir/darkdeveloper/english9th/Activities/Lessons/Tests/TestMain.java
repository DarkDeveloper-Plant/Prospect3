package ir.darkdeveloper.english9th.Activities.Lessons.Tests;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.BasicActivities.MainActivity;
import ir.darkdeveloper.english9th.Adapters.RecyclerAdapters.AdapterRecyclerTest;
import ir.darkdeveloper.english9th.Contacts.ContactRecyclerTest;
import ir.plant.english9th.R;

public class TestMain extends AppCompatActivity {
    Toolbar toolbar;
    List<ContactRecyclerTest> contactRecyclerMainList = new ArrayList<>();
    String[] main_text = {
            "Lesson1",
            "Lesson2",
            "Lesson3",
            "Lesson4",
            "Lesson5",
            "Lesson6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.activity_test_main);
            toolbar = findViewById(R.id.toolbar_test);
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            RecyclerView recyclerView = findViewById(R.id.recyclerView_test);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setHasFixedSize(true);
            for (int i = 0; i < 6; i++) {
                ContactRecyclerTest contactRecyclerMain = new ContactRecyclerTest();
                contactRecyclerMain.text_main = main_text[i];
                contactRecyclerMainList.add(contactRecyclerMain);

            }
            recyclerView.setAdapter(new AdapterRecyclerTest(getBaseContext(), contactRecyclerMainList));
            SharedPreferences color = getSharedPreferences("color?", Context.MODE_PRIVATE);
            int cc = color.getInt("color??", 4);
            if (cc == 5) {
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.dark));
            } else if (cc == 6) {
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.light));
            }

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
        startActivity(new Intent(TestMain.this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(TestMain.this, MainActivity.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
