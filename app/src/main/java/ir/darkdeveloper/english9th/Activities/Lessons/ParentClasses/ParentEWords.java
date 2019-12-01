package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import ir.darkdeveloper.english9th.Activities.AdBase;
import ir.plant.english9th.R;

public class ParentEWords {

    private int cs, cc, value;
    private Context context;
    private CardView cardView;
    private TextView textView;
    private ImageView imgGuide;

    public ParentEWords(Context context, String text, String activity) {
        this.context = context;
        this.text = text;
        this.activity = activity;
    }

    private String text, activity;
    private RelativeLayout relativeLayout;
    private ImageButton btnBack;



    @SuppressLint("SetTextI18n")
    public void initialize() {
        SharedPreferences preferences = context.getSharedPreferences("font_size",
                Context.MODE_PRIVATE);
        value = preferences.getInt("fontsize", 18);
        SharedPreferences color1 = context.getSharedPreferences("color1", Context.MODE_PRIVATE);
        cc = color1.getInt("color2", 0);
        SharedPreferences color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color.getInt("color??",4);
        cardView = ((Activity) context).findViewById(R.id.card_ewords);
        relativeLayout = ((Activity) context).findViewById(R.id.relativeBack);
        textView = ((Activity) context).findViewById(R.id.textView_ewords);
        TextView toolbarText = ((Activity) context).findViewById(R.id.toolbar_text_p);
        toolbarText.setText("EWords");
        TextView toggle = ((Activity) context).findViewById(R.id.change_lang_tog);
        btnBack = ((Activity) context).findViewById(R.id.menu_button_p);
        imgGuide = ((Activity) context).findViewById(R.id.img_guide);
        toggle.setVisibility(View.GONE);
        imgGuide.setVisibility(View.GONE);

    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    public void Texts() {
        textView.setText(text);
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
        if (cs == 5){
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            textView.setTextColor(Color.WHITE);
            relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.dark));
            if (cc == 4){
                textView.setTextColor(Color.argb(255,255,121,18));
            }else {
                textView.setTextColor(Color.WHITE);
            }
        }else if (cs == 6){
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.light));
        }
    }



    /**
     * Before invoking this function, invoke initialize() method
     */
    public void onclick() {
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
    public void onBackPressed(){
        context.startActivity(new Intent(activity));
        ((Activity) context).finish();
    }
}
