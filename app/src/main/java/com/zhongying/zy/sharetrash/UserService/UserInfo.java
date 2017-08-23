package com.zhongying.zy.sharetrash.UserService;

import java.io.Serializable;

/**
 * Created by zy on 2017/6/29.
 */

public class UserInfo implements Serializable{
    private int id;

    private String username;
    private String password;
    private String sex;
    private String urlUserIcon;
    private int credits;
    private int changeCredits;
    private int contributionCredits;
    private String cookie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUrlUserIcon() {
        return urlUserIcon;
    }

    public void setUrlUserIcon(String urlUserIcon) {
        this.urlUserIcon = urlUserIcon;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getChangeCredits() {
        return changeCredits;
    }

    public void setChangeCredits(int changeCredits) {
        this.changeCredits = changeCredits;
    }

    public int getContributionCredits() {
        return contributionCredits;
    }

    public void setContributionCredits(int contributionCredits) {
        this.contributionCredits = contributionCredits;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserInfo(String username, String password, String sex, String urlusericon) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.urlUserIcon = urlusericon;
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
