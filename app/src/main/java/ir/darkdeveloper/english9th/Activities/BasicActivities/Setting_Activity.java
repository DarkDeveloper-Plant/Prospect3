package ir.darkdeveloper.english9th.Activities.BasicActivities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rey.material.widget.Slider;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import ir.darkdeveloper.english9th.Activities.BasicActivities.CrashHandler.CrashHandler;
import ir.plant.english9th.R;

public class Setting_Activity extends AppCompatActivity {
    @SuppressLint("StaticFieldLeak")
    public static Toolbar toolbar_sett;
    TextView sample, slider1_text, slider2_text;
    Slider slider, slider2;
    Button black, white, gray;
    int scolor1, scolor2, i_tran, save1, save1_1, ct, cc, cs, newVal, value1, ad;
    float value2;
    SharedPreferences.Editor editor1, editor2, editor3, editor_save1;
    SharedPreferences preferences1, preferences2, color1,
            color2, tran, save_shared1, sh_text, colorb1, colorb2;
    Button fa, en;
    SwitchCompat theme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            setContentView(R.layout.activity_setting);

            toolbar_sett = findViewById(R.id.setting_toolbar);
            setSupportActionBar(toolbar_sett);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            ini();
            onClick();
            save();

        } catch (Exception e) {
            e.printStackTrace();
            new CrashHandler().catchException(e, this);
            startActivity(new Intent("ir.darkdeveloper.english9th." +
                    "Activities.BasicActivities.CrashHandler.CrashHandling"));
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(Setting_Activity.this, MainActivity.class));
            finish();
        } else if (id == R.id.help_button) {
            new AlertDialog.Builder(Setting_Activity.this)
                    .setTitle("راهنما")
                    .setMessage("شما می توانید اندازه متن را از اسلایدر اول قسمت Text تغییر دهید.\n\n برای تنظیم فاصله خطوط متن می توانید از اسلایدر دوم قسمت Text استفاده کنید\n\n برای تغییر رنگ متن از دکمه های رنگی قسمت Text رنگ دلخواه خود را انتخاب کنید.\n\n برای تغییر تم برنامه نیز میتوانید از بخش Theme تم مورد نظر خود را انتخاب کنبد.\n\n برای اینکه زبان متن برنامه را در هر درس مشخص کنید از دکمه های بخش Text Language استفاده کنید. \n\n\n *دقت کنید که وقتی تم تاریک را انتخاب میکنید فقط دو رنگ برای متن موجود است که یکی نارنجی و دیگری سفید است. سفید به طور خودکار با انتخاب رنگ های دیگر در متن برنامه اعمال می شود. گزینه های فاصله و اندازه خطوط جنبه پیش نمایش دارند و دوباره به حالت پیشفرض بر میگردند. همچنین زبان فارسی در محتوای اصلی بخش های lrw و language melody و find it و بخش تست هر درس اعمال نمیشود، چون این مطالب هدفشان یادگیری بدون ترجمه است.")
                    .setPositiveButton("فهمیدم", (dialogInterface, i) -> {
                        return;
                    })
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Setting_Activity.this, MainActivity.class));
        finish();
    }


    private void save() {


        if (cc == 1) {
            sample.setTextColor(Color.BLACK);
        } else if (cc == 2) {
            sample.setTextColor(Color.WHITE);
        } else if (cc == 3) {
            sample.setTextColor(Color.GRAY);
        } else if (cc == 4) {
            sample.setTextColor(Color.argb(255, 255, 121, 18));

        }


        if (save1_1 == 0) {
            theme.setChecked(true);
        } else {
            theme.setChecked(false);
        }
        if (ct == 2) {
            sample.setText("متن\nمثال");
        } else if (ct == 1){
            sample.setText("Example\ntext");
        }


        /////A way for saving slider:  getting value of slider and displaying in a text view.

    }


    @SuppressLint("CommitPrefEdits")
    private void ini() {
        slider = findViewById(R.id.slider_textSettings);
        slider2 = findViewById(R.id.slider_textSettingsmargin);
        sample = findViewById(R.id.sample);
        black = findViewById(R.id.btn_black);
        white = findViewById(R.id.btn_white);
        gray = findViewById(R.id.btn_gray);
        theme = findViewById(R.id.theme_switch);
        theme.setChecked(false);
        SharedPreferences preferences = getSharedPreferences("checked", Context.MODE_PRIVATE);
        save1_1 = preferences.getInt("nchecked", 1);

        color1 = getSharedPreferences("color1", 0);
        editor1 = color1.edit();
        scolor1 = color1.getInt("color2", 0);

        color2 = getSharedPreferences("color?", MODE_PRIVATE);
        editor2 = color2.edit();
        scolor2 = color2.getInt("color??", 4);

        tran = getSharedPreferences("trans", 0);
        editor3 = tran.edit();
        i_tran = tran.getInt("transs", 1);

        save_shared1 = getSharedPreferences("checked", 0);
        editor_save1 = save_shared1.edit();
        save1 = save_shared1.getInt("nchecked", 1);

        sh_text = getSharedPreferences("trans", Context.MODE_PRIVATE);
        ct = sh_text.getInt("transs", 1);

        colorb1 = getSharedPreferences("color1", Context.MODE_PRIVATE);
        cc = colorb1.getInt("color2", 0);

        colorb2 = getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = colorb2.getInt("color??", 4);

        fa = findViewById(R.id.btn_persian);
        en = findViewById(R.id.btn_english);

    }

    public void onClick() {

        theme.setOnCheckedChangeListener((compoundButton, b) -> {


            if (!theme.isChecked()) {
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.light));
                editor_save1.putInt("nchecked", 1);
                editor2.putInt("color??", 6);
                editor2.apply();
                editor_save1.apply();

            } else if (theme.isChecked()) {
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.dark));
                editor_save1.putInt("nchecked", 0);
                editor2.putInt("color??", 5);
                editor2.apply();
                editor_save1.apply();
            }
        });

        black.setOnClickListener(view -> {

            sample.setTextColor(Color.BLACK);
            editor1.putInt("color2", 1);
            editor1.apply();
        });


        gray.setOnClickListener(view -> {

            sample.setTextColor(Color.GRAY);

            editor1.putInt("color2", 3);
            editor1.apply();
        });



        white.setOnClickListener(view -> {
            if (cs == 5 || cs == 6) {
                sample.setTextColor(Color.argb(255, 255, 121, 18));
            }
            editor1.putInt("color2", 4);
            editor1.apply();
        });


        en.setOnClickListener(view -> {
            editor3.putInt("transs", 1);
            Toast.makeText(Setting_Activity.this, "Text language is English.", Toast.LENGTH_SHORT).show();
            sample.setText("Example\ntext");
            editor3.apply();

        });

        fa.setOnClickListener(view -> {
            editor3.putInt("transs", 2);
            Toast.makeText(Setting_Activity.this, "زبان متن فارسی است", Toast.LENGTH_SHORT).show();
            sample.setText("متن\nمثال");
            editor3.apply();
        });


        slider.setOnPositionChangeListener((view, fromUser, oldPos, newPos, oldValue, newValue) -> {
            sample.setTextSize((float) newValue);
            SharedPreferences.Editor editor = getSharedPreferences("font_size", Context.MODE_PRIVATE).edit();
            editor.putInt("fontsize", newValue);
            editor.apply();

        });


        slider2.setOnPositionChangeListener((view, fromUser, oldPos, newPos, oldValue, newValue) -> {
            sample.setLineSpacing(45, oldPos);
            SharedPreferences.Editor editor = getSharedPreferences("font_margin", Context.MODE_PRIVATE).edit();
            editor.putFloat("fontmargin", newPos);
            editor.apply();
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prAd = getSharedPreferences("ad", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorAd = prAd.edit();
        editorAd.putBoolean("isAdOpen", true);
        editorAd.apply();
    }
}
