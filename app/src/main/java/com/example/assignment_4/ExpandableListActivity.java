package com.example.assignment_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> groupData;
    HashMap<String, List<String>> childData;
    int lastExpandedGroup = -1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);

        btn = findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpandableListActivity.this, GenreActivity.class);
                startActivity(intent);  // Start the new activity
            }
        });

        expandableListView = findViewById(R.id.expandableListView);

        prepareData(); // Method to prepare the group and child data

        // Create and set the Expandable List adapter for the ExpandableListView
        ExpandableListAdapter adapter = new ExpandableListAdapter(this, groupData, childData);
        expandableListView.setAdapter(adapter);

        // Group click listener (to show the group name in a toast)
        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            String groupText = groupData.get(groupPosition);
            Toast.makeText(getApplicationContext(), groupText, Toast.LENGTH_SHORT).show();
            return false;
        });

        // Group collapse listener (to show which group was collapsed)
        expandableListView.setOnGroupCollapseListener(groupPosition -> {
            String groupText = groupData.get(groupPosition);
            Toast.makeText(getApplicationContext(), groupText + " is Collapsed", Toast.LENGTH_SHORT).show();
        });

        // Child click listener (to show the child name in a toast)
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String childText = childData.get(groupData.get(groupPosition)).get(childPosition);
            Toast.makeText(getApplicationContext(), childText, Toast.LENGTH_SHORT).show();
            return false;
        });

        // Group expand listener (to collapse previously expanded group)
        expandableListView.setOnGroupExpandListener(groupPosition -> {
            if (lastExpandedGroup != -1 && lastExpandedGroup != groupPosition) {
                expandableListView.collapseGroup(lastExpandedGroup);
            }
            lastExpandedGroup = groupPosition;
        });
    }

    // Prepare data for movie genres (groups) and movies (children)
    private void prepareData() {
        // Movie genres data
        String[] genreArray = getResources().getStringArray(R.array.movie_genres);

        // Movie lists for each genre
        String[] actionMovies = getResources().getStringArray(R.array.action_movies);
        String[] comedyMovies = getResources().getStringArray(R.array.comedy_movies);
        String[] dramaMovies = getResources().getStringArray(R.array.drama_movies);
        String[] horrorMovies = getResources().getStringArray(R.array.horror_movies);
        String[] thrillerMovies = getResources().getStringArray(R.array.thriller_movies);
        String[] sciFiMovies = getResources().getStringArray(R.array.science_fiction_movies);

        groupData = new ArrayList<>();
        childData = new HashMap<>();

        // Add genres and corresponding movie lists
        for (String genre : genreArray) {
            groupData.add(genre);
            List<String> movieList = new ArrayList<>();

            // Add movies for each genre
            switch (genre) {
                case "Action":
                    for (String movie : actionMovies) {
                        movieList.add(movie);
                    }
                    break;
                case "Comedy":
                    for (String movie : comedyMovies) {
                        movieList.add(movie);
                    }
                    break;
                case "Drama":
                    for (String movie : dramaMovies) {
                        movieList.add(movie);
                    }
                    break;
                case "Horror":
                    for (String movie : horrorMovies) {
                        movieList.add(movie);
                    }
                    break;
                case "Thriller":
                    for (String movie : thrillerMovies) {
                        movieList.add(movie);
                    }
                    break;
                case "Science-Fiction":
                    for (String movie : sciFiMovies) {
                        movieList.add(movie);
                    }
                    break;
            }

            // Put the movie list under the genre
            childData.put(genre, movieList);
        }
    }
}
