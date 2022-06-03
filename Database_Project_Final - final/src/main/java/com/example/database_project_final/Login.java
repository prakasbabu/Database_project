package com.example.database_project_final;

public class Login {
    private int loginId;
    private String username;
    private String password;
    private int userId;


    public Login(){

    }

    public Login(int loginId, String username, String password, int userId) {
        this.loginId = loginId;
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId=" + loginId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }
}
