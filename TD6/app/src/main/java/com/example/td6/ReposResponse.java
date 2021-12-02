package com.example.td6;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReposResponse {
    @SerializedName("items")
    private List<Repo> items;
    public List<Repo> getItems() {
        return items;
    }
}
