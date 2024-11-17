package com.example.assignment_4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GenreAdapter extends BaseAdapter {
    String[] genres;
    String[] actionMovies;
    String[] comedyMovies;
    String[] dramaMovies;
    String[] horrorMovies;
    String[] thrillerMovies;
    String[] sciFiMovies;
    Integer[] img;
    Context context;

    public GenreAdapter(Context context, String[] genres, String[] actionMovies, String[] comedyMovies, String[] dramaMovies, String[] horrorMovies,
                        String[] thrillerMovies, String[] sciFiMovies, Integer[] img) {
        this.context = context;
        this.genres = genres;
        this.actionMovies = actionMovies;
        this.comedyMovies = comedyMovies;
        this.dramaMovies = dramaMovies;
        this.horrorMovies = horrorMovies;
        this.thrillerMovies = thrillerMovies;
        this.sciFiMovies = sciFiMovies;
        this.img = img;
    }

    @Override
    public int getCount() {
        return genres.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.genre_view, parent, false);
        }

        // Get the views
        TextView title = convertView.findViewById(R.id.title);
        TextView subtitle1 = convertView.findViewById(R.id.subtitle1);
        TextView subtitle2 = convertView.findViewById(R.id.subtitle2);
        TextView subtitle3 = convertView.findViewById(R.id.subtitle3);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        // Set genre title
        title.setText(genres[position]);

        // Set subtitles based on genre
        switch (genres[position]) {
            case "Action":
                subtitle1.setText(actionMovies[0]);
                subtitle2.setText(actionMovies[1]);
                subtitle3.setText(actionMovies[2]);
                break;
            case "Comedy":
                subtitle1.setText(comedyMovies[0]);
                subtitle2.setText(comedyMovies[1]);
                subtitle3.setText(comedyMovies[2]);
                break;
            case "Drama":
                subtitle1.setText(dramaMovies[0]);
                subtitle2.setText(dramaMovies[1]);
                subtitle3.setText(dramaMovies[2]);
                break;
            case "Horror":
                subtitle1.setText(horrorMovies[0]);
                subtitle2.setText(horrorMovies[1]);
                subtitle3.setText(horrorMovies[2]);
                break;
            case "Thriller":
                subtitle1.setText(thrillerMovies[0]);
                subtitle2.setText(thrillerMovies[1]);
                subtitle3.setText(thrillerMovies[2]);
                break;
            case "Science-Fiction":
                subtitle1.setText(sciFiMovies[0]);
                subtitle2.setText(sciFiMovies[1]);
                subtitle3.setText(sciFiMovies[2]);
                break;
        }

        // Set image resource
        imageView.setImageResource(img[position]);

        return convertView;
    }
}
