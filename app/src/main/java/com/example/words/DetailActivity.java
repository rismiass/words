package com.example.words;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.words.adapter.WordAdapter;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String letter = getIntent().getStringExtra("letter").toLowerCase(Locale.ROOT);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new WordAdapter(this, letter));
    }
}