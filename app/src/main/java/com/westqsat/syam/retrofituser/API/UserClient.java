package com.westqsat.syam.retrofituser.API;

import com.westqsat.syam.retrofituser.Dto.UserDetails;
import com.westqsat.syam.retrofituser.POJO.User;
import com.westqsat.syam.retrofituser.POJO.UserID;

import java.io.StringReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by syam on 28/06/2018.
 */

public interface UserClient {

    @POST("asi_login.php")
    Call<UserDetails> createAccount(@Body User user);

    @POST("asi_notifications.php")
    Call<UserDetails> notificationList(@Body UserID user);

    @FormUrlEncoded
    @POST("notifications_list")
    Call<UserDetails> notificationListNew(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("checkFriendStatus")
    Call<UserDetails> mFriendDetails(@Field("user_id") String user_id,
                                     @Field("friend_id") String friend_id);

    @Headers({"content-type: application/json"})
    @POST("signUp")
    Call<UserDetails> mPostVideo(@Body String user);

}
