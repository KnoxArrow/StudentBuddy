package com.nitukbt19.StudentBuddy.Models;

import android.provider.ContactsContract;

public class Users {
    String ProfilePic,userName,mail,password,userId,lastMessage;
    boolean  isStudent;
    public Users(String profilepic, String userName, String mail, String password, String userId, String lastMessage,boolean isStudent) {
        this.ProfilePic = ProfilePic;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.userId = userId;
        this.lastMessage = lastMessage;
        this.isStudent=isStudent;
    }

    public Users(){}

    //SignUp Constructor
    public Users(String userName, String mail, String password,boolean isStudent) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.isStudent= isStudent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String ProfilePic) {
        this.ProfilePic= ProfilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

}
