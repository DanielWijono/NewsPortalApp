package com.example.daniel.tokopediaproject.Model;

import com.example.daniel.tokopediaproject.Model.Articles;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainResponse {

    @SerializedName("status")
    String status;
    @SerializedName("articles")
    List<Articles> articlesList;

    public String getStatus() {
        return status;
    }

    public List<Articles> getArticlesList() {
        return articlesList;
    }
}
