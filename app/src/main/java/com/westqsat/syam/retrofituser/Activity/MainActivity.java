package com.westqsat.syam.retrofituser.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.westqsat.syam.retrofituser.API.Api;
import com.westqsat.syam.retrofituser.Adapter.NotificationAdapter;
import com.westqsat.syam.retrofituser.Dto.UserDetails;
import com.westqsat.syam.retrofituser.POJO.User;
import com.westqsat.syam.retrofituser.POJO.UserID;
import com.westqsat.syam.retrofituser.R;
import com.westqsat.syam.retrofituser.Utils.ServiceCalling;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mETUserCode, mETPassword;
    Button mButtonsave, mButtonList;
    RecyclerView mNotiList;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mETUserCode = findViewById(R.id.mETUserCode);
        mETPassword = findViewById(R.id.mETPassword);
        mButtonsave = findViewById(R.id.mButtonsave);
        mButtonList = findViewById(R.id.mButtonList);
        mNotiList = findViewById(R.id.mNotiList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mNotiList.setLayoutManager(mLayoutManager);

        mButtonsave.setOnClickListener(this);
        mButtonList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mButtonsave) {
            if (mETUserCode.getText().toString().trim().isEmpty()) {
                Toast.makeText(mContext, "Enter user Email..", Toast.LENGTH_SHORT).show();
            } else if (mETPassword.getText().toString().trim().isEmpty()) {
                Toast.makeText(mContext, "Enter user password..", Toast.LENGTH_SHORT).show();
            } else {
//                sendLoginRequest();
            }
        } else if (v.getId() == R.id.mButtonList) {
//            sendNotificationListRequest();
//            ServiceCalling.sendNotificationListRequestNew(mContext, mNotiList);
//            ServiceCalling.sendFriendDetailsRequest(mContext);

            ServiceCalling.sendSignup(mContext, "");

        }
    }


    private void sendLoginRequest() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog


        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // Login is a POST request type method in which we are sending our field's in json format
        // enqueue is used for callback response and error
        Api.getClient().createAccount(new User(mETUserCode.getText().toString().trim(),
                mETPassword.getText().toString().trim(),
                "APA91bFxs7ciaCIuXiblAgw-f52HhvjFKjKPYNystlT31hX8Y3BlWFCZe2PEN07DLkZ2xU8PmBp48wpNsdNNgCRKMjmgVQ_zmTqMcb_9v1M-9Z3q6Cs8WsOUyJfjmOC-EbgqCT4dzVYyQiBGprHWJfQNdoWIJ_Csag")).enqueue(new Callback<UserDetails>() {

            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                progressDialog.dismiss();// dismiss progress dialog

                if (response.body().getmSuccess() != null) {
                    Toast.makeText(MainActivity.this, "Employee Name : " + response.body().getmName(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid employee credentials ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {
                progressDialog.dismiss();// dismiss progress dialog
                Toast.makeText(MainActivity.this, "something went wrong..", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void sendNotificationListRequest() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // notification list is a POST request type method in which we are sending our ASI id in json format
        // enqueue is used for callback response and error
        Api.getClient().notificationList(new UserID("12")).enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                progressDialog.dismiss();// dismiss progress dialog

                if (response.body().getmSuccess() == null) {
                    Toast.makeText(MainActivity.this, "something went wrong..", Toast.LENGTH_SHORT).show();
                } else {
                    if (response.body().getmSuccess().equals("1")) {
                        NotificationAdapter adapter = new NotificationAdapter(mContext, response.body().getmNotificationList());
                        mNotiList.setAdapter(adapter);

                        Toast.makeText(MainActivity.this, "List updated successfully..", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "No data to display..", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {
                progressDialog.dismiss();// dismiss progress dialog
                Toast.makeText(MainActivity.this, "something went wrong..", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
