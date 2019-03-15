package com.dagf.persoview;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dagf.persoview.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ViewPagerFlip extends PagerAdapter {

    private ViewGroup MainView;
    private Context jaj;
    private ArrayList<Movie> wachau;

    public ViewPagerFlip(Context mmm, ArrayList<Movie> m){

                // MainView.setVisibility(View.GONE);
        this.wachau = m;
                 this.jaj = mmm;
    }

    @Override
    public int getCount() {
        if(wachau.get(1) != null) {
            return 3;
        }else{
            //Log.e("MAIN", "getCount: "+wachau.size());
            return 2;
        }
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        MainView = container;
ViewGroup vau = null;

switch (position) {
    case 0:
    vau = (ViewGroup) LayoutInflater.from(jaj).inflate(R.layout.itemsitomerged, container, false);

    MergeHolder merg1 = new MergeHolder(vau);

        fillMerger(wachau.get(0), merg1);

    break;
    case 1:

        vau = (ViewGroup) LayoutInflater.from(jaj).inflate(R.layout.itemsitobb, container, false);

fillMain(vau);

        break;
    case 2:
if(wachau.get(1) != null) {
    vau = (ViewGroup) LayoutInflater.from(jaj).inflate(R.layout.itemsitomerged, container, false);

    MergeHolder merg2 = new MergeHolder(vau);

   fillMerger(wachau.get(1), merg2);


}
        break;

}

        //Log.e("MAIN", "instantiateItem: "+(vau!=null));
            container.addView(vau);


            return vau;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       // super.destroyItem(container, position, object);
        container.removeView((View)object);
    }

    public class MergeHolder extends RecyclerView.ViewHolder {

        TextView title_d;
        ImageView round;


        LinearLayout mainlins;
        TextView ov;
        TextView ov_title;


        public MergeHolder(@NonNull View itemView) {
            super(itemView);
            title_d = itemView.findViewById(R.id.title_jajas);
            round = itemView.findViewById(R.id.ptg);

            ov = itemView.findViewById(R.id.ov_desc);
            ov_title = itemView.findViewById(R.id.ov_title);
            mainlins = itemView.findViewById(R.id.lainmain);
        }
    }


// =================================== LLENAR VIEWS MERGER ======================================== //
// ======================================================================================== //

private void fillMerger(Movie movie, MergeHolder holder){

        holder.title_d.setText(movie.getName());

        Picasso.get().load(Uri.parse(movie.getUrlImg())).transform(new CropCircleTransformation()).into(holder.round);

        holder.ov.setText(movie.getOverview());

        for(int i=0; i < movie.getNameGenres().size(); i++){
            View vv = LayoutInflater.from(jaj).inflate(R.layout.textsimple, MainView, false);

          TextView genre =  vv.findViewById(R.id.texting);

          genre.setText(movie.getNameGenres().get(i));

          LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

          params.setMargins(15, 0, 15, 0);

          holder.mainlins.addView(vv, params);

        }

    }

    //================================= LLENAR VIEWS PRINCIPALES ============================== //
    // ======================================================================================== //

    private void fillMain(ViewGroup vau){

        FliperAdapter.Halder holder = new FliperAdapter.Halder(vau, true);


        Movie movie1 = wachau.get(0);
        Movie movie2 = null;

        movie2 = wachau.get(1);

        holder.title.setText(movie1.getName());
        Picasso.get().load(Uri.parse(movie1.getUrlImg())).fit().into(holder.image);
        if (movie2 != null) {
            holder.title2.setText(movie2.getName());
            Picasso.get().load(Uri.parse(movie2.getUrlImg())).fit().into(holder.image2);
        } else {
          //  Log.e("MAIN", "instantiateItem: SI OCULTO");
            holder.jastwo.setVisibility(View.GONE);
            holder.none.setVisibility(View.VISIBLE);
        }

    }


}
