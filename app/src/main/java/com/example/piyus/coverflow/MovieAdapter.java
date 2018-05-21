package com.example.piyus.coverflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends BaseAdapter {
    private List<Movie> MovieList;
    private Context mContext;

    public MovieAdapter(List<Movie> movieList, Context mContext) {
        MovieList = movieList;
        this.mContext = mContext;
    }



    @Override
    public int getCount() {
        return MovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return MovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView=convertView;
        if(rowView == null){
            rowView = LayoutInflater.from(mContext).inflate(R.layout.layout_item,null);
            TextView name=rowView.findViewById(R.id.label);
            ImageView imageView=rowView.findViewById(R.id.image);

            //setData
            Picasso.with(mContext).load(MovieList.get(position).getImageUrl()).into(imageView);
            name.setText(MovieList.get(position).getName());


        }
        return rowView;

    }
}
