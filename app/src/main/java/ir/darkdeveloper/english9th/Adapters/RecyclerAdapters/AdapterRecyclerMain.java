package ir.darkdeveloper.english9th.Adapters.RecyclerAdapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson1.Lesson1;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson2.Lesson2;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson3.Lesson3;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson4.Lesson4;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson5.Lesson5;
import ir.darkdeveloper.english9th.Activities.Lessons.Lesson6.Lesson6;
import ir.darkdeveloper.english9th.Contacts.ContactRecyclerMain;
import ir.plant.english9th.R;


public class AdapterRecyclerMain extends RecyclerView.Adapter<AdapterRecyclerMain.onViewHolder> {
    private List<ContactRecyclerMain> contactRecyclerMains;
    public Context context;
    public View view;

    public AdapterRecyclerMain(Context context, List<ContactRecyclerMain> contactRecyclerMains) {
        this.contactRecyclerMains = contactRecyclerMains;
        this.context = context;
    }


    @NonNull
    @Override
    public onViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_main, parent, false);
        return new onViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final onViewHolder holder, final int position) {
        final ContactRecyclerMain contactRecyclerMain = contactRecyclerMains.get(position);
        holder.textView1.setText(contactRecyclerMain.text_main);
        holder.textView2.setText(contactRecyclerMain.text_main2);
        holder.imageView1.setImageResource(contactRecyclerMain.image_main);
        if (holder.cs == 5) {
            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.dark));
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
            holder.textView1.setTextColor(Color.WHITE);
            holder.textView2.setTextColor(Color.WHITE);
        } else if (holder.cs == 6) {
            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.light));
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
            holder.textView1.setTextColor(Color.BLACK);
            holder.textView2.setTextColor(Color.BLACK);
        }

        holder.relativeLayout1.setOnClickListener(v -> {
            if (holder.ps.getBoolean("granted?", false)) {
                switch (position) {
                    case 0:
                        Intent lesson1 = new Intent(context, Lesson1.class);
                        v.getContext().startActivity(lesson1);
                        ((Activity) v.getContext()).finish();
                        break;
                    case 1:
                        Intent lesson2 = new Intent(context, Lesson2.class);
                        v.getContext().startActivity(lesson2);
                        ((Activity) v.getContext()).finish();
                        break;
                    case 2:
                        Intent lesson3 = new Intent(context, Lesson3.class);
                        v.getContext().startActivity(lesson3);
                        ((Activity) v.getContext()).finish();
                        break;
                    case 3:
                        Intent lesson4 = new Intent(context, Lesson4.class);
                        v.getContext().startActivity(lesson4);
                        ((Activity) v.getContext()).finish();
                        break;
                    case 4:
                        Intent lesson5 = new Intent(context, Lesson5.class);
                        v.getContext().startActivity(lesson5);
                        ((Activity) v.getContext()).finish();
                        break;
                    case 5:
                        Intent lesson6 = new Intent(context, Lesson6.class);
                        v.getContext().startActivity(lesson6);
                        ((Activity) v.getContext()).finish();
                        break;
                }
            } else {
                Toast.makeText(context, "دسترسی ها را به نرم افزار بدهید",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return contactRecyclerMains.size();
    }


    class onViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        ImageView imageView1;
        RelativeLayout relativeLayout1;
        LinearLayout linearLayout;
        SharedPreferences color, ps;
        int cs;
        CardView cardView;

        onViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView_main);
            imageView1 = itemView.findViewById(R.id.imageView_main);
            relativeLayout1 = itemView.findViewById(R.id.Rl_main);
            linearLayout = itemView.findViewById(R.id.ll_main);
            textView2 = itemView.findViewById(R.id.textView1_main);
            color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
            cs = color.getInt("color??", 4);
            ps = context.getSharedPreferences("permission", Context.MODE_PRIVATE);
            cardView = itemView.findViewById(R.id.card_main);
        }
    }
}
