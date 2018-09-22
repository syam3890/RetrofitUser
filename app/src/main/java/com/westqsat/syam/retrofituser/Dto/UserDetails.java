package com.westqsat.syam.retrofituser.Dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by syam on 28/06/2018.
 */

public class UserDetails {
    @SerializedName("success")
    private String mSuccess;


    @SerializedName("status")
    private String mStatus;

    @SerializedName("result")
    private UserInfo mUserInfo;

    @SerializedName("name")
    private String mName;

//    @SerializedName("result")
//    private UserInfo mUserResult;

//    @SerializedName("asi_notifications")
//    private List<NotificationDto> mNotificationList;

    @SerializedName("details")
    private List<NotificationDto> mNotificationList;

    public UserDetails(String mSuccess, String mStatus, UserInfo mUserInfo, String mName, List<NotificationDto> mNotificationList) {
        this.mSuccess = mSuccess;
        this.mStatus = mStatus;
        this.mUserInfo = mUserInfo;
        this.mName = mName;
        this.mNotificationList = mNotificationList;
    }

    public String getmSuccess() {
        return mSuccess;
    }

    public String getmStatus() {
        return mStatus;
    }

    public UserInfo getmUserInfo() {
        return mUserInfo;
    }

    public String getmName() {
        return mName;
    }

    public List<NotificationDto> getmNotificationList() {
        return mNotificationList;
    }
}
