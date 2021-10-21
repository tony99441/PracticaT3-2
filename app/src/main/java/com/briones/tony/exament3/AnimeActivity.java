package com.briones.tony.exament3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.briones.tony.exament3.adapters.AnimeAdapter;
import com.briones.tony.exament3.servicios.AnimeService;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);


        // Vinculando con la actividad

        RecyclerView rv = findViewById(R.id.rvAnime);

        rv.setLayoutManager(new LinearLayoutManager( AnimeActivity.this ));


        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl("https://exament3.free.beeceptor.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();





        AnimeService service = retrofit.create(AnimeService.class);
        service.all().enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {


              //  List<Anime> animes = Arrays.asList(new Anime("Pruebita", "buneaa"), new Anime("Pruebita2", "buddneaa"));

                AnimeAdapter animeAdapter = new AnimeAdapter(response.body());

                rv.setAdapter(animeAdapter);





            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {

            }
        });




    }





}