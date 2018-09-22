package com.westqsat.syam.retrofituser.POJO;

/**
 * Created by syam on 28/06/2018.
 */

public class User {

    private String email;
    private String password;
    private String gcm_id;

    public User(String emp_email, String emp_password, String mGcm_id) {
        email = emp_email;
        password = emp_password;
        gcm_id = mGcm_id;
    }

}
