package ir.darkdeveloper.english9th.Activities.Lessons.Tests;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.plant.english9th.R;

/**
 * Created by darkdeveloper on 11/15/17.
 */

public class Test4 extends AppCompatActivity {
    Toolbar toolbar;

    TextView title1, title2, title3, tv1, tv2, tv3, tv4, tv5, tv6;

    RadioButton radio1_1, radio1_2, radio1_3, radio1_4, radio1_5, radio1_6, radio2_1, radio2_2, radio2_3, radio2_4, radio2_5, radio2_6, radio2_7, radio2_8, radio2_9, radio2_10, radio2_11, radio2_12;

    ImageView img1, img2, img3;
    EditText ed1, ed2, ed3;
    FloatingActionButton fab_check;
    CardView card1, card2, card3;
    SharedPreferences color, color1;
    int cs, cc, value;
    float value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.activity_test1);
            toolbar = findViewById(R.id.toolbar_test);
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            ini();
            sets();
            colors();
            fab_check.setOnClickListener(v -> check());

        } catch (Exception e) {
            e.printStackTrace();
            new CrashHandler().catchException(e, this);
            startActivity(new Intent("ir.darkdeveloper.english9th." +
                    "Activities.BasicActivities.CrashHandler.CrashHandling"));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Test4.this, TestMain.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(Test4.this, TestMain.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    private void ini() {

        title1 = findViewById(R.id.tvt_test1);
        title2 = findViewById(R.id.tvt_test2);
        title3 = findViewById(R.id.tvt_test3);
        card1 = findViewById(R.id.card_tst1);
        card2 = findViewById(R.id.card_tst2);
        card3 = findViewById(R.id.card_tst3);
        tv1 = findViewById(R.id.tv_test1);
        tv2 = findViewById(R.id.tv_test2);
        tv3 = findViewById(R.id.tv_test3);
        tv4 = findViewById(R.id.tv_test4);
        tv5 = findViewById(R.id.tv_test5);
        tv6 = findViewById(R.id.tv_test6);
        radio1_1 = findViewById(R.id.radio_tst1_1);
        radio1_2 = findViewById(R.id.radio_tst1_2);
        radio1_3 = findViewById(R.id.radio_tst1_3);
        radio1_4 = findViewById(R.id.radio_tst1_4);
        radio1_5 = findViewById(R.id.radio_tst1_5);
        radio1_6 = findViewById(R.id.radio_tst1_6);
        radio2_1 = findViewById(R.id.radio_tst1_7);
        radio2_2 = findViewById(R.id.radio_tst1_8);
        radio2_3 = findViewById(R.id.radio_tst1_9);
        radio2_4 = findViewById(R.id.radio_tst1_10);
        radio2_5 = findViewById(R.id.radio_tst1_11);
        radio2_6 = findViewById(R.id.radio_tst1_12);
        radio2_7 = findViewById(R.id.radio_tst1_13);
        radio2_8 = findViewById(R.id.radio_tst1_14);
        radio2_9 = findViewById(R.id.radio_tst1_15);
        radio2_10 = findViewById(R.id.radio_tst1_16);
        radio2_11 = findViewById(R.id.radio_tst1_17);
        radio2_12 = findViewById(R.id.radio_tst1_18);
        fab_check = findViewById(R.id.btn_check);
        img1 = findViewById(R.id.img_tst1);
        img2 = findViewById(R.id.img_tst2);
        img3 = findViewById(R.id.img_tst3);
        ed1 = findViewById(R.id.ed_test1);
        ed2 = findViewById(R.id.ed_test2);
        ed3 = findViewById(R.id.ed_test3);
        SharedPreferences preferences = getSharedPreferences("font_size", Context.MODE_PRIVATE);
        value = preferences.getInt("fontsize", 18);
        color1 = getSharedPreferences("color1", Context.MODE_PRIVATE);
        cc = color1.getInt("color2", 0);
        color = getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color.getInt("color??", 4);
        SharedPreferences preferences2 = getSharedPreferences("font_margin", Context.MODE_PRIVATE);
        value2 = preferences2.getFloat("fontmargin", 0);
    }


    @SuppressLint("SetTextI18n")
    private void sets() {
        title3.setText("What are the people doing in the following pictures?");
        tv1.setText("I want a postcard.I should get it from a post office.");
        tv2.setText("You need cash. You should take out money from an ATM.");
        tv3.setText("firefighters never put out fire.");

        tv4.setText("Who ..... the game?");
        radio2_1.setText("start");
        radio2_2.setText("stop");
        radio2_3.setText("starts");
        radio2_4.setText("play");

        tv5.setText("Who does Ali ... to?");
        radio2_5.setText("helped");
        radio2_6.setText("help");
        radio2_7.setText("helps");
        radio2_8.setText("helping");

        tv6.setText("He always wakes up early. it means:");
        radio2_9.setText("He never wakes up late");
        radio2_10.setText("He never wake up late");
        radio2_11.setText("He always wakes up late");
        radio2_12.setText("He never wakes up early");

        img1.setImageResource(R.drawable.putoutfire);
        img2.setImageResource(R.drawable.callemergency);
        img3.setImageResource(R.drawable.hireataxi);
    }


    private void colors() {
        title1.setLineSpacing(45, value2);
        title1.setTextSize(value);
        title2.setLineSpacing(45, value2);
        title2.setTextSize(value);
        title3.setLineSpacing(45, value2);
        title3.setTextSize(value);
        tv1.setLineSpacing(45, value2);
        tv1.setTextSize(value);
        tv2.setLineSpacing(45, value2);
        tv2.setTextSize(value);
        tv3.setLineSpacing(45, value2);
        tv3.setTextSize(value);
        tv4.setLineSpacing(45, value2);
        tv4.setTextSize(value);
        tv5.setLineSpacing(45, value2);
        tv5.setTextSize(value);
        tv6.setLineSpacing(45, value2);
        tv6.setTextSize(value);


        if (cc == 1) {
            title1.setTextColor(Color.BLACK);
            title2.setTextColor(Color.BLACK);
            title3.setTextColor(Color.BLACK);
            tv1.setTextColor(Color.BLACK);
            tv2.setTextColor(Color.BLACK);
            tv3.setTextColor(Color.BLACK);
            tv4.setTextColor(Color.BLACK);
            tv5.setTextColor(Color.BLACK);
            tv6.setTextColor(Color.BLACK);
            radio1_1.setTextColor(Color.BLACK);
            radio1_2.setTextColor(Color.BLACK);
            radio1_3.setTextColor(Color.BLACK);
            radio1_4.setTextColor(Color.BLACK);
            radio1_5.setTextColor(Color.BLACK);
            radio1_6.setTextColor(Color.BLACK);
            radio2_1.setTextColor(Color.BLACK);
            radio2_2.setTextColor(Color.BLACK);
            radio2_3.setTextColor(Color.BLACK);
            radio2_4.setTextColor(Color.BLACK);
            radio2_5.setTextColor(Color.BLACK);
            radio2_6.setTextColor(Color.BLACK);
            radio2_7.setTextColor(Color.BLACK);
            radio2_8.setTextColor(Color.BLACK);
            radio2_9.setTextColor(Color.BLACK);
            radio2_10.setTextColor(Color.BLACK);
            radio2_11.setTextColor(Color.BLACK);
            radio2_12.setTextColor(Color.BLACK);
            ed1.setTextColor(Color.BLACK);
            ed2.setTextColor(Color.BLACK);
            ed3.setTextColor(Color.BLACK);
            ed1.setHintTextColor(Color.BLACK);
            ed2.setHintTextColor(Color.BLACK);
            ed3.setHintTextColor(Color.BLACK);
        } else if (cc == 2) {
            title1.setTextColor(Color.WHITE);
            title2.setTextColor(Color.WHITE);
            title3.setTextColor(Color.WHITE);
            tv1.setTextColor(Color.WHITE);
            tv2.setTextColor(Color.WHITE);
            tv3.setTextColor(Color.WHITE);
            tv4.setTextColor(Color.WHITE);
            tv5.setTextColor(Color.WHITE);
            tv6.setTextColor(Color.WHITE);
            radio1_1.setTextColor(Color.WHITE);
            radio1_2.setTextColor(Color.WHITE);
            radio1_3.setTextColor(Color.WHITE);
            radio1_4.setTextColor(Color.WHITE);
            radio1_5.setTextColor(Color.WHITE);
            radio1_6.setTextColor(Color.WHITE);
            radio2_1.setTextColor(Color.WHITE);
            radio2_2.setTextColor(Color.WHITE);
            radio2_3.setTextColor(Color.WHITE);
            radio2_4.setTextColor(Color.WHITE);
            radio2_5.setTextColor(Color.WHITE);
            radio2_6.setTextColor(Color.WHITE);
            radio2_7.setTextColor(Color.WHITE);
            radio2_8.setTextColor(Color.WHITE);
            radio2_9.setTextColor(Color.WHITE);
            radio2_10.setTextColor(Color.WHITE);
            radio2_11.setTextColor(Color.WHITE);
            radio2_12.setTextColor(Color.WHITE);
            ed1.setTextColor(Color.WHITE);
            ed2.setTextColor(Color.WHITE);
            ed3.setTextColor(Color.WHITE);
            ed1.setHintTextColor(Color.WHITE);
            ed2.setHintTextColor(Color.WHITE);
            ed3.setHintTextColor(Color.WHITE);
        } else if (cc == 3) {
            title1.setTextColor(Color.GRAY);
            title2.setTextColor(Color.GRAY);
            title3.setTextColor(Color.GRAY);
            tv1.setTextColor(Color.GRAY);
            tv2.setTextColor(Color.GRAY);
            tv3.setTextColor(Color.GRAY);
            tv4.setTextColor(Color.GRAY);
            tv5.setTextColor(Color.GRAY);
            tv6.setTextColor(Color.GRAY);
            radio1_1.setTextColor(Color.GRAY);
            radio1_2.setTextColor(Color.GRAY);
            radio1_3.setTextColor(Color.GRAY);
            radio1_4.setTextColor(Color.GRAY);
            radio1_5.setTextColor(Color.GRAY);
            radio1_6.setTextColor(Color.GRAY);
            radio2_1.setTextColor(Color.GRAY);
            radio2_2.setTextColor(Color.GRAY);
            radio2_3.setTextColor(Color.GRAY);
            radio2_4.setTextColor(Color.GRAY);
            radio2_5.setTextColor(Color.GRAY);
            radio2_6.setTextColor(Color.GRAY);
            radio2_7.setTextColor(Color.GRAY);
            radio2_8.setTextColor(Color.GRAY);
            radio2_9.setTextColor(Color.GRAY);
            radio2_10.setTextColor(Color.GRAY);
            radio2_11.setTextColor(Color.GRAY);
            radio2_12.setTextColor(Color.GRAY);
            ed1.setTextColor(Color.GRAY);
            ed2.setTextColor(Color.GRAY);
            ed3.setTextColor(Color.GRAY);
            ed1.setHintTextColor(Color.GRAY);
            ed2.setHintTextColor(Color.GRAY);
            ed3.setHintTextColor(Color.GRAY);
        } else if (cc == 4) {
            title1.setTextColor(Color.argb(255, 255, 121, 18));
            title2.setTextColor(Color.argb(255, 255, 121, 18));
            title3.setTextColor(Color.argb(255, 255, 121, 18));
            tv1.setTextColor(Color.argb(255, 255, 121, 18));
            tv2.setTextColor(Color.argb(255, 255, 121, 18));
            tv3.setTextColor(Color.argb(255, 255, 121, 18));
            tv4.setTextColor(Color.argb(255, 255, 121, 18));
            tv5.setTextColor(Color.argb(255, 255, 121, 18));
            tv6.setTextColor(Color.argb(255, 255, 121, 18));
            radio1_1.setTextColor(Color.argb(255, 255, 121, 18));
            radio1_2.setTextColor(Color.argb(255, 255, 121, 18));
            radio1_3.setTextColor(Color.argb(255, 255, 121, 18));
            radio1_4.setTextColor(Color.argb(255, 255, 121, 18));
            radio1_5.setTextColor(Color.argb(255, 255, 121, 18));
            radio1_6.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_1.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_2.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_3.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_4.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_5.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_6.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_7.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_8.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_9.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_10.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_11.setTextColor(Color.argb(255, 255, 121, 18));
            radio2_12.setTextColor(Color.argb(255, 255, 121, 18));
            ed1.setTextColor(Color.argb(255, 255, 121, 18));
            ed2.setTextColor(Color.argb(255, 255, 121, 18));
            ed3.setTextColor(Color.argb(255, 255, 121, 18));
            ed1.setHintTextColor(Color.argb(255, 255, 121, 18));
            ed2.setHintTextColor(Color.argb(255, 255, 121, 18));
            ed3.setHintTextColor(Color.argb(255, 255, 121, 18));
        }

        if (cs == 5) {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.dark));
            card1.setCardBackgroundColor(getResources().getColor(R.color.dark_card));
            card2.setCardBackgroundColor(getResources().getColor(R.color.dark_card));
            card3.setCardBackgroundColor(getResources().getColor(R.color.dark_card));
            title1.setTextColor(Color.WHITE);
            title2.setTextColor(Color.WHITE);
            title3.setTextColor(Color.WHITE);
            tv1.setTextColor(Color.WHITE);
            tv2.setTextColor(Color.WHITE);
            tv3.setTextColor(Color.WHITE);
            tv4.setTextColor(Color.WHITE);
            tv5.setTextColor(Color.WHITE);
            tv6.setTextColor(Color.WHITE);
            radio1_1.setTextColor(Color.WHITE);
            radio1_2.setTextColor(Color.WHITE);
            radio1_3.setTextColor(Color.WHITE);
            radio1_4.setTextColor(Color.WHITE);
            radio1_5.setTextColor(Color.WHITE);
            radio1_6.setTextColor(Color.WHITE);
            radio2_1.setTextColor(Color.WHITE);
            radio2_2.setTextColor(Color.WHITE);
            radio2_3.setTextColor(Color.WHITE);
            radio2_4.setTextColor(Color.WHITE);
            radio2_5.setTextColor(Color.WHITE);
            radio2_6.setTextColor(Color.WHITE);
            radio2_7.setTextColor(Color.WHITE);
            radio2_8.setTextColor(Color.WHITE);
            radio2_9.setTextColor(Color.WHITE);
            radio2_10.setTextColor(Color.WHITE);
            radio2_11.setTextColor(Color.WHITE);
            radio2_12.setTextColor(Color.WHITE);
            ed1.setTextColor(Color.WHITE);
            ed2.setTextColor(Color.WHITE);
            ed3.setTextColor(Color.WHITE);
            ed1.setHintTextColor(Color.WHITE);
            ed2.setHintTextColor(Color.WHITE);
            ed3.setHintTextColor(Color.WHITE);
            if (cc == 4) {
                title1.setTextColor(Color.argb(255, 255, 121, 18));
                title2.setTextColor(Color.argb(255, 255, 121, 18));
                title3.setTextColor(Color.argb(255, 255, 121, 18));
                tv1.setTextColor(Color.argb(255, 255, 121, 18));
                tv2.setTextColor(Color.argb(255, 255, 121, 18));
                tv3.setTextColor(Color.argb(255, 255, 121, 18));
                tv4.setTextColor(Color.argb(255, 255, 121, 18));
                tv5.setTextColor(Color.argb(255, 255, 121, 18));
                tv6.setTextColor(Color.argb(255, 255, 121, 18));
                radio1_1.setTextColor(Color.argb(255, 255, 121, 18));
                radio1_2.setTextColor(Color.argb(255, 255, 121, 18));
                radio1_3.setTextColor(Color.argb(255, 255, 121, 18));
                radio1_4.setTextColor(Color.argb(255, 255, 121, 18));
                radio1_5.setTextColor(Color.argb(255, 255, 121, 18));
                radio1_6.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_1.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_2.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_3.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_4.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_5.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_6.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_7.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_8.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_9.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_10.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_11.setTextColor(Color.argb(255, 255, 121, 18));
                radio2_12.setTextColor(Color.argb(255, 255, 121, 18));
                ed1.setTextColor(Color.argb(255, 255, 121, 18));
                ed2.setTextColor(Color.argb(255, 255, 121, 18));
                ed3.setTextColor(Color.argb(255, 255, 121, 18));
                ed1.setHintTextColor(Color.argb(255, 255, 121, 18));
                ed2.setHintTextColor(Color.argb(255, 255, 121, 18));
                ed3.setHintTextColor(Color.argb(255, 255, 121, 18));
            } else {
                title1.setTextColor(Color.WHITE);
                title2.setTextColor(Color.WHITE);
                title3.setTextColor(Color.WHITE);
                tv1.setTextColor(Color.WHITE);
                tv2.setTextColor(Color.WHITE);
                tv3.setTextColor(Color.WHITE);
                tv4.setTextColor(Color.WHITE);
                tv5.setTextColor(Color.WHITE);
                tv6.setTextColor(Color.WHITE);
                radio1_1.setTextColor(Color.WHITE);
                radio1_2.setTextColor(Color.WHITE);
                radio1_3.setTextColor(Color.WHITE);
                radio1_4.setTextColor(Color.WHITE);
                radio1_5.setTextColor(Color.WHITE);
                radio1_6.setTextColor(Color.WHITE);
                radio2_1.setTextColor(Color.WHITE);
                radio2_2.setTextColor(Color.WHITE);
                radio2_3.setTextColor(Color.WHITE);
                radio2_4.setTextColor(Color.WHITE);
                radio2_5.setTextColor(Color.WHITE);
                radio2_6.setTextColor(Color.WHITE);
                radio2_7.setTextColor(Color.WHITE);
                radio2_8.setTextColor(Color.WHITE);
                radio2_9.setTextColor(Color.WHITE);
                radio2_10.setTextColor(Color.WHITE);
                radio2_11.setTextColor(Color.WHITE);
                radio2_12.setTextColor(Color.WHITE);
                ed1.setTextColor(Color.WHITE);
                ed2.setTextColor(Color.WHITE);
                ed3.setTextColor(Color.WHITE);
                ed1.setHintTextColor(Color.WHITE);
                ed2.setHintTextColor(Color.WHITE);
                ed3.setHintTextColor(Color.WHITE);
            }
        } else if (cs == 6) {
            getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.light));
            card1.setCardBackgroundColor(getResources().getColor(R.color.light_card));
            card2.setCardBackgroundColor(getResources().getColor(R.color.light_card));
            card3.setCardBackgroundColor(getResources().getColor(R.color.light_card));
        }

    }


    @SuppressLint("SetTextI18n")
    private void check() {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.test_result, null);
        TextView tv1_result = view.findViewById(R.id.tv1_result);
        final TextView tv2_result = view.findViewById(R.id.tv2_result);
        final LinearLayout back = view.findViewById(R.id.back_result);
        String correct1 = "", wrong1 = "", correct2 = "", wrong2 = "", correct3 = "", wrong3 = "", correct4 = "", wrong4 = "", correct5 = "", wrong5 = "", correct6 = "", wrong6 = "", correct7 = "", wrong7 = "", correct8 = "", wrong8 = "", correct9 = "", wrong9 = "";

        if (radio1_1.isChecked()) {
            correct1 = "1. correct\n\n";
        } else {
            wrong1 = "1. Answer is wrong\n\n";
        }

        if (radio1_3.isChecked()) {
            correct2 = "2. correct\n\n";
        } else {
            wrong2 = "2. Answer is wrong\n\n";
        }

        if (radio1_6.isChecked()) {
            correct3 = "3. correct\n\n";
        } else {
            wrong3 = "3. Answer is wrong\n\n";
        }

        if (radio2_3.isChecked()) {
            correct4 = "4. correct\n\n";
        } else {
            wrong4 = "4. Wrong! answer is 'starts'\n\n";
        }

        if (radio2_6.isChecked()) {
            correct5 = "5. correct\n\n";
        } else {
            wrong5 = "5. Wrong! answer is 'help'\n\n";
        }

        if (radio2_9.isChecked()) {
            correct6 = "6. correct\n\n";
        } else {
            wrong6 = "6. Wrong! answer is 'He never wakes up late'\n\n";
        }


        if ((ed1.getText().toString().equals("Put out fire") || ed1.getText().toString().equals("Put out fire ")
                || ed1.getText().toString().equals("put out fire") || ed1.getText().toString().equals("put out fire ")
                || ed1.getText().toString().equals("Putting out fire") || ed1.getText().toString().equals("putting out fire"))) {
            correct7 = "7. correct\n\n";
        } else {
            wrong7 = "7. Wrong! answer is 'Putting out fire'\n\n";
        }


        if ((ed2.getText().toString().equals("Call the emergency") || ed2.getText().toString().equals("Call the emergency ")
                || ed2.getText().toString().equals("call the emergency") || ed2.getText().toString().equals("call the emergency "))
                || ed2.getText().toString().equals("Calling the emergency") || ed2.getText().toString().equals("calling the emergency")) {
            correct8 = "8. correct\n\n";
        } else {
            wrong8 = "8. Wrong! answer is 'Calling the emergency'\n\n";
        }


        if ((ed3.getText().toString().equals("Hire a taxi") || ed3.getText().toString().equals("Hire a taxi ")
                || ed3.getText().toString().equals("hire a taxi") || ed3.getText().toString().equals("hire a taxi "))
                || ed3.getText().toString().equals("Hiring a taxi") || ed3.getText().toString().equals("hiring a taxi")) {
            correct9 = "9. correct\n";
        } else {
            wrong9 = "9. Wrong! answer is 'Hiring a taxi'\n";
        }

        String data = correct1 + wrong1 + correct2 + wrong2 + correct3 + wrong3 + correct4 + wrong4
                + correct5 + wrong5 + correct6 + wrong6 + correct7 + wrong7 + correct8 + wrong8
                + correct9 + wrong9;

        tv2_result.setText(data);
        tv1_result.setText("Results");


        final AlertDialog dialog = new AlertDialog.Builder(Test4.this)
                .setCancelable(true)
                .setView(view)
                .create();

        dialog.show();


        if (cs == 5) {
            back.setBackgroundColor(getResources().getColor(R.color.dark));
            tv2_result.setTextColor(Color.WHITE);
            if (cc == 4) {
                tv2_result.setTextColor(Color.argb(255, 255, 121, 18));
            } else {
                tv2_result.setTextColor(Color.WHITE);
            }
        } else if (cs == 6) {
            back.setBackgroundColor(getResources().getColor(R.color.light));
        }


    }


}
