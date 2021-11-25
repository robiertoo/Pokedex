package com.robiertoo.pokedex.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonList {

    @SerializedName("results")
    private List<Pokemon> pokemons;

    public PokemonList() {
    }

    public PokemonList(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
