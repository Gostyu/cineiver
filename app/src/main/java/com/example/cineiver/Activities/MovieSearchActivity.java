package com.example.cineiver.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cineiver.R;
import com.example.cineiver.model.Movie;
import com.example.cineiver.utils.ActivityDataHandler;
import com.example.cineiver.viewmodels.MovieSearchViewModel;

public class MovieSearchActivity extends AppCompatActivity {
    EditText movieEditText;
    //MovieSearchViewModel movieSearchViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);
        movieEditText=findViewById(R.id.movieEditText);
       /* movieEditText.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEARCH) {

                return true;
            }
            return false;
        });*/
    }

}