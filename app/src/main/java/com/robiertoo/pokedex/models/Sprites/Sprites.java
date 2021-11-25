package com.robiertoo.pokedex.models.Sprites;

import com.google.gson.annotations.SerializedName;

public class Sprites {
    @SerializedName("front_default")
    private String sprite;

    public Sprites() {
    }

    public Sprites(String sprite) {
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}
