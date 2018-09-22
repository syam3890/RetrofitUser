package com.westqsat.syam.retrofituser.Dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by syam on 28/06/2018.
 */

public class NotificationDto {


    @SerializedName("subscriber_id")
    private String mSubscriberID;

    @SerializedName("Notf_Msg")
    private String mNotf_Msg;

    @SerializedName("user_firstname")
    private String mUserFirstname;

    @SerializedName("user_details")
    List<NotificationUserDto> notificationuser;


    public NotificationDto(String mSubscriberID) {
        this.mSubscriberID = mSubscriberID;
        this.mNotf_Msg = mNotf_Msg;
        this.notificationuser = notificationuser;
        this.mUserFirstname = mUserFirstname;
    }

    public String getmSubscriberID() {
        return mSubscriberID;
    }

    public String getmNotf_Msg() {
        return mNotf_Msg;
    }

    public List<NotificationUserDto> getNotificationuser() {
        return notificationuser;
    }

    public String getmUserFirstname() {
        return mUserFirstname;
    }
}
