package com.dagf.persoview;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dagf.persoview.flipviewpager.adapter.BaseFlipAdapter;
import com.dagf.persoview.flipviewpager.utils.FlipSettings;
import com.dagf.persoview.models.Movie;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class DrakAdapter extends BaseFlipAdapter {

   private List<Movie> movies = new ArrayList<>();
    private Activity mm;
    private int resd;

    public DrakAdapter(Context context, List<Movie> items, FlipSettings settings) {

        super(context, items, settings);

    }


    public DrakAdapter(Activity activity, List<Movie> items, FlipSettings settings, int resID){
        super(activity, items, settings);
        this.mm = activity;
        MobileAds.initialize(mm, mm.getString(R.string.admob_id));
        this.resd = resID;
        this.movies = items;
    }



    @Override
    public View getPage(int position, View convertView, ViewGroup parent, Object item1, Object item2, CloseListener closeListener) {
        final Halder holder;

        Movie movie1 = (Movie) item1;
        Movie movie2 = (Movie) item2;
        if(convertView == null){
            convertView = mm.getLayoutInflater().inflate(resd, parent, false);
            holder = new Halder(convertView);

            holder.merg = mm.getLayoutInflater().inflate(R.layout.itemsitomerged, parent, false);

            holder.title_d = holder.merg.findViewById(R.id.title_jajas);
            holder.round = holder.merg.findViewById(R.id.ptg);



        }else{
            holder = new Halder(convertView);
        }


        switch (position){
            case 1:
                holder.title.setText(movie1.getName());
                if (item2 != null) {
                    holder.title2.setText(movie2.getName());

                }else{
                    holder.jastwo.setVisibility(View.GONE);
                }
                break;
            default:
               // Log.e("MAIN", "getPage: "+position);
                fillHolder(holder, position == 0 ? movie1 : movie2);
if(item2 != null) {
    return holder.merg;
}
        }

        return convertView;
    }

    @Override
    public int getPagesCount() {
        return movies.size();
    }

    class Halder extends RecyclerView.ViewHolder{
         ImageView image;
        TextView title;
        TextView date;
        TextView viewer;
        TextView comments;
        AdView ads;
        LinearLayout movie;
        ImageView favorite;
        private View jasone;


        // ======================== MERGES =========================== //
        private View merg;
        private TextView title_d;
        private TextView cat;
        private ImageView round;

        // =============== second views ================== //

        private View jastwo;
        ImageView image2;
        TextView title2;
        TextView date2;
        TextView viewer2;
        TextView comments2;
        AdView ads2;
        LinearLayout movie2;

        public Halder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            viewer = itemView.findViewById(R.id.viewer);
            comments = itemView.findViewById(R.id.comments);
           ads = itemView.findViewById(R.id.adView);
            movie = itemView.findViewById(R.id.movie);
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

        }
    }

    private void fillHolder(Halder holder, Movie movie) {
            if (movie == null)
               return;

     //   Log.e("MAIN", "fillHolder: "+movie.getName());
        holder.title_d.setText(movie.getName());
        Picasso.get().load(Uri.parse(movie.getUrlImg())).transform(new CropCircleTransformation()).into(holder.round);
       // holder.cat.setText(movie.getCat());
     }
}
