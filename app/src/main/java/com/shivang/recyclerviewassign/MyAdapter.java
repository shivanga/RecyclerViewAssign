package com.shivang.recyclerviewassign;

/**
 * Created by sa on 3/27/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public CheckBox checkBox;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            checkBox=(CheckBox)view.findViewById(R.id.checkbox);
        }
    }


    public MyAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final int pos = position;

        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
       holder.checkBox.setChecked(moviesList.get(position).isSelected());
    }
    /*  public void selectAll(){
        isSelectedAll = true;
        notifyDataSetChanged();
    }

    /*public void removeItem(int position)
    {
        moviesList.remove(position);
        notifyItemRemoved(position);

        notifyItemRangeChanged(position, moviesList.size());
    }
    */
    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}