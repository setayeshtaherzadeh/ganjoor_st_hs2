package com.example.falhafez;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myAPI {

    //https://ganjgah.ir/api/ganjoor/hafez/faal

    @GET("faal")
    Call<datamodel> getdata();
}
