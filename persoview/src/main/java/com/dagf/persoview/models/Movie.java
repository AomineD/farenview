package com.dagf.persoview.models;

import java.util.ArrayList;

public class Movie {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String name;

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    private int idMovie;

    private String overview;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public ArrayList<String> getNameGenres() {
        return nameGenres;
    }

    public void setNameGenres(ArrayList<String> nameGenres) {
        this.nameGenres = nameGenres;
    }

    private ArrayList<String> nameGenres = new ArrayList<>();



    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    private String views;
    private String urlImg;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    private String releaseDate;
}
