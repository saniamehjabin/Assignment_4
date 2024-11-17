package com.example.assignment_4;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class GenreActivity extends AppCompatActivity {

    ListView listView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        listView = findViewById(R.id.listView);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GenreActivity.this, ExpandableListActivity.class);
                startActivity(intent);
            }
        });

        // Genre strings
        String[] genres = getResources().getStringArray(R.array.movie_genres);

        // Subgenres/movies based on genre
        String[] actionMovies = getResources().getStringArray(R.array.action_movies);
        String[] comedyMovies = getResources().getStringArray(R.array.comedy_movies);
        String[] dramaMovies = getResources().getStringArray(R.array.drama_movies);
        String[] horrorMovies = getResources().getStringArray(R.array.horror_movies);
        String[] thrillerMovies = getResources().getStringArray(R.array.thriller_movies);
        String[] sciFiMovies = getResources().getStringArray(R.array.science_fiction_movies);

        // Image resources for the genres
        Integer[] imgId = {
                R.drawable.action_icon,
                R.drawable.comedy_icon,
                R.drawable.drama_icon,
                R.drawable.horror_icon,
                R.drawable.thriller_icon,
                R.drawable.science_fiction_icon
        };

        // Set the adapter for the list view
        GenreAdapter adapter = new GenreAdapter(this, genres, actionMovies, comedyMovies, dramaMovies, horrorMovies, thrillerMovies, sciFiMovies, imgId);
        listView.setAdapter(adapter);
    }
}
