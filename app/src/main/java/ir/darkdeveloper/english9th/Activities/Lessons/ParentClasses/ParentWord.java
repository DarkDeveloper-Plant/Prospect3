package ir.darkdeveloper.english9th.Activities.Lessons.ParentClasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ir.darkdeveloper.english9th.Activities.BasicActivities.AudioInit;
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
    private AudioInit audioInit;
    private DataRecyclerWords dataRecyclerWords;
    private String  activity;
    private ImageButton btnBack;
    private RecyclerView recyclerView;
    private int cs, ct;
    private RelativeLayout audioBack;
    private FloatingActionButton fabAudio;
    private TextView toggle_lan;
    private ImageView imgGuide;
    private int fileId;
    private boolean isToggled = true;

    private ParentWord(Context context, int fileId, String activity) {
        this.context = context;
        this.fileId = fileId;
        this.activity = activity;
    }

    /**
     * For Words1
     */
    public ParentWord(Context context, DataRecyclerWords1 dataRecyclerWords1,
                      int fileId, String activity) {
        this(context, fileId, activity);
        this.dataRecyclerWords = dataRecyclerWords1;
    }

    /**
     * For Words2
     */
    public ParentWord(Context context, DataRecyclerWords2 dataRecyclerWords2,
                      int fileId, String activity) {
        this(context, fileId, activity);
        this.dataRecyclerWords = dataRecyclerWords2;
    }

    /**
     * For Words3
     */
    public ParentWord(Context context, DataRecyclerWords3 dataRecyclerWords3,
                      int fileId, String activity) {
        this(context, fileId, activity);
        this.dataRecyclerWords = dataRecyclerWords3;
    }

    /**
     * For Words4
     */
    public ParentWord(Context context, DataRecyclerWords4 dataRecyclerWords4,
                      int fileId, String activity) {
        this(context, fileId, activity);
        this.dataRecyclerWords = dataRecyclerWords4;
    }

    /**
     * For Words5
     */
    public ParentWord(Context context, DataRecyclerWords5 dataRecyclerWords5,
                      int fileId, String activity) {
        this(context, fileId, activity);
        this.dataRecyclerWords = dataRecyclerWords5;
    }

    /**
     * For Words6
     */
    public ParentWord(Context context, DataRecyclerWords6 dataRecyclerWords6,
                      int fileId, String activity) {
        this(context, fileId, activity);
        this.dataRecyclerWords = dataRecyclerWords6;
    }


    @SuppressLint("SetTextI18n")
    public void initialize() {
        fabAudio = ((Activity) context).findViewById(R.id.fab_words);
        audioBack = ((Activity) context).findViewById(R.id.back_words);
        AppCompatSeekBar seekBar = ((Activity) context).findViewById(R.id.wordSeek);

        toggle_lan = ((Activity) context).findViewById(R.id.change_lang_tog);
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
        initAdapter(toggle_lan);
        //Initializing Audio with the custom AudioInit class

        Handler handler = new Handler();
        audioInit = new AudioInit(fabAudio, handler, seekBar, recyclerView, audioBack, context, fileId);
        audioInit.audio();
        imgGuide = ((Activity) context).findViewById(R.id.img_guide);
        helpInit();
    }

    private void helpInit() {
        // This is a custom class to indicate an animation to show the elements
        // and tells the user how to use them
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
            } else {
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
