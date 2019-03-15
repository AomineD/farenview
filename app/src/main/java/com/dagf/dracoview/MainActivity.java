package com.dagf.dracoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.dagf.persoview.DrakAdapter;
import com.dagf.persoview.FliperAdapter;
import com.dagf.persoview.flipviewpager.utils.FlipSettings;
import com.dagf.persoview.models.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> jsda = new ArrayList<>();

        jsda.add("ANIMACIÓN");

        jsda.add("AVENTURA");

        jsda.add("FAMILIA");
        jsda.add("TERROR");
        jsda.add("DRAMA");
        jsda.add("OPERA");
        jsda.add("COMEDIA");
       // ListView rr = findViewById(R.id.idds);

        ArrayList<Movie> juasjuas = new ArrayList<>();

        Movie movie = new Movie();
        movie.setName("AJAJAJ");
        movie.setOverview(getString(R.string.ov));
        movie.setNameGenres(jsda);
movie.setViews("842");
movie.setUrlImg("https://s.abcnews.com/images/GMA/avengers-endgame-01-ht-jc-181207_hpMain_16x9_608.jpg");

        juasjuas.add(movie);

        Movie movie1 = new Movie();
        movie1.setName("Tiau");
        movie1.setViews("5756");
        movie1.setOverview(getString(R.string.ov));
        movie1.setUrlImg("http://oyster.ignimgs.com/wordpress/stg.ign.com/2019/03/Avengers-Poster.jpg");
        movie1.setNameGenres(jsda);

        juasjuas.add(movie1);

        Movie movie2 = new Movie();
        movie2.setName("Tiaus");
        movie2.setViews("5756");
        movie2.setOverview(getString(R.string.ov));
        movie2.setUrlImg("http://oyster.ignimgs.com/wordpress/stg.ign.com/2019/03/Avengers-Poster.jpg");
movie2.setNameGenres(jsda);

        juasjuas.add(movie2);


        Movie movie3 = new Movie();
        movie3.setName("Tiau");
        movie3.setViews("5756");
        movie3.setOverview(getString(R.string.ov));
        movie3.setUrlImg("http://oyster.ignimgs.com/wordpress/stg.ign.com/2019/03/Avengers-Poster.jpg");
movie3.setNameGenres(jsda);

        juasjuas.add(movie3);

        Movie movie4 = new Movie();
        movie4.setName("four");
        movie4.setViews("5756");
        movie4.setOverview(getString(R.string.ov));
        movie4.setUrlImg("http://oyster.ignimgs.com/wordpress/stg.ign.com/2019/03/Avengers-Poster.jpg");
movie4.setNameGenres(jsda);

        juasjuas.add(movie4);

        FliperAdapter adapter = new FliperAdapter(this, juasjuas);



     //   rr.setAdapter(adapter);

        RecyclerView cc = findViewById(R.id.idds);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        cc.setLayoutManager(manager);

        cc.setAdapter(adapter);


    }
}
