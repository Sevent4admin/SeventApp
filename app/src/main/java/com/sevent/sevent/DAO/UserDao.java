package com.sevent.sevent.DAO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Stev7x on 15/10/2016.
 */

public class UserDao {

    @SerializedName("id_user")
    private int id_user;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
