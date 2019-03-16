package com.dagf.dracoview;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.dagf.persoview.DrakAdapter;
import com.dagf.persoview.FliperAdapter;
import com.dagf.persoview.flipviewpager.utils.FlipSettings;
import com.dagf.persoview.models.Movie;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> juasjuas = new ArrayList<>();
    ArrayList<String> jsda = new ArrayList<>();
    FliperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        jsda.add("ANIMACIÓN");

        jsda.add("AVENTURA");

        jsda.add("FAMILIA");
        jsda.add("TERROR");
        jsda.add("DRAMA");
        jsda.add("OPERA");
        jsda.add("COMEDIA");
       // ListView rr = findViewById(R.id.idds);

        juasjuas = new ArrayList<>();

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



        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda, "KHE"));

        adapter = new FliperAdapter(this, juasjuas);


adapter.SetScrollListener(new FliperAdapter.ScrollCallbackFlip() {
    @Override
    public void onScrollEnded(int position) {
        if ((juasjuas.size() / 2) - 1 == position && !isr) {
            Log.e("MAIN", "SI VERGAAA "+position);
            onRefresh();
            isr = true;
        }
        Log.e("MAIN", "onScrollEnded: "+position);
    }
});

     //   rr.setAdapter(adapter);

         cc = findViewById(R.id.idds);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        cc.setLayoutManager(manager);

        cc.setAdapter(adapter);


    }

    private RecyclerView cc;

    private boolean isr;

    private void onRefresh() {
        juasjuas.add(seting(jsda, "LUEGITO WE"));
      //  adapter.notifyDataSetChanged();
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda));
        juasjuas.add(seting(jsda, "SIES"));
        //juasjuas.add(seting(jsda, "LAST"));
        Log.e("MAIN", "onRefresh: ESTOY AÑADIENDO");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("MAIN", "run: LISTO WE = "+adapter.getItemCount());
                      //  adapter.notifyDataSetChanged();
                        cc.getAdapter().notifyDataSetChanged();
                        isr = false;
                    }
                });

            }
        }, 10);

    }

    public Movie seting(ArrayList<String> jsda){
        Movie movie5 = new Movie();
        movie5.setName("four");
        movie5.setViews("5756");
        movie5.setOverview(getString(R.string.ov));
        movie5.setUrlImg("http://oyster.ignimgs.com/wordpress/stg.ign.com/2019/03/Avengers-Poster.jpg");
        movie5.setNameGenres(jsda);


        return movie5;
    }

    public Movie seting(ArrayList<String> jsda, String nam){
        Movie movie5 = new Movie();
        movie5.setName(nam);
        movie5.setViews("5756");
        movie5.setOverview(getString(R.string.ov));
        movie5.setUrlImg("http://oyster.ignimgs.com/wordpress/stg.ign.com/2019/03/Avengers-Poster.jpg");
        movie5.setNameGenres(jsda);


        return movie5;
    }

}
