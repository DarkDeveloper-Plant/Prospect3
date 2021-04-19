package ir.darkdeveloper.english9th.Activities.BasicActivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;

import com.melnykov.fab.FloatingActionButton;

import java.util.Objects;

import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.plant.english9th.R;

public class Info extends AppCompatActivity {

    private FloatingActionButton fab;
    private AppCompatImageButton telegram, instagram;
    private TextView txtVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.activity_info);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            init();
            onClicks();


        } catch (Exception e) {
            e.printStackTrace();
            new CrashHandler().catchException(e, this);
            startActivity(new Intent("ir.darkdeveloper.english9th." +
                    "Activities.BasicActivities.CrashHandler.CrashHandling"));
            finish();
        }

    }

    @SuppressLint("SetTextI18n")
    private void onClicks() {
        fab.setOnClickListener(view -> {
            Intent contact = new Intent(Info.this, ContactUs.class);
            startActivity(contact);
        });

        instagram.setOnClickListener(v ->{
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.instagram.com/darkdeveloper2/"));
            startActivity(intent);
        });

        telegram.setOnClickListener(v ->{
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://t.me/plantdg"));
            startActivity(intent);
        });

        txtVersion.setText("ver: " + MainActivity.VERSION_NAME);
    }

    private void init() {
        fab = findViewById(R.id.fab);
        instagram = findViewById(R.id.btnInstagram);
        telegram = findViewById(R.id.btnTelegram);
        txtVersion = findViewById(R.id.txtVersion);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
