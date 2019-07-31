package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.melnykov.fab.ObservableScrollView;

import ir.plant.english9th.R;

public class ParentFind {
    private Context context;
    private TextView textView, txtHint;
    private EditText editText, editText2;
    private ImageButton btnBack;
    private Button btnCheck;
    private int cs, cc, ct, value;
    private float value2;
    private CardView cardView;
    private ObservableScrollView scrollView;
    private String textFind, textFind2, activity;
    private TextView toggle_lan;
    private boolean state = true;


    public ParentFind(Context context, String textFind, String textFind2, String activity) {
        this.context = context;
        this.textFind = textFind;
        this.activity = activity;
        this.textFind2 = textFind2;
    }

    @SuppressLint("SetTextI18n")
    public void initialize() {
        textView = ((Activity) context).findViewById(R.id.textView_findit);
        txtHint = ((Activity) context).findViewById(R.id.txt_hint);
        TextView textToolbar = ((Activity) context).findViewById(R.id.toolbar_text_p);
        toggle_lan = ((Activity) context).findViewById(R.id.change_lang_tog);
        textToolbar.setText("Find it");
        btnBack = ((Activity) context).findViewById(R.id.menu_button_p);
        scrollView = ((Activity) context).findViewById(R.id.scrollFind);
        SharedPreferences preferences = context.getSharedPreferences("font_size", Context.MODE_PRIVATE);
        value = preferences.getInt("fontsize", 18);
        SharedPreferences color1 = context.getSharedPreferences("color1", Context.MODE_PRIVATE);
        cc = color1.getInt("color2", 0);
        SharedPreferences sh_text = context.getSharedPreferences("trans", Context.MODE_PRIVATE);
        ct = sh_text.getInt("transs", 1);
        editText = ((Activity) context).findViewById(R.id.edit_findit);
        editText2 = ((Activity) context).findViewById(R.id.edit_findit2);
        btnCheck = ((Activity) context).findViewById(R.id.btn_findit);
        SharedPreferences color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color.getInt("color??", 4);
        cardView = ((Activity) context).findViewById(R.id.find_c);
        SharedPreferences preferences2 = context.getSharedPreferences("font_margin", Context.MODE_PRIVATE);
        value2 = preferences2.getFloat("fontmargin", 0);
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
                textView.setText(textFind);
                toggle_lan.setText("fa");
                state = false;
            } else {
                textView.setText(textFind2);
                toggle_lan.setText("en");
                state = true;
            }
        });
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    public void check1() {
        btnCheck.setOnClickListener(view -> {
            if (editText.getText().toString().equals("8")) {
                Toast.makeText(context, "Congratulations!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Try Again!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check2() {
        editText.setHint("present continuous");
        txtHint.setText("How many present continuous tenses" +
                " did you find? Enter latin number below");
        btnCheck.setOnClickListener(view -> {
            if (editText.getText().toString().equals("4")) {
                Toast.makeText(context, "Congratulations!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Try Again!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check3() {
        editText2.setVisibility(View.VISIBLE);
        editText.setHint("simple present");
        editText2.setHint("possessive adj");
        txtHint.setText("How many simple present tenses and possessive adjs" +
                " did you find? Enter latin number below");
        btnCheck.setOnClickListener(view -> {
            if (editText.getText().toString().equals("5") &&
                    editText2.getText().toString().equals("1")) {
                Toast.makeText(context, "Congratulations!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Try Again!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check4() {
        editText.setHint("Wh questions");
        txtHint.setText("How many Wh questions did you find? Enter latin number below");
        btnCheck.setOnClickListener(view -> {
            if (editText.getText().toString().equals("4")) {
                Toast.makeText(context, "Congratulations!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Try Again!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check5() {
        editText.setHint("simple past");
        txtHint.setText("How many simple past tenses" +
                " did you find? Enter latin number below");
        btnCheck.setOnClickListener(view -> {
            if (editText.getText().toString().equals("8")) {
                Toast.makeText(context, "Congratulations!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Try Again!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Before invoking this function, invoke initialize() method
     */
    @SuppressLint("SetTextI18n")
    public void check6() {
        editText.setHint("simple past");
        txtHint.setText("How many simple past tenses did you find? Enter latin number below");
        btnCheck.setOnClickListener(view -> {
            if (editText.getText().toString().equals("10")) {
                Toast.makeText(context, "Congratulations!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Try Again!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    public void sets() {
        if (cs == 5) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            textView.setTextColor(Color.WHITE);
            scrollView.setBackgroundColor(context.getResources().getColor(R.color.dark));
            if (cc == 4) {
                textView.setTextColor(Color.argb(255, 255, 121, 18));
                txtHint.setTextColor(Color.argb(255, 255, 121, 18));
                editText.setTextColor(Color.argb(255, 255, 121, 18));
                editText2.setTextColor(Color.argb(255, 255, 121, 18));
            } else {
                txtHint.setTextColor(Color.WHITE);
                editText.setTextColor(Color.WHITE);
                editText2.setTextColor(Color.WHITE);
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
    @SuppressLint("SetTextI18n")
    public void Texts() {
        //textView.setText(textFind);
        if (ct == 1) {
            textView.setText(textFind);
            toggle_lan.setText("fa");
        } else if (ct == 2){
            textView.setText(textFind2);
            toggle_lan.setText("en");
        }

        textView.setLineSpacing(45, value2);
        textView.setTextSize(value);
        txtHint.setTextSize(value);
        if (cc == 1) {
            textView.setTextColor(Color.BLACK);
            txtHint.setTextColor(Color.BLACK);
            editText.setTextColor(Color.BLACK);
            editText2.setTextColor(Color.BLACK);
        } else if (cc == 2) {
            textView.setTextColor(Color.WHITE);
            txtHint.setTextColor(Color.WHITE);
            editText.setTextColor(Color.WHITE);
            editText2.setTextColor(Color.WHITE);
        } else if (cc == 3) {
            textView.setTextColor(Color.GRAY);
            txtHint.setTextColor(Color.GRAY);
            editText.setTextColor(Color.GRAY);
            editText2.setTextColor(Color.GRAY);
        } else if (cc == 4) {
            textView.setTextColor(Color.argb(255, 255, 121, 18));
            txtHint.setTextColor(Color.argb(255, 255, 121, 18));
            editText.setTextColor(Color.argb(255, 255, 121, 18));
            editText2.setTextColor(Color.argb(255, 255, 121, 18));
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
