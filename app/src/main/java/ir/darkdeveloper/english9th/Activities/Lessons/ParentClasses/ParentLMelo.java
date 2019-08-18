package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.cardview.widget.CardView;

import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;

import ir.darkdeveloper.english9th.Activities.AdBase;
import ir.darkdeveloper.english9th.Activities.BasicActivities.AudioInit.AudioL;
import ir.plant.english9th.R;

public class ParentLMelo {

    private TextView textView, toggle_lan;
    private Context context;
    private int cs, cc, ct, value;
    private float value2;
    private CardView cardView;
    private RelativeLayout relativeLayout;
    private AudioL audioInit;
    private String lmelody, lmelody_fa, fileName;
    private String activity;
    private ImageButton btnBack;
    private ObservableScrollView scrollView;
    private boolean state = true;

    public ParentLMelo(Context context, String lmelody, String lmelody_fa, String fileName, String activity) {
        this.context = context;
        this.lmelody = lmelody;
        this.fileName = fileName;
        this.activity = activity;
        this.lmelody_fa = lmelody_fa;
    }

    @SuppressLint("SetTextI18n")
    public void initialize() {
        AppCompatSeekBar seekBar = ((Activity) context).findViewById(R.id.slider);
        FloatingActionButton fab = ((Activity) context).findViewById(R.id.fab_lan);
        scrollView = ((Activity) context).findViewById(R.id.scrollLan);
        btnBack = ((Activity) context).findViewById(R.id.menu_button_p);
        fab.attachToScrollView(scrollView);
        textView = ((Activity) context).findViewById(R.id.textL);
        SharedPreferences preferences = context.getSharedPreferences("font_size", Context.MODE_PRIVATE);
        TextView toolbarText = ((Activity) context).findViewById(R.id.toolbar_text_p);
        toolbarText.setText("Language Melody");
        toggle_lan = ((Activity) context).findViewById(R.id.change_lang_tog);
        btnBack = ((Activity) context).findViewById(R.id.menu_button_p);
        value = preferences.getInt("fontsize", 18);
        SharedPreferences color1 = context.getSharedPreferences("color1", Context.MODE_PRIVATE);
        cc = color1.getInt("color2", 0);
        SharedPreferences color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color.getInt("color??", 4);
        SharedPreferences sh_text = context.getSharedPreferences("trans", Context.MODE_PRIVATE);
        ct = sh_text.getInt("transs", 1);
        cardView = ((Activity) context).findViewById(R.id.card_lm);
        relativeLayout = ((Activity) context).findViewById(R.id.media_lay_lm);
        SharedPreferences preferences2 = context.getSharedPreferences("font_margin", Context.MODE_PRIVATE);
        value2 = preferences2.getFloat("fontmargin", 0);
        audioInit = new AudioL(fab, seekBar, relativeLayout, context, fileName);
        audioInit.audio();
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void onclick() {
        btnBack.setOnClickListener(v -> {
            context.startActivity(new Intent(activity));
            ((Activity) context).finish();
        });
        toggle_lan.setOnClickListener(v -> {
            if (state) {
                textView.setText(lmelody);
                toggle_lan.setText("fa");
                state = false;
            } else {
                textView.setText(lmelody_fa);
                toggle_lan.setText("en");
                state = true;
            }
        });
        AdBase adBase = new AdBase(context);
        SharedPreferences pr = context.getSharedPreferences("ad", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pr.edit();
        if (pr.getBoolean("isAdOpen", true)) {
            new AlertDialog.Builder(context)
                    .setTitle("حمایت از ما")
                    .setMessage("اگر از برنامه خوشتان امد میتونید با دیدن تبلیغ زیر قوت قلبی برای ما باشید(کمتر از یک دقیقه)")
                    .setPositiveButton("تبلیغ", (dialog, which) -> {
                        adBase.showAd();
                        editor.putBoolean("isAdOpen", false);
                        editor.apply();
                    })
                    .setNegativeButton("فعلا نه", (d, w) -> {
                        d.dismiss();
                        editor.putBoolean("isAdOpen", false);
                        editor.apply();
                    })
                    .show();
        }
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void Texts() {
        textView.setText(lmelody);
        if (ct == 1) {
            textView.setText(lmelody);
            toggle_lan.setText("fa");
        } else if (ct == 2) {
            textView.setText(lmelody_fa);
            toggle_lan.setText("en");
        }
        textView.setLineSpacing(45, value2);
        textView.setTextSize(value);
        if (cc == 1) {
            textView.setTextColor(Color.BLACK);
        } else if (cc == 2) {
            textView.setTextColor(Color.WHITE);
        } else if (cc == 3) {
            textView.setTextColor(Color.GRAY);
        } else if (cc == 4) {
            textView.setTextColor(Color.argb(255, 255, 121, 18));
        }
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    public void sets() {
        if (cs == 5) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            textView.setTextColor(Color.WHITE);
            relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.dark));
            scrollView.setBackgroundColor(context.getResources().getColor(R.color.dark));
            if (cc == 4) {
                textView.setTextColor(Color.argb(255, 255, 121, 18));
            } else {
                textView.setTextColor(Color.WHITE);
            }
        } else if (cs == 6) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.light));
            scrollView.setBackgroundColor(context.getResources().getColor(R.color.light));
        }
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    public void onStop() {
        if (audioInit.mp != null) {
            if (audioInit.mp.isPlaying()) {
                audioInit.fabChanges();
                audioInit.mp.pause();
            }
        }
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    public void onPause() {
        if (audioInit.mp != null) {
            if (audioInit.mp.isPlaying()) {
                audioInit.fabChanges();
                audioInit.mp.pause();
            }
        }
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    public void onBackPressed() {
        context.startActivity(new Intent(activity));
        ((Activity) context).finish();
    }
}
