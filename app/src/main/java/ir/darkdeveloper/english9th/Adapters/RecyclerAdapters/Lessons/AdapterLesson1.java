package ir.darkdeveloper.english9th.Adapters.RecyclerAdapters.Lessons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities.Conversation;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities.Words;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities.EWords;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities.FindIt;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities.Grammar;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities.LRW;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Activities.LanguageMelody;
import ir.darkdeveloper.english9th.Contacts.ContactLessons;
import ir.plant.english9th.R;


public class AdapterLesson1 extends RecyclerView.Adapter<AdapterLesson1.onViewHolder> {
    private List<ContactLessons> lessonsList;
    public Context context;
    public View view;

    public AdapterLesson1(Context context, List<ContactLessons> lessonsList) {
        this.lessonsList = lessonsList;
        this.context = context;
    }




    @NonNull
    @Override
    public onViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_lessons, parent, false);
        return new onViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final onViewHolder holder, final int position) {
        final ContactLessons contactLessons = lessonsList.get(position);
        holder.textView1.setText(contactLessons.name);
        holder.textView2.setText(contactLessons.fileName);
        if (holder.cs == 5){
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.dark));
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
        }else if (holder.cs == 6){
            holder.relativeLayout.setBackgroundColor(context.getResources().getColor(R.color.light));
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
        }
        holder.cardView.setOnClickListener(v -> {
            switch (position) {
                case 0:
                    Intent Conversation = new Intent(context, Conversation.class);
                    v.getContext().startActivity(Conversation);
                    ((Activity) v.getContext()).finish();
                    break;
                case 1:
                    Intent Words = new Intent(context, Words.class);
                    v.getContext().startActivity(Words);
                    ((Activity) v.getContext()).finish();
                    break;
                case 2:
                    Intent LanguageMelody = new Intent(context, LanguageMelody.class);
                    v.getContext().startActivity(LanguageMelody);
                    ((Activity) v.getContext()).finish();
                    break;
                case 3:
                    Intent Grammar = new Intent(context, Grammar.class);
                    v.getContext().startActivity(Grammar);
                    ((Activity) v.getContext()).finish();
                    break;
                case 4:
                    Intent FindIt = new Intent(context, FindIt.class);
                    v.getContext().startActivity(FindIt);
                    ((Activity) v.getContext()).finish();
                    break;
                case 5:
                    Intent LRW = new Intent(context, LRW.class);
                    v.getContext().startActivity(LRW);
                    ((Activity) v.getContext()).finish();
                    break;
                case 6:
                    Intent Ewords = new Intent(context, EWords.class);
                    v.getContext().startActivity(Ewords);
                    ((Activity) v.getContext()).finish();
                    break;
            }
        });


    }

    @Override
    public int getItemCount() {
        return lessonsList.size();
    }



    class onViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        RelativeLayout relativeLayout;
        SharedPreferences color;
        int cs ;
        CardView cardView;
        onViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.name);
            relativeLayout = itemView.findViewById(R.id.back_lessons);
            textView2 = itemView.findViewById(R.id.fileName);
            color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
            cs = color.getInt("color??",4);
            cardView = itemView.findViewById(R.id.card_ls);
        }
    }
}
