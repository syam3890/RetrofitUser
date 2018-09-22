package com.westqsat.syam.retrofituser.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.westqsat.syam.retrofituser.API.Api;
import com.westqsat.syam.retrofituser.Adapter.NotificationAdapter;
import com.westqsat.syam.retrofituser.Dto.UserDetails;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 04/07/2018.
 */

public class ServiceCalling {


//    public static void sendNotificationListRequestNew(final Context mContext, final RecyclerView mNotiList) {
//        // display a progress dialog
//        final ProgressDialog progressDialog = new ProgressDialog(mContext);
//        progressDialog.setCancelable(false); // set cancelable to false
//        progressDialog.setMessage("Please Wait"); // set message
//        progressDialog.show(); // show progress dialog
//
//        // Api is a class in which we define a method getClient() that returns the API Interface class object
//        // notification list is a POST request type method in which we are sending our ASI id in json format
//        // enqueue is used for callback response and error
//        Api.getClient().notificationListNew("10").enqueue(new Callback<UserDetails>() {
//            @Override
//            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
//                progressDialog.dismiss();// dismiss progress dialog
//
//                if (!response.body().getmStatus()) {
//                    Toast.makeText(mContext, "something went wrong..", Toast.LENGTH_SHORT).show();
//                } else {
//                    if (response.body().getmStatus()) {
//                        NotificationAdapter adapter = new NotificationAdapter(mContext, response.body().getmNotificationList());
//                        mNotiList.setAdapter(adapter);
//
//
//                        Toast.makeText(mContext, "List updated successfully..", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(mContext, "No data to display..", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserDetails> call, Throwable t) {
//                progressDialog.dismiss();// dismiss progress dialog
//                Toast.makeText(mContext, "something went wrong..", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }


//    public static void sendFriendDetailsRequest(final Context mContext) {
//        // display a progress dialog
//        final ProgressDialog progressDialog = new ProgressDialog(mContext);
//        progressDialog.setCancelable(false); // set cancelable to false
//        progressDialog.setMessage("Please Wait"); // set message
//        progressDialog.show(); // show progress dialog
//
//        // Api is a class in which we define a method getClient() that returns the API Interface class object
//        // notification list is a POST request type method in which we are sending our ASI id in json format
//        // enqueue is used for callback response and error
//        Api.getClient().mFriendDetails("10", "12").enqueue(new Callback<UserDetails>() {
//            @Override
//            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
//                progressDialog.dismiss();// dismiss progress dialog
//
//                if (!response.body().getmStatus()) {
//                    Toast.makeText(mContext, "something went wrong..", Toast.LENGTH_SHORT).show();
//                } else {
//                    if (response.body().getmStatus()) {
//
//                        Toast.makeText(mContext, "" + response.body().getmNotificationList().get(0).getmUserFirstname(), Toast.LENGTH_SHORT).show();
//
//                    } else {
//                        Toast.makeText(mContext, "No data to display..", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserDetails> call, Throwable t) {
//                progressDialog.dismiss();// dismiss progress dialog
//                Toast.makeText(mContext, "something went wrong..", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

    public static void sendSignup(final Context mContext, String mobile_number) {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(mContext);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        JSONObject job = new JSONObject();

        try {

            job.put("mobile_no", "9000545223");
            job.put("activation_code", "ID00025");
            job.put("mobile_unique_id", "146888");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // notification list is a POST request type method in which we are sending our ASI id in json format
        // enqueue is used for callback response and error
        Api.getClient().mPostVideo(job.toString()).enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                progressDialog.dismiss();// dismiss progress dialog

                if (response.body() == null && response.code() == 401) {
                    Toast.makeText(mContext, "The activation code has already been taken.", Toast.LENGTH_SHORT).show();
                }
//                else if (response.body().getmStatus().equals("2")) {
//                    Toast.makeText(mContext, "The activation code has already been taken.", Toast.LENGTH_SHORT).show();
//                }
                else if (response.body().getmStatus().equals("1")) {
                    Toast.makeText(mContext, "" + response.body().getmUserInfo().getmUserResultMessage(), Toast.LENGTH_SHORT).show();
                } else if (response.body().getmStatus().equals("0")) {
                    Toast.makeText(mContext, "User ID : " + response.body().getmUserInfo().getmUserResultID(), Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {
                progressDialog.dismiss();// dismiss progress dialog
                Toast.makeText(mContext, "something went wrong..", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
