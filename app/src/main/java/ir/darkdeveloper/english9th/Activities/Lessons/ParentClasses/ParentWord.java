package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.darkdeveloper.english9th.Activities.BasicActivities.AudioInit.AudioWords;
import ir.darkdeveloper.english9th.Adapters.RecyclerAdapters.AdapterRecyclerWords;
import ir.darkdeveloper.english9th.Contacts.ContactRecyclerWords;
import ir.darkdeveloper.english9th.Data.Words.DataRecyclerWords;
import ir.darkdeveloper.english9th.Data.Words.DataRecyclerWords1;
import ir.darkdeveloper.english9th.Data.Words.DataRecyclerWords2;
import ir.darkdeveloper.english9th.Data.Words.DataRecyclerWords3;
import ir.darkdeveloper.english9th.Data.Words.DataRecyclerWords4;
import ir.darkdeveloper.english9th.Data.Words.DataRecyclerWords5;
import ir.darkdeveloper.english9th.Data.Words.DataRecyclerWords6;
import ir.plant.english9th.R;

public class ParentWord {

    private Context context;
    private List<ContactRecyclerWords> contactRecyclerWordses = new ArrayList<>();
    private AudioWords audioInit;
    private DataRecyclerWords dataRecyclerWords;
    private String fileName, activity;
    private ImageButton btnBack;
    private RecyclerView recyclerView;
    private int cs, ct;
    private LinearLayout audioBack;
    private boolean isToggled = true;

    private ParentWord(Context context, String fileName, String activity) {
        this.context = context;
        this.fileName = fileName;
        this.activity = activity;
    }

    /**
     * For Words1
     */
    public ParentWord(Context context, DataRecyclerWords1 dataRecyclerWords1,
                      String fileName, String activity) {
        this(context, fileName, activity);
        this.dataRecyclerWords = dataRecyclerWords1;
    }

    /**
     * For Words2
     */
    public ParentWord(Context context, DataRecyclerWords2 dataRecyclerWords2,
                      String fileName, String activity) {
        this(context, fileName, activity);
        this.dataRecyclerWords = dataRecyclerWords2;
    }

    /**
     * For Words3
     */
    public ParentWord(Context context, DataRecyclerWords3 dataRecyclerWords3,
                      String fileName, String activity) {
        this(context, fileName, activity);
        this.dataRecyclerWords = dataRecyclerWords3;
    }

    /**
     * For Words4
     */
    public ParentWord(Context context, DataRecyclerWords4 dataRecyclerWords4,
                      String fileName, String activity) {
        this(context, fileName, activity);
        this.dataRecyclerWords = dataRecyclerWords4;
    }

    /**
     * For Words5
     */
    public ParentWord(Context context, DataRecyclerWords5 dataRecyclerWords5,
                      String fileName, String activity) {
        this(context, fileName, activity);
        this.dataRecyclerWords = dataRecyclerWords5;
    }

    /**
     * For Words6
     */
    public ParentWord(Context context, DataRecyclerWords6 dataRecyclerWords6,
                      String fileName, String activity) {
        this(context, fileName, activity);
        this.dataRecyclerWords = dataRecyclerWords6;
    }


    @SuppressLint("SetTextI18n")
    public void initialize() {
        FloatingActionButton fab = ((Activity) context).findViewById(R.id.fab_words);
        audioBack = ((Activity) context).findViewById(R.id.back_words);
        AppCompatSeekBar seekBar = ((Activity) context).findViewById(R.id.wordSeek);

        TextView toggle = ((Activity) context).findViewById(R.id.change_lang_tog);
        TextView toolbarText = ((Activity) context).findViewById(R.id.toolbar_text_p);
        btnBack = ((Activity) context).findViewById(R.id.menu_button_p);
        toolbarText.setText("Words");
        SharedPreferences sh_text = context.getSharedPreferences("trans", Context.MODE_PRIVATE);
        ct = sh_text.getInt("transs", 1);
        SharedPreferences color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
        cs = color.getInt("color??", 4);
        recyclerView = ((Activity) context).findViewById(R.id.recyclerView_words);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(llm);
        initAdapter(toggle);
        audioInit = new AudioWords(fab, seekBar, recyclerView, audioBack, context, fileName);
        audioInit.audio();
    }

    @SuppressLint("SetTextI18n")
    private void initAdapter(TextView toggle) {
        List<ContactRecyclerWords> listContact = new ArrayList<>();
        int length = dataRecyclerWords.getEsm().length;
        for (int i = 0; i < length; i++) {
            ContactRecyclerWords crw = new ContactRecyclerWords();
            if (ct == 2) {
                crw.name = dataRecyclerWords.getEsm_f()[i];
                isToggled = false;
                toggle.setText("en");
            } else if (ct == 1) {
                crw.name = dataRecyclerWords.getEsm()[i];
                toggle.setText("fa");
                isToggled = true;
            }
            crw.image = dataRecyclerWords.getAks()[i];
            listContact.add(crw);

            contactRecyclerWordses.add(listContact.get(i));
        }

        AdapterRecyclerWords s = new AdapterRecyclerWords(context, contactRecyclerWordses);

        toggle.setOnClickListener(v -> {
            listContact.clear();
            contactRecyclerWordses.clear();
            if (isToggled) {
                isToggled = false;
                toggle.setText("en");
                for (int i = 0; i < length; i++) {
                    ContactRecyclerWords crw = new ContactRecyclerWords();
                    crw.name = dataRecyclerWords.getEsm_f()[i];
                    crw.image = dataRecyclerWords.getAks()[i];
                    listContact.add(crw);

                    contactRecyclerWordses.add(listContact.get(i));
                }
            }else {
                isToggled = true;
                toggle.setText("fa");
                for (int i = 0; i < length; i++) {
                    ContactRecyclerWords crw = new ContactRecyclerWords();
                    crw.name = dataRecyclerWords.getEsm()[i];
                    crw.image = dataRecyclerWords.getAks()[i];
                    listContact.add(crw);

                    contactRecyclerWordses.add(listContact.get(i));
                }
            }
            s.notifyDataSetChanged();
        });

        recyclerView.setAdapter(s);

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
    }


    /**
     * Before invoking this function, invoke initialize() method
     */
    public void sets() {
        if (cs == 5) {
            recyclerView.setBackgroundColor(context.getResources().getColor(R.color.dark));
            audioBack.setBackgroundColor(context.getResources().getColor(R.color.dark));
        } else if (cs == 6) {
            recyclerView.setBackgroundColor(context.getResources().getColor(R.color.light));
            audioBack.setBackgroundColor(context.getResources().getColor(R.color.light));
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