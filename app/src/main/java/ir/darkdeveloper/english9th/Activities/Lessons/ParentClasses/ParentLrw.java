package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import ir.darkdeveloper.english9th.Activities.AdBase;
import ir.darkdeveloper.english9th.Activities.BasicActivities.AudioInit;
import ir.plant.english9th.R;

public class ParentLrw {

    private Context context;
    private RelativeLayout relativeLayout;
    private int cs, cc, value;
    private float value2;
    private TextView textView, textView2;
    private ImageButton btnBack;
    private Button button;
    private CardView cardView, cardView2;
    private AppCompatRadioButton radioButton1, radioButton2,
            radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8;
    private AudioInit audioInit;
    private FloatingActionButton fabAudio;
    private String text1, text2, activity;
    private int fileId;
    private ImageView imgGuide;
    private ObservableScrollView scrollView;

    public ParentLrw(Context context, String text1, String text2, int fileId, String activity) {
        this.context = context;
        this.text1 = text1;
        this.text2 = text2;
        this.fileId = fileId;
        this.activity = activity;
    }



    @SuppressLint("SetTextI18n")
    public void initialize() {
        AppCompatSeekBar seekBar = ((Activity) context).findViewById(R.id.slider);
        textView = ((Activity) context).findViewById(R.id.text_lrw1);
        textView2 = ((Activity) context).findViewById(R.id.text_lrw2);
        SharedPreferences preferences = context.getSharedPreferences("font_size",
                Context.MODE_PRIVATE);
        value = preferences.getInt("fontsize", 18);
        SharedPreferences color1 = context.getSharedPreferences("color1", Context.MODE_PRIVATE);
        cc = color1.getInt("color2", 0);
        button = ((Activity) context).findViewById(R.id.btn_lrw);
        radioButton1 = ((Activity) context).findViewById(R.id.radio_lrw1);
        radioButton2 = ((Activity) context).findViewById(R.id.radio_lrw2);
        radioButton3 = ((Activity) context).findViewById(R.id.radio_lrw3);
        radioButton4 = ((Activity) context).findViewById(R.id.radio_lrw4);
        radioButton5 = ((Activity) context).findViewById(R.id.radio_lrw5);
        radioButton6 = ((Activity) context).findViewById(R.id.radio_lrw6);
        radioButton7 = ((Activity) context).findViewById(R.id.radio_lrw7);
        radioButton8 = ((Activity) context).findViewById(R.id.radio_lrw8);
        SharedPreferences color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color.getInt("color??", 4);
        cardView = ((Activity) context).findViewById(R.id.card_lrw);
        cardView2 = ((Activity) context).findViewById(R.id.card_lrw2);
        relativeLayout = ((Activity) context).findViewById(R.id.media_lay_lrw);
        SharedPreferences preferences2 = context.getSharedPreferences("font_margin", Context.MODE_PRIVATE);
        value2 = preferences2.getFloat("fontmargin", 0);
        TextView toolbarText = ((Activity) context).findViewById(R.id.toolbar_text_p);
        toolbarText.setText("L.R.W");
        TextView toggle_lan = ((Activity) context).findViewById(R.id.change_lang_tog);
        btnBack = ((Activity) context).findViewById(R.id.menu_button_p);
        toggle_lan.setVisibility(View.INVISIBLE);
        scrollView = ((Activity) context).findViewById(R.id.scrollLRW);
        fabAudio = ((Activity) context).findViewById(R.id.fab_lrw);
        Handler handler = new Handler();
        audioInit = new AudioInit(fabAudio, handler, scrollView, relativeLayout, context, seekBar, fileId);
        audioInit.audio();
        imgGuide = ((Activity) context).findViewById(R.id.img_guide);
        helpInit();
    }

