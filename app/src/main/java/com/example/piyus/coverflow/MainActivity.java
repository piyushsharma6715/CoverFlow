package com.example.piyus.coverflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private MovieAdapter movieAdapter;
    private List<Movie> MovieList = new ArrayList<>();
    private TextSwitcher mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mTitle = (TextSwitcher)findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView txt = (TextView)inflater.inflate(R.layout.layout_title,null);
                return txt;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        movieAdapter = new MovieAdapter(MovieList,this);
        coverFlow = (FeatureCoverFlow)findViewById(R.id.coverFlow);
        coverFlow.setAdapter(movieAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(MovieList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });
    }

    private void initData() {
        MovieList.add(new Movie("IRON MAN","https://media1.tenor.com/images/80eb9c353ee40c8abf95e508bf8ce3ea/tenor.gif?itemid=7371460"));
        MovieList.add(new Movie("INCREDIBLE HULK","https://vignette.wikia.nocookie.net/marveldatabase/images/7/7f/Bruce_Banner_%28Earth-TRN517%29_from_Marvel_Contest_of_Champions_001.png/revision/latest?cb=20150210033450"));
        MovieList.add(new Movie("IRON MAN 2","https://cdn-ssl.s7.shop.marvel.com/is/image/MarvelStore/7745055551383?$yetidetail$"));
        MovieList.add(new Movie("THOR","https://static0.srcdn.com/wordpress/wp-content/uploads/2017/02/Thor-The-Dark-World-Convergence.jpg"));
        MovieList.add(new Movie("CAPTAIN AMERICA:THE FIRST AVENGER","data:image/jpeg;base64,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"));
        MovieList.add(new Movie("THE AVENGERS","https://www.screengeek.net/wp-content/uploads/2017/04/avengers-4.png"));


        /*MovieList.add(new Movie("IRON MAN 3",""));
        MovieList.add(new Movie("THOR: THE DARK WORLD ",""));
        MovieList.add(new Movie("WINTER SOLDIER",""));
        MovieList.add(new Movie("GUARDIAN OF THE GALAXY",""));
        MovieList.add(new Movie("IRON MAN",""));
        MovieList.add(new Movie("IRON MAN",""));

        MovieList.add(new Movie("IRON MAN",""));
        MovieList.add(new Movie("IRON MAN",""));
        MovieList.add(new Movie("IRON MAN",""));
        MovieList.add(new Movie("IRON MAN",""));
        MovieList.add(new Movie("IRON MAN",""));
        MovieList.add(new Movie("IRON MAN",""));
        MovieList.add(new Movie("IRON MAN",""));
*/
    }
}