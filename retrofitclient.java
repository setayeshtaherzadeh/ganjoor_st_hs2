package com.example.falhafez;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitclient {

    private static final String baseurl="https://ganjgah.ir/api/ganjoor/";
    private static Retrofit retrofit=null;

    public static APIforlist getretrofit(){
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(APIforlist.class);
    }
}
