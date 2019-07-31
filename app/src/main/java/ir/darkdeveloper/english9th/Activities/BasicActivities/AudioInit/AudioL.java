package ir.darkdeveloper.english9th.Activities.BasicActivities.AudioInit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.io.File;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import ir.darkdeveloper.english9th.Activities.BasicActivities.DownloadCenter;
import ir.plant.english9th.R;

public class AudioL {

    private FloatingActionButton fab;
    public MediaPlayer mp;
    private Context pakageContext;
    private AppCompatSeekBar audio_seek;
    private Runnable runnable;
    private RelativeLayout audioBack;
    private String fileName;
    private String path = Environment.getExternalStorageDirectory() + "/Prospect3/media/audio/";
    private boolean state = true;


    public AudioL(FloatingActionButton fab, AppCompatSeekBar audio_seek,
                  RelativeLayout audioBack, Context pakageContext, String fileName) {
        this.fab = fab;
        this.fileName = fileName;
        this.audio_seek = audio_seek;
        this.audioBack = audioBack;
        this.pakageContext = pakageContext;
    }


    public void audio() {

        Handler handler = new Handler();
        path += fileName;
        File file = new File(path);
        if (!file.exists()) {
            audioBack.setVisibility(View.GONE);
            fab.setVisibility(View.GONE);
            new AlertDialog.Builder(pakageContext)
                    .setTitle("Audio file not found")
                    .setMessage("Audio file might be corrupted or could not found.\n" +
                            "Download the file " + fileName)
                    .setPositiveButton("Download", (dialog, which) -> {
                        pakageContext.startActivity(new Intent(pakageContext, DownloadCenter.class));
                        ((Activity) pakageContext).finish();
                    })
                    .setNegativeButton("Not now", (dialog, which) ->
                            Toast.makeText(pakageContext, "You will not able to use" +
                                            " audio file until you download it.",
                                    Toast.LENGTH_LONG).show()).show();

        } else {
            mp = MediaPlayer.create(pakageContext, Uri.parse(path));
            MediaPlayer finalMp = mp;
            Ls(handler, finalMp);
        }
    }

    private void Ls(Handler finalHandler, MediaPlayer finalMp) {
        audioBack.setVisibility(View.GONE);
        fab.setOnClickListener(n -> {
            if (state) {
                finalMp.start();
                Cycle(audio_seek, finalMp, fab, runnable, finalHandler);
                fab.setImageDrawable(ContextCompat.getDrawable(pakageContext
                        .getApplicationContext(), R.drawable.ic_pause_black_24dp));
                audioBack.setVisibility(View.VISIBLE);
                state = false;
            } else {
                finalMp.pause();
                fab.setImageDrawable(ContextCompat.getDrawable(pakageContext
                        .getApplicationContext(), R.drawable.ic_play_arrow_black_24dp));
                state = true;
            }
        });

        mp.setOnPreparedListener(mediaPlayer -> {
            audio_seek.setMax(finalMp.getDuration());
            Cycle(audio_seek, finalMp, fab, runnable, finalHandler);
        });

        mp.setOnCompletionListener(v -> {
            fab.setImageDrawable(ContextCompat.getDrawable(pakageContext
                    .getApplicationContext(), R.drawable.ic_play_arrow_black_24dp));
            state = true;
        });

        audio_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    finalMp.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    private void Cycle(AppCompatSeekBar audio_seek, MediaPlayer mp,
                       FloatingActionButton fab, Runnable runnable,
                       Handler handler) {
        audio_seek.setProgress(mp.getCurrentPosition());
        if (fab.isEnabled()) {
            Runnable finalRunnable = runnable;
            runnable = () -> Cycle(audio_seek, mp, fab, finalRunnable, handler);
            handler.postDelayed(runnable, 1000);
        }
    }

    public void fabChanges() {
        if (state) {
            fab.setImageDrawable(ContextCompat.getDrawable(pakageContext
                    .getApplicationContext(), R.drawable.ic_pause_black_24dp));
            audioBack.setVisibility(View.VISIBLE);
            state = false;
        } else {
            fab.setImageDrawable(ContextCompat.getDrawable(pakageContext
                    .getApplicationContext(), R.drawable.ic_play_arrow_black_24dp));
            state = true;
        }
    }
}
