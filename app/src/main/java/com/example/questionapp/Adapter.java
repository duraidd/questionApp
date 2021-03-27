package com.example.questionapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<Model> list;
    Context context;
    int FLAG = 1;

    int mExpandedPosition = -1 , previousExpandedPosition = -1;

    public Adapter(List<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = list.get(position);
        holder.question.setText(model.getQuestion());
        holder.answer.setText("\t\t\t"+ model.getAnswer());

        final boolean isExpanded = position==mExpandedPosition;
        holder.layout.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);

        if (isExpanded)
            previousExpandedPosition = position;

        if (holder.layout.getVisibility() == View.VISIBLE){
            holder.viewAnswer.setVisibility(View.GONE);
        }else {
            holder.viewAnswer.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        TextView answer;
        TextView viewAnswer, hideAnswer;
        LinearLayout layout;

        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.questionTextId);
            answer = itemView.findViewById(R.id.answerTextId);
            viewAnswer = itemView.findViewById(R.id.view_answerId);
            layout = itemView.findViewById(R.id.layoutId);
            hideAnswer = itemView.findViewById(R.id.hide_answer);
            cardView = itemView.findViewById(R.id.myCardViewId);
        }
    }
}
