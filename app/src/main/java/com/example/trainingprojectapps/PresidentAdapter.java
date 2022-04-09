package com.example.trainingprojectapps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingprojectapps.model.President;

import java.util.ArrayList;

interface OnItemClickListener {
    void onItemClick(President item);
}
public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder> {

    private ArrayList<President> data;
    private final OnItemClickListener listener;

    public PresidentAdapter(ArrayList<President> presidents, OnItemClickListener listener) {
        this.data = presidents;
        this.listener = listener;
    }


    @NonNull
    @Override
    public PresidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.president_item,parent,false);
        return new PresidentViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PresidentViewHolder holder, int position) {
        President president = data.get(position);
        holder.bind(president,listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}


class PresidentViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTextView,startTermTextView,endTermTextView;

    public PresidentViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.textview_president_name);
        startTermTextView = itemView.findViewById(R.id.textview_president_startterm);
        endTermTextView = itemView.findViewById(R.id.textview_president_endterm);
    }

    public void bind(final President item, final OnItemClickListener listener) {
        nameTextView.setText(item.getName());
        startTermTextView.setText(item.getTerm_began());
        endTermTextView.setText(item.getTerm_end());
        itemView.setOnClickListener(v -> listener.onItemClick(item));
    }
}
