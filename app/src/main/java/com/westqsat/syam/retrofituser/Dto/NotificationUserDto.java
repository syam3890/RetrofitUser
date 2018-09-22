package com.westqsat.syam.retrofituser.Dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 04/07/2018.
 */

public class NotificationUserDto {

    @SerializedName("user_firstname")
    private String mUserFirstname;

    public NotificationUserDto(String mUserFirstname) {
        this.mUserFirstname = mUserFirstname;
    }

    public String getmUserFirstname() {
        return mUserFirstname;
    }
}
