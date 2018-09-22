package com.westqsat.syam.retrofituser.Dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by syam on 28/06/2018.
 */

public class UserInfo {

    @SerializedName("emp_id")
    private String mUserID;

    @SerializedName("user_id")
    private String mUserResultID;

    @SerializedName("activation_code")
    private String[] mActivationCode;

    @SerializedName("message")
    private String mUserResultMessage;

    public void setmUserID(String mUserID) {
        this.mUserID = mUserID;
    }

    public String getmUserID() {
        return mUserID;
    }

    public String getmUserResultID() {
        return mUserResultID;
    }

    public void setmUserResultID(String mUserResultID) {
        this.mUserResultID = mUserResultID;
    }

    public String[] getmActivationCode() {
        return mActivationCode;
    }

    public void setmActivationCode(String[] mActivationCode) {
        this.mActivationCode = mActivationCode;
    }

    public String getmUserResultMessage() {
        return mUserResultMessage;
    }

    public void setmUserResultMessage(String mUserResultMessage) {
        this.mUserResultMessage = mUserResultMessage;
    }
}
