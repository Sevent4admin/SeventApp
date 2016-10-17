package com.sevent.sevent.DAO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Stev7x on 15/10/2016.
 */

public class LoginDao {
    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private UserDao data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDao getData() {
        return data;
    }

    public void setData(UserDao data) {
        this.data = data;
    }
}
