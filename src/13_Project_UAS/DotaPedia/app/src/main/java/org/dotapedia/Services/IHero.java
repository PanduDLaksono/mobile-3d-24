package org.dotapedia.Services;


import org.dotapedia.Models.MHero;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IHero {
    @GET("db.json")
    Observable<MHero> getListHero();
}
