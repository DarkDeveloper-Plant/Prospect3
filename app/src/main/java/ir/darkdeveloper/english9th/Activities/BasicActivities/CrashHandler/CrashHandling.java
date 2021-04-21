package ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ir.darkdeveloper.english9th.Activities.BasicActivities.MainActivity;
import ir.plant.english9th.R;

// This is an Idea to prevent app to close immediately
// You can do some actions or give some guidance to user how to use the app
public class CrashHandling extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_handling);
        Toolbar toolbar = findViewById(R.id.toolbarCrash);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.crashBackColor));
        }

        Bundle bundle = getIntent().getExtras();
        boolean isSqlExept = false;
        if (bundle != null) {
            isSqlExept = bundle.getBoolean("sqlException");
        }

        if (isSqlExept) {

            findViewById(R.id.btnSendFile).setVisibility(View.GONE);
            TextView textView = findViewById(R.id.txtCrash);
            textView.setText(getResources().getString(R.string.crash));
            ImageView img = findViewById(R.id.imgCrash);
            img.setImageResource(R.drawable.crash2);

        } else {
            String PATH = getExternalFilesDir(null) + "/logs/last_crash.log";
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                findViewById(R.id.btnSendFile).setVisibility(View.GONE);
                try {
                    List<String> lines = Files.readAllLines(Paths.get(PATH));
                    String linesBuilder = "";
                    for (String s: lines) {
                        linesBuilder += s + "\n";
                    }
                    TextView v = findViewById(R.id.txtCrashReport);
                    v.setText(linesBuilder);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {

                findViewById(R.id.btnSendFile)
                        .setOnClickListener(v -> {
                            Intent intentShareFile = new Intent(Intent.ACTION_SEND);
                            File fileWithinMyDir = new File(PATH);

                            if (fileWithinMyDir.exists()) {
                                intentShareFile.setType("text/log");
                                intentShareFile.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + PATH));

                                intentShareFile.putExtra(Intent.EXTRA_SUBJECT,
                                        "Exception caught!");
                                intentShareFile.putExtra(Intent.EXTRA_TEXT,
                                        "سلام. من حین اجرای برنامه به مشکل زیر برخوردم.");

                                startActivity(Intent.createChooser(intentShareFile, "Share File"));
                            }
                        });
            }
        }
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
