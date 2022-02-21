package com.example.words.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.words.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    List<String> filteredWords;

    public WordAdapter(Context context, String letter) {
        filteredWords = new ArrayList<>();

        String[] array = context.getResources().getStringArray(R.array.words);
        filteredWords = Arrays.stream(array)
                .filter(s->s.startsWith(letter))
                .collect(Collectors.toList());
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
        holder.button.setOnClickListener((view)-> {
            Uri uri = Uri.parse("https://yandex.ru/search/?text=" + item);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            holder.button.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return filteredWords.size();
    }

    static class WordViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button_item);
        }
    }
}
