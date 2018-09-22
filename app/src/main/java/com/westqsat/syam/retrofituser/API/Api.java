package com.westqsat.syam.retrofituser.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by syam
 */
public class Api {
    private static Retrofit retrofit = null;

    public static UserClient getClient() {

        // change your base URL
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://middlewicket.com/middlewicket/api/")
//                    .baseUrl("http://demo.adhishta.com/projects/brightfuture/services/index.php/web_services/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        UserClient api = retrofit.create(UserClient.class);
        return api; // return the APIInterface object
    }

}
