package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;


import ir.darkdeveloper.english9th.Activities.BasicActivities.AudioInit;
import ir.plant.english9th.R;

public class ParentCon {
    private RelativeLayout relativeLayout, relativeLayout2;
    private TextView text_con, text_p1, text_p2, toggle_lan, titleCon, titlePra1, titlePra2;
    private int cs, cc, ct, value;
    private float value2;
    private CardView cardView1, cardView2, cardView3;
    private AudioInit audioInit;
    private boolean state = true;
    private Context context;
    private String con, pra1, pra2, con_fa, pra1_fa, pra2_fa;
    private int fileId;
    private String activity;
    private ImageView imgGuide;
    private FloatingActionButton fabAudio;
    private ImageButton btnBack;

    public ParentCon(Context context, String con, String pra1, String pra2,
                     String con_fa, String pra1_fa, String pra2_fa,
                     String activity, int fileId) {
        this.context = context;
        this.con = con;
        this.pra1 = pra1;
        this.pra2 = pra2;
        this.activity = activity;
        this.con_fa = con_fa;
        this.pra1_fa = pra1_fa;
        this.pra2_fa = pra2_fa;
        this.fileId = fileId;
    }


    @SuppressLint("SetTextI18n")
    public void initialize() {
        SharedPreferences preferences = context.getSharedPreferences("font_size", Context.MODE_PRIVATE);
        value = preferences.getInt("fontsize", 18);
        SharedPreferences color1 = context.getSharedPreferences("color1", Context.MODE_PRIVATE);
        cc = color1.getInt("color2", 0);
        SharedPreferences sh_text = context.getSharedPreferences("trans", Context.MODE_PRIVATE);
        ct = sh_text.getInt("transs", 1);
        SharedPreferences color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color.getInt("color??", 4);
        SharedPreferences preferences2 = context.getSharedPreferences("font_margin", Context.MODE_PRIVATE);
        value2 = preferences2.getFloat("fontmargin", 0);
        TextView toolbarText = ((Activity) context).findViewById(R.id.toolbar_text_p);
        toggle_lan = ((Activity) context).findViewById(R.id.change_lang_tog);
        btnBack = ((Activity) context).findViewById(R.id.menu_button_p);
        relativeLayout = ((Activity) context).findViewById(R.id.rl_l);
        relativeLayout2 = ((Activity) context).findViewById(R.id.media_lay_con);
        AppCompatSeekBar seekBar = ((Activity) context).findViewById(R.id.slider);
        fabAudio = ((Activity) context).findViewById(R.id.fab_cons);
        ObservableScrollView scrollView = ((Activity) context).findViewById(R.id.scrollCon);
        fabAudio.attachToScrollView(scrollView);
        text_con = ((Activity) context).findViewById(R.id.text_conversation);
        text_p1 = ((Activity) context).findViewById(R.id.text_practice1);
        text_p2 = ((Activity) context).findViewById(R.id.text_practice2);
        titleCon = ((Activity) context).findViewById(R.id.titleCon);
        titlePra1 = ((Activity) context).findViewById(R.id.titlePra1);
        titlePra2 = ((Activity) context).findViewById(R.id.titlePra2);
        cardView1 = ((Activity) context).findViewById(R.id.card_con);
        cardView2 = ((Activity) context).findViewById(R.id.c_p_1);
        cardView3 = ((Activity) context).findViewById(R.id.c_p_2);
        toolbarText.setText("Conversation");
        Handler handler = new Handler();
        audioInit = new AudioInit(fabAudio, handler, scrollView, relativeLayout2, context, seekBar, fileId);
        audioInit.audio();
        imgGuide = ((Activity) context).findViewById(R.id.img_guide);
        helpInit();
    }

