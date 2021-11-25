package com.robiertoo.pokedex.models;

import com.robiertoo.pokedex.models.Sprites.Sprites;

public class Pokemon {
    private int id;
    private String name;
    private Sprites sprites;

    public Pokemon() {
    }

    public Pokemon(int id, String name, Sprites sprites) {
        this.id = id;
        this.name = name;
        this.sprites = sprites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }
}
