package com.robiertoo.pokedex.models;

import com.google.gson.annotations.SerializedName;

public class Type {
    private String name;

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
