package ir.darkdeveloper.english9th.Adapters.RecyclerAdapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import ir.darkdeveloper.english9th.Contacts.ContactRecyclerWords;
import ir.plant.english9th.R;

/**
 * Created by DarkDeveloper on 17/02/17.
 */

public class AdapterRecyclerWords extends RecyclerView.Adapter<AdapterRecyclerWords.onViewHolder> {
    private Context context;
    private List<ContactRecyclerWords> contactRecyclerWordsList;

    public AdapterRecyclerWords(Context context, List<ContactRecyclerWords> contactRecyclerWordsList){
        this.contactRecyclerWordsList = contactRecyclerWordsList;
        this.context = context;
    }

    @NonNull
    @Override
    public onViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_words, parent, false);
        return new onViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull onViewHolder holder, int position) {
        ContactRecyclerWords contactRecyclerWords = contactRecyclerWordsList.get(position);
        holder.textView.setText(contactRecyclerWords.name);
        holder.imageView.setImageResource(contactRecyclerWords.image);
        if (holder.cs == 5){
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.dark_card));
        }else if (holder.cs == 6){
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.light_card));
        }
    }

    @Override
    public int getItemCount() {
        return contactRecyclerWordsList.size();
    }

    class onViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        SharedPreferences color;
        int cs;
        CardView cardView;
        onViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_words);
            textView = itemView.findViewById(R.id.textView_words);
            color = context.getSharedPreferences("color?", Context.MODE_PRIVATE);
            cs = color.getInt("color??",4);
            cardView = itemView.findViewById(R.id.card_words);
        }
    }
}
