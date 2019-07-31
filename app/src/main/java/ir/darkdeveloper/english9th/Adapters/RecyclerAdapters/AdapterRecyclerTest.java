package ir.darkdeveloper.english9th.Adapters.RecyclerAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import ir.darkdeveloper.english9th.Activities.BasicActivities.Background;
import ir.darkdeveloper.english9th.Activities.Lessons.Tests.Test1;
import ir.darkdeveloper.english9th.Activities.Lessons.Tests.Test2;
import ir.darkdeveloper.english9th.Activities.Lessons.Tests.Test3;
import ir.darkdeveloper.english9th.Activities.Lessons.Tests.Test4;
import ir.darkdeveloper.english9th.Activities.Lessons.Tests.Test5;
import ir.darkdeveloper.english9th.Activities.Lessons.Tests.Test6;
import ir.darkdeveloper.english9th.Contacts.ContactRecyclerTest;
import ir.plant.english9th.R;

/**
 * Created by darkdeveloper on 11/14/17.
 */

public class AdapterRecyclerTest extends RecyclerView.Adapter<AdapterRecyclerTest.onViewHolder> {
    private List<ContactRecyclerTest> contactRecyclerMains;
    public Context context;
    public View view;

    public AdapterRecyclerTest(Context context, List<ContactRecyclerTest> contactRecyclerMains) {
        this.contactRecyclerMains = contactRecyclerMains;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterRecyclerTest.onViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_test, parent, false);
        return new AdapterRecyclerTest.onViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterRecyclerTest.onViewHolder holder, final int position) {
        final ContactRecyclerTest contactRecyclerMain = contactRecyclerMains.get(position);
        holder.textView1.setText(contactRecyclerMain.text_main);
        Background backgroundPainter1 = new Background();
        int color1_1 = ContextCompat.getColor(context, R.color.colorblack);
        int color1_2 = ContextCompat.getColor(context, R.color.colorwhite);
        backgroundPainter1.animate(holder.relativeLayout, color1_1, color1_2);
        holder.cardView.setOnClickListener(v -> {
            switch (position) {
                case 0:
                    Intent lesson1 = new Intent(context, Test1.class);
                    v.getContext().startActivity(lesson1);
                    break;
                case 1:
                    Intent lesson2 = new Intent(context, Test2.class);
                    v.getContext().startActivity(lesson2);
                    break;
                case 2:
                    Intent lesson3 = new Intent(context, Test3.class);
                    v.getContext().startActivity(lesson3);
                    break;
                case 3:
                    Intent lesson4 = new Intent(context, Test4.class);
                    v.getContext().startActivity(lesson4);
                    break;
                case 4:
                    Intent lesson5 = new Intent(context, Test5.class);
                    v.getContext().startActivity(lesson5);
                    break;
                case 5:
                    Intent lesson6 = new Intent(context, Test6.class);
                    v.getContext().startActivity(lesson6);
                    break;
            }
        });


    }

    @Override
    public int getItemCount() {
        return contactRecyclerMains.size();
    }



    class onViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        CardView cardView;
        RelativeLayout relativeLayout;
        onViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.txt_test);
            cardView = itemView.findViewById(R.id.card_test);
            relativeLayout = itemView.findViewById(R.id.relative_test);
        }
    }


}
