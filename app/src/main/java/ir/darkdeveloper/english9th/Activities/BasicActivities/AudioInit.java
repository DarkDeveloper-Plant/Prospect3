package ir.darkdeveloper.english9th.Activities.BasicActivities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;

import java.io.File;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import ir.darkdeveloper.english9th.Activities.BasicActivities.DownloadCenter;
import ir.plant.english9th.R;

// Some kind of parent class
public class AudioInit {

    public boolean state = true;
    private FloatingActionButton fabAudio;
    private Handler handler;
    private ObservableScrollView scrollView;
    private RelativeLayout audio_back;
    public MediaPlayer mp;
    private Context context;
    private AppCompatSeekBar audio_seek;
    private Runnable runnable = null;
    private RecyclerView recyclerView;
    private int fileId;

    public AudioInit(FloatingActionButton fabAudio, Handler handler,
                     ObservableScrollView scrollView, RelativeLayout audio_back,
                     Context context, AppCompatSeekBar audio_seek, int fileId) {
        this.fabAudio = fabAudio;
        this.handler = handler;
        this.scrollView = scrollView;
        this.audio_back = audio_back;
        this.context = context;
        this.audio_seek = audio_seek;
        this.fileId = fileId;
    }


    public AudioInit(FloatingActionButton fabAudio, Handler handler, AppCompatSeekBar audio_seek,
                     RecyclerView recyclerView, RelativeLayout audio_back, Context context, int fileId) {
        this.fabAudio = fabAudio;
        this.handler = handler;
        this.audio_back = audio_back;
        this.context = context;
        this.audio_seek = audio_seek;
        this.fileId = fileId;
        this.recyclerView = recyclerView;
    }


    public void audio() {
        handler = new Handler();
        if (scrollView != null) {
            fabAudio.attachToScrollView(scrollView);
        }
        if (recyclerView != null){
            fabAudio.attachToRecyclerView(recyclerView);
        }
        audio_back.setVisibility(View.GONE);

        mp = MediaPlayer.create(context, fileId);
        Handler finalHandler = handler;
        MediaPlayer finalMp = mp;
        fabAudio.setOnClickListener(v -> {
            if (state) {
                finalMp.start();
                Cycle(audio_seek, finalMp, fabAudio, runnable, finalHandler);
                fabAudio.setImageDrawable(ContextCompat.getDrawable(
                        context.getApplicationContext(), R.drawable.ic_pause_black_24dp));
                audio_back.setVisibility(View.VISIBLE);
                state = false;
            } else {
                finalMp.pause();
                fabAudio.setImageDrawable(ContextCompat.getDrawable(
                        context.getApplicationContext(), R.drawable.ic_play_arrow_black_24dp));
                state = true;
            }
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

}