    private void helpInit() {
        ParentHelp parentHelp = new ParentHelp(context, toggle_lan,
                fabAudio, imgGuide);
        parentHelp.initializeConWord();
        imgGuide.setOnClickListener(v -> {
            SharedPreferences preferences = context
                    .getSharedPreferences("prompt", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("showed?", false);
            editor.apply();
            parentHelp.initializeConWord();
        });
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void Texts() {
        if (ct == 2) {
            text_p1.setText(pra1_fa);
            text_p2.setText(pra2_fa);
            text_con.setText(con_fa);
            toggle_lan.setText("en");
        } else if (ct == 1) {
            text_p1.setText(pra1);
            text_p2.setText(pra2);
            text_con.setText(con);
            toggle_lan.setText("fa");
        }

        text_con.setTextSize(value);
        text_p1.setTextSize(value);
        text_p2.setTextSize(value);
        text_con.setLineSpacing(45, value2);
        text_p1.setLineSpacing(45, value2);
        text_p2.setLineSpacing(45, value2);


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
                text_p1.setText(pra1);
                text_p2.setText(pra2);
                text_con.setText(con);
                toggle_lan.setText("fa");
                state = false;
            } else {
                text_p1.setText(pra1_fa);
                text_p2.setText(pra2_fa);
                text_con.setText(con_fa);
                toggle_lan.setText("en");
                state = true;
            }
        });
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    public void sets() {
        relativeLayout2.setBackgroundColor(context.getResources().getColor(R.color.light));
        if (cc == 1) {
            text_con.setTextColor(Color.BLACK);
            text_p1.setTextColor(Color.BLACK);
            text_p2.setTextColor(Color.BLACK);
            titleCon.setTextColor(Color.BLACK);
            titlePra1.setTextColor(Color.BLACK);
            titlePra2.setTextColor(Color.BLACK);
        } else if (cc == 2) {
            text_con.setTextColor(Color.WHITE);
            text_p1.setTextColor(Color.WHITE);
            text_p2.setTextColor(Color.WHITE);
            titleCon.setTextColor(Color.WHITE);
            titlePra1.setTextColor(Color.WHITE);
            titlePra2.setTextColor(Color.WHITE);
        } else if (cc == 3) {
            text_con.setTextColor(Color.GRAY);
            text_p1.setTextColor(Color.GRAY);
            text_p2.setTextColor(Color.GRAY);
            titleCon.setTextColor(Color.GRAY);
            titlePra1.setTextColor(Color.GRAY);
            titlePra2.setTextColor(Color.GRAY);
        } else if (cc == 4) {
            text_con.setTextColor(Color.argb(255, 255, 121, 18));
            text_p1.setTextColor(Color.argb(255, 255, 121, 18));
            text_p2.setTextColor(Color.argb(255, 255, 121, 18));
            titleCon.setTextColor(Color.BLACK);
            titlePra1.setTextColor(Color.BLACK);
            titlePra2.setTextColor(Color.BLACK);
        }
        if (cs == 5) {
            cardView1.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            cardView2.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            cardView3.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            relativeLayout2.setBackgroundColor(context.getResources().getColor(R.color.dark));
            relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.dark));
            text_con.setTextColor(Color.WHITE);
            text_p1.setTextColor(Color.WHITE);
            text_p2.setTextColor(Color.WHITE);
            titleCon.setTextColor(Color.WHITE);
            titlePra1.setTextColor(Color.WHITE);
            titlePra2.setTextColor(Color.WHITE);
            if (cc == 4) {
                text_con.setTextColor(Color.argb(255, 255, 121, 18));
                text_p1.setTextColor(Color.argb(255, 255, 121, 18));
                text_p2.setTextColor(Color.argb(255, 255, 121, 18));
                titleCon.setTextColor(Color.WHITE);
                titlePra1.setTextColor(Color.WHITE);
                titlePra2.setTextColor(Color.WHITE);
            } else {
                text_con.setTextColor(Color.WHITE);
                text_p1.setTextColor(Color.WHITE);
                text_p2.setTextColor(Color.WHITE);
                titleCon.setTextColor(Color.WHITE);
                titlePra1.setTextColor(Color.WHITE);
                titlePra2.setTextColor(Color.WHITE);
            }
        } else if (cs == 6) {
            cardView1.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            cardView2.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            cardView3.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            relativeLayout2.setBackgroundColor(context.getResources().getColor(R.color.light));
            relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.light));
        }
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    public void onStop() {
        if (audioInit.mp != null && audioInit.mp.isPlaying()) {
            audioInit.mp.pause();
        }
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    public void onPause() {
        if (audioInit.mp != null && audioInit.mp.isPlaying()) {
            fabAudio.setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext()
                    , R.drawable.ic_play_arrow_black_24dp));
            audioInit.mp.pause();
            audioInit.state = true;
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
