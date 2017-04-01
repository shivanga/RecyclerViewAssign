package com.shivang.recyclerviewassign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    public int countSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        countSelected=0;
        mAdapter = new MyAdapter(movieList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                if(movieList.get(position).isSelected()) {
                    movieList.get(position).setSelected(false);
                    countSelected--;
                }
                else
                {
                    movieList.get(position).setSelected(true);
                    countSelected++;
                }

                mAdapter.notifyItemChanged(position);
               // Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                if(movieList.get(position).isSelected()) {
                    movieList.get(position).setSelected(false);
                    countSelected--;
                }
                else
                {
                    movieList.get(position).setSelected(true);
                    countSelected++;
                }

                mAdapter.notifyItemChanged(position);
            }
        }));

        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure",false);
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family",false);
        movieList.add(movie);

        movie = new Movie("Star Wars: The Force Awakens", "Action",false);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation",false);
        movieList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy",false);
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action",false);
        movieList.add(movie);

        movie = new Movie("Up", "Animation",false);
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction",false);
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation",false);
        movieList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure",false);
        movieList.add(movie);

        movie = new Movie("Aliens", "Science Fiction",false);
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation",false);
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction",false);
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure",false);
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure",false);
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy",false);
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

    public void countSel(View v)
    {
        Toast.makeText(this, "No. of selected is "+countSelected, Toast.LENGTH_LONG).show();
    }

    public void selectAll(View v)
    {
        for (int i=0;i<mAdapter.getItemCount(); i++)
        {
            movieList.get(i).setSelected(true);
            mAdapter.notifyItemChanged(i);
        }
        countSelected=mAdapter.getItemCount();
    }


    public void deleteSelected(View v)
    {
        for (int i=mAdapter.getItemCount()-1; i>=0; i--)
        {
            if(movieList.get(i).isSelected()) {
                movieList.remove(i);
                countSelected--;
                mAdapter.notifyItemRemoved(i);
                mAdapter.notifyItemRangeChanged(i, movieList.size());
            }
        }
    }
}