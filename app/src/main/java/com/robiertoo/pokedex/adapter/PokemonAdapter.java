package com.robiertoo.pokedex.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robiertoo.pokedex.R;
import com.robiertoo.pokedex.models.Pokemon;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.MyViewHolder> {
    private List<Pokemon> pokemons;

    public PokemonAdapter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(
                R.layout.pokemon_list_item,
                parent,
                false
        );
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
//        holder.textId.setText("" + pokemon.getId());
//        holder.textName.setText(pokemon.getName());

        Picasso.get()
                .load(pokemon.getSprites().getSprite())
                .resize(300,300)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView textId;
//        TextView textName;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagePokemon);
//            textId = itemView.findViewById(R.id.textId);
//            textName = itemView.findViewById(R.id.textName);
        }
    }
}
