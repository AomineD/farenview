package com.dagf.persoview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.DrawerTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ScaleInOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutTransformer;
import com.dagf.persoview.models.Movie;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class FliperAdapter extends RecyclerView.Adapter<FliperAdapter.Halder> {

private static ArrayList<Movie> movies;
private static Context mContext;
private ViewGroup vai;

public interface ClickMovieItem{
    void clickingItem(Movie m, String idmov);
}

    public interface ScrollCallbackFlip {

        void onScrollEnded(int position);
    }

    private ScrollCallbackFlip scrollListener;

    public FliperAdapter(Context m, ArrayList<Movie> jas){
        this.mContext = m;
        this.movies = jas;
    }


    private ClickMovieItem ll;

public void SetClickMovieListener(ClickMovieItem k){
    this.ll = k;
}

public void SetScrollListener(ScrollCallbackFlip lf){
    this.scrollListener = lf;
}

    @NonNull
    @Override
    public Halder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.vai = viewGroup;
        View view = LayoutInflater.from(mContext).inflate(R.layout.itemsitobb, viewGroup, false);

        return new Halder(view, false);
    }

    @Override
    public void onBindViewHolder(@NonNull Halder holder, int position) {




        Movie movie1 = movies.get(position * 2);
        Movie movie2 = null;

            movie2 = movies.size() > (position * 2 + 1) ? movies.get(position * 2 + 1) : null;


        if(!holder.isReady) {

            ArrayList<Movie> two = new ArrayList<>();
            two.add(movie1);
            two.add(movie2);
            holder.juas.setAdapter(new ViewPagerFlip(mContext, two, ll));
            StackTransformer horizontalTransformer = new StackTransformer();
            holder.juas.setPageTransformer(true, horizontalTransformer);
            holder.juas.setCurrentItem(1);
            holder.isReady = true;


            if (movies != null && scrollListener != null) {
                scrollListener.onScrollEnded(position);
            }
        }



    }

    @Override
    public int getItemCount() {
        return movies.size() % 2 == 0 ? movies.size():(movies.size() / 2)+1;
    }

  public static class Halder extends RecyclerView.ViewHolder{

         View none;
         private boolean isReady;

        ImageView image;
        TextView title;
        TextView date;
        TextView viewer;
        TextView comments;
        AdView ads;
        LinearLayout movie;
        ImageView favorite;
         View jasone;


        // ======================== MERGES =========================== //
         View merg;
         ViewPager juas;

         View mainc;

        // =============== second views ================== //

       View jastwo;
        ImageView image2;
        TextView title2;
        TextView date2;
        TextView viewer2;
        TextView comments2;
        AdView ads2;
        LinearLayout movie2;

        public Halder(View itemView, boolean isf) {
            super(itemView);

            none = itemView.findViewById(R.id.none);


            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            viewer = itemView.findViewById(R.id.viewer);
            comments = itemView.findViewById(R.id.comments);
            ads = itemView.findViewById(R.id.adView);
            movie = itemView.findViewById(R.id.movie);
            mainc = itemView.findViewById(R.id.maincontent);
            jasone = itemView.findViewById(R.id.viw1);

            //favorite = itemView.findViewById(R.id.favorites);



            image2 = itemView.findViewById(R.id.image2);
            title2 = itemView.findViewById(R.id.title2);
            date2 = itemView.findViewById(R.id.date2);
            viewer2 = itemView.findViewById(R.id.viewer2);
            comments2 = itemView.findViewById(R.id.comments2);
            ads2 = itemView.findViewById(R.id.adView2);
            movie2 = itemView.findViewById(R.id.movie2);
            jastwo = itemView.findViewById(R.id.viw2);

            if(!isf){
                juas = itemView.findViewById(R.id.viewpag);
                jastwo.setVisibility(View.GONE);
                jasone.setVisibility(View.GONE);
            }

        }
    }



    // ========================== PAGER TRANSFORMER PAPUUU ===================================== //

    public class CardTransformer implements ViewPager.PageTransformer {

        private final float scalingStart;

        public CardTransformer(float scalingStart) {
            super();
            this.scalingStart = 1 - scalingStart;
        }

        @Override
        public void transformPage(View page, float position) {

            if (position >= 0) {
                final int w = page.getWidth();
                float scaleFactor = 1 - scalingStart * position;
               // Log.e("MAIN", "transformPage: "+scaleFactor+" pos "+position);
                page.setAlpha(1 - position);
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setTranslationX(w * (1 - position) - w);
            }
        }
    }

}
