package com.qtasnim.qhopes.models;

public class AkunModel {
    String username, useremail, userphone;

    public AkunModel (
            String username,
            String useremail,
            String userphone

    ){
        this.username = username;
        this.useremail = useremail;
        this.userphone = userphone;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }
}
