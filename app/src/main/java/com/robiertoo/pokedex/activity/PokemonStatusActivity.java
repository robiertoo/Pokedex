package com.robiertoo.pokedex.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.robiertoo.pokedex.R;
import com.robiertoo.pokedex.models.Pokemon;
import com.robiertoo.pokedex.services.PokemonService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonStatusActivity extends AppCompatActivity {
    private ImageView imagePokemon;
    private TextView textType1;
    private TextView textType2;
    private TextView textPokemonName;
    private int pokemon_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_status);

        this.imagePokemon = findViewById(R.id.imagePokemon);
        this.textType1 = findViewById(R.id.textType1);
        this.textType2 = findViewById(R.id.textType2);
        this.textPokemonName = findViewById(R.id.textPokemonName);

        Intent pokemonIntent = getIntent();
        pokemon_id = Integer.parseInt(pokemonIntent.getStringExtra("pokemon_id")) + 1;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PokemonService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);
        Call<Pokemon> call = service.getPokemon(pokemon_id);

        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(!response.isSuccessful()) Log.e("ERRO", "Deu ruim!" + response.message());
                Pokemon pokemon = response.body();

                textType1.setText(capitalize(pokemon.getTypes().get(0).getType().getName()));
                if(pokemon.getTypes().size() == 2) textType2.setText(capitalize(pokemon.getTypes().get(1).getType().getName()));
                else {
                    textType2.setVisibility(View.GONE);
                }
                textPokemonName.setText(capitalize(pokemon.getName()));

                Picasso.get()
                        .load(pokemon.getSprites().getSprite())
                        .resize(300,300)
                        .into(imagePokemon);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("ERRO", t.getMessage());
            }
        });
    }

    public static String capitalize(String str)
    {
        if(str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}