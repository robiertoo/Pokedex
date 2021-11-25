package com.robiertoo.pokedex.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.robiertoo.pokedex.R;
import com.robiertoo.pokedex.adapter.PokemonAdapter;
import com.robiertoo.pokedex.models.Pokemon;
import com.robiertoo.pokedex.models.PokemonList;
import com.robiertoo.pokedex.services.PokemonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private List<Pokemon> pokemons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PokemonService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PokemonAdapter pokemonAdapter = new PokemonAdapter(pokemons);
        recyclerView.setAdapter(pokemonAdapter);

        add151Pokemons(service, pokemonAdapter);
    }

    private void add151Pokemons(PokemonService service, PokemonAdapter pokemonAdapter) {
        for (int i = 1; i <= 151; i ++ ) {
            Call<Pokemon> call = service.getPokemon(i);
            call.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if(!response.isSuccessful()) Log.e(TAG, response.message());
                    Pokemon pokemon = response.body();
                    pokemons.add(pokemon);
                    pokemonAdapter.notifyDataSetChanged();
                    Log.i(TAG, "" + pokemons.size());
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });
        }
    }
}