package com.robiertoo.pokedex.services;

import com.robiertoo.pokedex.models.Pokemon;
import com.robiertoo.pokedex.models.PokemonList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    public static String BASE_URL = "https://pokeapi.co/api/v2/";
    @GET("pokemon/?limit=10")
    Call<PokemonList> getPokemons();

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);
}
