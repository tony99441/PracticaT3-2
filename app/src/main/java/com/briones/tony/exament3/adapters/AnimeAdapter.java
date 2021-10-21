package com.briones.tony.exament3.adapters;


import static android.media.CamcorderProfile.get;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.briones.tony.exament3.Anime;
import com.briones.tony.exament3.AnimeActivity;
import com.briones.tony.exament3.R;
import com.bumptech.glide.Glide;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>  {

    List<Anime> animes;


    private Context context;

    public AnimeAdapter(List<Anime> animes, Context context) {
        this.animes = animes;
        this.context = context;
    }

    public int contador = 1;


    int [] datosImg;

    public AnimeAdapter(List<Anime> anime) {
        this.animes = anime;
    }


    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //creamos una mini vista con el item_contacto_adapter
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anime_adapter, parent,false);


        return new AnimeViewHolder(view);

    }
    @Override
    public void onBindViewHolder( AnimeViewHolder holder, int position) {

        View view = holder.itemView;
        Anime anime = animes.get(position);



       TextView textViewNombre = view.findViewById(R.id.tvNombre);
       TextView textViewDescripcion = view.findViewById(R.id.tvDescripcion);
        ImageView imageViewImagen = view.findViewById(R.id.imgView);
        ImageView btnFavorito = view.findViewById(R.id.imgFavorito);



        textViewNombre.setText(anime.getNombre());
        textViewDescripcion.setText(anime.getDescripcion());


        com.squareup.picasso.Picasso.get().load(anime.getImg()).into(imageViewImagen);

        //Picasso.Builder builder = new Picasso.Builder(context);
        //builder.downloader(new OkHttp3Downloader(context));
        //builder.build().load(animes.get(position).getImg())
          //      .placeholder(R.drawable.ic_launcher_background)
            //    .error(R.drawable.ic_launcher_background)
              //  .into(imageViewImagen);







        btnFavorito.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP && contador == 1) {
                    btnFavorito.setImageResource(R.drawable.ic_baseline_start_rate_24);
                    contador++;
                } else if (event.getAction() == MotionEvent.ACTION_UP && contador == 2) {
                    btnFavorito.setImageResource(R.drawable.ic_baseline_star_border_24xml);
                    contador--;
                }
                return true;
            }
        });

    }


    @Override
    public int getItemCount() {
        return animes.size();
    }


    public class AnimeViewHolder extends RecyclerView.ViewHolder{

        public AnimeViewHolder(View itemView) {
            super(itemView);
        }


    }

}