    private void helpInit() {
        ParentHelp parentHelp = new ParentHelp(context, fabAudio,
                imgGuide);
        parentHelp.initializeLRW();
        imgGuide.setOnClickListener(v -> {
            SharedPreferences preferences = context
                    .getSharedPreferences("prompt", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("showed?", false);
            editor.apply();
            parentHelp.initializeLRW();
        });
    }



    /**
     * Before invoking this function, invoke initialize() method
     */
    public void sets() {
        if (cs == 5) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            cardView2.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.dark));
            scrollView.setBackgroundColor(context.getResources().getColor(R.color.dark));
            textView.setTextColor(Color.WHITE);
            textView.setTextColor(Color.WHITE);
            radioButton1.setTextColor(Color.WHITE);
            radioButton2.setTextColor(Color.WHITE);
            radioButton3.setTextColor(Color.WHITE);
            radioButton4.setTextColor(Color.WHITE);
            radioButton5.setTextColor(Color.WHITE);
            radioButton6.setTextColor(Color.WHITE);
            radioButton7.setTextColor(Color.WHITE);
            radioButton8.setTextColor(Color.WHITE);
            if (cc == 4) {
                textView.setTextColor(Color.argb(255, 255, 121, 18));
                textView2.setTextColor(Color.argb(255, 255, 121, 18));
                radioButton1.setTextColor(Color.argb(255, 255, 121, 18));
                radioButton2.setTextColor(Color.argb(255, 255, 121, 18));
                radioButton3.setTextColor(Color.argb(255, 255, 121, 18));
                radioButton4.setTextColor(Color.argb(255, 255, 121, 18));
                radioButton5.setTextColor(Color.argb(255, 255, 121, 18));
                radioButton6.setTextColor(Color.argb(255, 255, 121, 18));
                radioButton7.setTextColor(Color.argb(255, 255, 121, 18));
                radioButton8.setTextColor(Color.argb(255, 255, 121, 18));
            } else {
                textView2.setTextColor(Color.WHITE);
                textView.setTextColor(Color.WHITE);
                radioButton1.setTextColor(Color.WHITE);
                radioButton2.setTextColor(Color.WHITE);
                radioButton3.setTextColor(Color.WHITE);
                radioButton4.setTextColor(Color.WHITE);
                radioButton5.setTextColor(Color.WHITE);
                radioButton6.setTextColor(Color.WHITE);
                radioButton7.setTextColor(Color.WHITE);
                radioButton8.setTextColor(Color.WHITE);
            }
        } else if (cs == 6) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            cardView2.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.light));
            scrollView.setBackgroundColor(context.getResources().getColor(R.color.light));
        }
    }



    /**
     * Before invoking this function, invoke initialize() method
     */
    public void Texts() {
        textView.setLineSpacing(45, value2);
        textView.setText(text1);
        textView.setTextSize(value);
        textView2.setLineSpacing(45, value2);
        textView2.setTextSize(value);
        textView2.setText(text2);
        radioButton1.setTextSize(value);
        radioButton2.setTextSize(value);
        radioButton3.setTextSize(value);
        radioButton4.setTextSize(value);
        radioButton5.setTextSize(value);
        radioButton6.setTextSize(value);
        radioButton7.setTextSize(value);
        radioButton8.setTextSize(value);
        if (cc == 1) {
            textView.setTextColor(Color.BLACK);
            textView2.setTextColor(Color.BLACK);
            radioButton1.setTextColor(Color.BLACK);
            radioButton2.setTextColor(Color.BLACK);
            radioButton3.setTextColor(Color.BLACK);
            radioButton4.setTextColor(Color.BLACK);
            radioButton5.setTextColor(Color.BLACK);
            radioButton6.setTextColor(Color.BLACK);
            radioButton7.setTextColor(Color.BLACK);
            radioButton8.setTextColor(Color.BLACK);
        } else if (cc == 2) {
            textView.setTextColor(Color.WHITE);
            textView2.setTextColor(Color.WHITE);
            radioButton1.setTextColor(Color.WHITE);
            radioButton2.setTextColor(Color.WHITE);
            radioButton3.setTextColor(Color.WHITE);
            radioButton4.setTextColor(Color.WHITE);
            radioButton5.setTextColor(Color.WHITE);
            radioButton6.setTextColor(Color.WHITE);
            radioButton7.setTextColor(Color.WHITE);
            radioButton8.setTextColor(Color.WHITE);
        } else if (cc == 3) {
            textView.setTextColor(Color.GRAY);
            textView2.setTextColor(Color.GRAY);
            radioButton1.setTextColor(Color.GRAY);
            radioButton2.setTextColor(Color.GRAY);
            radioButton3.setTextColor(Color.GRAY);
            radioButton4.setTextColor(Color.GRAY);
            radioButton5.setTextColor(Color.GRAY);
            radioButton6.setTextColor(Color.GRAY);
            radioButton7.setTextColor(Color.GRAY);
            radioButton8.setTextColor(Color.GRAY);
        } else if (cc == 4) {
            textView.setTextColor(Color.argb(255, 255, 121, 18));
            textView2.setTextColor(Color.argb(255, 255, 121, 18));
            radioButton1.setTextColor(Color.argb(255, 255, 121, 18));
            radioButton2.setTextColor(Color.argb(255, 255, 121, 18));
            radioButton3.setTextColor(Color.argb(255, 255, 121, 18));
            radioButton4.setTextColor(Color.argb(255, 255, 121, 18));
            radioButton5.setTextColor(Color.argb(255, 255, 121, 18));
            radioButton6.setTextColor(Color.argb(255, 255, 121, 18));
            radioButton7.setTextColor(Color.argb(255, 255, 121, 18));
            radioButton8.setTextColor(Color.argb(255, 255, 121, 18));
        }
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void onclick(){
        btnBack.setOnClickListener(v -> {
            context.startActivity(new Intent(activity));
            ((Activity) context).finish();
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
    public void check1() {

        button.setOnClickListener(v -> {
            if (radioButton1.isChecked() && radioButton8.isChecked()) {
                Toast.makeText(context, "Good job!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Oops!!Try again", Toast.LENGTH_SHORT).show();
            }
        });

    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check2() {

        button.setOnClickListener(v -> {
            if (radioButton5.isChecked() && radioButton3.isChecked()) {
                Toast.makeText(context, "Good job!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Oops!!Try again", Toast.LENGTH_SHORT).show();
            }
        });

        radioButton1.setText("Germany/surfing/can't");
        radioButton2.setText("England/checking/can");
        radioButton3.setText("England/checking/can't");
        radioButton4.setText("Canada/surfing/can");
        radioButton5.setText("Turkey/visiting/buying/ticket price");
        radioButton6.setText("Turkey/coming/renting/price");
        radioButton7.setText("Turkey/visiting/buying/ticket");
        radioButton8.setText("Turkey/coming/getting/ticket price");

    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check3() {

        button.setOnClickListener(v -> {
            if (radioButton2.isChecked() && radioButton8.isChecked()) {
                Toast.makeText(context, "Good job!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Oops!!Try again", Toast.LENGTH_SHORT).show();
            }
        });

        radioButton1.setText("melon/bots/poems of Hafez/parent's");
        radioButton2.setText("watermelon/nuts/poems of Hafez/grandparent's");
        radioButton3.setText("watermelon/nuts/poems of Hafez/parent's");
        radioButton4.setText("melon/nuts/poems of Hafez/grandparent's");
        radioButton5.setText("January/February/do/red/lucky money");
        radioButton6.setText("January/February/does/a/lucky money");
        radioButton7.setText("February/January/do/a/lucky money");
        radioButton8.setText("January/February/does/red/lucky money");

    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check4() {

        button.setOnClickListener(v -> {
            if (radioButton2.isChecked() && radioButton7.isChecked()) {
                Toast.makeText(context, "Good job!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Oops!!Try again", Toast.LENGTH_SHORT).show();
            }
        });

        radioButton1.setText("baker/store/in the morning");
        radioButton2.setText("baker/bakery/in the morning");
        radioButton3.setText("baker/bakery/in the evening");
        radioButton4.setText("baker/store/in the evening");
        radioButton5.setText("police officer/fire/Wednesdays/7 a.m");
        radioButton6.setText("police officer/police/Wednesday/7 a.m");
        radioButton7.setText("police officer/police/Wednesdays/7 a.m");
        radioButton8.setText("police officer/police/Wednesdays/7 p.m");

    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check5() {

        button.setOnClickListener(v -> {
            if (radioButton4.isChecked() && radioButton5.isChecked()) {
                Toast.makeText(context, "Good job!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Oops!!Try again", Toast.LENGTH_SHORT).show();
            }
        });

        radioButton1.setText("brilliant/media/Yes");
        radioButton2.setText("brilliant/internet/No");
        radioButton3.setText("brilliant/media/No");
        radioButton4.setText("brilliant/internet/Yes");
        radioButton5.setText("2/cartoon/home");
        radioButton6.setText("4/cartoon/cinema");
        radioButton7.setText("2/comedy/home");
        radioButton8.setText("4/cartoon/cinema");

    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check6() {

        button.setOnClickListener(v -> {
            if (radioButton2.isChecked() && radioButton5.isChecked()) {
                Toast.makeText(context, "Good job!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Oops!!Try again", Toast.LENGTH_SHORT).show();
            }
        });


        radioButton1.setText("this ball/fell/called");
        radioButton2.setText("the ball/fell/called");
        radioButton3.setText("the ball/fall/called");
        radioButton4.setText("the ball/fell/call");
        radioButton5.setText("a child/save/hospital");
        radioButton6.setText("child/save/fire station");
        radioButton7.setText("a child/safe/fire station");
        radioButton8.setText("child/safe/hospital");

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
    public void onBackPressed(){
        context.startActivity(new Intent(activity));
        ((Activity) context).finish();
    }
}
