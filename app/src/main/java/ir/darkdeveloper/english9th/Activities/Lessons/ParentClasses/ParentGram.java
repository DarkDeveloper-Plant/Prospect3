package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import com.melnykov.fab.ObservableScrollView;

import ir.darkdeveloper.english9th.Activities.AdBase;
import ir.plant.english9th.R;

public class ParentGram {

    private Context context;
    private TextView textView, toggle;
    private int cs, cc, ct, value;
    private float value2;
    private CardView cardView;
    private boolean state = true;
    private String textGram, textGramF, activity;
    private ImageButton btnBack;
    private ImageView imgGuide;
    private ObservableScrollView scrollView;

    public ParentGram(Context context, String textGram, String textGramF, String activity) {
        this.context = context;
        this.textGram = textGram;
        this.textGramF = textGramF;
        this.activity = activity;
    }


    @SuppressLint("SetTextI18n")
    public void initialize() {
        textView = ((Activity) context).findViewById(R.id.textView_grammar);
        SharedPreferences preferences = context.getSharedPreferences("font_size",
                Context.MODE_PRIVATE);
        value = preferences.getInt("fontsize", 18);
        SharedPreferences color1 = context.getSharedPreferences("color1", Context.MODE_PRIVATE);
        cc = color1.getInt("color2", 0);
        SharedPreferences color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color.getInt("color??", 4);
        SharedPreferences sh_text = context.getSharedPreferences("trans", Context.MODE_PRIVATE);
        ct = sh_text.getInt("transs", 1);
        SharedPreferences preferences2 = context.getSharedPreferences("font_margin",
                Context.MODE_PRIVATE);
        value2 = preferences2.getFloat("fontmargin", 0);
        cardView = ((Activity) context).findViewById(R.id.card_grammar);
        scrollView = ((Activity) context).findViewById(R.id.scrollGram);
        TextView toolbarText = ((Activity) context).findViewById(R.id.toolbar_text_p);
        toolbarText.setText("Grammar");
        toggle = ((Activity) context).findViewById(R.id.change_lang_tog);
        btnBack = ((Activity) context).findViewById(R.id.menu_button_p);
        imgGuide = ((Activity) context).findViewById(R.id.img_guide);
        helpInit();
    }

    private void helpInit() {
        ParentHelp parentHelp = new ParentHelp(context, toggle,
                imgGuide);
        parentHelp.initializeGramFind();
        imgGuide.setOnClickListener(v -> {
            SharedPreferences preferences = context
                    .getSharedPreferences("prompt", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("showed?", false);
            editor.apply();
            parentHelp.initializeGramFind();
        });
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void onclick() {

        toggle.setOnClickListener(v -> {
            if (state) {
                textView.setText(textGram);
                toggle.setText("fa");
                state = false;
            } else {
                textView.setText(textGramF);
                toggle.setText("en");
                state = true;
            }
        });

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
    @SuppressLint("SetTextI18n")
    public void Texts() {
        textView.setText(textGram);
        if (ct == 2) {
            textView.setText(textGramF);
            toggle.setText("en");
        } else if (ct == 1) {
            textView.setText(textGram);
            toggle.setText("fa");
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

        if (cs == 5) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            textView.setTextColor(Color.WHITE);
            scrollView.setBackgroundColor(context.getResources().getColor(R.color.dark));
            if (cc == 4) {
                textView.setTextColor(Color.argb(255, 255, 121, 18));
            } else {
                textView.setTextColor(Color.WHITE);
            }
        } else if (cs == 6) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            scrollView.setBackgroundColor(context.getResources().getColor(R.color.light));
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
