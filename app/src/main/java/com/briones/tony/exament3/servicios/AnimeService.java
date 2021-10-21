package com.briones.tony.exament3.servicios;

import com.briones.tony.exament3.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {

    @GET("animes")
    Call<List<Anime>> all();
}
