package ir.darkdeveloper.english9th.Activities.BasicActivities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.io.File;
import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandling;
import ir.plant.english9th.R;

public class DownloadCenter extends AppCompatActivity {

    private static final String PATH = Environment.getExternalStorageDirectory() + "/Prospect3/media/";
    private ProgressBar progressView;
    private Button btnDownload, btnCache;
    private File audioExists, zipFile;
    private static final String DOWNLOAD_URL = "https://raw.githubusercontent.com/" +
            "DarkDeveloper-Plant/AudioFiles/master/media/Prospect3/audio.zip";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
        /*    PRDownloaderConfig config = PRDownloaderConfig.newBuilder()
                    .setDatabaseEnabled(true)
                    .build();
            PRDownloader.initialize(getApplicationContext(), config);
*/
            setContentView(R.layout.activity_down_center);
            toolbarInit();
            mainInit();

            btnDownload.setOnClickListener(v ->
                    new AlertDialog.Builder(DownloadCenter.this)
                    .setTitle("مهم")
                    .setMessage(getResources().getString(R.string.downloadDes))
                    .setPositiveButton("فهمیدم", ((dialog, which) -> {
                        if (!zipFile.exists() && !audioExists.exists()) {
                            actionDownload();

                        } else {
                            doneDownload();
                        }
                    })).show());


            btnCache.setOnClickListener(v ->
                    new AlertDialog.Builder(DownloadCenter.this)
                            .setTitle("clear cache")
                            .setMessage("با اینکار فایل های دانلود شده توسط برنامه حذف خواهند شد و مجبور به دانلود دوباره خواهید شد. آیا اطمینان دارید؟")
                            .setPositiveButton("بله", (dialog, which) -> clearData())
                            .setNegativeButton("خیر", (dialog, which) -> {

                            }).show()
            );


        } catch (Exception e) {
            new CrashHandler().catchException(e, this);
            startActivity(new Intent(this, CrashHandling.class));
            finish();
        }
    }


    @SuppressLint("SetTextI18n")
    private void actionDownload() {
        ConnectivityManager CManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = CManager.getActiveNetworkInfo();
        SharedPreferences sp = getSharedPreferences("permission", Context.MODE_PRIVATE);
        btnDownload.setEnabled(false);
        btnCache.setEnabled(false);
        if (info != null &&
                info.isConnected() &&
                sp.getBoolean("granted?", false)) {

        /*    PRDownloader.download(DOWNLOAD_URL, PATH, "audio.zip")
                    .build()
                    .setOnStartOrResumeListener(() -> Toast.makeText(this,
                            "File is being downloaded. Please wait.", Toast.LENGTH_LONG).show())

                    .setOnProgressListener(progress -> {
                        long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                        progressView.setProgress((int) progressPercent);
                        progressView.setSecondaryProgress((int) progress.currentBytes + 10);
                        btnDownload.setText("Downloading " + (int) progressPercent + "%");
                    })*/

                   /* .start(new OnDownloadListener() {
                        @Override
                        public void onDownloadComplete() {
                            btnCache.setEnabled(true);
                            doneDownload();
                        }

                        @Override
                        public void onError(Error error) {
                            progressView.setProgress(0);
                            btnDownload.setEnabled(true);
                            btnCache.setEnabled(true);
                            btnDownload.setText("Get File");
                            //if zipFile and audioExists exists, clear it
                            clearData();
                            Toast.makeText(DownloadCenter.this,
                                    "مشکلی پیش آمد دوباره امتحان کنید", Toast.LENGTH_LONG).show();
                        }
                    });*/


        } else {
            Toast.makeText(this, "به اینترنت متصل شوید یا دسترسی حافظه را به برنامه بدهید",
                    Toast.LENGTH_LONG).show();
        }
    }

    @SuppressLint("SetTextI18n")
    private void clearData() {

        File pathFile = new File(PATH);
        if (pathFile.exists()) {
            MainActivity.deleteDirectory(pathFile);
            Toast.makeText(this, "حذف شد", Toast.LENGTH_SHORT).show();
            findViewById(R.id.imgDone).setVisibility(View.GONE);
            btnDownload.setVisibility(View.VISIBLE);
            progressView.setVisibility(View.VISIBLE);
            findViewById(R.id.txtDown).setVisibility(View.VISIBLE);
            findViewById(R.id.backDown).setBackgroundResource(R.drawable.down_card2);
            progressView.setProgress(0);
            btnDownload.setText("Get File");
            findViewById(R.id.imgDown).setVisibility(View.VISIBLE);
        }
    }

    private void doneDownload() {
        if (audioExists.exists()) {
            findViewById(R.id.imgDone).setVisibility(View.VISIBLE);
            btnDownload.setVisibility(View.GONE);
            progressView.setVisibility(View.GONE);
            findViewById(R.id.txtDown).setVisibility(View.GONE);
            findViewById(R.id.backDown).setBackgroundColor(getResources()
                    .getColor(R.color.white));
            findViewById(R.id.imgDown).setVisibility(View.GONE);
            progressView.setProgress(0);
            Toast.makeText(DownloadCenter.this, "دانلود کامل شد", Toast.LENGTH_LONG).show();

        } else {

            if (zipFile.exists()) {
                //ZipArchive.unzip(PATH + "audio.zip", PATH, "");
                findViewById(R.id.imgDone).setVisibility(View.VISIBLE);
                btnDownload.setVisibility(View.GONE);
                progressView.setVisibility(View.GONE);
                findViewById(R.id.txtDown).setVisibility(View.GONE);
                findViewById(R.id.backDown).setBackgroundColor(getResources()
                        .getColor(R.color.white));
                findViewById(R.id.imgDown).setVisibility(View.GONE);
                progressView.setProgress(0);
                Toast.makeText(DownloadCenter.this, "دانلود کامل شد", Toast.LENGTH_LONG).show();

            } else {
                actionDownload();
            }

        }
    }

    @SuppressLint("SetTextI18n")
    private void toolbarInit() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

    }

    private void mainInit() {
        progressView = findViewById(R.id.progressDown);
        btnDownload = findViewById(R.id.btnDownload);
        btnCache = findViewById(R.id.clearCache);
        btnDownload.setVisibility(View.VISIBLE);
        zipFile = new File(PATH + "audio.zip");
        audioExists = new File(PATH + "audio");
        SharedPreferences prAd = getSharedPreferences("ad", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorAd = prAd.edit();
        editorAd.putBoolean("isAdOpen", true);
        editorAd.apply();
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
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
