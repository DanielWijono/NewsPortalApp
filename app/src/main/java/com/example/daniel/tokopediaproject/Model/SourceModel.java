package com.example.daniel.tokopediaproject.Model;

import com.google.gson.annotations.SerializedName;

public class SourceModel {
    @SerializedName("name")
    String name;

    public String getName() {
        return name;
    }
}
