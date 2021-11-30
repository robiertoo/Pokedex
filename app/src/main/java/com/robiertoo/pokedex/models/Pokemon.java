package com.robiertoo.pokedex.models;

import com.google.gson.annotations.SerializedName;
import com.robiertoo.pokedex.models.Sprites.Sprites;
import com.robiertoo.pokedex.models.Types.Types;

import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private Sprites sprites;
    private List<Types> types;

    public Pokemon() {
    }

    public Pokemon(int id, String name, Sprites sprites, List<Types> types) {
        this.id = id;
        this.name = name;
        this.sprites = sprites;
        this.types = types;
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

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }
}
