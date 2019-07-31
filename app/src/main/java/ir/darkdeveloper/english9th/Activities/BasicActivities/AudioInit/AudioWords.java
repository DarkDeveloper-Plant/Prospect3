package ir.darkdeveloper.english9th.Activities.BasicActivities.AudioInit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.io.File;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ir.darkdeveloper.english9th.Activities.BasicActivities.DownloadCenter;
import ir.plant.english9th.R;

public class AudioWords {

    private FloatingActionButton fabAudio;
    private boolean state = true;
    private RecyclerView recyclerView;
    public MediaPlayer mp;
    private Context pakageContext;
    private AppCompatSeekBar audio_seek;
    private Runnable runnable;
    private String fileName;
    private LinearLayout audio_back;
    private String path = Environment.getExternalStorageDirectory() + "/Prospect3/media/audio/";



    public AudioWords(FloatingActionButton fabAudio, AppCompatSeekBar audio_seek,
                    RecyclerView recyclerView, LinearLayout audio_back,
                      Context pakageContext, String fileName){
        this.fabAudio = fabAudio;
        this.fileName = fileName;
        this.audio_back = audio_back;
        this.recyclerView = recyclerView;
        this.audio_seek = audio_seek;
        this.pakageContext = pakageContext;
    }




    public void audio() {

        fabAudio.attachToRecyclerView(recyclerView);
        Handler handler = new Handler();
        path += fileName;
        File file = new File(path);

        if (!file.exists()) {

            fabAudio.setVisibility(View.GONE);
            audio_back.setVisibility(View.GONE);
            new AlertDialog.Builder(pakageContext)
                    .setTitle("Audio file not found")
                    .setMessage("Audio file might be corrupted or could not found.\n" +
                            "Download the file " + fileName)
                    .setPositiveButton("Download", (dialog, which) -> {
                         pakageContext.startActivity(new Intent(pakageContext,
                         DownloadCenter.class));
                        ((Activity) pakageContext).finish();
                    })
                    .setNegativeButton("Not now", (dialog, which) ->
                            Toast.makeText(pakageContext, "You will not able to use" +
                                            " audio file until you download it.",
                                    Toast.LENGTH_LONG).show()).show();

        } else {

            mp = MediaPlayer.create(pakageContext, Uri.parse(path));
            word(handler, mp);
        }
    }

    private void word(Handler finalHandler, MediaPlayer finalMp) {
        audio_back.setVisibility(View.GONE);
        fabAudio.setOnClickListener(v -> {
            if (state) {
                finalMp.start();
                Cycle(audio_seek, finalMp, fabAudio, runnable, finalHandler);
                fabAudio.setImageDrawable(ContextCompat.getDrawable(pakageContext
                        .getApplicationContext(), R.drawable.ic_pause_black_24dp));
                audio_back.setVisibility(View.VISIBLE);
                state = false;
            } else {
                finalMp.pause();
                fabAudio.setImageDrawable(ContextCompat.getDrawable(pakageContext
                        .getApplicationContext(), R.drawable.ic_play_arrow_black_24dp));
                state = true;
            }
        });

        mp.setOnCompletionListener(v -> {
            fabAudio.setImageDrawable(ContextCompat.getDrawable(pakageContext
                    .getApplicationContext(), R.drawable.ic_play_arrow_black_24dp));
            state = true;
        });

        mp.setOnPreparedListener(mediaPlayer -> {
            audio_seek.setMax(finalMp.getDuration());
            Cycle(audio_seek, finalMp, fabAudio, runnable, finalHandler);
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
                       FloatingActionButton fabAudio, Runnable runnable,
                       Handler handler) {

        audio_seek.setProgress(mp.getCurrentPosition());
        if (fabAudio.isEnabled()) {
            Runnable finalRunnable = runnable;
            runnable = () -> Cycle(audio_seek, mp, fabAudio, finalRunnable, handler);
            handler.postDelayed(runnable, 1000);
        }

    }

    public void fabChanges() {
        if (state) {
            fabAudio.setImageDrawable(ContextCompat.getDrawable(pakageContext
                    .getApplicationContext(), R.drawable.ic_pause_black_24dp));
            audio_back.setVisibility(View.VISIBLE);
            state = false;
        } else {
            fabAudio.setImageDrawable(ContextCompat.getDrawable(pakageContext
                    .getApplicationContext(), R.drawable.ic_play_arrow_black_24dp));
            state = true;
        }
    }

}
