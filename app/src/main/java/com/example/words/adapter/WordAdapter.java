package com.example.words.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.words.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    List<String> filteredWords;

    public WordAdapter(Context context) {
        String[] array = context.getResources().getStringArray(R.array.words);
        List<String> words = Arrays.asList(array);
        filteredWords = words;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String item = filteredWords.get(position);
        holder.button.setText(item);
    }

    @Override
    public int getItemCount() {
        return filteredWords.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button_item);
        }
    }
}
