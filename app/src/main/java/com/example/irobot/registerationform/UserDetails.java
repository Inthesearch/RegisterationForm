package com.example.irobot.registerationform;

import java.io.Serializable;

/**
 * Created by iROBOT on 4/12/2017.
 */

public class UserDetails implements Serializable {

    private String username;
    private String password;
    private String email;
    private String fname;
    private String lname;
    private String gender;
    private int id;

    public UserDetails() {
        //this.username = username;
    }

    public UserDetails(int id,String username, String password, String email, String fname, String lname, String gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }





    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "com.example.irobot.registerationform.UserDetails{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
