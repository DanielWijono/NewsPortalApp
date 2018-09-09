package com.example.daniel.tokopediaproject.Model;

import com.google.gson.annotations.SerializedName;

public class Articles {
    @SerializedName("source")
    SourceModel sourceModel;
    @SerializedName("author")
    String author;
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
    @SerializedName("url")
    String url;
    @SerializedName("urlToImage")
    String urlToImage;

    public SourceModel getSourceModel() {
        return sourceModel;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}


